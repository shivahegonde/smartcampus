package com.sssa.jspm.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseRecyclerViewAdapter;
import com.sssa.jspm.data.model.GFMResult;
import com.sssa.jspm.misc.utils.Constants;
import com.sssa.jspm.misc.utils.Extras;

import java.util.ArrayList;
import java.util.List;

import static com.sssa.jspm.misc.utils.Helper.now;


/**
 * Created by Shiv on 2/26/2017.
 */

public class GFMStudentsAdapter extends BaseRecyclerViewAdapter<GFMResult, GFMStudentsAdapter.GFMStudentsViewholder> {


    private List<String> stringList = new ArrayList<>();

    public GFMStudentsAdapter(Context context, @NonNull List<GFMResult> data, String tableName) {
        super(context, data, tableName);
    }

    @Override
    public GFMStudentsViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.students_list, parent, false);
        return new GFMStudentsViewholder(rootview);
    }

    @Override
    public void onBindViewHolder(final GFMStudentsViewholder holder, final int position) {
        final GFMResult result = getItem(position);
        holder.students_name.setText(result.getFullname());
        holder.students_count.setText(result.getId()+". ");
        holder.studentsgrno.setText(result.getgrno());
    }

    @Override
    public GFMResult getItem(int position) throws ArrayIndexOutOfBoundsException {
        return super.getItem(position);
    }


    public class GFMStudentsViewholder extends RecyclerView.ViewHolder{

        private TextView students_count, students_name,studentsgrno;

        public GFMStudentsViewholder(View itemView) {
            super(itemView);

            students_count = (TextView) itemView.findViewById(R.id.students_count);
            students_name = (TextView) itemView.findViewById(R.id.students_name);
            studentsgrno = (TextView) itemView.findViewById(R.id.studentsgrno);
        }
    }
}
