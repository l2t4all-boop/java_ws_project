package com.l2t.lcj.functional;

public class MathOperationManager {
    
    public static class AddOperation implements MathOperation {
        @Override
        public int operate(int a, int b) {
            return a + b;
        }
    }
    
    public static class DivOperation implements MathOperation {
        @Override
        public int operate(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return a / b;
        }
    }
    
    public static class MulOperation implements MathOperation {
        @Override
        public int operate(int a, int b) {
            return a * b;
        }
    }
    
    public static class ModOperation implements MathOperation {
        @Override
        public int operate(int a, int b) {
            if (b == 0) {
                throw new ArithmeticException("Modulo by zero");
            }
            return a % b;
        }
    }

    public static int executeOperation(MathOperation operation, int a, int b) {
        return operation.operate(a, b);
    }
    
    public static void main(String[] args) {
        MathOperation add = new AddOperation();
        MathOperation div = new DivOperation();
        MathOperation mul = new MulOperation();
        MathOperation mod = new ModOperation();
        
        System.out.println("10 + 5 = " + executeOperation(add, 10, 5));
        System.out.println("10 / 5 = " + executeOperation(div, 10, 5));
        System.out.println("10 * 5 = " + executeOperation(mul, 10, 5));
        System.out.println("10 % 5 = " + executeOperation(mod, 10, 5));

    }
}
