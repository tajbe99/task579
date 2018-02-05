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
                try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task579\\output.txt", false))) {
                    writeBuff.write(subsequenceArray.size()+"\n");
                    for (Integer indexOfDigit:subsequenceArray) {
                        writeBuff.write(indexOfDigit+" ");
                        writeBuff.flush();
                    }
                }
            } else {
                System.out.println("Натуральное число выходит за пределы  n (1 ≤ n ≤ 10000)");
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
        ArrayList<Integer> finalyArray = new ArrayList<>();
        Integer sumOfNeg =0;
        Integer sumOfPos =0;
            for (String digit:arrayOfDigits) {
                if(Integer.parseInt(digit)<0){
                    sumOfNeg+=Integer.parseInt(digit);
                }
                else if (Integer.parseInt(digit)>0){
                    sumOfPos+=Integer.parseInt(digit);
                }
            }
            if (sumOfPos>Math.abs(sumOfNeg)){
                for (int i=0;i<arrayOfDigits.length;i++) {
                    if (Integer.parseInt(arrayOfDigits[i])>0){
                        finalyArray.add(i+1);
                    }
                }
            }
            else if (sumOfPos<Math.abs(sumOfNeg)){
                for (int i=0;i<arrayOfDigits.length;i++) {
                    if (Integer.parseInt(arrayOfDigits[i])<0){
                        finalyArray.add(i+1);
                    }
                }
            }
        return finalyArray;
    }
}
