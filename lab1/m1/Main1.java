package lab1.m1;

import java.util.*;

public class Main1 {
    // Test Data for the program
    private static String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

    public static void main(String[] argv) {
        if (argv.length != 2) {
            System.out.println("Usage: java Main {average | median | beststudent} <module code>");
            System.exit(1);
        }
        switch (argv[0]) {
            case "average":
                System.out.print("The average mark of module " + argv[1] + " = " + calculateModuleAverageMark(argv[1]));
                break;
            case "median":
                System.out.print("The median mark of module " + argv[1] + " = " + calculateModuleMedian(argv[1]));
                break;
            case "beststudent":
                displayBestStudent(argv[1]);
                break;
            default:
                System.out.println("Usage: java Main {average | median | beststudent} <module code>");
                break;

        }

        // if the user wants to find the average mark of a module,
        // call the calculateModuleAverageMark method and show the result in DOS prompt

        // else if the user wants to find the median mark of a module,
        // call the calculateModuleMedian method and show the result in DOS prompt

        // else if the user wants to find the best students (may have more than 1 best student) of a module,
        // call the displayBestStudent method

        // else show the message on how to run the program in DOS prompt and exit the program

    }

    public static double calculateModuleAverageMark(String mCode) {
        int index = getModuleIndex(mCode);
        double total = 0;
        for (int i = 0; i < marks[index].length; i++)
            total += marks[index][i];
        return total / marks[index].length;
        // return the average mark of a module (module code as input parameter "mCode")

    }

    public static double calculateModuleMedian(String mCode) {
        int index = getModuleIndex(mCode);
        Arrays.sort(marks[index]);
        return (marks[index].length % 2 == 1) ?
                marks[index][marks[index].length / 2] : (marks[index][marks[index].length / 2] + marks[index][marks[index].length / 2 - 1]) / 2.0;
        // return the median mark of a module (module code as input parameter "mCode")

    }

    public static void displayBestStudent(String mCode) {
        int index = getModuleIndex(mCode);
        int best = 0;
        for (int i = 0; i < marks[index].length; i++)
            best = (marks[index][i] > best) ? i : best;
        System.out.print("In module " + mCode + ", the following students perform the best:\n" + studentID[best]);
        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt
    }

    public static int getModuleIndex(String mCode) {
        switch (mCode) {
            case "ITD2322":
                return 0;
            case "ICT2422":
                return 1;
            case "ITD2321":
                return 2;
            case "ICT2669":
                return 3;
            default:
                return 0;
        }
    }
    // return the index of a module (module code as input parameter "mCode") in the array of moduleCode
    // You may need to call this method when you want to find the average mark, the median
    // or the best student of a module.
}
