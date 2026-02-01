package com.l2t.lcj.exceptions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionExample2 {


    private ExceptionExample2() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        BufferedReader br = null;
        try {
            fileReader = new FileReader(ExceptionExample2.class.getResource("/names.txt").getFile());
            br = new BufferedReader(fileReader);
            String name = null;
            while ((name = br.readLine()) != null) {
                System.out.println(name);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (StringIndexOutOfBoundsException e){
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try{
                if(br!=null){
                    br.close();
                }
                if(fileReader != null){
                    fileReader.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
