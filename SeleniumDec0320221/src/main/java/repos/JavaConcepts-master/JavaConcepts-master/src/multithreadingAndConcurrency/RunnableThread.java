/*Threads, Multithreading and Concurrency*/
package multithreadingAndConcurrency;

public class RunnableThread implements Runnable {

	@Override
	public void run() {
		System.out.println(
				"This is inside the first new thread created by a class which implements the Runnable interface.");
	}

}
