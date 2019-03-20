package com.sssa.jspm.ui.adapters.displayAdapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseRecyclerViewAdapter;
import com.sssa.jspm.data.model.GFMResult;
import com.sssa.jspm.data.model.Result;

import java.util.List;

/**
 * Created by Shiv on 2/27/2017.
 */

public class LoadGFMDataAdapter extends BaseRecyclerViewAdapter<GFMResult, LoadGFMDataAdapter.loadGFMStudentsViewholder> {

    public LoadGFMDataAdapter(@NonNull Context context, @NonNull List<GFMResult> data) {
        super(context, data);
    }

    @Override
    public LoadGFMDataAdapter.loadGFMStudentsViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        Toast.makeText(getContext(),"Loading inflate..",Toast.LENGTH_SHORT).show();
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.loadgfmdata_list, parent, false);
        return new loadGFMStudentsViewholder(rootview);
    }

    @Override
    public void onBindViewHolder(LoadGFMDataAdapter.loadGFMStudentsViewholder holder, int position) {
        holder.studentgr.setText(getItem(position).getgrno());
        holder.student_count.setText(getItem(position).getId());
        holder.studentname.setText(getItem(position).getFullname());
    }

    public class loadGFMStudentsViewholder extends RecyclerView.ViewHolder {

        private TextView student_count, studentname, studentgr;

        public loadGFMStudentsViewholder(View itemView) {
            super(itemView);

            student_count = (TextView) itemView.findViewById(R.id.student_count);
            studentname = (TextView) itemView.findViewById(R.id.studentname);
            studentgr = (TextView) itemView.findViewById(R.id.studentgr);
        }
    }
}
