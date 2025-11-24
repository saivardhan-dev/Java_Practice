import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> tasks = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int choice;

        do{
            System.out.println("\n1. Add Task \n2. View Task \n3. Remove Task \n4.Exit");
            System.out.println("Choose: ");
            choice = sc.nextInt();

            switch(choice){
                case 1:
                    System.out.println("Enter task: ");
                    tasks.add(sc.nextLine());
                    System.out.println("Task Added!");
                    break;
                case 2:
                    System.out.println("Your Tasks: ");
                    for(int i=0; i < tasks.size();i++) {
                        System.out.println((i + 1) + ". " + tasks.get(i));
                    }break;
                case 3:
                    System.out.println("Enter task number to remove: ");
                    int index = sc.nextInt()-1;
                    if(index>=0 && index<tasks.size()){
                        tasks.remove(index);
                        System.out.println("Task Removed!");
                    }
                    else{
                        System.out.println("Invalid number!");
                    }
                case 4:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }while(choice!=4);
        sc.close();
    }
}