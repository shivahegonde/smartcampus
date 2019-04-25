package com.sssa.jspm.ui.fragments.common;

import android.support.design.widget.Snackbar;
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
import com.sssa.jspm.data.model.Result;
import com.sssa.jspm.misc.utils.Constants;
import com.sssa.jspm.misc.widgets.DividerItemDecoration;
import com.sssa.jspm.ui.activities.MainActivity;
import com.sssa.jspm.ui.adapters.GFMStudentsAdapter;
import com.sssa.jspm.ui.adapters.SyllabusAdapter;
import com.sssa.jspm.ui.adapters.displayAdapters.LoadDataAdapter;
import com.sssa.jspm.ui.adapters.displayAdapters.LoadGFMDataAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Shiv on 3/8/2017.
 */

public class CommonGFMDataLoaderFragment extends BaseFragment {

    private Toolbar toolbar;
    private RecyclerView rv;
    private List<GFMResult> resultList;
    private LoadGFMDataAdapter loadDataAdapter;
    private static String tableName;

    /**
     * Instance of this class
     * @return
     */
    public static CommonGFMDataLoaderFragment getInstance(String tableName){
        setTableName(tableName);
        return new CommonGFMDataLoaderFragment();
    }

    @Override
    protected int layoutId() {
        return R.layout.common_rv;
    }

    @Override
    protected void ui(View rootview) {
        toolbar = (Toolbar) rootview.findViewById(R.id.toolbar);
        rv = (RecyclerView) rootview.findViewById(R.id.rv);
    }

    @Override
    protected void function() {
        toolbar.setTitle("Load Students");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setSmoothScrollbarEnabled(true);
        rv.setLayoutManager(linearLayoutManager);
        rv.addItemDecoration(new DividerItemDecoration(getContext(), 75));
        rv.setHasFixedSize(true);
        loadGFMData();
        resultList = new ArrayList<>();
        loadDataAdapter = new LoadGFMDataAdapter(getContext(), resultList);
        rv.setAdapter(loadDataAdapter);
    }

    @Override
    protected Fragment setfragment() {
        return null;
    }

    @Override
    protected int setContainerId() {
        return 0;
    }


    /**
     * Load syllabus Data
     */
    private void loadGFMData(){
        AndroidNetworking.post(Constants.LOADSTUDENTS)
                .addBodyParameter("tablename", getTableName())
                .setPriority(Priority.HIGH)
                .setTag("get_results")
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        if (response.length() > 0){
                            for (int i = 0; i < response.length(); i++) {
                                GFMResult result = new GFMResult();
                                JSONObject json;
                                try {
                                    json = response.getJSONObject(i);
                                    result.setFullname(json.getString("fullname"));
                                    result.setId(String.valueOf(i+1));
                                    result.setgrno(json.getString("grno"));
                                    String data="Name is "+result.getFullname()+" ID NO "+result.getId()+" GR No "+result.get_pending_fees();
                                    Toast.makeText(getContext(),data,Toast.LENGTH_SHORT).show();
                                    Log.d("fespa", json.getString("id") +" "+ json.getString("chaptername"));
                                    resultList.add(result);
                                    loadDataAdapter.addDataList(resultList);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            loadDataAdapter.notifyDataSetChanged();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {

                    }
                });

    }
    public static String getTableName() {
        return tableName;
    }

    public static void setTableName(String tableNames) {
        tableName = tableNames;
    }

}
