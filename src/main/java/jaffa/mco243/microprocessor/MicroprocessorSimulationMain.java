package jaffa.mco243.microprocessor;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MicroprocessorSimulationMain {

	public static void main(String[] args) throws FileNotFoundException {
		try {
			MicroprocessorSimulation ms = new MicroprocessorSimulation(
					"mach.in");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
