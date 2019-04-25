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
import com.sssa.jspm.data.model.GFMFeesResult;
import com.sssa.jspm.data.model.GFMResult;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Shiv on 2/26/2017.
 */

public class GFMStudentsFeesAdapter extends BaseRecyclerViewAdapter<GFMFeesResult, GFMStudentsFeesAdapter.GFMStudentsViewholder> {


    private List<String> stringList = new ArrayList<>();

    public GFMStudentsFeesAdapter(Context context, @NonNull List<GFMFeesResult> data, String tableName) {
        super(context, data, tableName);
    }

    @Override
    public GFMStudentsViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_fees_list, parent, false);
        return new GFMStudentsViewholder(rootview);
    }

    @Override
    public void onBindViewHolder(final GFMStudentsViewholder holder, final int position) {
        final GFMFeesResult result = getItem(position);
        holder.students_name.setText(result.getFullname());
        holder.students_count.setText(result.getId()+". ");
        holder.studentsfees.setText(result.get_pending_fees());
    }

    @Override
    public GFMFeesResult getItem(int position) throws ArrayIndexOutOfBoundsException {
        return super.getItem(position);
    }


    public class GFMStudentsViewholder extends RecyclerView.ViewHolder{

        private TextView students_count, students_name,studentsfees;

        public GFMStudentsViewholder(View itemView) {
            super(itemView);

            students_count = (TextView) itemView.findViewById(R.id.students_count);
            students_name = (TextView) itemView.findViewById(R.id.students_name);
            studentsfees = (TextView) itemView.findViewById(R.id.students_fees);
        }
    }
}
