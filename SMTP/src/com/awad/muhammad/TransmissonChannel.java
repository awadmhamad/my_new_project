package com.awad.muhammad;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.ServerSocket;
import java.net.Socket;

public class TransmissonChannel implements Runnable{
	
	private int port=110;
	ServerSocket serverSocket;
	Socket clientSocket;
	public TransmissonChannel() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		
		try {
			serverSocket=new ServerSocket(port);
			clientSocket=new Socket();
			serverSocket.accept();
			Class<? extends ServerSocket> c=serverSocket.getClass();
			Field f=c.getField("");
			f.set(serverSocket,15);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
