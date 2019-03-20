package com.sssa.jspm.data.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.sssa.jspm.misc.utils.Constants;
import com.sssa.jspm.misc.utils.Extras;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Shiv on 2/22/2017.
 */

public class sendMail {
    /**
     * Default Constructor
     */
    public sendMail() {

    }

    /**
     * Register user account
     * @param view
     * @param inputview
     * @param inputview2
     */

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void SendMail(final Context context, final View view, final String to, final String message, final inputview inputview, final inputview inputview2) {
        final Extras prefrences = new Extras(context);
        try {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    AndroidNetworking.post(Constants.SENDMAIL)
                            .addBodyParameter("to", to)
                            .addBodyParameter("message", message)
                            .setTag("sendmail")
                            .setPriority(Priority.HIGH)
                            .build()
                            .getAsJSONObject(new JSONObjectRequestListener() {
                                @Override
                                public void onResponse(JSONObject response) {
                                    String msg = "Successfully mail sent to Student";
                                    inputview.gettext().getText().clear();
                                    inputview2.gettext().getText().clear();
//                                progressDialog.dismiss();
                                    try {
                                        boolean goterror = response.getBoolean("error");
                                        if (!goterror) {
                                            Log.d("Send Mail", "success" + response.toString());
                                            Snackbar.make(view, msg, Snackbar.LENGTH_LONG).setText(msg).show();
                                            Log.d("Student", "Mail sent Success");
                                        } else {
                                            String error_msg = response.getString("error_msg");
//                                        progressDialog.dismiss();
                                            Snackbar.make(view, error_msg, Snackbar.LENGTH_LONG).setText(error_msg).show();
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }

                                @Override
                                public void onError(ANError anError) {

                                }
                            });
                }
            }, 200);
        } catch (Exception e) {

        }
    }
}