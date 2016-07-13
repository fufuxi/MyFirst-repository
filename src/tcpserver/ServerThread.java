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
             
            ��while(!line.equals("bye")){ 
          ������������//������ַ���Ϊ "bye"����ֹͣѭ��
          ����������������pw.println(line); 
          ����������������//��ͻ���������ַ���
          ����������������pw.flush(); 
          ����������������//ˢ���������ʹClient�����յ����ַ���
          ����������������System.out.println("Server:"+line); 
          ����������������//��ϵͳ��׼����ϴ�ӡ���ַ���
          ����������������System.out.println("Client:"+ clientnum +reader.readLine());
          ����������������//��Client����һ�ַ���������ӡ����׼�����
          ����������������line=reader2.readLine(); 
          ����������������//��ϵͳ��׼�������һ�ַ���
          ������������} //����ѭ��
          ������������pw.close(); //�ر�Socket�����
          ������������reader.close(); //�ر�Socket������
          ������������socket.close(); //�ر�Socket

         } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        
	}

}
