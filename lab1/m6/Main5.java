package lab1.m6;

import java.util.*;

public class Main5 {
    private static String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private static String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static int[][] marks = {{30, 40, 50, 60, 45, 55, 65, 75}, // mark for ITD2322
            {80, 70, 60, 40, 34, 56, 78, 90}, // mark for ICT2422
            {76, 45, 67, 89, 12, 45, 67, 54}, // mark for ITD2321
            {56, 76, 54, 55, 50, 43, 66, 44}}; // mark for ICT2669
    private static char[][] marks2 = {{'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
            {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
            {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
            {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

    public static void main(String[] argv) {
        if (argv.length != 3) {
            System.out.println("Usage: java Main5 {letter | numeric } {average | median | beststudent} <module code>");
            System.exit(1);
        }
        int index = getModuleIndex(argv[1]);

        // the main logic of this program, to be implemented by you!

        if (argv[0].equals("letter"))
            switch (argv[1]) {
                case "average":
                    System.out.print("The average mark of module " + argv[2] + " = " + calculateCharModuleAverageMark(argv[2]));
                    break;
                case "median":
                    System.out.print("The median mark of module " + argv[2] + " = " + calculateCharModuleMedian(argv[2]));
                    break;
                case "beststudent":
                    displayCharBestStudent(argv[2]);
                    break;
                default:
                    System.out.println("Usage: java Main {average | median | beststudent} <module code>");
                    break;

            }

        else if (argv[0].equals("numeric")) {
            switch (argv[1]) {
                case "average":
                    System.out.print("The average mark of module " + argv[2] + " = " + calculateIntModuleAverageMark(argv[2]));
                    break;
                case "median":
                    System.out.print("The median mark of module " + argv[2] + " = " + calculateIntModuleMedian(argv[2]));
                    break;
                case "beststudent":
                    displayIntBestStudent(argv[2]);
                    break;
                default:
                    System.out.println("Usage: java Main {average | median | beststudent} <module code>");
                    break;

            }
        }
    }

    public static double calculateIntModuleAverageMark(String mCode) {
        int index = getModuleIndex(mCode);
        int mmarks[] = marks[index];
        double total = 0;
        for (int i = 0; i < mmarks.length; i++)
            total += mmarks[i];
        return total / marks.length;
    }

    public static double calculateCharModuleAverageMark(String mCode) {
        int index = getModuleIndex(mCode);
        double total = 0;
        for (int i = 0; i < marks2[index].length; i++)
            total += letterToNumeric(marks2[index][i]);
        return total / marks2[index].length;
        // return the average mark of a module (module code as input parameter "mCode")

    }

    public static double calculateCharModuleMedian(String mCode) {
        int index = getModuleIndex(mCode);
        Arrays.sort(marks[index]);
        return (marks[index].length % 2 == 1) ?
                letterToNumeric(marks2[index][marks2[index].length / 2]) : (letterToNumeric(marks2[index][marks2[index].length / 2]) + letterToNumeric(marks2[index][marks2[index].length / 2 - 1])) / 2.0;
        // return the median mark of a module (module code as input parameter "mCode")

    }

    public static double calculateIntModuleMedian(String mCode) {
        int index = getModuleIndex(mCode);
        int mmarks[] = marks[index];
        Arrays.sort(marks);
        return (mmarks.length % 2 == 1) ?
                mmarks[mmarks.length / 2] : (mmarks[mmarks.length / 2] + mmarks[mmarks.length / 2 - 1]) / 2.0;
    }

    public static void displayCharBestStudent(String mCode) {
        int index = getModuleIndex(mCode);
        System.out.println("In module " + mCode + ", the following students perform the best:");
        int best = 0;
        for (int i = 0; i < marks2[index].length; i++)
            best = (letterToNumeric(marks2[index][i]) > letterToNumeric(marks2[index][best])) ? i : best;
        for (int i = 0; i < marks2[index].length; i++) {
            if (letterToNumeric(marks2[index][i]) == letterToNumeric(marks2[index][best]))
                System.out.println("Student " + studentID[i]);
        }
    }

    public static void displayIntBestStudent(String mCode) {
        int index = getModuleIndex(mCode);
        System.out.println("In module " + mCode + ", the following students perform the best:");
        int mmarks[] = marks[index];
        int best = 0;
        for (int i = 1; i < mmarks.length; i++)
            best = (mmarks[i] > (mmarks[best])) ? i : best;
        for (int i = 0; i < mmarks.length; i++) {
            if ((mmarks[i]) == (mmarks[best]))
                System.out.println("Student " + getStudentID(i));
        }
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

    public static String getStudentID(int i) {
        return studentID[i];
    }
}
