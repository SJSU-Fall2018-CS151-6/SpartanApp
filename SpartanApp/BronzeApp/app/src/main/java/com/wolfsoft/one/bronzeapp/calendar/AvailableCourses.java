package com.wolfsoft.one.bronzeapp.calendar;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.wolfsoft.one.bronzeapp.R;

import java.util.ArrayList;

public class AvailableCourses {
    private ArrayList<Lecture> lectures = new ArrayList<>();

    public AvailableCourses(Context context) {
        Drawable myIcon = context.getResources().getDrawable(R.drawable.tomcruise);

        Lecture lecture1 = new Lecture("CS 22A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);
        Lecture lecture2 = new Lecture("CS 23A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);
        Lecture lecture3 = new Lecture("CS 24A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);
        Lecture lecture4 = new Lecture("CS 25A - Python Programming for Non Majors I ",
                "TuTh 1:30PM-2:45PM",
                "Duncan Hall 450",
                "Mei-Chong Lee", myIcon);

        lectures.add(lecture1);
        lectures.add(lecture2);
        lectures.add(lecture3);
        lectures.add(lecture4);
    }

    public Lecture getIndexOf(Integer index){
        if(lectures.size() > index){
            return lectures.get(index);
        }
        return new Lecture(index);
    }

    public ArrayList<Lecture> getLectures(){
        return lectures;
    }

}
