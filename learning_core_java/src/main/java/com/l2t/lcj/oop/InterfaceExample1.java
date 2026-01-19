package com.l2t.lcj.oop;

import java.util.concurrent.ThreadLocalRandom;

interface Instrument{
   void makeSound();
}

class Guitar implements Instrument{
   @Override
   public void makeSound() {
      System.out.println("TIN TIN TIN TIN.....");
   }
}
class Piano implements Instrument{
   @Override
   public void makeSound() {
      System.out.println("PEE PEE PEE PEE.......");
   }
}
class Flute implements Instrument{
   @Override
   public void makeSound() {
      System.out.println("PEFF... PEEE TIN PEEE...");
   }
}


public class InterfaceExample1 {

   public static void main(String[] args) {
         Instrument obj = getInstrument();
         obj.makeSound();
   }







   public static Instrument getInstrument(){
      int num = ThreadLocalRandom.current().nextInt(1,4);
      return (num == 1) ? new Guitar() : num == 2 ? new Piano(): new Flute();
   }
}
