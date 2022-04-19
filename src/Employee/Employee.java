package Employee;

public class Employee {
    String First_Name;
    String Last_Name;
    long mobile_no;
    double wadge;
    int workingHour;
    boolean isStudent;

    public Employee(String first_Name, String last_Name, long mobile_no, double wadge, int workingHour, boolean isStudent) {
        First_Name = first_Name;
        Last_Name = last_Name;
        this.mobile_no = mobile_no;
        this.wadge = wadge;
        this.workingHour = workingHour;
        this.isStudent = isStudent;
    }

    public String getFirst_Name() {
        return First_Name;
    }

    public void setFirst_Name(String first_Name) {
        First_Name = first_Name;
    }

    public String getLast_Name() {
        return Last_Name;
    }

    public void setLast_Name(String last_Name) {
        Last_Name = last_Name;
    }

    public long getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(long mobile_no) {
        this.mobile_no = mobile_no;
    }

    public double getWadge() {
        return wadge;
    }

    public void setWadge(double wadge) {
        this.wadge = wadge;
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
