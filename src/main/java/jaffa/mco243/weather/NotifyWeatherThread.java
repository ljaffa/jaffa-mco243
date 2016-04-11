package jaffa.mco243.weather;

import java.util.concurrent.LinkedBlockingQueue;

public class NotifyWeatherThread extends Thread {

	private volatile String badWeather; // one copy
	private LinkedBlockingQueue<String> queue;

	public NotifyWeatherThread(LinkedBlockingQueue<String> queue) {
		this.queue = queue;
	}

	public void Run() {
		while (true) {
			String message;
			try {
				message = queue.take(); // will block if there's nothing there
				soundAlarm(message);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public String isBadWeather() {
		return badWeather;
	}

	public void setBadWeather(String badWeather) {
		this.badWeather = badWeather;
	}

	private void soundAlarm(String message) {
		for (int i = 0; i < 1000000; i++) {
			// do an action like sending an email....
		}
	}

}
