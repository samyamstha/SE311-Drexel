package edu.drexel.samyam;

public class ConsoleOutput extends MyObserver {

	private LineStorage lineStorage;

	public ConsoleOutput(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}

	public void printLines() {
		
		if(lineStorage.getAlphabetized().isEmpty()) {
			System.out.println("\n\n***********No lines present to print!***********\n\n");
		}else {
			System.out.println("\n\n***********Printing alphabetized lines***********\n\n");

		}
		
		for (String each : lineStorage.getAlphabetized()) {
			System.out.println(each);
		}
	}

	@Override
	public void update(MyEvent event) {
		if (isMyEvent(event.getEventType(), MyEvent.PRINT_READY)) {
			printLines();
		}
	}

}
