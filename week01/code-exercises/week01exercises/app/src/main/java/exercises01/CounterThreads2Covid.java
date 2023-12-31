// For week 1
// raup@itu.dk * 2021-08-27
package exercises01;

import java.util.concurrent.locks.ReentrantLock;

public class CounterThreads2Covid {

    long counter = 0;
    final long PEOPLE  = 10_000;
    final long MAX_PEOPLE_COVID = 15_000;
	private final ReentrantLock lock = new ReentrantLock();

    public CounterThreads2Covid() {
	try {
	    Turnstile turnstile1 = new Turnstile();
	    Turnstile turnstile2 = new Turnstile();

	    turnstile1.start();turnstile2.start();
	    turnstile1.join();turnstile2.join();

	    System.out.println(counter+" people entered");
	}
	catch (InterruptedException e) {
	    System.out.println("Error " + e.getMessage());
	    e.printStackTrace();
	}
    }

    public static void main(String[] args) {
	new CounterThreads2Covid();
    }


    public class Turnstile extends Thread {
	public void run() {
	    for (int i = 0; i < PEOPLE; i++) {
			lock.lock();
			if(counter < MAX_PEOPLE_COVID) //don't let people in
				counter++;
			/* 
				To optimize performance maybe make a stop in an "else" like
			else {
				i = PEOPLE
			}
			*/ 
			lock.unlock();
	    }	    
	}
    }
}
