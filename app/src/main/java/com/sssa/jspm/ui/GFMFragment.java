package com.sssa.jspm.ui;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.fragments.NoticeFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMDataLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMStudentsLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMStudentsLoaderFragment_SendMSG;
import com.sssa.jspm.ui.fragments.gfm.GFMBatchStudents;
import com.sssa.jspm.ui.fragments.year.FirstYearFragment;
import com.sssa.jspm.ui.fragments.year.FourthYearFragment;

/**
 * Created by Shiv on 3/7/2017.
 */

public class GFMFragment extends BaseFragment {

    private Toolbar toolbar;
    private AppCompatButton allstudents,sendmail;
    private static String toolbarTitle;
    private Extras prefernces;

    /**
     * Instance of this class
     *
     * @return
     */
    public static GFMFragment getInstance(String toolbarTitle) {
        setToolbarTitle(toolbarTitle);
        return new GFMFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.gfm_module;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        allstudents = (AppCompatButton) rootview.findViewById(R.id.allstudents);
        sendmail = (AppCompatButton) rootview.findViewById(R.id.sendmail);

    }

    @Override
    protected void function() {
        toolbar.setTitle(getToolbarTitle());
        allstudents.setOnClickListener(onClick);
        sendmail.setOnClickListener(onClick);

        prefernces = new Extras(getContext());
    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.allstudents:
//                    prefernces.setGFMBatchStudents(false);
//                    fragmentLoader(CommonGFMDataLoaderFragment.getInstance("student"));
                    fragmentLoader(CommonGFMStudentsLoaderFragment.getInstance("Students", "student"));
//                    startActivity(GFMBatchStudents.getInstance("GFM Batch"));
                    break;
                case R.id.sendmail:
                    fragmentLoader(CommonGFMStudentsLoaderFragment_SendMSG.getInstance("Students", "student"));

                    break;
            }
        }
    };

    public static String getToolbarTitle() {
        return toolbarTitle;
    }

    public static void setToolbarTitle(String toolbarTitles) {
        toolbarTitle = toolbarTitles;
    }

    private void fragmentLoader(Fragment fragment) {
        getFragmentManager().beginTransaction().replace(setContainerId(), fragment).addToBackStack(null).commit();
    }
}
