package com.sssa.jspm.data.network;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.sssa.jspm.misc.utils.Constants;
import com.sssa.jspm.misc.utils.Extras;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Rutuja on 03-04-2019.
 */


public class setYear {

    /**
     * Default Constructor
     */
    public setYear() {
    }


    /**
     * Register user account
     *
     * @param view

     * @param inputview

     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static void SetYear(final Context context, final View view, final String username, final String year, final inputview inputview) {
        final Extras prefrences = new Extras(context);
        //final String classString="wee";
        final ProgressDialog progressDialog = new ProgressDialog(context);
        progressDialog.setProgressStyle(android.R.style.Widget_Material_ProgressBar);
        progressDialog.setIndeterminate(true);
        progressDialog.setTitle("Updating");
        progressDialog.setMessage("Please wait...");
        progressDialog.show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AndroidNetworking.post(Constants.ASSIGNYEAR)
                        .addBodyParameter("username", username)
                        .addBodyParameter("year", year)

                        .setTag("assignment")
                        .setPriority(Priority.HIGH)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                inputview.gettext().getText().clear();
                                progressDialog.dismiss();
                                try {
                                    boolean goterror = response.getBoolean("error");
                                    if (!goterror) {
                                        Log.d("SetUp", "success" + response.toString());
                                        String msg = "Success Asign Year To "+username;
                                        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).setText(msg).show();
                                        Log.d("SetUp", " Success");
                                    } else {
                                        String error_msg = response.getString("error_msg");
                                        progressDialog.dismiss();
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

    }
}