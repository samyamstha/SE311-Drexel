package edu.drexel.samyam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UpperCaseConverter extends Filter {

	private final String FILES_FOLDER_PATH = "src" + File.separator + "edu" + File.separator + "drexel" + File.separator
			+ "samyam";

	public UpperCaseConverter(Pipe input_, Pipe output_) {
		super(input_, output_);
	}

	@Override
	protected void transform() {
		try {
			String line;
			File file = new File(FILES_FOLDER_PATH + File.separator + "output.txt");

			FileWriter writer = new FileWriter(file);

			while ((line = (String) input_.get()) != null) {
				System.out.println(line.toUpperCase());
				writer.write(line.toUpperCase() + "\n");
			}
			System.out.println("\n****Output written to the file named output.txt in the project folder**** \n");

			writer.close();

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}
	}

}
