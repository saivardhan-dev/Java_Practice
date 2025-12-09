class ParallelExecution{
    private boolean t2Turn = true;
    public synchronized void printFromT2() throws InterruptedException{
        while(!t2Turn){
            wait();
        }
        System.out.println("Hola, Senorita");
        t2Turn = false;
        notifyAll();
    }
    public synchronized void printFromT1() throws InterruptedException{
        while(t2Turn){
            wait();
        }
        System.out.println("Hola, Amigo");
        t2Turn = true;
        notifyAll();
    }
}

class t2 implements Runnable{
    private final ParallelExecution pe;
    public t2(ParallelExecution pe){
        this.pe=pe;
    }
    @Override
    public void run(){
        try {
            for(int i=0;i<5;i++) {
                pe.printFromT2();
            }
        }catch (Exception e){}
    }
}

class t1 implements Runnable{
    private final ParallelExecution pe;
    public t1(ParallelExecution pe){
        this.pe=pe;
    }
    @Override
    public void run(){
        try {
            for (int i = 0; i < 5; i++) {
                pe.printFromT1();
            }
        }catch (Exception e){}
    }
}

class Main{
    public static void main(String[] args) throws InterruptedException {
        ParallelExecution pe = new ParallelExecution();

        Thread t2 = new Thread(new t2(pe));
        Thread t1 = new Thread(new t1(pe));

        t2.start();
        t1.start();

        t2.join();
        t1.join();
    }
}