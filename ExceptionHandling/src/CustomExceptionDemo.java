class InvalidEAgexception extends Exception {
    public InvalidEAgexception(String message) {
        super(message);
    }
}

public class CustomExceptionDemo {
    static void checkAge(int age) throws InvalidEAgexception {
        if (age < 18) throw new InvalidEAgexception("Age must be greater than 18");
        else System.out.println("Age is greater than 18");
    }

    public static void main(String[] args) {
        try {
            checkAge(18);
        } catch (InvalidEAgexception e) {
            System.out.println(e.getMessage());
        }
    }
}
