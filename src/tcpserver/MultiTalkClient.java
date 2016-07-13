package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MultiTalkClient {
	public static void main(String[] args) {
		try {
			Socket socket = new Socket("127.0.0.1", 8080);
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			
			PrintWriter pw = new PrintWriter(socket.getOutputStream());
			
			BufferedReader reader2  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			String line ;
			line = reader.readLine();
			while(!line.equalsIgnoreCase("bye")){
				
				pw.write(line);

				pw.flush();
				
				System.out.println("client: " + line);
				
				System.out.println("server: " + reader2.readLine());
				
				line = reader.readLine();
				
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
