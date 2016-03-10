package jaffa.mco243.microprocessor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CompilerMain {

	public static void main(String[] args) {

		try {
			// BufferedReader reader = new BufferedReader(new
			// InputStreamReader(System.in));
			BufferedReader reader = new BufferedReader(new FileReader(
					"assemblyLanguage.txt"));

			Compiler compiler = new Compiler();
			String instruction;

			while ((instruction = reader.readLine()) != null) {
				compiler.execute(instruction);
			}
			reader.close();
			compiler.completeOutput();

			for (String word : compiler.getOutput()) {
				System.out.print(word);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
