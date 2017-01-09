package erasmus.transportapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import model.contracts;
import model.userDB;

public class MainAnnouncementActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_announcement);

        startDataBase();

        if(findViewById(R.id.fragment_container) != null){
            if(savedInstanceState !=null){
                return;
            }
            MainFragment mainFragment = new MainFragment();
            mainFragment.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,mainFragment).commit();

        }

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarMain);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                publishAnnounce();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
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
        getMenuInflater().inflate(R.menu.main_announcement, menu);
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

    //TODO: HACER QUE EL BOTON BACK FUNCIONE MÁS RAPIDO. ¿OnResume()?
    public void publishAnnounce(){
        Intent intent = new Intent(this, PublishActivity.class);
        startActivity(intent);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.my_announ) {
            // Handle the camera action
        } else if (id == R.id.last_announ) {
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void startDataBase(){
        userDB dataBaseHelper = new userDB(this);

        SQLiteDatabase dataBase = dataBaseHelper.getWritableDatabase();

        if(dataBase != null){
            for(int i=0; i<20; i++){
                String nickname = "User" + i;
                String pswd = "hola";
                String mail = "foo@example.com";
                String name = "Name " + i;
                String surname = "Surname" + i;

                /*  INSERT INTO users (nickname, password, mail, name, surname)
                    VALUES ( 'nickname', 'pswd', 'mail', 'name', 'surname' )
                 */
                dataBase.execSQL(
                        "INSERT INTO " + contracts.usersEntry.tableName +"("+
                                contracts.usersEntry.nickname + ", " + contracts.usersEntry.pswd +", " + contracts.usersEntry.mail+ ", " +
                                contracts.usersEntry.name + ", " + contracts.usersEntry.surname +  ")"  +
                        "VALUES('" + nickname + "', '" + pswd + "', '" + mail + "', '" + name + "', '" + surname + "' )");
            }
            dataBase.close();

        }
    }



}