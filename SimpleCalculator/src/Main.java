import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number 1: ");
        double num1=sc.nextInt();

        System.out.println("Choose an operation:  1.Addition(+)   2.Subtraction(-)  3.Multiplication(*)   4.Division(/)");
        char operator = sc.next().charAt(0);

        System.out.println("Enter Number 1: ");
        double num2=sc.nextInt();

        double result;
        switch(operator){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1/num2;
                break;
            case '/':
                if(num2==0){
                    System.out.println("Number 2 should be greater than zero");
                }
                else{
                    result=num1/num2;
                }
            default: System.out.println("Invalid Operator!");
                return;
        }
        System.out.println("Result : " + result);
        sc.close();
    }
}