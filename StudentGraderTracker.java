import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class StudentGraderTracker  {
    public static void main(String[] args)
     {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> studentNames = new ArrayList<>();
        ArrayList<Double> studentGrades = new ArrayList<>();

       try {
         System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        scanner.nextLine(); 

        if (numStudents <= 0){
            throw new IllegalArgumentException("Number of Students must be greater than 0.");
        }

        // Input student names and grades
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter the name of student " + (i + 1) + ": ");
            String name = scanner.nextLine();
            studentNames.add(name);

            System.out.print("Enter the grade of student " + (i + 1) + ": ");
            double grade = scanner.nextDouble();
            studentGrades.add(grade);
            scanner.nextLine(); // Consume newline left-over
        }

        // Display entered grades
        System.out.println("\nEntered grades:");
        for (int i = 0; i < numStudents; i++) {
            System.out.println(studentNames.get(i) + ": " + studentGrades.get(i));
        }

        // Calculate average score
        double totalGrade = 0;
        
        for (double grade : studentGrades) {
            totalGrade += grade;
            
        }
        double averageGrade = totalGrade / numStudents;
        System.out.println("\nAverage grade: " + averageGrade);

    // highest and lowest score
    
        double highestGrade = Double.MIN_VALUE;
        double lowestGrade = Double.MAX_VALUE;
        String highestStudent = "";
        String lowestStudent = "";
        for (int i = 0; i < numStudents; i++) {
            double grade = studentGrades.get(i);
            if (grade > highestGrade) {
                highestGrade = grade;
                highestStudent = studentNames.get(i);
            }
            if (grade < lowestGrade) {
                lowestGrade = grade;
                lowestStudent = studentNames.get(i);
            }
        }
        System.out.println("Highest grade: " + highestGrade + " (Student: " + highestStudent + ")");
        System.out.println("Lowest grade: " + lowestGrade + " (Student: " + lowestStudent + ")");
    } catch (InputMismatchException e) {
        System.out.println("Invalid input. Please enter a valid number.");
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage());
    } catch (ArithmeticException e) {
        System.out.println("Error: Division by zero. Please enter at least one student.");
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: Index out of bounds.");
    } finally {
         scanner.close();
    }
    }
}
