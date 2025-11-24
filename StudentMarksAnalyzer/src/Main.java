import java.util.Scanner;

public class Main {
    static void analyzeMarks(int[] marks){
        int sum = 0, max = marks[0], min = marks[0];
        for(int m : marks){
            sum+=m;
            if(m>max) max=m;
            if(m<min) min=m;
        }
        double avg = (double) sum/marks.length;
        System.out.println("Total : " + sum);
        System.out.println("Average : " + avg);
        System.out.println("Highest : " + max);
        System.out.println("Lowest : " + min);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Students: ");
        int n= sc.nextInt();
        int[] marks = new int[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter marks for student: " + (i+1) + ":");
            marks[i]=sc.nextInt();
        }
        analyzeMarks(marks);
        sc.close();
    }
}