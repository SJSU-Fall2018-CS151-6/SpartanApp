//package com.wolfsoft.one.bronzeapp.todo;
package com.incubate.code.spartanapp.todo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * This is a Queue where the producer thread is posting to and can be received from an other thread
 * @param <Assignment> The data that is sored in the queue is of type Assignment
 */

public class MassageQueue<Assignment> extends LinkedBlockingQueue<Assignment> {

    private static final MassageQueue instance = new MassageQueue<>();

    public static MassageQueue getInstance(){
        return instance;
    }
}
