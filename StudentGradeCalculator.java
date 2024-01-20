package CodSoft;


import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of subjects:");
        int n = sc.nextInt();
        final int numSubjects = n;  

        ArrayList<String> l = new ArrayList<String>();
        int[] marks = new int[numSubjects];

        sc.nextLine();

        System.out.println("Enter the name for the subjects");

        for (int j = 0; j < numSubjects; ++j) {
            System.out.print("Subject: ");
            l.add(sc.nextLine()); 
        }

        System.out.println("Enter marks obtained (out of 100) in each subject:");

        for (int i = 0; i < numSubjects; ++i) {
            System.out.print("Marks obtained in " + l.get(i) + ": ");
            marks[i] = sc.nextInt();

            
            if (marks[i] < 0 || marks[i] > 100) {
                System.out.println("Invalid marks! Marks should be between 0 and 100.");
                i--;
                continue; 
            }
        }

        
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }

        int maxMarks = 100 * numSubjects;

        
        double averagePercentage = (double) totalMarks / numSubjects;

        
        char grade;
        if (averagePercentage >= 90) {
            grade = 'S';
        } else if (averagePercentage >= 80) {
            grade = 'A';
        } else if (averagePercentage >= 70) {
            grade = 'B';
        } else if (averagePercentage >= 60) {
            grade = 'C';
        } else if (averagePercentage >= 50){
            grade = 'D';
        } else if (averagePercentage >= 50){
            grade = 'E';
        } else {
            grade = 'F';
        }

        
        System.out.println("\nResults:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.print(l.get(i) + " : ");
            System.out.println(marks[i]);   
        }

        System.out.println("Total Marks: " + totalMarks + "/" + maxMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        sc.close();
    }
}



