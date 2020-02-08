package edu.drexel.samyam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput extends Filter {

	private final String FILES_FOLDER_PATH = "src" + File.separator + "files";
	private String outputFile;

	public FileOutput(Pipe input, Pipe output, String outputFile) {
		super(input, output);
		this.outputFile = outputFile;

	}

	@Override
	protected void transform() {
		try {
			File file = new File(FILES_FOLDER_PATH + File.separator + outputFile);
			

			FileWriter writer = new FileWriter(file);

			String line;

			while ((line = (String) input.get()) != null) {
				writer.write(line + "\n");
			}
			System.out.println("\n****Output written to the given file named " + outputFile + " in the files folder**** \n");
			writer.close();
		} catch (InterruptedException | IOException e) {
			System.out.println("File not present to write.");
		}		
	}

}
