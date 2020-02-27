package com.drexel.samyam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class OddFinderServer {

	public static void main(String[] args) throws IOException {

		ServerSocket server = new ServerSocket(3000);

		while (true) {
			Socket client = server.accept();

			RequestHandler handler = new RequestHandler(client);
			handler.start();
		}
	}

}
