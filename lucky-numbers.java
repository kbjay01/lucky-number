package com.company;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class lucky_number {

    public static boolean arrayChecker(int[] arr, int n) {
        for (byte a = 0; a <= (arr.length -1); a++) {
            if (arr[a] == n) {
                return true;
            }
            else {
                continue;
            }
        }
        return false;
    }

    private static String numPrinter() {

        String out = "";
        String days[] = new String[5];
        days[0] = "Monday: ";
        days[1] = "Tuesday: ";
        days[2] = "Wednesday: ";
        days[3] = "Thursday: ";
        days[4] = "Friday: ";

        Random r = new Random();
        int tempRand = 0;
        int numbers[] = new int[5];

        for (byte i = 0; i <= 4; i++) {
            tempRand = r.nextInt(30) + 1;
            while(arrayChecker(numbers,tempRand) == true){
                tempRand = r.nextInt(30) + 1; }
            if ((arrayChecker(numbers,tempRand) == false)){
                numbers[i] = tempRand;
            }
        }

        System.out.println("Lucky numbers for this week: ");
        for (byte j = 0; j <= 4; j++) {
            System.out.println(days[j] + numbers[j]);

            if (j != 4) {
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        // Filling an out String with proper data
        for (byte k = 0; k<=4; k++){
            out += days[k] + numbers[k] + "\n";
        }
        return out;
    }

    private static void fileLog() throws IOException{

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH-mm-ss");
        String fileDate = simpleDateFormat.format(new Date());
        String fileName = "lucky_numbers_" + fileDate +".txt";

        FileWriter fileWriter = new FileWriter(fileName);
        PrintWriter printWriter = new PrintWriter(fileWriter);

        String output = numPrinter();

        simpleDateFormat  = new SimpleDateFormat("dd-MM-yyyy ");
        fileDate = simpleDateFormat.format(new Date());
        simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
        String fileTime = simpleDateFormat.format(new Date());

        printWriter.print("Those lucky numbers were generated in " + fileDate + "at " + fileTime +  "\n------------\n" + output);
        printWriter.close();

        File file = new File(fileName);
        file.setReadOnly();

        System.out.println("\nMade an output file --> " + file);

    }

    public static void main(String[] args) throws IOException {
    Date now = new Date();
    System.out.println(now);
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEEE");
    String day = simpleDateFormat.format(now);

    System.out.println("Today is " + day);

    if (day.equals("Monday")){
        numPrinter();

    }
    else if(!"Monday".equals(day)){
        Scanner input = new Scanner(System.in);
        System.out.print("Do you really want to get new lucky numbers? [y/n]: ");
        String check = input.nextLine();

        check.toLowerCase();

        if((check.length() == 1) && check.equals("y")){
            fileLog();
            return;
        }
        else{
            System.out.println("Okay quiting...");
            return;
        }
    }
    }
}
