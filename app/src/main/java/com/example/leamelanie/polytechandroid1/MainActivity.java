package com.example.leamelanie.polytechandroid1;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final QuestionFormFrag questionFrom = new QuestionFormFrag();
    private final BeerFrag beerFrag = new BeerFrag();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        FrameLayout background = (FrameLayout) findViewById(R.id.background);
        background.setBackgroundResource(R.drawable.polytech);

        if (findViewById(R.id.fragment) != null) {
            final HomepageFrag homePage = new HomepageFrag();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment, homePage).commit();
        }
    }

    //ActionBar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    //click on action of the actionBar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_save:
                save();
                return true;
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    //Action "Save"
    private void save(){
        Toast.makeText(this,R.string.save_app,Toast.LENGTH_LONG).show();
    }

    private void showFragment(final Fragment fragment) {
        if (fragment == null) {
            return;
        }

        // Begin a fragment transaction.
        final FragmentManager fm = getSupportFragmentManager();
        final FragmentTransaction ft = fm.beginTransaction();
        // We can also animate the changing of fragment.
        ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        // Replace current fragment by the new one.
        ft.replace(R.id.fragment, fragment);


        // Commit changes.
        ft.commit();
    }
}
