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
	private ArrayList<Integer> oddNumberList;
	ArrayList<Integer> numbers;

	public RequestHandler(Socket client) {
		this.client = client;
		this.oddNumberList = new ArrayList<Integer>();
	}

	public void run() {
		try {
			ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());

			numbers = (ArrayList<Integer>) objectInputStream.readObject();

			for (Integer number : numbers) {
				if (number.intValue() % 2 != 0) {
					oddNumberList.add(number);
				}
			}

			OutputStream outputStream = client.getOutputStream();
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(oddNumberList);

		} catch (IOException | ClassNotFoundException e) {
//			e.printStackTrace();
		}
	}

}
