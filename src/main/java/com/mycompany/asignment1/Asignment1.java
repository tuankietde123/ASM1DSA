/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asignment1;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Main class to run the student management system. Provides a menu for user interaction.
 */
public class Asignment1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManager system = new StudentManager();

        while (true) {
            System.out.println("1. Add Student");
            System.out.println("2. Edit Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Search Student");
            System.out.println("5. Sort Students by Marks");
            System.out.println("6. Display All Students");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    addStudent(scanner, system);
                    break;
                case 2:
                    editStudent(scanner, system);
                    break;
                case 3:
                    deleteStudent(scanner, system);
                    break;
                case 4:
                    searchStudent(scanner, system);
                    break;
                case 5:
                    system.sortStudentsByMarks();
                    break;
                case 6:
                    system.displayAllStudents();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static int getChoice(Scanner scanner) {
        while (true) {
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                return choice;
            } catch (InputMismatchException e) {
                System.out.print("Invalid input. Please enter a number: ");
                scanner.nextLine();  // Consume the invalid input
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManager system) {
        try {
            System.out.print("Enter Student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter Full Name: ");
            String name = scanner.nextLine();
            System.out.print("Enter Marks: ");
            int marks = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            system.addStudent(new Student(id, name, marks));
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Student ID and Marks should be integers.");
            scanner.nextLine();  // Consume the invalid input
        }
    }

    private static void editStudent(Scanner scanner, StudentManager system) {
        try {
            System.out.print("Enter Student ID to edit: ");
            int editId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            System.out.print("Enter new Full Name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new Marks: ");
            int newMarks = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            system.editStudent(editId, newName, newMarks);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Student ID and Marks should be integers.");
            scanner.nextLine();  // Consume the invalid input
        }
    }

    private static void deleteStudent(Scanner scanner, StudentManager system) {
        try {
            System.out.print("Enter Student ID to delete: ");
            int deleteId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            system.deleteStudent(deleteId);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Student ID should be an integer.");
            scanner.nextLine();  // Consume the invalid input
        }
    }

    private static void searchStudent(Scanner scanner, StudentManager system) {
        try {
            System.out.print("Enter Student ID to search: ");
            int searchId = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            Student student = system.searchStudent(searchId);
            if (student != null) {
                System.out.println(student);
            } else {
                System.out.println("Student not found");
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Student ID should be an integer.");
            scanner.nextLine();  // Consume the invalid input
        }
    }
}
