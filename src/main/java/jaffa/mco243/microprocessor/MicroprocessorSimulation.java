package jaffa.mco243.microprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MicroprocessorSimulation {

	private char[] memory;
	private String line;

	private char character;
	private int accumulatorA;
	private int accumulatorB;
	private int location;

	private String hex;
	private int dec;

	public MicroprocessorSimulation(String fileName) throws IOException {
		memory = new char[256];
		BufferedReader reader = new BufferedReader(new FileReader(fileName));

		while ((line = reader.readLine()) != null) {
			execute(line.toCharArray());
		}
	}

	public void execute(char[] memory) {
		accumulatorA = 0;
		accumulatorB = 0;

		for (int i = 0; i < memory.length; i++) {
			character = memory[i];

			switch (character) {
			case '0':
				hex = String.valueOf(memory[i + 1]).toUpperCase()
						+ String.valueOf(memory[i + 2]).toUpperCase();
				dec = Integer.parseInt(hex, 16);
				location = dec;
				accumulatorA = Integer.parseInt(String
						.valueOf(memory[location]).toUpperCase(), 16);
				i += 2;
				break;
			case '1':
				hex = String.valueOf(memory[i + 1]).toUpperCase()
						+ String.valueOf(memory[i + 2]).toUpperCase();
				dec = Integer.parseInt(hex, 16);
				location = dec;
				String hex2 = Integer.toHexString(accumulatorA).toUpperCase();
				memory[location] = hex2.charAt(0);
				i += 2;
				break;
			case '2':
				int temp = accumulatorA;
				accumulatorA = accumulatorB;
				accumulatorB = temp;
				break;
			case '3':
				int sum = accumulatorA + accumulatorB;
				String hex = Integer.toHexString(sum);
				accumulatorB = sum / 16;
				accumulatorA = sum - accumulatorB * 16;
				break;
			case '4':
				if (accumulatorA <= 14) {
					accumulatorA++;
				} else {
					accumulatorA = 0;
				}
				break;
			case '5':
				if (accumulatorA > 0) {
					accumulatorA--;
				} else {
					accumulatorA = 15;
				}
				break;
			case '6':
				if (accumulatorA == 0) {
					hex = String.valueOf(memory[i + 1]).toUpperCase()
							+ String.valueOf(memory[i + 2]).toUpperCase();
					dec = Integer.parseInt(hex, 16);
					location = dec;
					i = --location;
					continue;
				} else {
					i += 2;
					break;
				}
			case '7':
				hex = String.valueOf(memory[i + 1]).toUpperCase()
						+ String.valueOf(memory[i + 2]).toUpperCase();
				dec = Integer.parseInt(hex, 16);
				location = dec;
				i = --location;
				continue;
			case '8':
				for (int j = 0; j < memory.length; j++) {
					System.out.print(memory[j]);
				}
				System.out.println();
				i = memory.length;
				break;
			}
		}
		return;
	}
}