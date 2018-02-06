package com.round1.task579;

import java.io.*;
import java.util.ArrayList;

public class task579 {
    public static void main(String[] args) {
        BufferedReader readBuff = null;
        ArrayList<Integer> subsequenceArray;
        try {
            readBuff = new BufferedReader(new FileReader("src\\com\\round1\\task579\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            assert readBuff != null;
            String line = readBuff.readLine();
            if ((Integer.parseInt(line) >= 1) && (Integer.parseInt(line) <= 10000)) {
                String[] arrayOfDigits = ArrayReader(readBuff);
                subsequenceArray = GetIndexOfDigits(arrayOfDigits);
                if (subsequenceArray!=null) {
                    try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task579\\output.txt", false))) {
                        writeBuff.write(subsequenceArray.size() + "\n");
                        for (Integer indexOfDigit : subsequenceArray) {
                            writeBuff.write(indexOfDigit + " ");
                            writeBuff.flush();
                        }
                    }
                }
                else{
                    try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task579\\output.txt", false))) {

                        writeBuff.write("Один из эллементов, по модулю, превосходит 10000");
                    }
                }
            } else {
                try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task579\\output.txt", false))) {

                    writeBuff.write("Количество эллементов выходит за пределы  n (1 ≤ n ≤ 10000)");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert readBuff != null;
                readBuff.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] ArrayReader(BufferedReader readBuff) throws IOException {
        return readBuff.readLine().split(" ");
    }
    private static ArrayList<Integer> GetIndexOfDigits(String[] arrayOfDigits){
        ArrayList<Integer> finalArray;
        ArrayList<Integer> posArray = new ArrayList<>();
        ArrayList<Integer> negArray = new ArrayList<>();
        Integer sumOfNeg =0;
        Integer sumOfPos =0;
            for (int i=0;i<arrayOfDigits.length;i++) {
                if(Integer.parseInt(arrayOfDigits[i])<0){
                    sumOfNeg+=Integer.parseInt(arrayOfDigits[i]);
                    negArray.add(i);
                }
                else if (Integer.parseInt(arrayOfDigits[i])>0 && Math.abs(Integer.parseInt(arrayOfDigits[i]))<10000){
                    sumOfPos+=Integer.parseInt(arrayOfDigits[i]);
                    posArray.add(i);
                }
                else if(Math.abs(Integer.parseInt(arrayOfDigits[i]))>10000){
                    return null;
                }
            }
            finalArray = (sumOfPos>Math.abs(sumOfNeg))?posArray:negArray;
        return finalArray;
    }
}
