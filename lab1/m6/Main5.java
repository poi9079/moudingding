package lab1.m6;

import java.util.*;

public class Main5 {
    private static GRSData GRSData = new GRSData();

    // create a private static data member of lab1.m3.GRSData object
    // (You need to call the methods of lab1.m3.GRSData when you find the average mark, median or
    //  best student(s) of a module


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
        int marks[] = GRSData.getModuleMark(mCode);
        double total = 0;
        for (int i = 0; i < marks.length; i++)
            total += marks[i];
        return total / marks.length;
        // return the average mark of a module (module code as input parameter "mCode")

    }

    public static double calculateModuleMedian(String mCode) {
        int marks[] = GRSData.getModuleMark(mCode);
        Arrays.sort(marks);
        return (marks.length % 2 == 1) ?
                marks[marks.length / 2] : (marks[marks.length / 2] + marks[marks.length / 2 - 1]) / 2.0;
        // return the median mark of a module (module code as input parameter "mCode")

    }

    public static void displayBestStudent(String mCode) {
        System.out.println("In module " + mCode + ", the following students perform the best:");
        int marks[] = GRSData.getModuleMark(mCode);
        int best = 0;
        for (int i = 1; i < marks.length; i++)
            best = (marks[i] > (marks[best])) ? i : best;
        for (int i = 0; i < marks.length; i++) {
            if ((marks[i]) == (marks[best]))
                System.out.println("Student " + GRSData.getStudentID(i));
        }
        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt
    }
}

class GRSData {

    private String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) {
        switch (mCode) {
            case "ITD2322":
                return marks[0];
            case "ICT2422":
                return marks[1];
            case "ITD2321":
                return marks[2];
            case "ICT2669":
                return marks[3];
            default:
                return marks[0];
        }
        // return an array of marks for a module with given module code
        // (module code as input parameter "mCode").
    }

    public String getStudentID(int i) {
        return studentID[i];
        // return student ID of the student with index i in array stduentID

    }
}