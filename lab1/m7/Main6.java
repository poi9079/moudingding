package lab1.m7;

import java.util.*;

public class Main6 {
    private static GRSData GRSData;

    // declare a private static data member of GRSData object
    // (You need to call the methods of GRSData when you finding the average mark, median
    //  best student(s) of a module

    public static void main(String[] argv) {

        if (argv.length != 3) {
            System.out.println("Usage: java Main6 {letter | numeric } {average | median | beststudent} <module code>");
            System.exit(1);
        }
        if (argv[0].equals("numeric")) {
            GRSData= new NumericGRSData();
        }if (argv[0].equals("letter")) {
            GRSData = new LetterGRSData();
        }
        switch (argv[1]) {
            case "average":
                System.out.print("The average mark of module " + argv[2] + " = " + calculateModuleAverageMark(argv[2]));
                break;
            case "median":
                System.out.print("The median mark of module " + argv[2] + " = " + calculateModuleMedian(argv[2]));
                break;
            case "beststudent":
                displayBestStudent(argv[2]);
                break;
            default:
                System.out.println("Usage: java Main {average | median | beststudent} <module code>");
                break;

        }

    }

    public static double calculateModuleMedian(String mCode) {
        int markss[] = GRSData.getModuleMark(mCode);
        Arrays.sort(markss);
        return (markss.length % 2 == 1) ?
                markss[markss.length / 2] : ((markss[markss.length / 2]) + markss[markss.length / 2 - 1]) / 2.0;
        // return the median mark of a module (module code as input parameter "mCode")

    }

    public static double calculateModuleAverageMark(String mCode) {
        int markss[] = GRSData.getModuleMark(mCode);
        double total = 0;
        for (int i = 0; i < markss.length; i++)
            total += markss[i];
        return total / markss.length;
        // return the average mark of a module (module code as input parameter "mCode")

    }

    public static void displayBestStudent(String mCode) {
        System.out.println("In module " + mCode + ", the following students perform the best:");
        int markss[] = GRSData.getModuleMark(mCode);
        int best = 0;
        for (int i = 1; i < markss.length; i++)
            best = (markss[i] > markss[best]) ? i : best;
        for (int i = 0; i < markss.length; i++) {
            if (markss[i] == markss[best])
                System.out.println("Student " + GRSData.getStudentID(i));
        }

    // the main logic of this program, to be implemented by you!

}

// other methods for calculating the average mark, median and display the best student(s)
// have already been implemented in Stage 3 and Stage 4
}

abstract class GRSData {

    protected String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    protected String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};


    abstract int[] getModuleMark(String mCode);

    public String getStudentID(int i) {
        return studentID[i];
    }
}

class LetterGRSData extends GRSData {

    private char[][] marks = {{'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
            {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
            {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
            {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) {
        int index;
        switch (mCode) {
            case "ITD2322":
                index = 0;
                break;
            case "ICT2422":
                index = 1;
                break;
            case "ITD2321":
                index = 2;
                break;
            case "ICT2669":
                index = 3;
                break;
            default:
                index = 0;
                break;
        }
        int[][] markss = new int[marks.length][marks[index].length];
        for (int i = 0; i < marks[index].length; i++) {
            markss[index][i] = letterToNumeric(marks[index][i]);
        }
        return markss[index];
    }


    public static int letterToNumeric(char grade) {
        switch (grade) {
            case 'A':
                return 5;
            case 'B':
                return 4;
            case 'C':
                return 3;
            case 'D':
                return 2;
            case 'E':
                return 1;
            case 'F':
                return 0;
            default:
                return 0;
        }
    }


    // convert and return a numeric mark from a grade (grade as input pararmeter "grade)

    // you may need to call this method from the method getModuleMark

}

class NumericGRSData extends GRSData {

    private int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) { // return the marks of a student with the given ID
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
    }
}