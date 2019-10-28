package com.example.multitablesqlite.Util;

public class Config {

    public static final String DATABASE_NAME = "student-db";

    //column names of student table
    public static final String TABLE_STUDENT = "student";
    public static final String COLUMN_STUDENT_ID = "_id";
    public static final String COLUMN_STUDENT_NAME = "name";
    public static final String COLUMN_STUDENT_REGISTRATION = "registration_no";
    public static final String COLUMN_STUDENT_PHONE = "phone";
    public static final String COLUMN_STUDENT_EMAIL = "email";

    //column names of subject table
    public static final String TABLE_COURSE = "subject";
    public static final String COLUMN_COURSE_ID = "_id";
    public static final String COLUMN_REGISTRATION_NUMBER = "fk_registration_no";
    public static final String COLUMN_COURSE_NAME = "name";
    public static final String COLUMN_COURSE_CODE = "subject_code";
    public static final String COLUMN_COURSE_CREDIT = "credit";
    public static final String STUDENT_SUB_CONSTRAINT = "student_sub_unique";

    //others for general purpose key-value pair data
    public static final String TITLE = "title";
    public static final String CREATE_STUDENT = "create_student";
    public static final String UPDATE_STUDENT = "update_student";
    public static final String CREATE_COURSE = "create_subject";
    public static final String UPDATE_COURSE = "update_subject";
    public static final String STUDENT_REGISTRATION = "student_registration";
}
