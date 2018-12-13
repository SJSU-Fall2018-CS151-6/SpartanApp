
package com.incubate.code.spartanapp.course;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.incubate.code.spartanapp.R;

import java.util.ArrayList;


/**
 * This class is for creating all the courses that can bee shown on the screen to choose from
 */

public class AvailableCourses {
    private ArrayList<Course> courses = new ArrayList<>();

    /**
     * constructor
     *
     * @param context for getting access to the apps resources
     */

    public AvailableCourses(Context context) {
        Drawable myIcon1 = context.getResources().getDrawable(R.drawable.meichonglee);
        Drawable myIcon2 = context.getResources().getDrawable(R.drawable.markstamp);
        Drawable myIcon3 = context.getResources().getDrawable(R.drawable.angusyeung);
        Drawable myIcon4 = context.getResources().getDrawable(R.drawable.meichonglee);
        Drawable myIcon5 = context.getResources().getDrawable(R.drawable.rulakhayrallah);
        Drawable myIcon6 = context.getResources().getDrawable(R.drawable.ahmedezzat);
        Drawable myIcon7 = context.getResources().getDrawable(R.drawable.ronmak);
        Drawable myIcon8 = context.getResources().getDrawable(R.drawable.eswarbadari);
        Drawable myIcon9 = context.getResources().getDrawable(R.drawable.hyeran);
        Drawable myIcon10 = context.getResources().getDrawable(R.drawable.eswarbadari);

        Course course1 = new Course("CS 22A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Wendy Lee", myIcon1);
        Course course2 = new Course("CS 46A - Introduction to Programming in Java ",
                "TuTh 1:30PM-2:45PM",
                "Engineering 450",
                "Mark Stamp", myIcon2);
        Course course3 = new Course("CS 151 - Object-Oriented Design in Java ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 222",
                "Angus Yeung ", myIcon3);
        Course course4 = new Course("CS 152 - Programming Paradigms ",
                "TuTh 11:30AM-2:45PM",
                "Duncan Hall 345",
                "Mei-Chong Lee", myIcon4);
        Course course5 = new Course("CS 151 - Introduction to Artificial Intelligence ",
                "TuTh: 10:30-11:45 AM ",
                "MacQuarrie Hall 218",
                "Rula Khayrallah", myIcon5);
        Course course6 = new Course("CS 157A - Introduction to Database ",
                "TuTh: 04:30-06:45 PM",
                "MacQuarrie Hall 218",
                "Ahmed Ezzat", myIcon6);
        Course course7 = new Course("CMPE 131 - Software Engineering I ",
                "MoWe: 10:30-11:45 AM ",
                "ENG 250",
                "Ronald Mak", myIcon7);
        Course course8 = new Course("CMPE 133 - Software Engineering II ",
                "TuTh: 10:30-11:45 AM",
                "ENG 250",
                "Badari S. Eswar", myIcon8);
        Course course9 = new Course("CMPE 120 - Computer Organization and Architecture",
                "TuTh: 10:30-11:45 AM ",
                "ENG 337",
                "Hyeran Jeon", myIcon9);
        Course course10 = new Course("CMPE 165 - Software Engineering Process Management",
                "MoWe: 10:30-11:45 AM",
                "ENG 337",
                "Badari S. Eswar", myIcon10);

        courses.add(course1);
        courses.add(course2);
        courses.add(course3);
        courses.add(course4);
        courses.add(course5);
        courses.add(course6);
        courses.add(course7);
        courses.add(course8);
        courses.add(course9);
        courses.add(course10);
    }

    /**
     *
     * @param index is for selectin a position from the list of courses
     * @return the course at a certain position
     */

    public Course getIndexOf(Integer index){
        if(courses.size() > index){
            return courses.get(index);
        }
        return new Course(index);
    }

    /**
     *
     * @return the entire list of courses
     */

    public ArrayList<Course> getCourses(){
        return courses;
    }

}
