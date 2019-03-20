package com.sssa.jspm.ui.fragments;

import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.data.network.inputview;
import com.sssa.jspm.data.network.sendMail;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.fragments.common.CommonDataLoaderFragment;
import com.sssa.jspm.ui.fragments.common.CommonSyllabusLoaderFragment;
import com.sssa.jspm.data.network.sendMail;

/**
 * Created by Shiv on 3/8/2017.
 */

public class SendMessage extends BaseFragment {

    private Toolbar toolbar;
    private static String toolbarTitle;
    private TextInputEditText to,message;
    private AppCompatButton send;
    private Extras prefernces;
    private String usermail,usermessage;

    /**
     * Instance of this class
     * @return
     */
    public static SendMessage getInstances(String toolbarTitle){
        setToolbarTitle(toolbarTitle);
        return new SendMessage();
    }

    @Override
    protected int layoutId() {
        return R.layout.sendmessage;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.stoolbar);
        to=(TextInputEditText) rootview.findViewById(R.id.mail_id);
        message=(TextInputEditText) rootview.findViewById(R.id.message);
        send=(AppCompatButton) rootview.findViewById(R.id.sendmail);
    }

    @Override
    protected void function() {
        prefernces = new Extras(getContext());
        toolbar.setTitle(getToolbarTitle());
        send.setOnClickListener(onClick);
    }

    /**
     * ClickListerner
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.sendmail:
                    sendMail(view);
                    break;
            }
        }
    };
    private void sendMail(View view){
        usermail=to.getText().toString().trim();
        usermessage=message.getText().toString().trim();
        if(!usermail.isEmpty() && !usermessage.isEmpty()) {
            sendMail.SendMail(getContext(), view, usermail, usermessage, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return to;
                }
            }, new inputview() {
                @Override
                public TextInputEditText gettext() {
                    return message;
                }
            });
        }
    }

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
