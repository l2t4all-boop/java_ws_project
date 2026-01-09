package com.l2t.lcj.enumsandarrays;


enum ShirtSize{

    S(36), M(38),L(40),XL(42);

    private int size;

    ShirtSize(int size){
        this.size = size;
    }

    public int getSize(){
        return size;
    }
}
public class TellDayInformation {

    public static void main(String[] args) {
        showMessage(Day.WEDNESDAY);

        for(Day day:Day.values()){
            System.out.println(day);
        }

        for(ShirtSize size:ShirtSize.values()){
            System.out.println(size+" => "+size.getSize());
        }
    }

    private static void showMessage(Day day){
        switch (day) {
            case MONDAY:
                System.out.println("Mondays are bad.");
                break;

            case FRIDAY:
                System.out.println("Fridays are better.");
                break;

            case SATURDAY:
            case SUNDAY:
                System.out.println("Weekends are best.");
                break;

            default:
                System.out.println("Midweek days are so-so.");
                break;
        }
    }
}
