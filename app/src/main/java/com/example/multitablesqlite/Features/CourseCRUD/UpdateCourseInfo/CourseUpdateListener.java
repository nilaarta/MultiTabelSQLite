package com.example.multitablesqlite.Features.CourseCRUD.UpdateCourseInfo;

import com.example.sqlite_project.Features.CourseCRUD.CreateCourse.Subject;

public interface CourseUpdateListener {
    void onSubjectInfoUpdate(Subject subject, int position);
}
