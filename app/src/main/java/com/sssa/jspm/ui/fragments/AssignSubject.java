package com.sssa.jspm.ui.fragments;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.data.network.inputview;
import com.sssa.jspm.data.network.setSub;
import com.sssa.jspm.misc.utils.Extras;

/**
 * Created by Rutuja on 20-04-2019.
 */

/**
 * Created by Rutuja on 02-04-2019.
 */

public class AssignSubject extends BaseFragment {

    private TextInputEditText usernameInput;
    private AppCompatButton set;
    Spinner subjectInput;
    private Toolbar toolbar;
    private static String toolbarTitle;

    private Extras prefernces;
    String[] SUBJECTLIST ={"DAA","HPC","AIR","DMV"};


    private String username,subject;
    private static boolean buttonAnim;

    /**
     * Instance of fragment
     * @return
     */

    public static AssignSubject getInstances(String toolbarTitle){
        setToolbarTitle(toolbarTitle);
        return new AssignSubject();
    }


    public static AssignSubject getInstance(boolean buttonAnim){
        setButtonAnim(buttonAnim);
        return new AssignSubject();
    }

    @Override
    protected int layoutId() {
        return R.layout.assign_subject;
    }

    @Override
    protected void ui(View rootview) {
        usernameInput = (TextInputEditText) rootview.findViewById(R.id.username);
        subjectInput = (Spinner)rootview.findViewById(R.id.subject_input);
        set = (AppCompatButton) rootview.findViewById(R.id.set);


        ArrayAdapter<String> arrayAdapterdepartment = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, SUBJECTLIST);

        subjectInput.setAdapter(arrayAdapterdepartment);

        subjectInput.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                // Toast.makeText(getContext(), DEPARTMENTLIST[position],Toast.LENGTH_LONG).show();
                subject = SUBJECTLIST[position].toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });





    }


    @Override
    protected void function() {
        set.setEnabled(true);
        set.setOnClickListener(onClick);
        if (buttonAnim){
            Animation animation= AnimationUtils.loadAnimation(getContext(),R.anim.rotate_left_to_right);
            set.setAnimation(animation);
        }

        prefernces = new Extras(getContext());
    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }

    @Override
    public void FrgamentLoader() {
        super.FrgamentLoader();
    }



    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()){

                case R.id.set:
                    setSubject(view);
                    break;
            }
        }
    };


    /**
     * Register account
     * @param view
     */
    private void setSubject(View view){
        username = usernameInput.getText().toString().trim();

        /**
         * register account
         */if (!username.isEmpty() && !subject.isEmpty()  )
            setSub.SetSub(getContext(), view, username, subject, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return usernameInput;
                }

            });
        else {

            if (username.isEmpty()){
                usernameInput.setError("enter valid user name");
            }

        }
    }



    public static String getToolbarTitle() {
        return toolbarTitle;
    }

    public static void setToolbarTitle(String toolbarTitles) {
        toolbarTitle = toolbarTitles;
    }

    public static void setButtonAnim(boolean buttonAnims) {
        buttonAnim = buttonAnims;
    }
}
