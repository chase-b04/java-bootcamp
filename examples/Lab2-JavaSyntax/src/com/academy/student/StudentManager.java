package com.academy.student;

import java.util.Scanner;

public class StudentManager {

    private static final int MAX_STUDENTS = 20;

    private final Student[] students = new Student[MAX_STUDENTS];
    private int studentCount = 0;
    private final Scanner scanner;

    public StudentManager(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("====================================");
        System.out.println("Student Management System");
        System.out.println("====================================");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Search Student");
        System.out.println("4. Average Marks");
        System.out.println("5. Exit");
        System.out.print("Enter Choice : ");
    }

    // Methods addStudent, displayStudents, searchStudent, calculateAverage
    // will be filled in later steps.
    public void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Student list is full");
            return;
        }

        int studentId;
        while (true){
            System.out.print("Student ID : ");
            String input = scanner.nextLine();
            try {
                studentId = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Student ID. Enter a whole number.");
                continue;
            }
            if (studentId <= 0) {
                System.out.println("Invalid Student ID. Enter positive number.");
                continue;
            }
            boolean exists = false;
            for (int i = 0; i < studentCount; i++) {
                if (students[i].getStudentId() == studentId) {
                    System.out.println("Student ID already exists");
                    exists = true;
                    break;
                }
            }
            if (exists == true) {continue;}
            break;
        }
//        scanner.nextLine();

        System.out.print("Name : ");
        String name = scanner.nextLine();
        while (name.isBlank()) {
            System.out.print("Enter a valid Name: ");
            name = scanner.nextLine();
        }

        System.out.print("Course : ");
        String course = scanner.nextLine();
        while (course.isBlank()) {
            System.out.print("Enter a valid Course: ");
            course = scanner.nextLine();
        }

        System.out.print("Marks : ");
        Double marks = Double.parseDouble(scanner.nextLine());
        while (marks > 100 || marks < 0) {
            System.out.print("Enter a valid mark amount (1-100): ");
            marks = Double.parseDouble(scanner.nextLine());
        }

        students[studentCount] = new Student(studentId, name, course, marks);
        studentCount++;
        System.out.println("Student Added Successfully.");
    }

    public void displayStudents() {
        if (studentCount == 0) {
            System.out.println("No students to display.");
            return;
        }
        System.out.println("----------------------------------------------------------");
        System.out.println("ID      Name                 Course          Marks");
        System.out.println("----------------------------------------------------------");
        for (int i = 0; i < studentCount; i++) {
            Student student = students[i];
            System.out.printf("%-8d %-20s %-15s %-8.2f%n",
                    student.getStudentId(),
                    student.getName(),
                    student.getCourse(),
                    student.getMarks());
            System.out.println("----------------------------------------------------------");
        }
    }

    public void searchStudent() {
        if (studentCount == 0) {
            System.out.println("No students to search.");
            return;
        }
        System.out.print("Student ID : ");
        int studentId = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId() == studentId) {
                students[i].display();
                System.out.println();
                return;
            }
        }
        System.out.println("Student Not Found.");
    }

    public void calculateAverage() {
        if (studentCount == 0) {
            System.out.println("No students to search.");
            return;
        }
        int totalMarks = 0;
        for (int i = 0; i < studentCount; i++) {
            totalMarks += students[i].getMarks();
        }
        double avg = totalMarks/studentCount;
        System.out.printf("Average Marks: %.2f%n", avg);
    }

}