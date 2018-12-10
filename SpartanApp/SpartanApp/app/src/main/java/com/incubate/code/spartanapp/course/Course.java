//package com.wolfsoft.one.bronzeapp.course;
package com.incubate.code.spartanapp.course;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;


public class Course {
    private String name;
    private String time;
    private String room;
    private String teacherName;
    private Drawable image;

    Course(String name, String time, String room, String teacherName, Drawable image) {
        this.name = name;
        this.time = time;
        this.room = room;
        this.teacherName = teacherName;
        this.image = image;
    }

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

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }

    public String getRoom() {
        return room;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public Drawable getImage() {
        return image;
    }

    @Override
    public boolean equals(Object o) {
        if (o.getClass() != this.getClass()){
            return false;
        }
        Course course = (Course)o;
        if (!name.equals(course.getName())) return false;
        if (!time.equals(course.getTime())) return false;
        if (!room.equals(course.getRoom())) return false;
        if (!teacherName.equals(course.getTeacherName())) return false;

        return image.equals(course.getImage());
    }
}
