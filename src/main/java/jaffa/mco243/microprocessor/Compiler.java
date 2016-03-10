package jaffa.mco243.microprocessor;

public class Compiler {

	// private Scanner file;

	// private String word;

	private int index;
	private int num;
	private String hex;

	// private StringBuilder builder;
	private String[] output;

	public Compiler() {
		output = new String[256];
		index = 0;
	}

	public void execute(String ins) {
		String[] splitWord = ins.split(" ");
		String instruction = splitWord[0];
		String data = null;
		if (splitWord.length == 2) {
			data = splitWord[1];
		}

		switch (instruction) {
		case "LD":
			// builder.append(0);
			output[index++] = "0";
			num = Integer.parseInt(data);
			hex = Integer.toHexString(num).toUpperCase();
			// builder.append(hex);
			if (hex.length() == 2) {
				output[index++] = String.valueOf(hex.charAt(0));
				output[index++] = String.valueOf(hex.charAt(1));
			} else {
				output[index++] = "0";
				output[index++] = String.valueOf(hex.charAt(0));
			}
			break;
		case "ST":
			// builder.append(1);
			output[index++] = "1";
			num = Integer.parseInt(data);
			hex = Integer.toHexString(num).toUpperCase();
			// builder.append(hex);
			if (hex.length() == 2) {
				output[index++] = String.valueOf(hex.charAt(0));
				output[index++] = String.valueOf(hex.charAt(1));
			} else {
				output[index++] = "0";
				output[index++] = String.valueOf(hex.charAt(0));
			}
			break;
		case "SWP":
			// builder.append(2);
			output[index++] = "2";
			break;
		case "ADD":
			// builder.append(3);
			output[index++] = "3";
			break;
		case "INC":
			// builder.append(4);
			output[index++] = "4";
			break;
		case "DEC":
			// builder.append(5);
			output[index++] = "5";
			break;
		case "BZ":
			// builder.append(6);
			output[index++] = "6";
			num = Integer.parseInt(data);
			hex = Integer.toHexString(num).toUpperCase();
			// builder.append(hex);
			if (hex.length() == 2) {
				output[index++] = String.valueOf(hex.charAt(0));
				output[index++] = String.valueOf(hex.charAt(1));
			} else {
				output[index++] = "0";
				output[index++] = String.valueOf(hex.charAt(0));
			}
			break;
		case "BR":
			// builder.append(7);
			output[index++] = "7";
			num = Integer.parseInt(data);
			hex = Integer.toHexString(num).toUpperCase();
			// builder.append(hex);
			if (hex.length() == 2) {
				output[index++] = String.valueOf(hex.charAt(0));
				output[index++] = String.valueOf(hex.charAt(1));
			} else {
				output[index++] = "0";
				output[index++] = String.valueOf(hex.charAt(0));
			}
			break;
		case "STP":
			// builder.append(8);
			output[index++] = "8";
			break;
		case "DATA":
			String[] dataArray = data.split("");
			for (String d : dataArray) {
				output[index++] = d;
			}
			break;
		}
	}

	public void completeOutput() {
		if (index < output.length) {
			for (int i = index; i < output.length; i++) {
				output[index] = "0";
			}
		}
	}

	public String[] getOutput() {
		return output;
	}

}
