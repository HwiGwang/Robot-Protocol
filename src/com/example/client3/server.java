package com.example.client3;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.logging.Logger;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

public class server {
    private final static Logger LOGGER = Logger.getLogger(server.class.getName());

    public static void main(String[] args) {
        ServerSocket serverSocket_1st = null;

        try {
            serverSocket_1st = new ServerSocket(9000);
            LOGGER.info("클라이언트 연결 대기 중...");
            
            //새로운 포트를 열고 클라이언트 연결 대기중
            ServerSocket serverSocket_2nd = new ServerSocket(9001); 
            LOGGER.info("추가 포트 " + 9001 + " 대기 중...");

            // Timer를 사용하여 주기적으로 좌표값을 클라이언트로 보냅니다.
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    secondClient(serverSocket_2nd);
                }
            }, 0, 500); // 0초부터 시작하여 0.5초 간격으로 실행
            

            while (true) {
                Socket clientSocket = serverSocket_1st.accept();
                LOGGER.info("클라이언트 연결됨");	

                // 클라이언트로부터 데이터를 바이트 배열로 직접 읽기
                InputStream in = clientSocket.getInputStream();
                byte[] receivedDataBytes = new byte[300];  // 클라이언트에서 보낸 것과 동일한 크기로 설정
                int readBytes = in.read(receivedDataBytes);

                if (readBytes > 0) {
                    LOGGER.info("데이터 읽기 시도");

                    // 수신된 데이터를 처리합니다. 예: ByteBuffer로 감싸서 데이터 추출
                    ByteBuffer buffer = ByteBuffer.wrap(receivedDataBytes);
                    buffer.order(ByteOrder.LITTLE_ENDIAN);
                    
                    // 데이터 추출 예시
                    byte mainCommandType = buffer.get();
                    byte subCommandType = buffer.get();
                    // ... 추가 데이터 추출 ...
                    
                    if(mainCommandType >= 0x00 && mainCommandType <= 0x02) {
                        Make_Jog receivedData = new Make_Jog(receivedDataBytes);
                        Make_JogData.Make_Jog_Command(receivedData);
                    } else if (mainCommandType == 0x03) {
                        Make_Joint receivedData = new Make_Joint(receivedDataBytes);
                        Make_JointData.Make_Joint_Command(receivedData);
                    } else {
                        LOGGER.warning("Unknown mainCommandType: " + mainCommandType);
                        // Handle unknown command type
                    }
                  
                }

                // 클라이언트 소켓 닫기
                closeSocket(clientSocket);
            }

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "오류 발생", e);
        } finally {
            closeSocket(serverSocket_1st);
        }
    }
    
    private static void secondClient(ServerSocket serverSocket_2nd) {
    	try {
    		Socket clientSocket = serverSocket_2nd.accept();
            LOGGER.info("추가 포트 " + serverSocket_2nd.getLocalPort() + "에서 클라이언트 연결됨");
            
            
            
            closeSocket(clientSocket);


    	}catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "오류 발생", e);
        }
    }

    private static void closeSocket(Socket socket) {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void closeSocket(ServerSocket serverSocket) {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}