package com.l2t.lcj.staticex;

public class TaskManagerClient {

    void main(String... args){

        TaskManager obj1 = TaskManager.getInstance();
        TaskManager obj2 = TaskManager.getInstance();
        TaskManager.showCount();

    }
}
