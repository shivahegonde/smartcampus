package com.sssa.jspm.ui.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseRecyclerViewAdapter;
import com.sssa.jspm.data.model.AdminResult;
import com.sssa.jspm.data.model.GFMResult;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Shiv on 2/26/2017.
 */

public class AdminTeachersAdapter extends BaseRecyclerViewAdapter<AdminResult, AdminTeachersAdapter.AdminTeachersViewholder> {


    private List<String> stringList = new ArrayList<>();

    public AdminTeachersAdapter(Context context, @NonNull List<AdminResult> data, String tableName) {
        super(context, data, tableName);
    }

    @Override
    public AdminTeachersViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_list, parent, false);
        return new AdminTeachersViewholder(rootview);
    }

    @Override
    public void onBindViewHolder(final AdminTeachersViewholder holder, final int position) {
        final AdminResult result = getItem(position);
        holder.teacher_name.setText(result.getFullname());
        holder.teacher_count.setText(result.getId()+". ");
        holder.teacherid.setText(result.getTeacherid());
    }

    @Override
    public AdminResult getItem(int position) throws ArrayIndexOutOfBoundsException {
        return super.getItem(position);
    }


    public class AdminTeachersViewholder extends RecyclerView.ViewHolder{

        private TextView teacher_count, teacher_name,teacherid;

        public AdminTeachersViewholder(View itemView) {
            super(itemView);

            teacher_count = (TextView) itemView.findViewById(R.id.students_count);
            teacher_name = (TextView) itemView.findViewById(R.id.students_name);
            teacherid = (TextView) itemView.findViewById(R.id.studentsgrno);
        }
    }
}
