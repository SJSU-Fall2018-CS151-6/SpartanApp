package com.incubate.code.spartanapp.course;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 *
 *
 *
 */

public class Course {
    private String name;
    private String time;
    private String room;
    private String teacherName;
    private Drawable image;

    /**
     *
     * @param name
     * @param time
     * @param room
     * @param teacherName
     * @param image
     */
    Course(String name, String time, String room, String teacherName, Drawable image) {
        this.name = name;
        this.time = time;
        this.room = room;
        this.teacherName = teacherName;
        this.image = image;
    }

    /**
     *
     * @param i
     */
    Course(Integer i) {
        this.name = "lecture"+Integer.toString(i);
        this.time = "some time";
        this.room = "some room";
        this.teacherName = "some teacher";
        this.image = new Drawable() {
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
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getTime() {
        return time;
    }

    /**
     *
     * @return
     */
    public String getRoom() {
        return room;
    }

    /**
     *
     * @return
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     *
     * @return
     */
    public Drawable getImage() {
        return image;
    }
}
