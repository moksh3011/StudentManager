package org.example;
import java.io.*;
import java.util.ArrayList;

public class StudentManager {

    ArrayList<Student> studentList = new ArrayList<>();
    RecordManager record = new RecordManager();


    public StudentManager(){
        studentList = record.loadFromFile();
    }
    public void addStudents(Student s) {
     studentList.add(s);
     System.out.println("Record added successfully!!");
     record.addtoFile(s);
 }



    public void viewStudentRecords(){


        record.readfromFile();

    }


    public void updateName(int roll, String name){
        for(Student s: studentList){
            if(s.getRollNo() == roll) {
                s.setName(name);
                record.updateFile(studentList);
                return;
            }
        }System.out.println("record not found!");
    }

    public void updateMarks(int roll, double marks) {
        for (Student s : studentList) {
            if (s.getRollNo() == roll) {
                s.setMarks(marks);
                record.updateFile(studentList);
                return;
            }
            System.out.println("record not found!");
        }
    }

    public void deleteRecord(int roll) {
        for (Student s : studentList) {
            if (s.getRollNo() == roll) {
                studentList.remove(s);
                record.updateFile(studentList);
                return;
            }
        }


    }}