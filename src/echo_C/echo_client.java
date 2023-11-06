package echo_C;

import java.io.*;
import java.net.*;

public class echo_client {
    public static void main(String[] args) {
        String serverIP = "220.66.115.51";
        int serverPort = 8000;

        try {
            Socket socket = new Socket(serverIP, serverPort);

            // 출력 스트림 얻기
            OutputStream out = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(out, true);
            // 입력 스트림 얻기
            InputStream in = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));

            // 보낼 메시지
            String message = "Hellow";

            // 메시지 서버로 보내기
            writer.println(message);
            // 서버로부터 응답 받기
            String response = reader.readLine();
            // 응답 출력
            System.out.println("서버로부터 받은 응답: " + response);

            // 소켓 닫기
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



