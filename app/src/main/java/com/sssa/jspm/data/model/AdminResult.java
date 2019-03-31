package com.sssa.jspm.data.model;

/**
 * Created by Shiv on 2/26/2017.
 */


public class AdminResult {

    private String id;
    private String fullname;
    private String teacherid;
    private String checked;
    private boolean ischecked;


    public String getId() {
        return id;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTeacherid() {
        return teacherid;
    }
    public void setChecked(String checked) {
        this.checked = checked;
    }


    public boolean ischecked() {
        return ischecked;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

}
