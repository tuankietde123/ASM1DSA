/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asignment1;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Comparator;

/**
 * Manages a list of students, allowing addition, modification, deletion, and querying.
 * It also provides functionality to sort and display students.
 */
public class StudentManager {
    private final List<Student> students;

    public StudentManager() {
        this.students = new ArrayList<>();
    }

    /**
     * Adds a student to the list if a student with the same ID does not already exist.
     * @param student the student to add
     */
    public void addStudent(Student student) {
        Optional<Student> existingStudent = students.stream()
                .filter(s -> s.getStudentID() == student.getStudentID())
                .findFirst();

        if (existingStudent.isPresent()) {
            System.out.println("Student with ID " + student.getStudentID() + " already exists.");
        } else {
            students.add(student);
            System.out.println("Student added successfully.");
        }
    }

    /**
     * Edits the details of an existing student.
     * @param studentID the ID of the student to edit
     * @param fullName the new full name
     * @param marks the new marks
     */
    public void editStudent(int studentID, String fullName, int marks) {
        Optional<Student> optionalStudent = students.stream()
                .filter(student -> student.getStudentID() == studentID)
                .findFirst();

        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFullName(fullName);
            student.setMarks(marks);
            System.out.println("Student updated successfully.");
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

    /**
     * Deletes a student from the list.
     * @param studentID the ID of the student to delete
     */
    public void deleteStudent(int studentID) {
        if (students.removeIf(student -> student.getStudentID() == studentID)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student with ID " + studentID + " not found.");
        }
    }

    /**
     * Searches for a student by their ID.
     * @param studentID the ID of the student to search for
     * @return the student if found, or null if not found
     */
    public Student searchStudent(int studentID) {
        return students.stream()
                .filter(student -> student.getStudentID() == studentID)
                .findFirst()
                .orElse(null);
    }

    /**
     * Sorts the students by their marks in ascending order.
     */
    public void sortStudentsByMarks() {
        students.sort(Comparator.comparingInt(Student::getMarks));
        System.out.println("Students sorted by marks successfully.");
    }

    /**
     * Displays all students in the list.
     */
    public void displayAllStudents() {
        students.forEach(System.out::println);
    }
}