package com.example.islamgsayed.firstapp.pillapp.ViewController;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.net.URISyntaxException;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

import com.example.islamgsayed.firstapp.pillapp.Model.Alarm;
import com.example.islamgsayed.firstapp.pillapp.Model.PillBox;
import com.example.islamgsayed.firstapp.R;

/**
 * This fragment is based on the code at
 * http://www.feelzdroid.com/2014/10/android-action-bar-tabs-swipe-views.html
 *
 * This fragment handles the view and controller of the today tab on home screen
 */

public class TodayFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_today, container, false);

        TableLayout stk = (TableLayout) rootView.findViewById(R.id.table_today);



        PillBox pillBox = new PillBox();

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        List<Alarm> alarms = Collections.emptyList();

        try {
            alarms = pillBox.getAlarms(container.getContext(), day);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        if(alarms.size() != 0) {
            for(Alarm alarm: alarms) {
                TableRow tbrow = new TableRow(container.getContext());

                TextView t1v = new TextView(container.getContext());
                t1v.setText(alarm.getPillName());
                t1v.setTextColor(Color.BLACK);
                t1v.setGravity(Gravity.CENTER);
                t1v.setPadding(30, 30, 30, 30);
                t1v.setTextSize(25);
                t1v.setMaxEms(6);

                tbrow.addView(t1v);

                TextView t2v = new TextView(container.getContext());

                String time = alarm.getStringTime();
                t2v.setText(time);
                t2v.setTextColor(Color.BLACK);
                t2v.setGravity(Gravity.CENTER);
                t2v.setPadding(30, 30, 30, 30);
                t2v.setTextSize(25);
                tbrow.addView(t2v);

                stk.addView(tbrow);
            }
        } else {
            TableRow tbrow = new TableRow(container.getContext());

            TextView t1v = new TextView(container.getContext());
            t1v.setText("You don't have any alarms for Today!");
            t1v.setTextColor(Color.BLACK);
            t1v.setGravity(Gravity.CENTER);
            t1v.setPadding(30, 30, 30, 30);
            t1v.setTextSize(25);
            t1v.setMaxEms(10);
            tbrow.addView(t1v);

            stk.addView(tbrow);
        }
        return rootView;
    }
}
