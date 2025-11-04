import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Calculator!");

        // Step 1: Input number of subjects
        System.out.print("\nEnter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        // Step 2: Input marks for each subject
        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        for (int i = 0; i < numSubjects; i++) {
            while (true) {
                System.out.print("Enter marks for subject " + (i + 1) + " (out of 100): ");
                int mark = scanner.nextInt();

                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    totalMarks += mark;
                    break;
                } else {
                    System.out.println("Invalid input! Marks should be between 0 and 100. Try again.");
                }
            }
        }

        // Step 3: Calculate total and average percentage
        double averagePercentage = (double) totalMarks / numSubjects;

        // Step 4: Determine grade based on average
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Step 5: Display results
        System.out.println("\n===== Result Summary =====");
        System.out.println("Total Marks: " + totalMarks + " / " + (numSubjects * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade: " + grade);
        System.out.println("=============================");

        System.out.println("\n Thank you for using the Grade Calculator!");
        scanner.close();
    }
}
