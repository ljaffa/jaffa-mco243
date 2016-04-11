package jaffa.mco243.deadlock;

import java.util.logging.Logger;

public class Philosopher extends Thread {

	private static final Logger LOG = Logger.getLogger(Philosopher.class
			.getName());
	private Fork f1;
	private Fork f2;
	private String name;
	private Waiter waiter;

	public Philosopher(String name, Fork f1, Fork f2, Waiter waiter) {
		this.name = name;
		this.f1 = f1;
		this.f2 = f2;
		this.waiter = waiter;
	}

	@Override
	public void run() {
		while (true) {
			think();
			eat();
		}
	}

	private void think() {
		waitForAFewSeconds(5);
	}

	private void eat() {
		LOG.info(this.toString() + " trying to eat");
		if (waiter.tryToEat(f1, f2)) {
			waitForAFewSeconds(10);
			LOG.info(this.toString() + " done eating");
			f1.setInUse(false);
			f2.setInUse(false);
		}
	}

	private void waitForAFewSeconds(int seconds) {
		try {
			Thread.sleep((long) seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "Philosopher [name=" + name + "]";
	}

}
