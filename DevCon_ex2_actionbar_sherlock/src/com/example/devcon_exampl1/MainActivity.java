package com.example.devcon_exampl1;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.widget.Toast;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;

public class MainActivity extends SherlockActivity {

    private static final int NUM_TABS = 3;
    private String[] tabsTitleArray;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);
        initTabs();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getSupportMenuInflater();
        inflater.inflate(R.menu.activity_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Toast toast = Toast.makeText(MainActivity.this, "HOME", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            case R.id.search:
                //Toast toast = Toast.makeText(MainActivity.this, "Search", Toast.LENGTH_SHORT);
                //toast.show();
                return true;
        }
        return super.onMenuItemSelected(featureId, item);
    }

    private void initTabs() {
        tabsTitleArray = getResources().getStringArray(R.array.main_tab);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        for (int i = 0; i < NUM_TABS; i++) {
            actionbar.addTab(actionbar.newTab().setText(tabsTitleArray[i]).setTabListener(new MyTabsListener()));
        }
    }

    class MyTabsListener implements ActionBar.TabListener {
        public void onTabReselected(Tab tab, FragmentTransaction ft) {

        }

        public void onTabSelected(Tab tab, FragmentTransaction ft) {
            Toast toast = Toast.makeText(MainActivity.this, "Pulsado el tab "
                    + tabsTitleArray[tab.getPosition()], Toast.LENGTH_SHORT);
            toast.show();
        }

        public void onTabUnselected(Tab tab, FragmentTransaction ft) {

        }
    }
}
