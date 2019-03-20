package com.sssa.jspm.ui.fragments.year;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;

/**
 * Created by Shiv on 3/7/2017.
 */

public class FirstYearFragment extends BaseFragment {

    private Toolbar toolbar;
    private static String toolbarTitle;


    /**
     * Instance of this class
     * @return
     */
    public static FirstYearFragment getInstance(String toolbarTitle){
        setToolbarTitle(toolbarTitle);
        return new FirstYearFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_firstyear;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
    }

    @Override
    protected void function() {
        toolbar.setTitle(getToolbarTitle());
    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }

    public static String getToolbarTitle() {
        return toolbarTitle;
    }

    public static void setToolbarTitle(String toolbarTitles) {
        toolbarTitle = toolbarTitles;
    }
}
