package org.example;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner fetch = new Scanner(System.in);
        StudentManager manager = new StudentManager();

        while (true) {
            System.out.println("\n------Students Marks Manager-----");
            System.out.println("1. Add Student ");
            System.out.println("2. View Student ");
            System.out.println("3. Update Student ");
            System.out.println("4. Delete Student ");
            System.out.println("5. Exit ");
            System.out.println("Choose an option: ");

            int option = fetch.nextInt();

            switch (option) {
                case 1: {
                    System.out.println("Enter your name: ");
                    String name = fetch.next();
                    System.out.println("Enter your roll number: ");
                    int rollNo = fetch.nextInt();
                    System.out.println("Enter your marks: ");
                    double marks = fetch.nextDouble();
                    manager.addStudents(new Student(name, rollNo, marks));
                }
                break;

                case 2: {
                    System.out.println("----Student Records----");
                    manager.viewStudentRecords();
                }
                break;
                case 3: {
                    while (!manager.studentList.isEmpty()) {
                        System.out.println("1. Name");
                        System.out.println("2. Marks");
                        System.out.println("3. Return to main menu");
                        System.out.println("Choose a field to update");
                        int choose = fetch.nextInt();

                        if (choose == 3) {
                            System.out.println("Returning to main menu");
                            break;
                        }


                        switch (choose) {
                            case 1: {
                                System.out.println("Updating Name");
                                System.out.println("Choose an record to update( Enter the roll no: )");
                                int roll = fetch.nextInt();
                                System.out.println("Enter new Name: ");
                                String name = fetch.next();
                                manager.updateName(roll, name);
                                System.out.println("Name updated");
                            }
                            break;
                            case 2: {
                                System.out.println("Updating Marks");
                                System.out.println("Choose an record to update( Enter the roll no: )");
                                int roll = fetch.nextInt();
                                System.out.println("Enter new marks: ");
                                double marks = fetch.nextDouble();
                                manager.updateMarks(roll, marks);
                                System.out.println("Marks updated");
                            }
                            break;

                            default:
                                System.out.println("Invalid Option!!");
                        }
                    }
                }
                break;

                case 4: {
                    if(!manager.studentList.isEmpty()){
                    System.out.println("Deleting records");
                    System.out.println("Choose an record to delete( Enter the roll no: )");
                    int roll = fetch.nextInt();

                    manager.deleteRecord(roll);
                    System.out.println("Record deleted");
                    }
                }
                break;
                case 5:
                    System.out.println("Exiting....");
                    return;
                default:
                    System.out.println("Invalid Option!!");


            }

        }
    }
}