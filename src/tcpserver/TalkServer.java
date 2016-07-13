package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TalkServer {
  public static void main(String[] args) {
	try {
		ServerSocket server = new ServerSocket(8888);
		Socket socket = server.accept();
		
		String line;
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
    	PrintWriter pw = new PrintWriter(socket.getOutputStream());
		
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Client: " + reader.readLine());
		
		line = reader2.readLine();
		while(!line.equalsIgnoreCase("bye")){
			pw.println(line);
			
			pw.flush();
			
			System.out.println("Server: " + reader2.readLine());
			
			System.out.println("Client: " + reader.readLine());
			
			line = reader2.readLine();
			
		}
		pw.close();
		reader.close();
		socket.close();
		server.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
