package com.l2t.lcj.staticex;

import java.util.Arrays;

interface Operation {
    int perform(int... nums);
}

class AddNumbers implements Operation {
    @Override
    public int perform(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}

class MaxNumber implements Operation {

    @Override
    public int perform(int... nums) {
        int max = nums[0];
        for (int num : nums) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }
}


public class InterfaceAbstractExample {

    public static void main(String[] args) {

        int[] arr = new int[]{1, 2, 3, 8, 9, 7, 6, 5, 4};

        Operation operation = new AddNumbers();
        int res = operation.perform(arr);
        Operation operation1 = new MaxNumber();
        int max = operation1.perform(arr);
        Operation operation2 = new Operation() {
            @Override
            public int perform(int... nums) {
                int min = nums[0];
                for(int num:nums){
                    if(min > num){
                        min = num;
                    }
                }
                return min;
            }
        };
        int min =  operation2.perform(arr);

        System.out.println("The sum of " + Arrays.toString(arr) + " element is " + res);
        System.out.println("The max value in given  " + Arrays.toString(arr) + " array is " + max);
        System.out.println("The min value in given  " + Arrays.toString(arr) + " array is " + min);

    }
}
