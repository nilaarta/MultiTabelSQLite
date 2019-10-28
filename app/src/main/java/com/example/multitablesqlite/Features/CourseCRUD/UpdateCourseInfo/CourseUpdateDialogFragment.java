package com.example.multitablesqlite.Features.CourseCRUD.UpdateCourseInfo;


import android.app.Dialog;
import android.os.Bundle;
import androidx.core.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.sqlite_project.Database.DatabaseDAO;
import com.example.sqlite_project.Features.CourseCRUD.CreateCourse.Subject;
import com.example.sqlite_project.R;
import com.example.sqlite_project.Util.Config;

public class CourseUpdateDialogFragment extends DialogFragment {

    private EditText subjectNameEditText;
    private EditText subjectCodeEditText;
    private EditText subjectCreditEditText;
    private Button updateButton;
    private Button cancelButton;

    private static CourseUpdateListener subjectUpdateListener;
    private static long subjectId;
    private static int position;

    private DatabaseDAO databaseQueryClass;

    public CourseUpdateDialogFragment() {
        // Required empty public constructor
    }

    public static CourseUpdateDialogFragment newInstance(long subId, int pos, CourseUpdateListener listener){
        subjectId = subId;
        position = pos;
        subjectUpdateListener = listener;

        CourseUpdateDialogFragment courseUpdateDialogFragment = new CourseUpdateDialogFragment();
        Bundle args = new Bundle();
        args.putString("title", "Update Course information");
        courseUpdateDialogFragment.setArguments(args);

        courseUpdateDialogFragment.setStyle(androidx.core.app.DialogFragment.STYLE_NORMAL, R.style.CustomDialog);

        return courseUpdateDialogFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subject_update_dialog, container, false);

        subjectNameEditText = view.findViewById(R.id.subjectNameEditText);
        subjectCodeEditText = view.findViewById(R.id.subjectCodeEditText);
        subjectCreditEditText = view.findViewById(R.id.subjectCreditEditText);
        updateButton = view.findViewById(R.id.updateButton);
        cancelButton = view.findViewById(R.id.cancelButton);

        databaseQueryClass = new DatabaseDAO(getContext());

        String title = getArguments().getString(Config.TITLE);
        getDialog().setTitle(title);

        Subject subject = databaseQueryClass.getSubjectById(subjectId);

        subjectNameEditText.setText(subject.getName());
        subjectCodeEditText.setText(String.valueOf(subject.getCode()));
        subjectCreditEditText.setText(String.valueOf(subject.getCredit()));

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String subjectName = subjectNameEditText.getText().toString();
                int subjectCode = Integer.parseInt(subjectCodeEditText.getText().toString());
                double subjectCredit = Double.parseDouble(subjectCreditEditText.getText().toString());

                Subject subject = new Subject(subjectId, subjectName, subjectCode, subjectCredit);

                long rowCount = databaseQueryClass.updateSubjectInfo(subject);

                if(rowCount>0){
                    subjectUpdateListener.onSubjectInfoUpdate(subject, position);
                    getDialog().dismiss();
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().dismiss();
            }
        });

        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.WRAP_CONTENT;
            //noinspection ConstantConditions
            dialog.getWindow().setLayout(width, height);
        }
    }

}
