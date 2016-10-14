package brilliance.ldcprev_fragment;

import android.content.DialogInterface;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        navigationView = (NavigationView)findViewById(R.id.navigation_id);




        navigationView.setItemIconTintList(null);

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frama_layout, new FrondPage_Fragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawers();
//..................get the natigation list from the menu folder...drawer_menu......................
                if (item.getItemId() == R.id.home_id){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new FrondPage_Fragment()).commit();
                }

                if (item.getItemId() == R.id.nav_paper_1){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new Question1()).commit();
                }

                if (item.getItemId() == R.id.nav_paper_2){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new Question2()).commit();
                }

                if (item.getItemId() == R.id.nav_paper_3){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new Question3()).commit();
                }

 //.................model ..........................................................................
                if (item.getItemId() == R.id.nav_model_1){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new Model1()).commit();
                }
                if (item.getItemId() == R.id.nav_model_2){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new Model2()).commit();
                }
                if (item.getItemId() == R.id.nav_model_3){
                    FragmentTransaction fragmentTransaction1 = fragmentManager.beginTransaction();
                    fragmentTransaction1.replace(R.id.frama_layout, new Model3()).commit();
                }
                return false;
            }
        });


        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name,
                R.string.app_name);
        drawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle.syncState();


        drawerLayout.openDrawer(Gravity.LEFT);

    }






//.................on back pressed..................................................................

    public void onBackPressed(){
        new AlertDialog.Builder(this)
            //    .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Are you sure you want to close this App?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();

                    }
                }).setNegativeButton("No", null).show();

    }




}
