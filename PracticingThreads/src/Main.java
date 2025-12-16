import java.util.LinkedList;
import java.util.List;

class Runway{
    private final int capacity;
    private final List<String> aircraftStand=new LinkedList<>();
    public Runway(int capacity){
        this.capacity=capacity;
    }
    public synchronized void landing(String plane) throws InterruptedException{
        while (aircraftStand.size()==capacity) {
            wait();
        }
        aircraftStand.add(plane);
        System.out.println("Landing: "+plane);
        notifyAll();
    }
    public synchronized String onBoarding() throws InterruptedException{
        while(aircraftStand.isEmpty()){
            wait();
        }
        String plane=aircraftStand.remove(0);
        System.out.println("Onboarding: "+plane);
        notifyAll();
        return plane;
    }
}

class Incoming implements Runnable{
    private final Runway runway;
    private final int totalPlanes;

    public Incoming(Runway runway, int totalPlanes){
        this.runway=runway;
        this.totalPlanes=totalPlanes;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= totalPlanes; i++) {
                String name = "Flight-" + i;
                runway.landing(name);
                Thread.sleep(100);
            }
        }catch(InterruptedException ignored){}
    }
}
class Outgoing implements Runnable{
    private final Runway runway;
    private final int toProcess;

    public Outgoing(Runway runway, int toProcess){
        this.runway=runway;
        this.toProcess=toProcess;
    }

    @Override
    public void run(){
        try{
            for(int i = 1; i <= toProcess; i++){
                String name = runway.onBoarding();
                System.out.println("TakeOff: " + name);
                Thread.sleep(150);
            }
        }catch(InterruptedException ignored){}
    }
}

class Terminal{
    public static void main(String[] args) throws InterruptedException{
        int capacity=3;
        int totalPlanes=10;

        Runway aircraftStand = new Runway(capacity);

        Thread incoming = new Thread(new Outgoing(aircraftStand, totalPlanes),"Incoming");
        Thread outgoing = new Thread(new Incoming(aircraftStand, totalPlanes),"Outgoing");


        outgoing.start();
        incoming.start();
        outgoing.join();
        incoming.join();
        System.out.println("All planes processed. Simulation complete.");
    }
}