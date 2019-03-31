package com.sssa.jspm.ui.fragments.common;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.data.model.AdminResult;
import com.sssa.jspm.data.model.GFMResult;
import com.sssa.jspm.misc.utils.Constants;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.misc.widgets.DividerItemDecoration;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.adapters.AdminTeachersAdapter;
import com.sssa.jspm.ui.adapters.GFMStudentsAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shiv on 3/8/2017.
 */

public class CommonAdminTeachersLoaderFragment extends BaseFragment {

    private Toolbar toolbar;
    private RecyclerView rv;
    private AdminTeachersAdapter adminTeachersAdapter;
    private List<AdminResult> resultList;
    private static String toolbarTitle;
    private static String tableName;
    private Extras prefernces;
    private FloatingActionButton saveButton;

    /**
     * Instance of this class
     */
    public static CommonAdminTeachersLoaderFragment getInstance(String toolbarTitle, String tableName){
        setToolbarTitle(toolbarTitle);
        setTableName(tableName);
        return new CommonAdminTeachersLoaderFragment();
    }


    @Override
    protected int layoutId() {
        return R.layout.student_rv;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.stoolbar);
        rv = (RecyclerView) rootview.findViewById(R.id.stud_rv);
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
        adminTeachersAdapter = new AdminTeachersAdapter(context, resultList,getTableName());
        rv.setAdapter(adminTeachersAdapter);
        MainActivity mainActivity = ((MainActivity) getActivity());
        if (toolbar != null) {
            mainActivity.setSupportActionBar(toolbar);
            if (mainActivity.getSupportActionBar() != null) {
                mainActivity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                mainActivity.getSupportActionBar().setHomeButtonEnabled(true);
                mainActivity.getSupportActionBar().setDisplayShowHomeEnabled(true);
            }
        }

    }


    @Override
    protected Fragment setfragment() {
        return CommonAdminTeachersLoaderFragment.getInstance(getToolbarTitle(),getTableName());
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
        AndroidNetworking.post(Constants.ADMINDATA)
                .addBodyParameter("tablename", "teacher")
                .setPriority(Priority.HIGH)
                .setTag("get_result")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0){
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject json;
                                AdminResult result = new AdminResult();
                                try {
                                    json = response.getJSONObject(i);
                                    result.setFullname(json.getString("fullname"));
                                    result.setId(json.getString("id"));
                                    result.setTeacherid(json.getString("grno"));
//                                    Log.d("data", json.getString("id") +" "+ json.getString("fullname"));
                                    resultList.add(result);
                                    adminTeachersAdapter.addDataList(resultList);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            adminTeachersAdapter.notifyDataSetChanged();
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
