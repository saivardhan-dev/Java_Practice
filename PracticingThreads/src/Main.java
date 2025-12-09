class t1 extends Thread{
    public void run(){
        for(int i = 0; i < 10; i++) {
            System.out.println("Hello t1!");
        }
    }
}

class t2 implements Runnable{
    public void run() {
        for(int i = 0; i < 10; i++) {
            System.out.println("Hola t2!");
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException{
        Thread t2 = new Thread(new t2());
        t2.start();
        t2.join();
        t1 thread = new t1();
        thread.start();
    }
}