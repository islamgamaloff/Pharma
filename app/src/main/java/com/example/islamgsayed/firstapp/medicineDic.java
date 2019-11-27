package com.example.islamgsayed.firstapp;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import static android.content.Context.SEARCH_SERVICE;

public class medicineDic extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;
    RecyclerView recyclerVieww;
    SearchView searchView;

//    private ListView lvproduct;
//    private productlistAdapter adapter1;
//    private List<product> mproductlist;

    ArrayList<product>mproducts;
    DatabaseReference databaseReference;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.content_medicine_dic, container, false);
        productlistAdapter productlistAdapters;

        mproducts=new ArrayList<>();

        tabLayout = v.findViewById(R.id.tablayoutmedicinedic);
        viewPager = v.findViewById(R.id.viewpager_medicinedic);



        productlistAdapters=new productlistAdapter(mproducts,getActivity());

        databaseReference= FirebaseDatabase.getInstance().getReference().child("medicine");
        databaseReference.child("tablets").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot drags:dataSnapshot.getChildren()){
                    product products=drags.getValue(product.class);
                    mproducts.add(products);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        viewpageradapter adapter = new viewpageradapter(getActivity().getSupportFragmentManager());
        adapter.addfragment(new tablets(),"اقراص");
        adapter.addfragment(new capsules(),"كبسول");
        adapter.addfragment(new Ampoule(),"حقن");
        adapter.addfragment(new Vial(),"دواء شرب");
        //adapter.addfragment(new test(),"tany");
        //adapter.addfragment(new profileHistory(),"Ampoule");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return v;
    }


//    @Override
//    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
//
//        inflater.inflate(R.menu.medicine_dic, menu);
//
//        MenuItem item = menu.findItem(R.id.action_search);
//        // Retrieve the SearchView and plug it into SearchManager
//        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
//        SearchManager searchManager = (SearchManager) getActivity().getSystemService(SEARCH_SERVICE);
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getActivity().getComponentName()));
//        super.onCreateOptionsMenu(menu, inflater);
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
