package edu.drexel.samyam;

public class ConsoleOutput extends Output {

	public ConsoleOutput(Pipe input, Pipe output) {
		super(input, output);
	}

	@Override
	protected void transform() {
		System.out.println("\n***Printing alphabetized lines*** \n");
		String line;

		try {
			while ((line = (String) input.get()) != null) {
				System.out.println(line);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
