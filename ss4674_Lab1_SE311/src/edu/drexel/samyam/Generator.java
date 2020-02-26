package edu.drexel.samyam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class Generator extends Filter{

	public Generator(Pipe input_, Pipe output_) {
		super(input_, output_);
	}


	private final String FILES_FOLDER_PATH = "src" + File.separator + "edu" + File.separator + "drexel" + File.separator + "samyam";

	
	public void readFile() {
		BufferedReader reader;
		File file;
		String line;
		Scanner scan = new Scanner(System.in);
		boolean valid = false;
		
		while(!valid) {
		System.out.println("Please enter the name of the file for input");
		String fileName = scan.nextLine().trim();
		
		try {
			
			if(fileName == "") {
				throw new IOException();
			}
			
			file = new File(FILES_FOLDER_PATH + File.separator +fileName);
			
//			set file permissions
			file.setExecutable(true); 
            file.setReadable(true); 
            file.setWritable(true); 
            
			FileReader freader = new FileReader(file);
			reader = new BufferedReader(freader);
			
			while ((line = reader.readLine()) != null){
				input_.put(line);
				
			}
			input_.put(null);
			valid = true;
			
		} catch (IOException e) {
//			e.printStackTrace();
			System.out.println("\nFile not found!\n");
		}
		}
		scan.close();

	}


	@Override
	protected void transform() {
		readFile();
		
	}
}
