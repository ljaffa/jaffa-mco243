package jaffa.mco243.deadlock;

public class Fork {

	private int number;

	public Fork(int number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "Fork [number=" + number + "]";
	}

}
