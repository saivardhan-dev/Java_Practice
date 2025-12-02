/*
Take a Paragraph and
1. Find the number of char in the string -
2. No. of spaces -
3. No. of words -
4. No. of letters -
5. No. of letters by alphabets
6. No. of special characters, symbols, or punctuation

In Java, java.lang.Throwable is the superclass of all errors and exceptions. Only objects that are instances of Throwable (or one of its subclasses) can be thrown by the Java Virtual Machine or by the throw statement in your code. Similarly, only Throwable or its subclasses can be used as the argument type in a catch clause to handle exceptions.
*/

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        int n=input.length();
        int count = 0;
        int noOfSpaces=0;
        int noOfLetters=0;
        String[] words = input.split("[^a-zA-Z]+");

        for(int i = 0; i < n; i++) {
            count++;
            if(input.charAt(i) == ' '){
                noOfSpaces++;
            }
            else{
                noOfLetters++;
            }
        }

        System.out.println("Number of char in the string: " + count);
        System.out.println("Number of Spaces in the string: " + noOfSpaces);
        System.out.println("Number of letters in the string: " + noOfLetters);
        System.out.println("Number of Words in the string: " + words.length);


//        char[] ch = input.toCharArray();
//        System.out.println("Character Occurrences:");
//        for (int i = 0; i < ch.length; i++) {
//            int charCount=1;
//            for(int j = i + 1; j < ch.length; j++) {
//                if (ch[i] == ch[j]) {
//                    charCount++;
//                }
//            }
//            System.out.println(ch[i] + " : " + charCount);
//        }

        Map<Character, Integer> map = new HashMap<>();
        for(char c : input.toCharArray()) {
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);
            }
        }
        System.out.println("Character Occurrences: " + map);
    }
}