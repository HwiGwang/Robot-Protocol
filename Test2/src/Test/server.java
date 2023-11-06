package Test;

import java.net.*;
import java.io.*;

public class server {

	public static void main(String[] args) throws IOException {
		Socket s = null;
		ServerSocket aaa = null;
		
		try(ServerSocket serverSocket = aaa = new ServerSocket(4321)) {
			System.out.println("클라이언트와의 연결을 대기중");
			
			s = aaa.accept();
			System.out.println("서버 접속");
		
		
		
			InputStream in = s.getInputStream();
			byte[] data = new byte[1024];
			int byteRead = in.read(data);
		
			if(byteRead != -1) {
				String message = new String(data, 0, byteRead, "UTF-8");
				System.out.println("클라이언트로 부터 받은 메세지 : "+message);
			
			
			//클라이언트에 전송할 데이터
				OutputStream out = s.getOutputStream();
				String responseMessage = "뭐가문제냐";
				byte[] responseData = responseMessage.getBytes("UTF-8");
				out.write(responseData);

				out.close();
			} else {
             System.out.println("클라이언트로부터 데이터를 읽을 수 없음.");
         }
			in.close();
			s.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
		
}