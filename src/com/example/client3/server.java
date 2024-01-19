package com.example.client3;

import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class server {
    private final static Logger LOGGER = Logger.getLogger(server.class.getName());
    
    public static void main(String[] args) {
        ServerSocket serverSocket_1st = null;
        ServerSocket serverSocket_2nd = null;

        try {
        	serverSocket_1st = new ServerSocket(9999);
            LOGGER.info("클라이언트 연결 대기 중...");

            // 새로운 포트를 열고 클라이언트 연결 대기중
            final ServerSocket finalServerSocket_2nd = new ServerSocket(8888);
            serverSocket_2nd = finalServerSocket_2nd;
            LOGGER.info("추가 포트 " + 8030 + " 대기 중...");
            Robo_Position robo_Position = new Robo_Position(); // 초기화

            // Timer를 사용하여 주기적으로 좌표값을 클라이언트로 보냅니다.
            Timer timer = new Timer();
            timer.scheduleAtFixedRate(new TimerTask() {
                @Override
                public void run() {
                    secondServer(finalServerSocket_2nd, true, robo_Position);
                    secondServer(finalServerSocket_2nd, false, robo_Position);
                }
            }, 0, 500);

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

                    if (mainCommandType >= 0x00 && mainCommandType <= 0x02) {
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
                clientSocket.close();  // 클라이언트 소켓 닫으면 안 됨
                // 클라이언트 소켓 닫기
            }

        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "오류 발생", e);
        } finally {
            closeSocket(serverSocket_1st);
            closeSocket(serverSocket_2nd);
        }
    }

private static void secondServer(ServerSocket serverSocket_2nd, boolean send0x9C, Robo_Position robo_Position) {
    try {
        Socket clientSocket = serverSocket_2nd.accept();
        LOGGER.info("추가 포트 " + serverSocket_2nd.getLocalPort() + "에서 클라이언트 연결됨");

        byte mainCommandType;
        byte subCommandType;
        byte data;
        float joint1;
        float joint2;
        float joint3;
        float joint4;
        float global_x;
        float global_y;
        float global_z;
        float global_Rx;
        float global_Ry;
        float global_Rz;
        float local_x;
        float local_y;
        float local_z;
        float local_Rx;
        float local_Ry;
        float local_Rz;
        float user_x;
        float user_y;
        float user_z;
        float user_Rx;
        float user_Ry;
        float user_Rz;
        
        float DigitalOut;

        if (send0x9C) {
            // mainCommandType 0x9C에 대한 데이터 설정
            mainCommandType = (byte) 0x9C;
            subCommandType = (byte) 0x01;
            data = (byte) 0x01;

            // mainCommandType 0x9C 또는 0x9D에 대한 데이터 설정
            ByteBuffer buffer = ByteBuffer.allocate(4);
            buffer.order(ByteOrder.LITTLE_ENDIAN);
            buffer.put(mainCommandType);
            buffer.put(subCommandType);
            buffer.put(data);
            buffer.put((byte) 0x00); // 예약된 바이트

            // 클라이언트에게 바이트 배열 전송
            OutputStream out = clientSocket.getOutputStream();

            // 소켓이 닫혀 있는지 확인 후 전송
            if (!clientSocket.isClosed()) {
                out.write(buffer.array());
                out.flush();
                LOGGER.info("클라이언트로 값 전송: " +
                        "mainCommandType=" + mainCommandType +
                        ", subCommandType=" + subCommandType +
                        ", data=" + data);
            }

            // 클라이언트 소켓 닫기
            closeSocket(clientSocket);
        } else {
            // mainCommandType 0x9D에 대한 데이터 설정
            mainCommandType = (byte) 0x9D;
            DigitalOut = 0.0f;

            joint1 = robo_Position.joint1;
            joint2 = robo_Position.joint2;
            joint3 = robo_Position.joint3;
            joint4 = robo_Position.joint4;
            
            global_x = robo_Position.global_x;
            global_y = robo_Position.global_y;
            global_z = robo_Position.global_z;
            global_Rx = robo_Position.global_Rx;
            global_Ry = robo_Position.global_Ry;
            global_Rz = robo_Position.global_Rz;
            
         // Update local values
            local_x = robo_Position.local_x;
            local_y = robo_Position.local_y;
            local_z = robo_Position.local_z;
            local_Rx = robo_Position.local_Rx;
            local_Ry = robo_Position.local_Ry;
            local_Rz = robo_Position.local_Rz;

            // Update user values
            user_x = robo_Position.user_x;
            user_y = robo_Position.user_y;
            user_z = robo_Position.user_z;
            user_Rx = robo_Position.user_Rx;
            user_Ry = robo_Position.user_Ry;
            user_Rz = robo_Position.user_Rz;

            
         // 반복문을 사용하여 subCommandType를 0x00부터 0x03까지 순차적으로 설정
            for (subCommandType = 0x00; subCommandType <= 0x03; subCommandType++) {
            	if(subCommandType == 0x00) {
                    // ByteBuffer를 사용하여 바이트 배열로 변환
                    ByteBuffer buffer = ByteBuffer.allocate(23);
                    buffer.order(ByteOrder.LITTLE_ENDIAN);

                    // robo_Position의 값을 sendBuffer에 넣어주기
                    buffer.put(mainCommandType);
                    buffer.put(subCommandType);
                    buffer.putFloat(joint1);
                    buffer.putFloat(joint2);
                    buffer.putFloat(joint3);
                    buffer.putFloat(joint4);
                    buffer.putFloat(DigitalOut); // DigitalOut 값이 필요한 경우에 넣어주세요.
                    buffer.put((byte) 0x00); // 예약된 바이트
                    

                    OutputStream out = clientSocket.getOutputStream();

                    // 소켓이 닫혀 있는지 확인 후 전송
                    if (!clientSocket.isClosed()) {
                        out.write(buffer.array());
                        out.flush();
                        LOGGER.info("클라이언트로 값 전송: " +
                                "mainCommandType=" + mainCommandType +
                                ", subCommandType=" + subCommandType +
                                ", joint1=" + joint1 +
                                ", joint2=" + joint2 +
                                ", joint3=" + joint3 +
                                ", joint4=" + joint4);
            	}
                    
            }else if(subCommandType == 0x01) {
                // ByteBuffer를 사용하여 바이트 배열로 변환
                ByteBuffer buffer = ByteBuffer.allocate(31);
                buffer.order(ByteOrder.LITTLE_ENDIAN);
                
                // robo_Position의 값을 sendBuffer에 넣어주기
                buffer.put(mainCommandType);
                buffer.put(subCommandType);
                buffer.putFloat(global_x);
                buffer.putFloat(global_y);
                buffer.putFloat(global_z);
                buffer.putFloat(global_Rx);
                buffer.putFloat(global_Ry);
                buffer.putFloat(global_Rz);;
                buffer.putFloat(DigitalOut); // DigitalOut 값이 필요한 경우에 넣어주세요.
                buffer.put((byte) 0x00); // 예약된 바이트
                
                OutputStream out = clientSocket.getOutputStream();

                // 소켓이 닫혀 있는지 확인 후 전송
                if (!clientSocket.isClosed()) {
                    out.write(buffer.array());
                    out.flush();
                    LOGGER.info("클라이언트로 값 전송: " +
                            "mainCommandType=" + mainCommandType +
                            ", subCommandType=" + subCommandType +
                            ", global_x=" + global_x +
                            ", global_y=" + global_y +
                            ", global_z=" + global_z +
                            ", global_Rx=" + global_Rx +
                            ", global_Ry=" + global_Ry +
                            ", global_Rz=" + global_Rz);
                }
                
            }else if(subCommandType == 0x02) {
                ByteBuffer buffer = ByteBuffer.allocate(31);
                buffer.order(ByteOrder.LITTLE_ENDIAN);

                // robo_Position의 값을 sendBuffer에 넣어주기
                buffer.put(mainCommandType);
                buffer.put(subCommandType);
                buffer.putFloat(local_x);
                buffer.putFloat(local_y);
                buffer.putFloat(local_z);
                buffer.putFloat(local_Rx);
                buffer.putFloat(local_Ry);
                buffer.putFloat(local_Rz);
                buffer.putFloat(DigitalOut); // DigitalOut 값이 필요한 경우에 넣어주세요.
                buffer.put((byte) 0x00); // 예약된 바이트

                OutputStream out = clientSocket.getOutputStream();

                // 소켓이 닫혀 있는지 확인 후 전송
                if (!clientSocket.isClosed()) {
                    out.write(buffer.array());
                    out.flush();
                    LOGGER.info("클라이언트로 값 전송: " +
                            "mainCommandType=" + mainCommandType +
                            ", subCommandType=" + subCommandType +
                            ", local_x=" + local_x +
                            ", local_y=" + local_y +
                            ", local_z=" + local_z +
                            ", local_Rx=" + local_Rx +
                            ", local_Ry=" + local_Ry +
                            ", local_Rz=" + local_Rz);
                }
                
            }else if(subCommandType == 0X03) {
            	 // ByteBuffer를 사용하여 바이트 배열로 변환
                ByteBuffer buffer = ByteBuffer.allocate(31);
                buffer.order(ByteOrder.LITTLE_ENDIAN);

                // robo_Position의 값을 sendBuffer에 넣어주기
                buffer.put(mainCommandType);
                buffer.put(subCommandType);
                buffer.putFloat(user_x);
                buffer.putFloat(user_y);
                buffer.putFloat(user_z);
                buffer.putFloat(user_Rx);
                buffer.putFloat(user_Ry);
                buffer.putFloat(user_Rz);
                buffer.putFloat(DigitalOut); // DigitalOut 값이 필요한 경우에 넣어주세요.
                buffer.put((byte) 0x00); // 예약된 바이트

                OutputStream out = clientSocket.getOutputStream();

                // 소켓이 닫혀 있는지 확인 후 전송
                if (!clientSocket.isClosed()) {
                    out.write(buffer.array());
                    out.flush();
                    LOGGER.info("클라이언트로 값 전송: " +
                            "mainCommandType=" + mainCommandType +
                            ", subCommandType=" + subCommandType +
                            ", user_x=" + user_x +
                            ", user_y=" + user_y +
                            ", user_z=" + user_z +
                            ", user_Rx=" + user_Rx +
                            ", user_Ry=" + user_Ry +
                            ", user_Rz=" + user_Rz);
            }
            }
            

            }

            // 클라이언트 소켓 닫기
            closeSocket(clientSocket);
        }

    } catch (IOException e) {
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
            LOGGER.log(Level.SEVERE, "소켓 닫기 오류", e);
        }
    }

    private static void closeSocket(ServerSocket serverSocket) {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.log(Level.SEVERE, "서버 소켓 닫기 오류", e);
        }
    }
}
