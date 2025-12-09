package org.example;
//import static org.example.StudentManager.*;


public class Student {
    private String name;
    private int rollNo;
    private double marks;

    //constructor
    public Student(String name, int rollNo, double marks){
        this.name = name;
        this.rollNo = rollNo;
        this.marks = marks;
    }


    //setters and getters

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }
    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public double getMarks() {
        return marks;
    }
    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString(){
        return "Name: " + getName() + ", RollNo: " + getRollNo() +  ", Marks: " + getMarks() ;
    }
}
