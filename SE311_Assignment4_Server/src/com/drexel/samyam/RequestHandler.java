package com.drexel.samyam;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class RequestHandler extends Thread {

	private Socket client;
	private String expression;
	ArrayList<String> expressions;

	public RequestHandler(Socket client, ArrayList<String> expressions) {
		this.client = client;
		this.expressions = expressions;
	}

	public void run() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());

			expression = (String) objectInputStream.readObject();

			expressions.add(expression);

			System.out
					.println("The total number of successful calculated math" + " equations is " + expressions.size());

			System.out.println("Displaying the list of all the equations:");
			for (String expression : expressions) {
				System.out.println(expression);
			}


		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error occured in Server!");
		}
	}

}
