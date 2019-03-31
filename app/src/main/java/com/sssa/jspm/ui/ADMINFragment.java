package com.sssa.jspm.ui;

import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.fragments.common.CommonAdminTeachersLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMStudentsLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonGFMStudentsLoaderFragment_SendMSG;

/**
 * Created by Shiv on 3/7/2017.
 */

public class ADMINFragment extends BaseFragment {

    private Toolbar toolbar;
    private AppCompatButton allteachers,sendmail;
    private static String toolbarTitle;
    private Extras prefernces;

    /**
     * Instance of this class
     *
     * @return
     */
    public static ADMINFragment getInstance(String toolbarTitle) {
        setToolbarTitle(toolbarTitle);
        return new ADMINFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.admin_module;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        allteachers = (AppCompatButton) rootview.findViewById(R.id.allteachers);
        sendmail = (AppCompatButton) rootview.findViewById(R.id.sendmail);

    }

    @Override
    protected void function() {
        toolbar.setTitle(getToolbarTitle());
        allteachers.setOnClickListener(onClick);
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
                case R.id.allteachers:
//                    prefernces.setGFMBatchStudents(false);
//                    fragmentLoader(CommonGFMDataLoaderFragment.getInstance("student"));
                    fragmentLoader(CommonAdminTeachersLoaderFragment.getInstance("Teachers", "admins"));
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
