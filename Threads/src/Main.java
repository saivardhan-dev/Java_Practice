import java.util.LinkedList;
import java.util.List;

class FileQueue{
    private final List<String> queue=new LinkedList<>();
    private final int capacity;

    public FileQueue(int capacity){
        this.capacity=capacity;
    }

    public synchronized void addFile(String fileName) throws InterruptedException{
        while(queue.size()==capacity){
            wait();
        }
        queue.add(fileName);
        System.out.println("File added: "+fileName);
        notifyAll();
    }
    public synchronized String removeFile() throws InterruptedException{
        while(queue.isEmpty()){
            wait();
        }
        String file=queue.remove(0);
        System.out.println("File removed: "+file);
        notifyAll();
        return file;
    }
}

class Producer implements Runnable{
    private final FileQueue fileQueue;
    private final int totalFiles;

    public Producer(FileQueue fileQueue, int totalFiles){
        this.fileQueue=fileQueue;
        this.totalFiles=totalFiles;
    }

    public void run(){
        try {
            for (int i = 0; i <= totalFiles; i++) {
                String name = "file=" + i;
                fileQueue.addFile(name);
                Thread.sleep(100);
            }
        }catch(InterruptedException ignored){}
    }
}
class Comsumer implements Runnable{
    private final FileQueue fileQueue;
    private final int toProcess;
    public Comsumer(FileQueue fileQueue, int toProcess){
        this.fileQueue=fileQueue;
        this.toProcess=toProcess;
    }
    public void run(){
        try{
            for(int i = 0; i < toProcess; i++){
                String file = fileQueue.removeFile();
                System.out.println("Processing: " + file);
                Thread.sleep(150);
            }
        }catch(InterruptedException ignored){}
    }
}

public class Main{
    public static void main(String[] args)throws InterruptedException{
        int capacity=3;
        int totalFiles=10;

        FileQueue queue = new FileQueue(capacity);

        Thread producer = new Thread(new Producer(queue, totalFiles),"Producer");
        Thread comsumer = new Thread(new Comsumer(queue, totalFiles),"Comsumer");

        producer.start();
        comsumer.start();
        producer.join();
        comsumer.join();
    }
}