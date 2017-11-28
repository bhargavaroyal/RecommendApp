package com.droid.tv.recommendapp;

import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.List;

/**
 * Created by bhargava.gugamsetty on 03-11-2017.
 */

public class MainActivity extends Activity {

    Switch s1;
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG ,"onCreate");
        setContentView(R.layout.activity_main);

        ListView listInstalledApps = findViewById(R.id.installed_app_list);

        List<AppList> installedApps = getInstalledApps();
        AppAdapter installedAppAdapter = new AppAdapter(MainActivity.this, installedApps);
        listInstalledApps.setAdapter(installedAppAdapter);

        listInstalledApps.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.d(TAG ,"onItemClick");
//                Toast.makeText(getBaseContext(), position, Toast.LENGTH_LONG).show();
                s1.requestFocus();
                s1= (Switch) findViewById(R.id.control_switch);
                s1.setChecked(true);
            }
        });


        listInstalledApps.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(getBaseContext(), i, Toast.LENGTH_LONG).show();
                Log.d(TAG ,"item selected");
                s1= (Switch) findViewById(R.id.control_switch);
                s1.setChecked(true);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private List<AppList> getInstalledApps() {
        List<AppList> res = new ArrayList<AppList>();
        List<PackageInfo> packs = getPackageManager().getInstalledPackages(0);
        for (int i = 0; i < packs.size(); i++) {
            PackageInfo p = packs.get(i);

                String appName = p.applicationInfo.loadLabel(getPackageManager()).toString();
                Drawable icon = p.applicationInfo.loadIcon(getPackageManager());
                res.add(new AppList(appName, icon));

        }
        return res;
    }
}
