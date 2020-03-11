package com.drexel.samyam;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

	public static void main(String[] args) throws IOException {
		ArrayList<String> expressions = new ArrayList<String>();
		ServerSocket server = new ServerSocket(3000);

		while (true) {
			Socket client = server.accept();

			RequestHandler handler = new RequestHandler(client, expressions);
			handler.start();
		}
	}

}
