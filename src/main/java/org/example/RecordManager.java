package org.example;

import java.io.*;
import java.util.ArrayList;

public class RecordManager {
    private final File file = new File("studentRecord.txt");

    public ArrayList<Student> loadFromFile() {
        ArrayList<Student> list = new ArrayList<>();

        if (!file.exists()) {
            return list;
        }
        try (BufferedReader br = new BufferedReader(new FileReader("studentRecords.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");

                if (parts.length == 3) {
                    String name = parts[0];
                    int roll = Integer.parseInt(parts[1]);
                    double marks = Double.parseDouble(parts[2]);

                    list.add(new Student(name, roll, marks));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }


    /*public void saveAllToFile(ArrayList<Student> list) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("studentRecords.txt", true))) {
            bw.write(toString());
            bw.newLine();
        }
     catch (IOException e){
            e.printStackTrace();
     }

    }*/


    public void addtoFile(Student s) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("studentRecords.txt", true))) {
            bw.write( s.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readfromFile(){
        try(BufferedReader bR  = new BufferedReader(new FileReader("studentRecords.txt"))){
            String line = bR.readLine();
            if(line == null) {
                System.out.println("No records Found!");
                return;
            }
            do {
                System.out.println(line);
            } while ((line = bR.readLine()) != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
     public void updateFile(ArrayList<Student> studentList){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter("studentRecords.txt"))){
            for(Student s: studentList){
              bw.write(s.getName() + ", " + s.getRollNo() + ", " + s.getMarks());
              bw.newLine();
            }
        } catch (IOException e) {
             e.printStackTrace();        }
     }
}
