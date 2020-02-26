package edu.drexel.samyam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutput extends Output {

	private final String FILES_FOLDER_PATH = "src" + File.separator + "files";

	public FileOutput(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}

	@Override
	public void printLines() {

		try {
			File file = new File(FILES_FOLDER_PATH + File.separator + "output.txt");
			

			FileWriter writer = new FileWriter(file);
			for (String each : lineStorage.getLines()) {
				writer.write(each + "\n");
			}
			System.out.println("\n****Output written to the file named output.txt in the files folder**** \n");
			writer.close();
		} catch (IOException e) {
			System.out.println("File not present to write.");
//			e.printStackTrace();
		}

	}

}
