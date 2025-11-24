class MyThread extends Thread{
    public void run(){
        for(int i=0;i<=5;i++){
            System.out.println("Numbers in Thread: " + i);
        }
    }
}

class MyThread2 implements Runnable{
    public void run(){
        for(int i=5;i<=0;i--){
            System.out.println("Numbers in Runnable: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t1= new MyThread();
        Runnable t2= new MyThread2();

        t1.start();
        t2.run();
    }
}