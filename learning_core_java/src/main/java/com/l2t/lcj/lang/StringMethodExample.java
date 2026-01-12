package com.l2t.lcj.lang;

import java.util.Arrays;

public class StringMethodExample {
    public static void main(String[] args) {

            String str = "CAT";
            char[] arr = str.toCharArray();
            System.out.println(Arrays.toString(arr));
            str = new String(arr);
            System.out.println(str);

            String str1 = "cat";
            String str2 = "abt";
            System.out.println(isAnagram(str1,str2));

            String userData = "1001-Krish-krish.t@gmail.com,1002-Charn-char.k@gmail.com,1003-Akesh-akesh@gmail.com";
            String[] userDataArr = userData.split(",");
            String[] emails = new String[userDataArr.length];
            int i=0;
            for(String user:userDataArr){
                String email = user.split("-")[2];
                emails[i++] = email;
            }
            email(emails);
    }


    public static void email(String[] emails){
            // Logic to send email
            String subject = "Pongal Greetings - from L2T";
            for(String email:emails){
                String body = String.format("""
                        Hello %s,
                            We wish you happy Pongal
                        Thank you
                        """,email.split("@")[0].toUpperCase());
                sendEmail(subject,body,email);
            }
    }

    private static void sendEmail(String subject, String body, String email) {
        System.out.printf("Sending email to :%s\nSubject :%s\n\nBody %s",email,subject,body);
        System.out.println("-".repeat(100));
    }

    public static boolean isAnagram(String str1, String str2){
            if(str1.length() != str2.length()){
                return false;
            }
            char[] arr1 = str1.toCharArray();
            char[] arr2 = str2.toCharArray();
            Arrays.sort(arr1);
            Arrays.sort(arr2);
            return Arrays.equals(arr1,arr2);
    }
}
