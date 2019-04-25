package com.sssa.jspm.misc.utils;

/**
 * Created by Shiv on 2/17/2017.
 */

public class Constants {

    /**
     * Permission
     */

    public static final int PERMISSIONS_REQ = 1;

    /**
     * Server Links
     */
//    public static final String SRegisterUrl = "http://192.168.43.224:2000/smartcampus/register";
    public static final String SRegisterUrl = "http://192.168.1.101/smartcampus/register.php";
    public static final String SENDMAIL = "http://192.168.1.101/smartcampus/sendmail.php";

    public static final String SLoginUrl = "http://192.168.1.101/smartcampus/login.php";

    public static final String TRegisterUrl = "http://192.168.1.101/smartcampus/otherregister.php";
    public static final String TLoginUrl = "http://192.168.1.101/smartcampus/otherlogin.php";

    public static final String NTRegisterUrl = "http://192.168.1.101/smartcampus/nontregister.php";
    public static final String GFMRegisterUrl = "http://192.168.1.101/smartcampus/gfmregister.php";
    public static final String AdminRegisterUrl = "http://192.168.1.101/smartcampus/adminregister.php";
    public static final String NTLoginUrl = "http://192.168.1.101/smartcampus/nontlogin.php";
    public static final String GFMLogin_URL = "http://192.168.1.101/smartcampus/gfmlogin.php";
    public static final String AdminLogin_URL = "http://192.168.1.101/smartcampus/adminlogin.php";

    public static final String SYLLABUSDATA = "http://192.168.1.101/smartcampus/syllabus/syllabusTeacher.php";
    public static final String GFMDATA = "http://192.168.1.101/smartcampus/gfm/loadStudent.php";
    public static final String FEEDATA = "http://192.168.1.101/smartcampus/gfm/loadStudentFees.php";
    public static final String ADMINDATA = "http://192.168.1.101/smartcampus/gfm/loadTeachers.php";

    public static final String SAVINGSYLLABUS = "http://192.168.1.101/smartcampus/syllabus/saveSyllabus.php";
    public static final String UNSAVINGSYLLABUS = "http://192.168.1.101/smartcampus/syllabus/unsaveSyllabus.php";

    public static final String LOADSYLLABUS = "http://192.168.1.101/smartcampus/syllabus/dataStudent.php";
    public static final String LOADSTUDENTS = "http://192.168.1.101/smartcampus/gfm/loadStudent.php";

    public static final String UPLOADFILES = "http://192.168.1.101/smartcampus/upload.php";
    public static final String CMPNUPLOAD = "http://192.168.1.101/smartcampus/cmpnupload.php";
    public static final String ITUPLOAD = "http://192.168.1.101/smartcampus/itupload.php";
    public static final String EXTCUPLOAD = "http://192.168.1.101/smartcampus/extcupload.php";
    public static final String ETRXUPLOAD = "http://192.168.1.101/smartcampus/etrxupload.php";
    public static final String MECHUPLOAD = "http://192.168.1.101/smartcampus/mechupload.php";
    public static final String CIVILUPLOAD = "http://192.168.1.101/smartcampus/civilupload.php";

    public static final String UPLOADFILESG = "http://192.168.1.101/smartcampus/gupload.php";
    public static final String UPLOADGFMFILESG = "http://192.168.1.101/smartcampus/gfmupload.php";

    public static final String FILEVIEWS = "http://192.168.1.101/smartcampus/getuploaded.php";
    public static final String FILEVIEWS2 = "http://192.168.1.101/smartcampus/getuploadedg.php";
    public static final String GFMFILEVIEWS = "http://192.168.1.101/smartcampus/getuploadedgfm.php";

    public static final String FORGOTPASS = "http://192.168.1.101/smartcampus/forgotpassword.php";

    public static final String FORGOTPASST = "http://192.168.1.101/smartcampus/forgotpasswordt.php";

    public static final String FORGOTPASSNT = "http://192.168.1.101/smartcampus/forgotpasswordnt.php";

    public static final String FORGOTPASSGFM = "http://192.168.1.101/smartcampus/forgotpasswordgfm.php";
    public static final String FORGOTPASSADMIN = "http://192.168.1.101/smartcampus/forgotpasswordadmin.php";


    public static final String TAKEATTENDANCE = "http://192.168.1.101/smartcampus/attendance/insertAttendance.php";
    
    public static final String VIEWATTENDANCE = "http://192.168.1.101/smartcampus/attendance/viewAttendance.php";


    /**
     * Preferences
     */
    public static final String INOUROUT = "loggedIn";
    public static final String USERNAME = "username";
    public static final String STUDENT_LOGIN = "studentlogin";
    public static final String TEACHER_LOGIN = "teacherlogin";
    public static final String NTEACHER_LOGIN = "nteacherlogin";
    public static final String GFM_LOGIN = "gfmlogin";
    public static final String Admin_LOGIN = "adminlogin";
    public static final String GFM_LOGIN_TRACK = "gfmtrack";
    public static final String ADMIN_LOGIN_TRACK = "admintrack";
    public static final String STUDENT_LOGIN_TRACK = "strack";
    public static final String TEACHER_LOGIN_TRACK = "ttrack";
    public static final String NTEACHER_LOGIN_TRACK = "nttrack";
    public static final String STUDENTINIT = "branch";
    public static final String ONETIMESCREEN = "onetimescreen";
    public static final String BRANCHCMPN = "branchcmpn";
    public static final String GFMBATCH = "gfmbatch";
    public static final String GFMBATCHSTUDENTS = "gfmbatchstudents";
    public static final String COMMONYR = "year";
    public static final String FOURTHYR = "fourth_year";
    public static final String SUBJECTNAME = "subjectname";
    public static final String STARTDATE = "startdate";
    public static final String ENDDATE = "enddate";
    public static final String ATDATA = "atdata";
    public static final String COUNTER = "counter";
    public static final String SYLLABUS = "syllabus";
    public static final String GFMSTUDENT = "gfmstudent";
    public static final String NOTICETRACK = "noticeTrack";


    /**
     * Extras
     */
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

}
