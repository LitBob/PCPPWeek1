package exercises01;
import java.util.concurrent.*;
import java.util.concurrent.locks.ReentrantLock;
public class PrintDasher {

    public static void main(String[] args) {
    new PrintDasher();
    }

    Printer p = new Printer();
    int counts = 10_000;
	private final ReentrantLock lock = new ReentrantLock();
    
    public PrintDasher() {

        Thread t1 = new Thread(() -> {
            for (int i=0; i<counts; i++) 
                p.print();
        });
        Thread t2 = new Thread(() -> {
            for (int i=0; i<counts; i++) 
                p.print();
        });
        t1.start(); t2.start();
        try { t1.join(); t2.join(); }
        catch (InterruptedException exn) { 
            System.out.println("Some thread was interrupted");
        }
    }

    class Printer {
        public void print() {
        lock.lock();
        System.out.print("-");
        //try { Thread.sleep(50); } catch (InterruptedException exn) { }
        System.out.print("|");
        lock.unlock();
        }
    }

    
}
