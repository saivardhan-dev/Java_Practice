```text
class t2 implements Runnable{
    public void run(){
        for(int i=0;i<5;i++) {
            System.out.println("Hola, Senorita");
        }
    }
}

class t1 extends Thread{
    @Override
    public void run(){
        for(int i=0;i<5;i++) {
            System.out.println("Hola, Amigo");
        }
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        t2 Thread2 = new t2();
        Thread thread = new Thread(Thread2);
        thread.start();

        t1 Thread = new t1();
        Thread.start();


        /*Thread.sleep(1000): sleep: pauses the thread for a given period of time in milliseconds.
        Thread.join():  Makes one thread wait for another thread to finish.
        wait(): can ONLY be called inside a synchronized block/method.
            What it does:
		        Makes the thread release the lock
		        Puts thread into waiting state
		        Thread will wake up only when another thread calls notify() or notifyAll()
		 notify(): Wakes up one thread waiting on the same object’s monitor.
		 notifyAll(): Wakes up all threads waiting on the same object. Useful when you don’t know which thread should wake up.
		 
		 Real Life Analogy:
            run(): Person goes inside and uses bathroom
            sleep(mil.sec): Person inside bathroom takes a nap — still inside, lock remains
            wait(): Person steps out and leaves the key for others, waits outside to be notified
            notify(): Someone inside opens door and calls one waiting person
            notifyAll(): Someone opens door and calls everyone waiting
            join(): You wait outside until a specific person finishes using the bathroom
        */
    }
}
```
