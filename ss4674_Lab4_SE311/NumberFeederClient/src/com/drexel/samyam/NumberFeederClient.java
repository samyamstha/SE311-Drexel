package com.drexel.samyam;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberFeederClient {

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {

//		int inputSize = 0;
		ArrayList<Integer> numbersList = new ArrayList<Integer>();
		Scanner scan = new Scanner(System.in);
		Socket socket = new Socket("localhost", 3000);

//		System.out.println("How many numbers do you want to enter?");
//		inputSize = Integer.valueOf(scan.nextLine().trim());

		ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		
		boolean valid = true;
		String input;
		
		
		System.out.println("Please provide integer input.\nEnter 'q' when done inputting the integers.");
		do {
			System.out.println("Enter input: ");

			input = scan.nextLine().trim();
			if (input.equals("q")) {
				valid = false;
			} else {
				try {
					numbersList.add(Integer.valueOf(input));
				} catch (NumberFormatException | InputMismatchException nfe) {
					System.out.println("Entered the non-integer input, so avoiding it..");
				}
			}

		} while (valid);

		objectOutputStream.writeObject(numbersList);

		ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
		ArrayList<Integer> oddNumberList = (ArrayList<Integer>) inputStream.readObject();

		printList(oddNumberList);

		scan.close();
		socket.close();

	}

	private static void printList(ArrayList<Integer> numberList) {
		System.out.println("\n\nTotal odd numbers in the list: " + numberList.size());
		System.out.println("\nElements in the list: ");
		for (Integer number : numberList) {
			System.out.println(number);
		}
	}

}
