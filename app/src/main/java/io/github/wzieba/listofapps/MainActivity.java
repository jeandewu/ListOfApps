package io.github.wzieba.listofapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressbar);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, true));

        InstalledAppsAsyncTask installedAppsAsyncTask = new InstalledAppsAsyncTask();
        installedAppsAsyncTask.execute();
    }

    private class InstalledAppsAsyncTask extends AsyncTask<Void, Void, AppAdapter> {

        @Override
        protected AppAdapter doInBackground(Void... voids) {
            PackageManager packageManager = getPackageManager();
            List<ApplicationInfo> apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);

            List<AppInfo> appInfos = new ArrayList<>();

            for (ApplicationInfo applicationInfo : apps) {
                appInfos.add(new AppInfo(
                        applicationInfo.uid,
                        applicationInfo.loadLabel(packageManager).toString(),
                        applicationInfo.loadIcon(packageManager)
                ));
            }

            return new AppAdapter(appInfos);
        }

        @Override
        protected void onPostExecute(AppAdapter appAdapter) {
            super.onPostExecute(appAdapter);
            progressBar.setVisibility(View.GONE);
            recyclerView.setAdapter(appAdapter);
        }
    }

}
