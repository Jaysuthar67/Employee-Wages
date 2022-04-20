package com.suthar.jay;

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
    public double totalWage(){
        double finalwage = 0.0;
        finalwage = wage*workingHour;
        if (workingHour > StaticProperties.BONUS_SLOT_15000) {
            finalwage = finalwage + (finalwage * StaticProperties.BONUS_FOR_15000);
        } else if (workingHour > StaticProperties.BONUS_SLOT_10000) {
            finalwage = finalwage + (finalwage * StaticProperties.BONUS_FOR_10000);
        } else if (workingHour > StaticProperties.BONUS_SLOT_5000) {
            finalwage = finalwage + (finalwage * StaticProperties.BONUS_FOR_5000);
        }
        return finalwage;
    }

    public String taxSlot(){
        if (isStudent){
            return "No Tax";
        }
        double totalWage = totalWage();
        if (totalWage>StaticProperties.TAX_SLOT_12500){
            return "45%";
        }else if(totalWage>StaticProperties.TAX_SLOT_4190){
            return "40%";
        }else if(totalWage>StaticProperties.TAX_SLOT_1050){
            return "20%";
        }else {
            return "NIL";
        }
    }

    public Double taxAmount(){
        if (isStudent){
            return 0.0;
        }
        Double taxAmount;
        double totalWage = totalWage();
        if (totalWage>StaticProperties.TAX_SLOT_12500){
            taxAmount = totalWage*StaticProperties.TAX_FOR_12500;
        }else if(totalWage>StaticProperties.TAX_SLOT_4190){
            taxAmount = totalWage*StaticProperties.TAX_FOR_4190;
        }else if(totalWage>StaticProperties.TAX_SLOT_1050){
            taxAmount = totalWage*StaticProperties.TAX_FOR_1050;
        }else {
            taxAmount = 0.0;
        }
        return taxAmount;
    }

    public Double netPay(){
        return totalWage()-taxAmount();
    }

}
