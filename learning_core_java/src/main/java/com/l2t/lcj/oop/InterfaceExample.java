package com.l2t.lcj.oop;

interface Game{
     void start();
     void play();
     void stop();
}
abstract class AbstractGame implements Game{
    @Override
    public void start() {
        System.out.println("The game "+this.getClass().getSimpleName()+" is started");
    }

    @Override
    public void stop() {
        System.out.println("The game "+this.getClass().getSimpleName()+" is stopped");
    }
}

class Car extends  AbstractGame implements Game{

    @Override
    public void play() {
        System.out.println("You are playing "+this.getClass().getSimpleName()+" game please wear seat belt");
    }

}

class Ship extends AbstractGame implements Game{

    @Override
    public void play() {
        System.out.println("You are playing "+this.getClass().getSimpleName()+" game please wear water jacket");
    }

}

class Bike extends AbstractGame implements Game{

    @Override
    public void play() {
        System.out.println("You are playing "+this.getClass().getSimpleName()+" game please wear helmet");
    }

}


public class InterfaceExample {
}
