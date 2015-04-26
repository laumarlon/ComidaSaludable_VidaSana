package com.csvs.aplicaciones.g1.comidasaludablesvidassanas.facebook;

/**
 * Created by PINEDA on 26/04/2015.
 */
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.csvs.aplicaciones.g1.comidasaludablesvidassanas.R;
import com.facebook.FacebookSdk;

public class InicioFacebook extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciofacebook);
        FacebookSdk.sdkInitialize(getApplicationContext());
        mFragmentManager = getSupportFragmentManager();

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_logo, menu);
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

        if (id == R.id.action_simple_login) {
            toggleFragment(INDEX_SIMPLE_LOGIN);
            return true;
        }
        if (id == R.id.action_custom_login) {
            toggleFragment(INDEX_CUSTOM_LOGIN);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void toggleFragment(int index) {
        Fragment fragment = mFragmentManager.findFragmentByTag(FRAGMENT_TAG);
        FragmentTransaction transaction = mFragmentManager.beginTransaction();
        switch (index){
            case INDEX_SIMPLE_LOGIN:
                transaction.replace(android.R.id.content, new FragmentLogin(),FRAGMENT_TAG);
                break;
            case INDEX_CUSTOM_LOGIN:
                transaction.replace(android.R.id.content, new FragmentLogin(),FRAGMENT_TAG);
                break;
        }
        transaction.commit();
    }
}
