public class Main {
    public static void main(String[] args) {
        int x;
        do {
            switch (x=3) {
                case 1:
                    System.out.println("Hi");
                    break;
                case 2:
                    System.out.println("Hello");
                    break;
                case 3:
                    System.out.println("Hola");
                    break;
                default:
                    System.out.println("Cómo estás");
            }
        }while(x<=1 && x>=3);
    }
}