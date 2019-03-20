package com.sssa.jspm.ui.fragments;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.sssa.jspm.R;
import com.sssa.jspm.base.BaseFragment;
import com.sssa.jspm.misc.utils.Extras;
import com.sssa.jspm.ui.activities.MainActivity;

/**
 * Created by Shiv on 2/22/2017.
 */

public class LoginProcess extends BaseFragment {

    private ImageView student,teacher,other,facebook,instagram,twitter,web,gfm,admin;
    private Extras prefernces;

    /**
     * instance of this class
     * @return
     */
    public static LoginProcess getInstance(){
        return new LoginProcess();
    }

    @Override
    protected int layoutId() {
        return R.layout.login_process;
    }

    @Override
    protected void ui(View rootview) {
        student = (ImageView) rootview.findViewById(R.id.studentlogin);
        teacher = (ImageView) rootview.findViewById(R.id.teacherlogin);
        other = (ImageView) rootview.findViewById(R.id.nonteacherlogin);
        facebook=(ImageView)rootview.findViewById(R.id.facebook);
        instagram=(ImageView)rootview.findViewById(R.id.instagram);
        twitter=(ImageView)rootview.findViewById(R.id.twitter);
        web=(ImageView)rootview.findViewById(R.id.web);
        gfm=(ImageView)rootview.findViewById(R.id.gfm);
        admin=(ImageView)rootview.findViewById(R.id.admin);
    }

    @Override
    protected void function() {
        other.setOnClickListener(onClick);
        student.setOnClickListener(onClick);
        teacher.setOnClickListener(onClick);
        facebook.setOnClickListener(onClick);
        twitter.setOnClickListener(onClick);
        instagram.setOnClickListener(onClick);
        web.setOnClickListener(onClick);
        gfm.setOnClickListener(onClick);
        admin.setOnClickListener(onClick);
        prefernces = new Extras(getContext());
        Glide.with(getContext())
                .load(R.drawable.studenticon)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(300,300)
                .into(student);

        Glide.with(getContext())
                .load(R.drawable.teachericon)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(300,300)
                .into(teacher);

        Glide.with(getContext())
                .load(R.drawable.nonteachingicon)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(300,300)
                .into(other);
        Glide.with(getContext())
                .load(R.drawable.gfmicon)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(300,300)
                .into(gfm);
        Glide.with(getContext())
                .load(R.drawable.adminicon)
                .crossFade()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .override(300,300)
                .into(admin);

    }

    @Override
    protected Fragment setfragment() {
        return CommonFragment.getInstance();
    }

    @Override
    protected int setContainerId() {
        return ((MainActivity) getActivity()).setContainerId();
    }

    @Override
    public void FrgamentLoader() {
        super.FrgamentLoader();
    }

    /**
     * OnClickListener
     */
    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.studentlogin :
                    Toast.makeText(getContext(),"Student Clicked",Toast.LENGTH_LONG).show();
                    FrgamentLoader();
                    //save prefences
                    prefernces.setStudent("0");

                    prefernces.setTeacher(null);
                    prefernces.setStudentTrack(true);
                    prefernces.setNTeacherTrack(false);
                    prefernces.setGFMTrack(false);
                    prefernces.setTeacherTrack(false);
                    break;

                case R.id.teacherlogin:
                    FrgamentLoader();
                    //save prefences
                    prefernces.setTeacher("3");
                    prefernces.setStudentTrack(false);
                    prefernces.setNTeacherTrack(false);
                    prefernces.setGFMTrack(false);
                    prefernces.setTeacherTrack(true);
                    break;

                case R.id.nonteacherlogin:
                    FrgamentLoader();
                    //save prefences
                    prefernces.setNTeacher("6");
                    prefernces.setStudentTrack(false);
                    prefernces.setGFMTrack(false);
                    prefernces.setNTeacherTrack(true);
                    prefernces.setTeacherTrack(false);
                    break;

                case R.id.gfm:
                    FrgamentLoader();
                    //save prefences
                    prefernces.setGfm("9");
                    prefernces.setStudentTrack(false);
                    prefernces.setGFMTrack(true);

                    prefernces.setNTeacherTrack(false);
                    prefernces.setTeacherTrack(false);
                    break;
                case R.id.facebook:
                    Intent browserFacebookIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com/icoer"));
                    startActivity(browserFacebookIntent);
                    break;
                case R.id.instagram:
                    Intent browserInstagramIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.instagram.com/icoerian_insta"));
                    startActivity(browserInstagramIntent);

                    break;
                case R.id.twitter:
                    Intent browserTwitterIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.twitter.com/jspmicoer"));
                    startActivity(browserTwitterIntent);

                    break;
                case R.id.web:
                    Intent browserWebIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jspmicoer.edu.in"));
                    startActivity(browserWebIntent);

                    break;


            }
        }
    };
}
