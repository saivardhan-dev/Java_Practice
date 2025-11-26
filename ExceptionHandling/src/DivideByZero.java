//Accept two numbers and handle division by zero

public class DivideByZero {
    public static void main(String[] args){
        System.out.println("Divide by zero");
        try {
            System.out.println(10 / 0);
        }catch (ArithmeticException e){
            System.out.println("Arithmetic Exception");
        }
        System.out.println("QUE PASO");
    }
}
