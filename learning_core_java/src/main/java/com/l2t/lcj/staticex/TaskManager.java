package com.l2t.lcj.staticex;

import static java.lang.IO.println;

public final class TaskManager {

    private static TaskManager ref;
    private static int count = 0;

    private TaskManager() {
        count++;
    }

    public static TaskManager getInstance() {
        if (ref == null) {
            ref = new TaskManager();
        }
        return ref;
    }

    public static void showCount() {
        println("Count :" + count);
    }

}
