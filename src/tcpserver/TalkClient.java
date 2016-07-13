package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TalkClient {
  public static void main(String[] args) {
	try {
		Socket socket = new Socket("127.0.0.1",8888);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
	    String readline;
	     
	    readline = reader.readLine();
	    
	    while(!readline.equalsIgnoreCase("bye")){
	    	pw.println(readline);
	    	
	    	pw.flush();
	    	
	    	System.out.println("Client: " + readline);
	    	
	    	System.out.println("Server: " + reader2.readLine());
	    	
	    	readline = reader.readLine();
	    }
	    pw.close();
	    reader2.close();
	    socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
