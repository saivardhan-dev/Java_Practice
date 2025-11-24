class MyThread extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            System.out.println("Numbers in Thread: " + i);
        }
    }
}

class MyThread2 implements Runnable{
    public void run(){
        for(int i=5;i>=1;i--){
            System.out.println("Numbers in Runnable: " + i);
        }
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new MyThread();

        Runnable r= new MyThread2();
        Thread t2=new Thread(r);
        t2.start();
        t1.start();
        t2.join();
    }
}