package com.example.rs.project_result_mob;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.design.widget.Snackbar;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.rs.project_result_mob.ItemRecyclerView.itemRecycler;

import java.util.ArrayList;
import java.util.List;

public class Main_Menu_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    ArrayList<itemRecycler> listItem = new ArrayList<>();
    RecyclerView MyRecyclerView;
    String NAME_DATA[] = {
            "Name 1",
            "Name 2",
            "Name 3",
            "Name 4"
    };
    int IMAGE_DATA[] = {
            R.drawable.demo1,
            R.drawable.demo2,
            R.drawable.demo3,
            R.drawable.demo4
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__menu_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        spinnerHolder();



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    private void spinnerHolder() {
        String[] arrDistrict = new String[]{
                "District 1",
                "District 2",
                "District 3",
                "District 4",
                "District 5",
                "District 6",
                "District 7",
                "District 8",
                "District 9",
                "District 10",
                "District 11",
                "District 12",
                "Go Vap District",
                "Tan Binh District",
                "Tan Phu District",
                "Binh Thanh District",
                "Phu Nhuan District",
                "Thu Duc District",
                "Binh Tan District",
                "Binh Chanh District",
                "Cu Chi District",
                "Hoc Mon District",
                "Nha Be District",
                "Can Gio District"
        };

        Spinner spinner = (Spinner) findViewById(R.id.spinner_contain_header_side);
        //Adapter
        ArrayAdapter<String> adapterSpinner = new ArrayAdapter<String>(
                Main_Menu_Activity.this,
                android.R.layout.simple_spinner_dropdown_item,
                arrDistrict
        );
        spinner.setAdapter(adapterSpinner);

        listRecyclerView();
//        spinner.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Toast.makeText(Main_Menu_Activity.this, "click", Toast.LENGTH_SHORT).show();
//            }
//        });

    }

    private void listRecyclerView() {
        listItem.clear();
        for(int i = 0; i<NAME_DATA.length;i++){
            itemRecycler item = new itemRecycler();
            item.setName(NAME_DATA[i]);
            item.setImageIdAvatar(IMAGE_DATA[i]);
            listItem.add(item);
        }
//        getActivity()
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__menu_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        displaySelected(id);
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelected(int id) {
        android.app.FragmentManager fm = getFragmentManager();
        android.app.FragmentTransaction ft = fm.beginTransaction();
        Fragment fragment = null;


        switch(id){
            case R.id.nav_home:
                try{
                    fragment = new Fragment_Home();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_plan:
                try{
                     fragment = new Fragment_Attraction_Places();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_checkin:
                try{
                     fragment = new Fragment_Best_Check_In();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_news:
                try{
                   fragment = new Fragment_News();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_city:
                try{
                    fragment = new Fragment_City_Safely();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_list:
                try{
                    fragment = new Fragment_Check_List();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_travel_tips:
                try{
                    fragment = new Fragment_Travel_Tips();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_travel_guides:
                try{
                    fragment = new Fragment_Travel_Guide();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_gallery:
                try{
                    fragment = new Fragment_Gallery();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_feedback:
                try{
                    fragment = new Fragment_Feedback();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.nav_about_us:
                try{
                    fragment = new Fragment_About_Us();
                }
                catch (Exception ex){
                    Toast.makeText(this, ex+"", Toast.LENGTH_SHORT).show();
                }
                break;

            default:
                Toast.makeText(this, "Noting", Toast.LENGTH_SHORT).show();
                break;
        }
        ft.replace(R.id.fragmentContainer, fragment);
        ft.commit();
    }
}
