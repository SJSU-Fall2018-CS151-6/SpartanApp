package com.incubate.code.spartanapp.course;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.incubate.code.spartanapp.R;
import java.util.ArrayList;



/**
 *This Class will list all the available course to be added
 *It Uses the course class to create list of available courses
 * to the student.
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
     * This method will get the index of the course from the ArrayList
     * of courses.
     *
     * @param
     * @return index
     */

    public Course getIndexOf(Integer index){
        if(courses.size() > index){
            return courses.get(index);
        }
        return new Course(index);
    }

    /**
     * Will get the Array List of Courses
     * @return courses
     */

    public ArrayList<Course> getCourses(){
        return courses;
    }

}
