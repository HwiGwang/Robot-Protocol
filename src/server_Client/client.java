package server_Client;

import java.net.*;
import java.io.*;


public class client {

	public static void main(String[] args) {
		try {
			
		Socket s = new Socket("192.168.35.149", 54321);
		
		
		OutputStream out = s.getOutputStream();
		
		String message = "바이";
		byte[] data = message.getBytes("UTF-8");
		out.write(data);
		
	//서버로부터 데이터를 읽기 위한 입력 스트림 생성
		
		InputStream in = s.getInputStream();
		byte[] receiveData = new byte[1024];
		int byteRead = in.read(receiveData);
		
		if(byteRead != -1) {
			String receiveMessage = new String(receiveData, 0, byteRead, "UTF-8");
            System.out.println("서버로부터 받은 메시지: " + receiveMessage);
        } else {
            System.out.println("서버로부터 데이터를 읽을 수 없음.");
        }
		
		in.close();
	
		out.close();
		s.close();
		
		
	} catch(IOException e) {
		e.printStackTrace();
	}
		
	}
}
