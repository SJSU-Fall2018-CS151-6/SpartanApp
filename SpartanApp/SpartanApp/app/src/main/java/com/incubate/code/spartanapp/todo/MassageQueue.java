//package com.wolfsoft.one.bronzeapp.todo;
package com.incubate.code.spartanapp.todo;

import java.util.concurrent.LinkedBlockingQueue;

public class MassageQueue<Assignment> extends LinkedBlockingQueue<Assignment> {

    private static final MassageQueue instance = new MassageQueue<>();

    public static MassageQueue getInstance(){
        return instance;
    }
}
