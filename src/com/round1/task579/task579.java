package com.round1.task579;

import java.io.*;

public class task579 {
    public static void main(String[] args) {
        BufferedReader readBuff = null;
        try {
            readBuff = new BufferedReader(new FileReader("src\\com\\round1\\task579\\input.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            String line = readBuff.readLine();
            if ((Integer.parseInt(line) >= 1) && (Integer.parseInt(line) <= 10000)) {
                String[] arrayOfDigits = ArrayReader(readBuff);

            } else {
                System.out.println("Натуральное число выходит за пределы  n (1 ≤ n ≤ 10000)");
            }
            try (BufferedWriter writeBuff = new BufferedWriter(new FileWriter("src\\com\\round1\\task579\\output.txt", false))) {
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                readBuff.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String[] ArrayReader(BufferedReader readBuff) throws IOException {
        String[] arrayOfDigits = readBuff.readLine().split(" ");
        for (int i=0;i<arrayOfDigits.length;i++){
            System.out.println(arrayOfDigits[i]);
        }
        return arrayOfDigits;
    }
}
