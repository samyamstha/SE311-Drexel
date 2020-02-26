package edu.drexel.samyam;

public class ConsoleOutput extends Output {

	public ConsoleOutput(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}

	@Override
	public void printLines() {
		System.out.println("\n***Printing alphabetized lines*** \n");
		for (String each : lineStorage.getLines()) {
			System.out.println(each);
		}
	}

}
