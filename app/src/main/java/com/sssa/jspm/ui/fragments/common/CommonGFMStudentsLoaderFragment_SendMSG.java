package com.sssa.jspm.ui.fragments.common;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.data.model.GFMResult;
import com.sssa.jspm.misc.utils.Constants;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.misc.utils.Helper;
import com.sssa.jspm.misc.widgets.DividerItemDecoration;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.adapters.GFMStudentsAdapter;
import com.sssa.jspm.ui.adapters.GFMStudentsMailAdapter;
import com.sssa.jspm.ui.fragments.SendMessage;
import com.sssa.jspm.ui.fragments.year.FourthYearFragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shiv on 3/8/2017.
 */

public class CommonGFMStudentsLoaderFragment_SendMSG extends BaseFragment {

    private Toolbar toolbar;
    private RecyclerView rv;
    private GFMStudentsMailAdapter gfmStudentsAdapter;
    private List<GFMResult> resultList;
    private static String toolbarTitle;
    private static String tableName;
    private Extras prefernces;
    private FloatingActionButton sendmsg;

    /**
     * Instance of this class
     */
    public static CommonGFMStudentsLoaderFragment_SendMSG getInstance(String toolbarTitle, String tableName){
        setToolbarTitle(toolbarTitle);
        setTableName(tableName);
        return new CommonGFMStudentsLoaderFragment_SendMSG();
    }


    @Override
    protected int layoutId() {
        return R.layout.studentmsg_rv;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.st_stoolbar);
        rv = (RecyclerView) rootview.findViewById(R.id.st_stud_rv);
        sendmsg=(FloatingActionButton) rootview.findViewById(R.id.sendmsg);
    }

    @Override
    protected void function() {
        prefernces = new Extras(getContext());
        Context context= getContext();
        toolbar.setTitle(getToolbarTitle());
        toolbar.showOverflowMenu();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(getContext(), 75));
        rv.setHasFixedSize(true);
        loadData();
        resultList = new ArrayList<>();
        gfmStudentsAdapter = new GFMStudentsMailAdapter(context, resultList, getTableName());
        rv.setAdapter(gfmStudentsAdapter);
        MainActivity mainActivity = ((MainActivity) getActivity());
        if (toolbar != null) {
            mainActivity.setSupportActionBar(toolbar);
            if (mainActivity.getSupportActionBar() != null) {
                mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                mainActivity.getSupportActionBar().setHomeButtonEnabled(true);
                mainActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }
        sendmsg.setVisibility(View.VISIBLE);
        rv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy >0){
                    sendmsg.hide();
                }else {
                    sendmsg.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        sendmsg.setImageBitmap(Helper.textAsBitmap("Send Message", 16, Color.WHITE));
        sendmsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fragmentLoader(SendMessage.getInstances("Send Message"));
                Toast.makeText(getContext(),"Clickced on Send Mail",Toast.LENGTH_LONG).show();
            }
        });

    }

    private void fragmentLoader(Fragment fragment){
        getFragmentManager().beginTransaction().replace(setContainerId(), fragment).addToBackStack(null).commit();
    }
    @Override
    protected Fragment setfragment() {
        return CommonGFMStudentsLoaderFragment_SendMSG.getInstance(getToolbarTitle(),getTableName());
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }


    /**
     * Load data
     */
    private void loadData(){
        Toast.makeText(getContext(),"Inside GFM Load",Toast.LENGTH_SHORT).show();
        AndroidNetworking.post(Constants.GFMDATA)
                .addBodyParameter("tablename", "student")
                .setPriority(Priority.HIGH)
                .setTag("get_result")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0){
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject json;
                                GFMResult result = new GFMResult();
                                try {
                                    json = response.getJSONObject(i);
                                    Toast.makeText(getContext(),json.getString("id"),Toast.LENGTH_SHORT).show();
                                    result.setFullname(json.getString("fullname"));
                                    result.setId(json.getString("id"));
                                    result.setgrno(json.getString("grno"));
                                    Log.d("data", json.getString("id") +" "+ json.getString("fullname"));
                                    resultList.add(result);
                                    gfmStudentsAdapter.addDataList(resultList);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            gfmStudentsAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }

    public static void setToolbarTitle(String toolbarTitles) {
        toolbarTitle = toolbarTitles;
    }

    public static String getToolbarTitle() {
        return toolbarTitle;
    }

    public static String getTableName() {
        return tableName;
    }

    public static void setTableName(String tableNames) {
        tableName = tableNames;
    }


    @Override
    public void FrgamentLoader() {
        super.FrgamentLoader();
    }

}
