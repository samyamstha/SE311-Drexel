package edu.drexel.samyam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput extends Output {

	private final String FILES_FOLDER_PATH = "src" + File.separator + "files";

	public FileOutput(Pipe input, Pipe output) {
		super(input, output);
	}

	@Override
	protected void transform() {
		try {
			File file = new File(FILES_FOLDER_PATH + File.separator + "output.txt");
			

			FileWriter writer = new FileWriter(file);

			String line;

			while ((line = (String) input.get()) != null) {
				writer.write(line + "\n");
			}
			System.out.println("\n****Output written to the file named output.txt in the files folder**** \n");
			writer.close();
		} catch (InterruptedException | IOException e) {
			System.out.println("File not present to write.");
		}		
	}

}
