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


/**
 * Created by Shiv on 2/26/2017.
 */

public class GFMStudentsMailAdapter extends BaseRecyclerViewAdapter<GFMResult, GFMStudentsMailAdapter.GFMStudentsViewholder> {


    private List<String> stringList = new ArrayList<>();

    public GFMStudentsMailAdapter(Context context, @NonNull List<GFMResult> data, String tableName) {
        super(context, data, tableName);
    }

    @Override
    public GFMStudentsViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootview = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list, parent, false);
        return new GFMStudentsViewholder(rootview);
    }

    @Override
    public void onBindViewHolder(final GFMStudentsViewholder holder, final int position) {
        final GFMResult result = getItem(position);
        holder.students_name.setText(result.getFullname());
        holder.students_count.setText(result.getId()+". ");
        holder.studentsgrno.setText(result.getgrno());
        holder.checkBox.setChecked(result.ischecked());
        holder.checkBox.setTag(position);
        holder.checkBox.setOnCheckedChangeListener(null);
        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                result.setIschecked(b);
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(result.ischecked()) {

                    stringList.add(holder.students_name.getText().toString());
                    new Extras(getContext()).saveGFMData(stringList);
                    holder.students_name.setTextColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
                } else  {
                    stringList.clear();
                    new Extras(getContext()).getSharedPreferences().edit().remove(Constants.GFMSTUDENT).commit();
                    holder.students_name.setTextColor(Color.BLACK);
                }
            }
        });
    }

    @Override
    public GFMResult getItem(int position) throws ArrayIndexOutOfBoundsException {
        return super.getItem(position);
    }


    public class GFMStudentsViewholder extends RecyclerView.ViewHolder{

        private TextView students_count, students_name,studentsgrno;
        private CheckBox checkBox;

        public GFMStudentsViewholder(View itemView) {
            super(itemView);

            students_count = (TextView) itemView.findViewById(R.id.students_count);
            students_name = (TextView) itemView.findViewById(R.id.students_name);
            studentsgrno = (TextView) itemView.findViewById(R.id.studentsgrno);
            checkBox = (CheckBox) itemView.findViewById(R.id.scheckbox);
        }
    }
}
