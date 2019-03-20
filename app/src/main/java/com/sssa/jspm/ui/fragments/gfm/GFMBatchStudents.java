package com.sssa.jspm.ui.fragments.gfm;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMDataLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMStudentsLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonSyllabusLoaderFragment;

/**
 * Created by Shiv on 3/7/2017.
 */

public class GFMBatchStudents extends BaseFragment {

    private Toolbar toolbar;
    private static String toolbarTitle;


    /**
     * Instance of this class
     * @return
     */
    public static GFMBatchStudents getInstance(String toolbarTitle){
        setToolbarTitle(toolbarTitle);
        return new GFMBatchStudents();
    }
    @Override
    protected int layoutId() {
        return R.layout.gfm_students;
    }
    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
    }
    @Override
    protected void function() {
        Toast.makeText(getContext(),"Testing",Toast.LENGTH_SHORT).show();
        fragmentLoader(CommonGFMDataLoaderFragment.getInstance("student"));
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

    private void fragmentLoader(Fragment fragment){
        getFragmentManager().beginTransaction().replace(setContainerId(), fragment).addToBackStack(null).commit();
    }
    public static void setToolbarTitle(String toolbarTitles) {
        toolbarTitle = toolbarTitles;
    }
}
