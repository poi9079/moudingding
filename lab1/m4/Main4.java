package lab1.m4;
import java.util.*;

public class Main4 {
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
        int markss[] = GRSData.getModuleMark(mCode);
        double total = 0;
        for (int i = 0; i < markss.length; i++)
            total += markss[i];
        return total / markss.length;
        // return the average mark of a module (module code as input parameter "mCode")

    }

    public static double calculateModuleMedian(String mCode) {
        int markss[] = GRSData.getModuleMark(mCode);
        Arrays.sort(markss);
        return (markss.length % 2 == 1) ?
                markss[markss.length / 2] : ((markss[markss.length / 2]) + markss[markss.length / 2 - 1]) / 2.0;
        // return the median mark of a module (module code as input parameter "mCode")

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
        // find the highest mark of a module (module code as input parameter "mCode")
        // then find the studentID(s) of student(s) with the highest mark
        // show the above information in DOS prompt
    }
}

class GRSData {

    private String[] moduleCode = {"ITD2322", "ICT2422", "ITD2321", "ICT2669"};
    private String[] studentID = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private char[][] marks = { {'F', 'D', 'C', 'B', 'C', 'B', 'C', 'A'}, // mark for ITD2322
            {'D', 'B', 'A', 'A', 'F', 'B', 'C', 'C'}, // mark for ICT2422
            {'D', 'B', 'E', 'B', 'C', 'F', 'F', 'D'}, // mark for ITD2321
            {'C', 'B', 'E', 'D', 'C', 'B', 'C', 'A'}}; // mark for ICT2669

    public int[] getModuleMark(String mCode) {
        int index;
        switch (mCode) {
            case "ITD2322":
                index = 0 ;
                break;
            case "ICT2422":
                index = 1 ;
                break;
            case "ITD2321":
                index = 2 ;
                break;
            case "ICT2669":
                index = 3 ;
                break;
            default:
                index = 0;
                break;
        }
        int [][] markss= new  int[marks.length][marks[index].length];
        for (int i = 0 ;i<marks[index].length;i++){
            markss[index][i]=letterToNumeric(marks[index][i]);
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
    public String getStudentID(int i) {
        return studentID[i];
    }

}
