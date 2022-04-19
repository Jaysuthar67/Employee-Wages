package Employee;

public class Employee {
    private String Full_Name;
    private long mobile_no;
    private double wage;
    private int workingHour;
    private boolean isStudent;

    public Employee(String full_Name, long mobile_no, double wage, int workingHour, boolean isStudent) {
        Full_Name = full_Name;
        this.mobile_no = mobile_no;
        this.wage = wage;
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

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
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

}
