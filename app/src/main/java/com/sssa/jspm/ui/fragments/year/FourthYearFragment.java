package com.sssa.jspm.ui.fragments.year;

import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.fragments.common.CommonDataLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonSyllabusLoaderFragment;

/**
 * Created by Shiv on 3/8/2017.
 */

public class FourthYearFragment extends BaseFragment {

    private Toolbar toolbar;
    private static String toolbarTitle;
    private TextView dsp,mc,pm,sc,ss;
    private Extras prefernces;

    /**
     * Instance of this class
     * @return
     */
    public static FourthYearFragment getInstances(String toolbarTitle){
        setToolbarTitle(toolbarTitle);
        return new FourthYearFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.fragment_fourthyear;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        dsp = (TextView) rootview.findViewById(R.id.syallbus_dsp);
        mc = (TextView) rootview.findViewById(R.id.syallbus_mc);
        pm = (TextView) rootview.findViewById(R.id.syallbus_pm);
        sc = (TextView) rootview.findViewById(R.id.syallbus_sc);
        ss = (TextView) rootview.findViewById(R.id.syallbus_ss);
    }

    @Override
    protected void function() {
        prefernces = new Extras(getContext());
        toolbar.setTitle(getToolbarTitle());
        mc.setOnClickListener(onClick);
        pm.setOnClickListener(onClick);
        sc.setOnClickListener(onClick);
        ss.setOnClickListener(onClick);
        dsp.setOnClickListener(onClick);
        if (prefernces.getfourthYear()){
            toolbar.setVisibility(View.GONE);
        }else {
            toolbar.setVisibility(View.VISIBLE);
        }
    }

    /**
     * ClickListerner
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.syallbus_mc:
                    if (prefernces.getfourthYear()){
                        fragmentLoader(CommonDataLoaderFragment.getInstance("mc"));
                    }else {
                        fragmentLoader(CommonSyllabusLoaderFragment.getInstance("Mc Syllabus", "mc"));
                        prefernces.setSubjectName("atmc");
                    }
                    break;

                case R.id.syallbus_dsp:
                    if (prefernces.getfourthYear()){
                        fragmentLoader(CommonDataLoaderFragment.getInstance("dsp"));
                    }else {
                        fragmentLoader(CommonSyllabusLoaderFragment.getInstance("Dsp Syllabus", "dsp"));
                        prefernces.setSubjectName("atdsp");
                    }
                    break;

                case R.id.syallbus_ss:
                    if (prefernces.getfourthYear()){
                        fragmentLoader(CommonDataLoaderFragment.getInstance("ss"));
                    }else {
                        fragmentLoader(CommonSyllabusLoaderFragment.getInstance("Ss Syllabus", "ss"));
                    }
                    break;

                case R.id.syallbus_sc:
                    if (prefernces.getfourthYear()){
                        fragmentLoader(CommonDataLoaderFragment.getInstance("sc"));
                    }else {
                        fragmentLoader(CommonSyllabusLoaderFragment.getInstance("Sc Syllabus", "sc"));
                    }
                    break;

                case R.id.syallbus_pm:
                    if (prefernces.getfourthYear()){
                        fragmentLoader(CommonDataLoaderFragment.getInstance("pm"));
                    }else {
                        fragmentLoader(CommonSyllabusLoaderFragment.getInstance("Pm Syllabus", "pm"));
                    }
                    break;
            }
        }
    };

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    public static String getToolbarTitle() {
        return toolbarTitle;
    }

    public static void setToolbarTitle(String toolbarTitles) {
        toolbarTitle = toolbarTitles;
    }

    private void fragmentLoader(Fragment fragment){
        getFragmentManager().beginTransaction().replace(setContainerId(), fragment).addToBackStack(null).commit();
    }
}
