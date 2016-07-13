package tcpserver;

import java.io.IOException;
import java.net.ServerSocket;

public class MultiTalkServer {
   static int clientnum = 0;
   
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       ServerSocket serverSocket = null;
       
       boolean listening = true;
       
       try {
		serverSocket = new ServerSocket(8080);
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		System.out.println("Could not listen on port:8080");
		System.exit(-1);
	}
       while(listening){
    	   new ServerThread(serverSocket.accept(),clientnum).start;
       }
       
	}

}
