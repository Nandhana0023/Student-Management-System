import java.util.InputMismatchException;
import java.util.ArrayList;
import java.util.Scanner;
class Student{
    int id;
    String name;
    int marks;
    Student(int id, String name, int marks){
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
public class crud {
    public static void main(String[] args) {
        Scanner z = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        int choice;
        while(true){
            try{
            System.out.println("------Student Management System------");
            System.out.print("1.Create\n2.View\n3.Update\n4.Delete\n5.Exit\nEnter choice: ");
            choice = z.nextInt();
            z.nextLine();
            if(choice == 5){
                System.out.println("Exiting, Thank you!");
                break;
            }
        }catch(InputMismatchException e){
            System.out.println("Invalid input, Please enter integers only!");
            z.nextLine();
            continue;
        }
        switch(choice){
            case 1:
                System.out.print("Enter ID: ");
                int id = z.nextInt();
                System.out.print("Enter Name: ");
                String name = z.next();
                System.out.print("Enter Marks: ");
                int marks = z.nextInt();
                list.add(new Student(id, name, marks));
                System.out.println("Record added!");
                break;
            case 2:
                System.out.println("---Student Records---");
                if(list.isEmpty()){
                    System.out.println("No records found.");
                }
                System.out.println("ID\tName\tMarks");
                for(Student s : list){
                    System.out.println(s.id + "\t" + s.name + "\t" + s.marks);
                }
                break;
            case 3:
                System.out.print("Enter ID to update: ");
                int updateId = z.nextInt();
                boolean found = false;
                for(Student s : list){
                    if(s.id == updateId){
                        System.out.print("Enter new name: ");
                        s.name = z.next();
                        System.out.print("Enter new marks: ");
                        s.marks = z.nextInt();
                        found = true;
                    }
                }
                if(found){
                    System.out.println("Record updated!");
                } else {
                    System.out.println("Student ID not found");
                }
                break;
            case 4:
                System.out.print("Enter ID to delete: ");
                int deleteId = z.nextInt();
                boolean deleted = false;
                for(Student s : list){
                    if(s.id == deleteId){
                        list.remove(s);
                        System.out.println("Record deleted!");
                        deleted = true;
                        break;
                    }
                }
                if(!deleted){
                    System.out.println("Student ID not found");
                }
                break;
            }
        }
        z.close();
    }
}