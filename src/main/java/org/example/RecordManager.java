package org.example;

import java.io.*;

public class RecordManager {
    public void createFile(){
        File file = new File("studentRecords.txt");
        try{ if(file.createNewFile()) {
            System.out.println("file created" + file.getName());
        }else {
            System.out.println("file already exists!");
        }}catch(IOException e ){
            System.out.println("an error occurred");
            e.printStackTrace();
        }
    }

    public void addtoFile(String name , int rollNo, double marks) {
        createFile();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("studentRecords.txt", true))) {
            writer.write("Name: " + name+ " RollNO: "+rollNo+" Marks: "+ marks);
            writer.newLine();
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
}
