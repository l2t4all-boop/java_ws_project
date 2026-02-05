package com.l2t.lsj;

import java.util.concurrent.ThreadLocalRandom;

public class HelloWorld {

    public static void main(String[] args) {

            Greetings obj = getGreetingsObject();
            String message = obj.getGreetings();
            System.out.println(message);
    }



    private static Greetings getGreetingsObject() {
        int randNum = ThreadLocalRandom.current().nextInt(1,4);
        if(randNum == 1){
            return new BirthdayGreetings();
        }else if(randNum == 2){
            return new CongratulationGreetings();
        }else {
            return new GenericGreetings();
        }

    }
}
