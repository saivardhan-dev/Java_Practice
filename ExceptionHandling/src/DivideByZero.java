//Accept two numbers and handle division by zero

public class DivideByZero {
    public static void main(String[] args){
        try{
            int a=10;
            int b=0;
            int c=a/b;
            System.out.println("c=" + c);
        }catch(ArithmeticException e){
            System.out.println("Error: " + e);
        }
    }
}
