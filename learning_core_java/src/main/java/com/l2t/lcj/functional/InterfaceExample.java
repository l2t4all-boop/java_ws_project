package com.l2t.lcj.functional;

interface MathUtil {
    boolean isPrime(int num);

    default int primeCount(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }

    default int getEvenNumberCount(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (isEven(i)) {
                count++;
            }
        }
        return count;
    }

    default int getOddNumberCount(int lb, int ub) {
        int count = 0;
        for (int i = lb; i <= ub; i++) {
            if (!isEven(i)) {
                count++;
            }
        }
        return count;
    }

    static String getSystemInfo() {
        String osName = System.getProperty("os.name");
        String javaVersion = getJavaVersion();
        return "OS: " + osName + ", Java: " + javaVersion;
    }

    private static String getJavaVersion() {
        return System.getProperty("java.version");
    }

    private boolean isEven(int num) {
        return num % 2 == 0;
    }

    default int[] prime(int lb, int ub) {
        int[] arr = new int[primeCount(lb, ub)];
        for (int i = lb, index = 0; i <= ub; i++) {
            if (isPrime(i)) {
                arr[index++] = i;
            }
        }
        return arr;
    }
}

class MathUtilImpl implements MathUtil {

    @Override
    public boolean isPrime(int num) {
        return false;
    }
}

class PasswordGenerator implements MathUtil {

    public String generatePassword() {
        String basePassword = "SecurePass";
        int prime1 = getRandomPrime();
        int prime2 = getRandomPrime();
        return basePassword + prime1 + prime2;
    }

    private int getRandomPrime() {
        int[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        return primes[(int) (Math.random() * primes.length)];
    }

    @Override
    public boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
}

public class InterfaceExample {
    void main() {
        MathUtil obj = new MathUtilImpl();
        String sysInfo = MathUtil.getSystemInfo();
        System.out.println(sysInfo);
    }
}
