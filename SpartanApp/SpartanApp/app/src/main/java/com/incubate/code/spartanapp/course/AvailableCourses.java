package com.incubate.code.spartanapp.course;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.incubate.code.spartanapp.R;
import java.util.ArrayList;



/**
 *
 *
 */

public class AvailableCourses {
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     *
     * @param context
     */

    public AvailableCourses(Context context) {
        Drawable myIcon = context.getResources().getDrawable(R.drawable.tomcruise);

        Course course1 = new Course("CS 22A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);
        Course course2 = new Course("CS 23A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);
        Course course3 = new Course("CS 24A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);
        Course course4 = new Course("CS 25A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
    }

    /**
     *
     *
     * @param
     * @return
     */

    public Course getIndexOf(Integer index){
        if(courses.size() > index){
            return courses.get(index);
        }
        return new Course(index);
    }

    /**
     *
     * @return
     */

    public ArrayList<Course> getCourses(){
        return courses;
    }

}
