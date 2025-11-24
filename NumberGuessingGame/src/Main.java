import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Random rand = new Random();
        int numberToGuess = rand.nextInt(100)+1;
        int guess=0, attempts=0;
        System.out.println("Guess a number between 1 and 100: ");

        while(guess != numberToGuess){
            System.out.println("Enter you Guess: ");
            guess = sc.nextInt();
            attempts++;

            if(guess>numberToGuess){
                System.out.println("Too High, Try again!");
            }
            else if(guess<numberToGuess){
                System.out.println("Too low, Try again!");
            }
            else{
                System.out.println("🎉Congrats guessed it in " + attempts + " tries");
            }
        }
        sc.close();
    }
}