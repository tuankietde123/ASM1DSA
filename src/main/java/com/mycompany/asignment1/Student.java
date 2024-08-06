/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asignment1;

/**
 * Represents a student with an ID, full name, and marks. 
 * Provides methods to get and set these properties, as well as to determine the student's rank based on marks.
 */
public class Student {
    private int studentID;
    private String fullName;
    private int marks;

    public Student(int studentID, String fullName, int marks) {
        this.studentID = studentID;
        this.fullName = fullName;
        this.marks = marks;
    }

    // Getters and Setters
    public int getStudentID() {
        return studentID;
    }

    public String getFullName() {
        return fullName;
    }

    public int getMarks() {
        return marks;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Method to get rank based on marks
    public String getRank() {
        if (marks < 5.0) {
            return "Fail";
        } else if (marks < 6.5) {
            return "Medium";
        } else if (marks < 7.5) {
            return "Good";
        } else if (marks < 9.0) {
            return "Very Good";
        } else {
            return "Excellent";
        }
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID + ", Full Name: " + fullName + ", Marks: " + marks + ", Rank: " + getRank();
    }
}
