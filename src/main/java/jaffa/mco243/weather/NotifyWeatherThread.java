package jaffa.mco243.weather;

public class NotifyWeatherThread extends Thread {

	private boolean badWeather;

	public void Run() {
		if (badWeather) {
			soundAlarm();
		}
	}

	private void soundAlarm() {

	}

}
