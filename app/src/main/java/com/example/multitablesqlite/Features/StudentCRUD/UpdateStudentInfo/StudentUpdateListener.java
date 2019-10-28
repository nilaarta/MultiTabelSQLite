package com.example.multitablesqlite.Features.StudentCRUD.UpdateStudentInfo;

import com.example.sqlite_project.Features.StudentCRUD.CreateStudent.Student;

public interface StudentUpdateListener {
    void onStudentInfoUpdated(Student student, int position);
}
