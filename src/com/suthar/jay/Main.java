package com.suthar.jay;

import Employee.Employee;
import com.bethecoder.ascii_table.ASCIITable;

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
        switch (scanner.nextLine().trim()) {
            case "1":
                ManagerHome(false);
                break;
            case "2":
                EmployeeHome();
                break;
            default:
                System.out.println(" Error : Please Enter Valid Number");
                Home();
        }
    }

    private static void ManagerHome(boolean PasswordValid) {
        System.out.println("===== Manager Home =====");
        String inPassword = "a";
        if (!PasswordValid) {
            System.out.printf(" Please Enter Manager Password >");
            inPassword = scanner.nextLine().trim();
        }
        if (inPassword.equals(StaticProperties.MANAGER_PASSWORD) || PasswordValid) {
            System.out.println("\t 1. Create New Employee");
            System.out.println("\t 2. View Employee");
            System.out.println("\t 3. Edit Employee");
            System.out.println("\t 4. Delete Employee");
            System.out.println("\t 5. View All Data");
            System.out.println("\t 6. More");
            System.out.println("\t 7. Exit");
            System.out.printf("Enter Number of Command > ");
            switch (scanner.nextLine().trim()) {
                case "1":
                    CreateNewEmployee();
                    break;
                case "2":
                    System.out.printf("Please Enter Employee ID > ");
                    ViewEmployee(scanner.nextInt());
                    break;
                case "3":
                    System.out.printf("Please Enter Employee ID to edit > ");
                    EditEmployee(scanner.nextInt());
                    break;
                case "4":
                    System.out.printf("Please Enter Employee ID to Delete > ");
                    DeleteEmployee(scanner.nextInt());
                    break;
                case "5":
                    ViewALLData();
                    break;
                case "6":
                    ManagerMore(true);
                    break;
                case "7":
                    Home();
                    break;
                default:
                    ManagerHome(true);
            }

        } else {
            System.out.println(" Error : Wrong Password");
            Home();
        }
    }

    private static void ManagerMore(boolean PasswordValid) {
        System.out.println("===== Manager Additional Menu =====");
        String inPassword = null;
        if (!PasswordValid) {
            System.out.printf(" Please Enter Manager Password >");
            inPassword = scanner.nextLine().trim();
        }
    }
private static void temp(){
    Employee newEmployee = new Employee("safasf", 123, 345, 23, false);
    allEMP.add(newEmployee);
    allEMP.add(newEmployee);
    allEMP.add(newEmployee);
    allEMP.add(newEmployee);
    allEMP.add(newEmployee);
}
    private static void ViewALLData() {
                temp();
        System.out.println("\n\n\n=========== All Data ===========");
        ArrayList<String[]> newList = new ArrayList<>();
        for (int i = 0; i < allEMP.size(); i++) {
            Employee e = allEMP.get(i);
            String[] str= {""+i,""+e.getFull_Name(),""+e.getMobile_no(),""+e.getWage(),""+e.getWorkingHour(),""+e.isStudent()};
            newList.add(str);
        }
        printTable(StaticProperties.HEADERS_BASIC, newList.toArray(String[][]::new));
        ManagerHome(true);
    }

    private static void DeleteEmployee(int empID) {
    }

    private static void EditEmployee(int empID) {
    }

    private static void ViewEmployee(int empID) {
        Employee e = allEMP.get(empID);
        String[][] strAry= {{""+empID,""+e.getFull_Name(),""+e.getMobile_no(),""+e.getWage(),""+e.getWorkingHour(),""+e.isStudent()}};
        printTable(StaticProperties.HEADERS_BASIC,strAry);

    }

    private static void CreateNewEmployee() {
        Employee newEmployee = new Employee("", 0, 0, 0, false);
        System.out.println("===== Creat New Employee =====");

        System.out.printf("Enter Full Name > ");
        newEmployee.setFull_Name(scanner.nextLine().trim());

        System.out.printf("Enter Wage > ");
        newEmployee.setWage(scanner.nextDouble());

        System.out.printf("Enter Worked Hours > ");
        newEmployee.setWorkingHour(scanner.nextInt());

        System.out.printf("Is Employee Student ? Yes(Y) or No(N) > ");
        String input;
        input = scanner.nextLine();
        input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y") || input.equals("Yes")) {
            newEmployee.setStudent(true);
        } else {
            newEmployee.setStudent(false);
        }
        System.out.println("==== New Employee Details ====");
        System.out.println("Full Name: " + newEmployee.getFull_Name());
        System.out.println("Mobile No.: " + newEmployee.getMobile_no());
        System.out.println("Wage: " + newEmployee.getWage());
        System.out.println("Worked Hour: " + newEmployee.getWorkingHour());
        System.out.println("Is Student: " + newEmployee.isStudent());

        System.out.printf("Confirm Save ? Yes(Y) or No(N) > ");
        input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y") || input.equals("Yes")) {
            allEMP.add(newEmployee);
            System.out.println("Employee Added");
            ManagerHome(true);
        } else {
            ManagerHome(true);
        }
    }


    private static void EmployeeHome() {

    }

    private static void printTable(String[] header, String[][] data){
        ASCIITable.getInstance().printTable(header,data);
    }
}
