package edu.drexel.samyam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class FileInput extends Input {

	private Scanner scan;
	private final String FILES_FOLDER_PATH = "src" + File.separator + "files";

	public FileInput(Pipe input, Pipe output) {
		super(input, output);
		scan = new Scanner(System.in);
	}


	@Override
	protected void transform() {
		BufferedReader reader;
		File file;
		String line;
		boolean valid = false;

		while (!valid) {

			try {
				System.out.println("Please enter the name of the file for input");
				String fileName = scan.nextLine();
				file = new File(FILES_FOLDER_PATH + File.separator + fileName);

				if (!file.exists()) {
					throw new IOException();
				}

				// set file permissions
				file.setExecutable(true);
				file.setReadable(true);
				file.setWritable(true);

				FileReader freader = new FileReader(file);
				reader = new BufferedReader(freader);

				while ((line = reader.readLine()) != null) {
					
					output.put(line.replaceAll("\\p{Punct}", ""));
				
				}
				output.put(null);
				valid = true;

			} catch (IOException e) {
				// e.printStackTrace();
				System.out.println("File not found!");
			}
		}
	}
}
