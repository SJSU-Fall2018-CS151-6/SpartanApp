package com.incubate.code.spartanapp.todo;

import java.util.TimerTask;

/**
 * A producer thread to get assignments posted
 */

public class CourseNotificationCreator extends TimerTask {

    private Integer assignmentCount = 0;

    @Override
    public void run() {
        try {
            MassageQueue.getInstance().put(new Assignment("assignment"+Integer.toString(++assignmentCount)));

        }catch (InterruptedException ie){
            ie.printStackTrace();
        }

    }

}
