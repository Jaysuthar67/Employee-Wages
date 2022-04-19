package com.suthar.jay;

import Employee.Employee;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner scanner;
    static ArrayList<Employee> allEMP;

    public static void main(String[] args) {
        init();

    }

    private static void init() {
        scanner = new Scanner(System.in);
        allEMP = new ArrayList<>();
        Home();
    }

    static void Home() {
        System.out.println("===== Employee Wages Calculator =====");
        System.out.println("\t 1. Manager");
        System.out.println("\t 2. Employee");
        System.out.printf("Enter Number of Command > ");
        switch (scanner.nextLine()) {
            case "1":
                ManagerHome();
                break;
            case "2":
                EmployeeHome();
                break;
            default:
                System.out.println(" Error : Please Enter Valid Number");
                Home();
        }
    }

    static void ManagerHome() {
        System.out.println("===== Manager Page =====");
        System.out.printf(" Please Enter Manager Password >");
        String inPassword = scanner.nextLine();
        if (inPassword.equals(StaticProperties.MANAGER_PASSWORD)) {
            System.out.println("\t 1. Add Employee");
            System.out.println("\t 2. View Employee");
            System.out.println("\t 2. Edit Employee");
            System.out.println("\t 2. Delete Employee");
            System.out.println("\t 2. View All Data");
        } else {
            System.out.println(" Error : Wrong Password");
            Home();
        }
    }

    static void EmployeeHome() {

    }
}
