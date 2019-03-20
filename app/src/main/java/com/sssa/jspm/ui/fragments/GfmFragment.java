package com.sssa.jspm.ui.fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.ui.GFMFragment;
import com.sssa.jspm.ui.activities.AboutActivity;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.fragments.common.CommonYrFragment;

/**
 * Created by Shiv on 2/23/2017.
 */

public class GfmFragment extends BaseFragment implements NavigationView.OnNavigationItemSelectedListener {


    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private Extras preferences;
    private ImageView gfmbatch, sendmsg;
    private ActionBarDrawerToggle barDrawerToggle;
    private TextView userName;
    private View navigationHeader;

    /**
     * Instance of this class
     *
     * @return
     */
    public static GfmFragment getInstance() {
        return new GfmFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_gfm;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        navigationView = (NavigationView) rootview.findViewById(R.id.navigation_view);
        drawerLayout = (DrawerLayout) rootview.findViewById(R.id.drawerLayout);
        gfmbatch = (ImageView) rootview.findViewById(R.id.gfmbatch);
        sendmsg = (ImageView) rootview.findViewById(R.id.sendmsg);
        navigationHeader = navigationView.inflateHeaderView(R.layout.navigation_headerview);
        userName = (TextView) navigationHeader.findViewById(R.id.userName);
    }

    @Override
    protected void function() {
        toolbar.setTitle(getString(R.string.gfm));
        MainActivity mainActivity = ((MainActivity) getActivity());
        barDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(barDrawerToggle);
        barDrawerToggle.syncState();
        if (toolbar != null) {
            mainActivity.setSupportActionBar(toolbar);
            if (mainActivity.getSupportActionBar() != null) {
                mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                mainActivity.getSupportActionBar().setHomeButtonEnabled(true);
                mainActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }
        navigationView.setNavigationItemSelectedListener(this);
        setHasOptionsMenu(true);
        preferences = new Extras(getContext());
        sendmsg.setOnClickListener(onClick);
        gfmbatch.setOnClickListener(onClick);

        if (userName != null){
            userName.setText(preferences.getUserName());
        }

//        Glide.with(getContext())
//                .load(R.drawable.gfmbatch)
//                .crossFade()
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .override(300,300)
//                .into(gfmbatch);
//
//        Glide.with(getContext())
//                .load(R.drawable.sendmsg)
//                .crossFade()
//                .centerCrop()
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .placeholder(R.mipmap.ic_launcher)
//                .error(R.mipmap.ic_launcher)
//                .override(300,300)
//                .into(sendmsg);
    }

    /**
     * OnclickListerner
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.gfmbatch:
//                    preferences.branchCmpn("cmpn");
//                    fragmentLoaders(CommonYrFragment.getInstance("CMPN"));
                    fragmentLoaders(GFMFragment.getInstance("GFM"));
                    break;

                case R.id.sendmsg:
//                    preferences.branchCmpn("cmpn");
//                    fragmentLoaders(CommonYrFragment.getInstance("CMPN"));
                    fragmentLoaders(SendMessage.getInstances("Send Message"));
                    break;


            }

        }
    };

    @Override
    protected Fragment setfragment() {
        return LoginProcess.getInstance();
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        drawerLayout.closeDrawers();
        drawerLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                switch (item.getItemId()) {
                    case R.id.dept:
                        if (GfmFragment.getInstance().isAdded()){
                            getFragmentManager().beginTransaction().detach(GfmFragment.getInstance()).attach(GfmFragment.getInstance()).addToBackStack(null).commit();
                        }
                        break;
                    case R.id.general:
                        fragmentLoaders(GeneralFragment.getInstance(false, true));
                        break;
                    case R.id.about:
                        Intent intents = new Intent(getActivity(), AboutActivity.class);
                        startActivity(intents);
                        break;
                }
            }
        }, 75);
        return true;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public void FrgamentLoader() {
        super.FrgamentLoader();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout:
                preferences.getUserSessionEdit().clear();
                preferences.getUserSessionEdit().commit();
                FrgamentLoader();
                break;
        }
        return true;
    }

    /**
     * Load Fragments
     * @param fragment
     */
    private void fragmentLoaders(Fragment fragment){
        getFragmentManager().beginTransaction().replace(setContainerId(), fragment).addToBackStack(null).commit();
    }
}

