package edu.drexel.samyam;

import java.util.Scanner;

public class InteractiveInput extends MyObservable {

	private LineStorage lineStorage;
	private ConsoleInput input;
	private ConsoleOutput consoleOutput;
	private Alphabetize alphabetize;

	public InteractiveInput(LineStorage lineStorage, ConsoleInput input, Alphabetize alphabetize,
			ConsoleOutput consoleOutput) {
		this.lineStorage = lineStorage;
		this.input = input;
		this.alphabetize = alphabetize;
		this.consoleOutput = consoleOutput;
		setupObservers();
	}

	private void setupObservers() {
		attach(new RemoveLineObserver());
		attach(new AddLineObserver());
		attach(alphabetize);
		attach(consoleOutput);
	}

	public void getInput() {
		System.out.println("Welcome to the interactive input console.");

		while (true) {
			printInfo();

			char userChoice = input.getLineInput().charAt(0);

			System.out.println("You have selected option: " + userChoice);
			performSelectedAction(userChoice);

		}

	}

	private void performSelectedAction(char userChoice) {
		if (userChoice == 'a') {
			String line = input.getLineInput();

			processEvent(new MyEvent(line, MyEvent.LINE_ADDED));

		} else if (userChoice == 'd') {
			System.out.println("Please enter the number for the line do you want to remove:");

			if (lineStorage.getLines().size() < 1) {
				System.out.println("\n\n***********No lines present to delete!***********\n\n");
				
			} else {
				for (int i = 0; i < lineStorage.getLines().size(); i++) {
					System.out.println(i + ".    " + lineStorage.getLines().get(i));
				}
				int lineIndex;
				do {
					System.out.println("\nPlease make sure to enter a valid input");
					lineIndex = input.getIntInput();
				} while (!(lineIndex >= 0 && lineIndex < lineStorage.getLines().size()));

				processEvent(new MyEvent(lineIndex, MyEvent.LINE_REMOVED));
			}

		} else if (userChoice == 'p') {
			processEvent(new MyEvent(null, MyEvent.ALBHABETIZE));
			processEvent(new MyEvent(null, MyEvent.PRINT_READY));

		} else {
			System.out.println("Quiting the program.");
			System.exit(0);
		}
	}

	private void printInfo() {
		System.out.println("\n\nPlease select an action from the following to execute.");
		System.out.println("Enter 'a' to add a new line.");
		System.out.println("Enter 'd' to delete a new line.");
		System.out.println("Enter 'p' to print circuarly shifted and then alphabetically sorted lines.");
		System.out.println("Enter 'q' or anything else to quit the system.\n\n");
	}

	private void processEvent(MyEvent event) {
		notifyAllObservers(event);
	}

	private class RemoveLineObserver extends MyObserver {

		@Override
		public void update(MyEvent event) {
			if (isMyEvent(event.getEventType(), MyEvent.LINE_REMOVED)) {
				lineStorage.removeLine(event.getLineIndex());
			}
		}
	}

	private class AddLineObserver extends MyObserver {

		@Override
		public void update(MyEvent event) {
			if (isMyEvent(event.getEventType(), MyEvent.LINE_ADDED)) {
				lineStorage.addLine(event.getLine());
			}
		}
	}

}
