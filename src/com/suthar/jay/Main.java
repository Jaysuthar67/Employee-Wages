package com.suthar.jay;

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
        temp();
        Home();
    }

    /**
     * Create <b>Testing Data</b>
     */
    private static void temp() {
        allEMP.add(new Employee("A", 12, 15000, false));
        allEMP.add(new Employee("B", 123, 10000, true));
        allEMP.add(new Employee("C", 1234, 5000, true));
        allEMP.add(new Employee("D", 1235, 100, false));
        allEMP.add(new Employee("E", 12345, 1540, false));
//        allEMP.add(new Employee("A", 10, 20, false));
//        allEMP.add(new Employee("B", 10, 20, false));
//        allEMP.add(new Employee("C", 10, 20, false));
//        allEMP.add(new Employee("D", 10, 20, false));
//        allEMP.add(new Employee("E", 10, 20, false));
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
        if (inPassword.equals(SP.MANAGER_PASSWORD) || PasswordValid) {
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
                    ViewEmployee(Integer.parseInt(scanner.nextLine()));
                    ManagerHome(true);
                    break;
                case "3":
                    System.out.printf("Please Enter Employee ID to edit > ");
                    EditEmployee(Integer.parseInt(scanner.nextLine()));
                    break;
                case "4":
                    System.out.printf("Please Enter Employee ID to Delete > ");
                    DeleteEmployee(Integer.parseInt(scanner.nextLine()));
                    break;
                case "5":
                    ViewALLData();
                    break;
                case "6":
                    ManagerMore();
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

    private static void ManagerMore() {
        System.out.println("===== Manager Additional Menu =====");
        System.out.println("\t 1. Total Wages");
        System.out.println("\t 2. Average Wages");
        System.out.println("\t 3. Minimum worked hours");
        System.out.println("\t 4. Maximum worked hours");
        System.out.println("\t 5. Minimum Wages amount");
        System.out.println("\t 6. Maximum Wages amount");
        System.out.println("\t 7. Total 20% slot tax");
        System.out.println("\t 8. Total 40% slot tax");
        System.out.println("\t 9. Total 45% slot tax");
        System.out.println("\t 10. Total tax");
        System.out.println("\t 11. Exit");
        System.out.printf("Enter Number of Command > ");
        switch (scanner.nextLine().trim()) {
            case "1":
                System.out.println("\t ==> Total Wages of all Employee : " + totalWages());
                ManagerMore();
                break;
            case "2":
                System.out.println("\t ==> Average Wages of all Employee : " + averageWage());
                ManagerMore();
                break;
            case "3":
                MinWorkedHour();
                ManagerMore();
                break;
            case "4":
                MaxWorkedHour();
                ManagerMore();
                break;
            case "5":
                MinWage();
                ManagerMore();
                break;
            case "6":
                MaxWage();
                ManagerMore();
                break;
            case "7":
                System.out.println("\t ==> Total Tax 20% : " + TotalTax20());
                ManagerMore();
                break;
            case "8":
                System.out.println("\t ==> Total Tax 40% : " + TotalTax40());
                ManagerMore();
                break;
            case "9":
                System.out.println("\t ==> Total Tax 45% : " + TotalTax45());
                ManagerMore();
                break;
            case "10":
                System.out.println("\t ==> Total Tax of all Employee : " + TotalTax());
                ManagerMore();
                break;
            case "11":
                Home();
                break;
            default:
                ManagerHome(true);
        }

    }

    private static double TotalTax() {
        double totalTax = 0.0;
        for (int i = 0; i < allEMP.size(); i++) {
            totalTax += allEMP.get(i).taxAmount();
        }
        return totalTax;
    }

    private static double TotalTax20() {
        double totalTax = 0.0;
        for (int i = 0; i < allEMP.size(); i++) {
            if (allEMP.get(i).taxSlot().equals("20%")) {
                totalTax += allEMP.get(i).taxAmount();
            }
        }
        return totalTax;
    }

    private static double TotalTax40() {
        double totalTax = 0.0;
        for (int i = 0; i < allEMP.size(); i++) {
            if (allEMP.get(i).taxSlot().equals("40%")) {
                totalTax += allEMP.get(i).taxAmount();
            }
        }
        return totalTax;
    }

    private static double TotalTax45() {
        double totalTax = 0.0;
        for (int i = 0; i < allEMP.size(); i++) {
            if (allEMP.get(i).taxSlot().equals("45%")) {
                totalTax += allEMP.get(i).taxAmount();
            }
        }
        return totalTax;
    }

    private static void MinWorkedHour() {
        int min = allEMP.get(0).getWorkingHour();
        int minIdx = 0;
        for (int i = 0; i < allEMP.size(); i++) {
            int currentWage = allEMP.get(i).getWorkingHour();
            if (currentWage < min) {
                min = currentWage;
                minIdx = i;
            }
        }
        ViewEmployee(minIdx);
    }

    private static void MaxWorkedHour() {
        int max = allEMP.get(0).getWorkingHour();
        int maxIdx = 0;
        for (int i = 0; i < allEMP.size(); i++) {
            int currentWage = allEMP.get(i).getWorkingHour();
            if (currentWage > max) {
                max = currentWage;
                maxIdx = i;
            }
        }
        ViewEmployee(maxIdx);
    }

    private static void MaxWage() {
        double max = allEMP.get(0).totalWage();
        int maxIdx = 0;
        for (int i = 0; i < allEMP.size(); i++) {
            double currentWage = allEMP.get(i).totalWage();
            if (currentWage > max) {
                max = currentWage;
                maxIdx = i;
            }
        }
        ViewEmployee(maxIdx);
    }

    private static void MinWage() {
        double min = allEMP.get(0).totalWage();
        int minIdx = 0;
        for (int i = 0; i < allEMP.size(); i++) {
            double currentWage = allEMP.get(i).totalWage();
            if (currentWage < min) {
                min = currentWage;
                minIdx = i;
            }
        }
        ViewEmployee(minIdx);
    }

    private static void ViewALLData() {

        System.out.println("\n\n\n=========== All Data ===========");
        ArrayList<String[]> newList = new ArrayList<>();
        for (int i = 0; i < allEMP.size(); i++) {
            Employee e = allEMP.get(i);
            String[] str = {"" + i, "" + e.getFull_Name(), "" + e.getMobile_no(), "" + e.getWorkingHour(), "" + e.isStudent(), "" + e.totalWage(), "" + e.taxSlot(), "" + e.taxAmount(), "" + e.netPay()};
            newList.add(str);
        }
        printTable(SP.HEADERS, newList.toArray(String[][]::new));
        ManagerHome(true);
    }

    private static void DeleteEmployee(int empID) {
        allEMP.remove(empID);
        ViewALLData();
    }

    private static void EditEmployee(int empID) {
        System.out.println("==== Editing Employee ====");

        String[][] strAry = {
                {"" + empID,
                        "" + allEMP.get(empID).getFull_Name(),
                        "" + allEMP.get(empID).getMobile_no(),
                        "" + allEMP.get(empID).getWorkingHour(),
                        "" + allEMP.get(empID).isStudent(),
                        "" + allEMP.get(empID).totalWage(),
                        "" + allEMP.get(empID).taxSlot(),
                        "" + allEMP.get(empID).taxAmount(),
                        "" + allEMP.get(empID).netPay()}};
        printTable(SP.HEADERS, strAry);
        System.out.println("EDIT -> ");

        System.out.printf("Enter Full Name (Default: " + allEMP.get(empID).getFull_Name() + " )> ");
        String fullName;
        fullName = scanner.nextLine();
        fullName.trim();
        if (!fullName.equals("")) allEMP.get(empID).setFull_Name(fullName);

        System.out.printf("Enter Mobile No. (Default: " + allEMP.get(empID).getMobile_no() + " ) > ");
        Long mobile = Long.parseLong(scanner.nextLine());
        if (mobile != null && mobile != 0) allEMP.get(empID).setMobile_no(mobile);


        System.out.printf("Enter Worked Hours (Default: " + allEMP.get(empID).getWorkingHour() + " ) > ");
        Integer workingHour = Integer.parseInt(scanner.nextLine());
        if (workingHour != null && workingHour != 0) allEMP.get(empID).setWorkingHour(workingHour);

        System.out.printf("Is Employee Student ? Yes(Y) or No(N)  > ");
        String input;
        input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y") || input.equals("Yes")) allEMP.get(empID).setStudent(true);
        else if (input.equals("N") || input.equals("n") || input.equals("No")) allEMP.get(empID).setStudent(false);
        strAry = new String[][]{
                {"" + empID,
                        "" + allEMP.get(empID).getFull_Name(),
                        "" + allEMP.get(empID).getMobile_no(),
                        "" + allEMP.get(empID).getWorkingHour(),
                        "" + allEMP.get(empID).isStudent(),
                        "" + allEMP.get(empID).totalWage(),
                        "" + allEMP.get(empID).taxSlot(),
                        "" + allEMP.get(empID).taxAmount(),
                        "" + allEMP.get(empID).netPay()}};
        printTable(SP.HEADERS, strAry);
        ManagerHome(true);
    }

    private static void ViewEmployee(int empID) {
        Employee e = allEMP.get(empID);
        String[][] strAry = {{"" + empID,
                "" + e.getFull_Name(),
                "" + e.getMobile_no(),
                "" + e.getWorkingHour(),
                "" + e.isStudent(),
                "" + e.totalWage(),
                "" + e.taxSlot(),
                "" + e.taxAmount(),
                "" + e.netPay()}};
        printTable(SP.HEADERS, strAry);

    }

    private static void CreateNewEmployee() {
        Employee newEmployee = new Employee("", 0, 0, false);
        System.out.println("===== Creat New Employee =====");

        System.out.printf("Enter Full Name > ");
        newEmployee.setFull_Name(scanner.nextLine().trim());

        System.out.printf("Enter Mobile No. > ");
        newEmployee.setMobile_no(Long.parseLong(scanner.nextLine()));

        System.out.printf("Enter Worked Hours > ");
        newEmployee.setWorkingHour(Integer.parseInt(scanner.nextLine()));

        System.out.printf("Is Employee Student ? Yes(Y) or No(N) > ");
        String input;
        input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y") || input.equals("Yes")) {
            newEmployee.setStudent(true);
        } else {
            newEmployee.setStudent(false);
        }
        System.out.println("==== New Employee Details ====");
        System.out.println("Full Name: " + newEmployee.getFull_Name());
        System.out.println("Mobile No.: " + newEmployee.getMobile_no());
        System.out.println("Wage: " + newEmployee.totalWage());
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
        System.out.println("===== Employee Details =====");
        System.out.printf("Please Enter Employee ID > ");
        Integer empID = Integer.parseInt(scanner.nextLine());
        Employee e = allEMP.get(empID);
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("\t Welcome " + e.getFull_Name());
        System.out.println("\t Your Total Worked Hour : " + e.getWorkingHour());
        System.out.println("\t Your Total Wage : " + e.totalWage());
        System.out.println("\t Your Total Net Pay : " + e.netPay());
        System.out.println(totalWages());
        System.out.println("\t Your Percentage of Wages : " + ((e.totalWage() * 100) / totalWages()) + "%");
        System.out.println("-------------------------------------------------------------------------------");
        System.out.printf("Do You have any complaint or issue ? Yes(Y) or No(N) > ");
        String input = scanner.nextLine();
        if (input.equals("Y") || input.equals("y") || input.equals("Yes")) {
            System.out.println("Please Enter Complaint > ");
            String complaint = scanner.nextLine();
            System.out.println("Complaint Noted : " + complaint);
        } else {
            System.out.println("Thank you");
            System.out.printf("Do You want to restart ? Yes(Y) or No(N) > ");
            input = scanner.nextLine();
            if (input.equals("Y") || input.equals("y") || input.equals("Yes")) {
                System.out.println("\t\t Thank You, Good Bye");
                Home();
            } else ;

        }

    }

    private static Double totalWages() {
        Double total = 0.0;
        for (int i = 0; i < allEMP.size(); i++) {
            total += allEMP.get(i).totalWage();
        }
        return total;
    }

    private static Double averageWage() {
        return totalWages() / allEMP.size();
    }

    private static void printTable(String[] header, String[][] data) {
        ASCIITable.getInstance().printTable(header, data);
    }
}

/**
 * STATIC PROPERTIES CLASS
 * */
class SP {
    static final String MANAGER_PASSWORD = "123";

    static final String[] HEADERS = {"Employee ID", "Full Name", "Mobile No.", "Worked Hours", "Is Student", "Total Wage", "Tax Slot", "Tax Amount", "Net Pay"};

    //=== Wage Slot Settings ===
    static final int Wage_SLOT_80 = 80;
    static final double Wage_FOR_80 = 9.5;
    static final int Wage_SLOT_120 = 120;
    static final double Wage_FOR_120 = 10.5;
    static final int Wage_SLOT_200 = 200;
    static final double Wage_FOR_200 = 11;
    static final double Wage_FOR_OVER_200 = 13;


    static final double wage_upto_80 = (Wage_SLOT_80) * Wage_FOR_80;
    static final double wage_Upto_120 = (Wage_SLOT_120 - Wage_SLOT_80) * Wage_FOR_120;
    static final double wage_Upto_200 = (Wage_SLOT_200 - Wage_SLOT_120 - Wage_SLOT_80) * Wage_FOR_200;

    //=== Tax Slot Settings ===
    static final int TAX_SLOT_12500 = 12500;
    static final double TAX_FOR_12500 = 0.45;
    static final int TAX_SLOT_4190 = 4190;
    static final double TAX_FOR_4190 = 0.40;
    static final int TAX_SLOT_1050 = 1050;
    static final double TAX_FOR_1050 = 0.20;


}

class Employee {
    private String Full_Name;
    private long mobile_no;
    private int workingHour;
    private boolean isStudent;

    public Employee(String full_Name, long mobile_no, int workingHour, boolean isStudent) {
        Full_Name = full_Name;
        this.mobile_no = mobile_no;
        this.workingHour = workingHour;
        this.isStudent = isStudent;
    }

    public String getFull_Name() {
        return Full_Name;
    }

    public void setFull_Name(String full_Name) {
        Full_Name = full_Name;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public int getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }

    public double totalWage() {
        double finalWage;
        if (workingHour > SP.Wage_SLOT_200) {
            finalWage = SP.wage_upto_80 + SP.wage_Upto_120 + SP.wage_Upto_200 + ((workingHour - SP.Wage_SLOT_80 - SP.Wage_SLOT_120 - SP.Wage_SLOT_200) * SP.Wage_FOR_OVER_200);
        } else if (workingHour > SP.Wage_SLOT_120) {
            finalWage = SP.wage_upto_80 + SP.wage_Upto_120 + ((workingHour - SP.Wage_SLOT_80 - SP.Wage_SLOT_120) * SP.Wage_FOR_200);
        } else if (workingHour > SP.Wage_SLOT_80) {
            finalWage = SP.wage_upto_80 + ((workingHour - SP.Wage_SLOT_80) * SP.Wage_FOR_120);
        } else {
            finalWage = workingHour * SP.Wage_FOR_80;
        }
        return finalWage;
    }

    public String taxSlot() {
        if (isStudent) {
            return "No Tax";
        }
        double totalWage = totalWage();
        if (totalWage > SP.TAX_SLOT_12500) {
            return "45%";
        } else if (totalWage > SP.TAX_SLOT_4190) {
            return "40%";
        } else if (totalWage > SP.TAX_SLOT_1050) {
            return "20%";
        } else {
            return "NIL";
        }
    }

    public Double taxAmount() {
        if (isStudent) {
            return 0.0;
        }
        Double taxAmount;
        double totalWage = totalWage();
        if (totalWage > SP.TAX_SLOT_12500) {
            taxAmount = totalWage * SP.TAX_FOR_12500;
        } else if (totalWage > SP.TAX_SLOT_4190) {
            taxAmount = totalWage * SP.TAX_FOR_4190;
        } else if (totalWage > SP.TAX_SLOT_1050) {
            taxAmount = totalWage * SP.TAX_FOR_1050;
        } else {
            taxAmount = 0.0;
        }
        return taxAmount;
    }

    public Double netPay() {
        return totalWage() - taxAmount();
    }

}