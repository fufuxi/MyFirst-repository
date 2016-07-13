package tcpserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    Socket socket = null;
    int clientnum;
    
	public ServerThread(Socket socket, int num) {
		this.socket = socket;
		this.clientnum = num++;
	}

	public void run() {
		// TODO Auto-generated method stub
         String line;
         try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
			 PrintWriter pw = new PrintWriter(socket.getOutputStream());
	         
	         BufferedReader reader2 = new BufferedReader(new InputStreamReader(System.in));
        
             System.out.println("Client:" +clientnum + reader.readLine());
             
             line = reader.readLine();
             
            　while(!line.equals("bye")){ 
          　　　　　　//如果该字符串为 "bye"，则停止循环
          　　　　　　　　pw.println(line); 
          　　　　　　　　//向客户端输出该字符串
          　　　　　　　　pw.flush(); 
          　　　　　　　　//刷新输出流，使Client马上收到该字符串
          　　　　　　　　System.out.println("Server:"+line); 
          　　　　　　　　//在系统标准输出上打印该字符串
          　　　　　　　　System.out.println("Client:"+ clientnum +reader.readLine());
          　　　　　　　　//从Client读入一字符串，并打印到标准输出上
          　　　　　　　　line=reader2.readLine(); 
          　　　　　　　　//从系统标准输入读入一字符串
          　　　　　　} //继续循环
          　　　　　　pw.close(); //关闭Socket输出流
          　　　　　　reader.close(); //关闭Socket输入流
          　　　　　　socket.close(); //关闭Socket

         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        
	}

}
