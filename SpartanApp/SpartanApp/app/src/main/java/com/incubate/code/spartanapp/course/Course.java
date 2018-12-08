package com.incubate.code.spartanapp.course;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Course Model Object.
 * Various attributes of course, and related behavior.
 * Course class implement all the attribute needed for a course.
 * These include course courseName, courseTime, class classRoom,
 * the instructor courseName and courseImage for the course.
 *
 * @author Philp H
 * @author Abraham T
 * @version 1.0
 *
 */

public class Course {
    private String courseName;
    private String courseTime;
    private String classRoom;
    private String teacherName;
    private Drawable courseImage;

    /**
     *  Course Constructor.
     * @param courseName (required) course courseName
     * @param courseTime courseTime of the course given
     * @param classRoom the class classRoom courseName
     * @param teacherName courseName of the instructor
     * @param courseImage the course courseImage holder
     */
    Course(String courseName, String courseTime, String classRoom, String teacherName, Drawable courseImage) {
        this.courseName = courseName;
        this.courseTime = courseTime;
        this.classRoom = classRoom;
        this.teacherName = teacherName;
        this.courseImage = courseImage;
    }

    /**
     * Course Constructor that instantiate the objects
     * @param i
     */
    Course(Integer i) {
        this.courseName = "lecture"+Integer.toString(i);
        this.courseTime = "some courseTime";
        this.classRoom = "some classRoom";
        this.teacherName = "some teacher";
        this.courseImage = new Drawable() {
            @Override
            public void draw(@NonNull Canvas canvas) { }

            @Override
            public void setAlpha(int i) { }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) { }

            @Override
            public int getOpacity() {
                return PixelFormat.TRANSLUCENT;
            }
        };
    }

    /**
     * The method will get the student courseName
     * @return
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * The method will get the the courseTime for the course
     * @return
     */
    public String getCourseTime() {
        return courseTime;
    }

    /**
     * The method will get the classRoom for
     * @return
     */
    public String getClassRoom() {
        return classRoom;
    }

    /**
     * This method will get the Teacher name for the course
     * @return
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * This method will get image for the course
     * @return
     */
    public Drawable getCourseImage() {
        return courseImage;
    }
}
