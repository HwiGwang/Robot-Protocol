package com.example.client3;

import java.io.*;
import java.net.*;

public class server {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(14321);
            System.out.println("클라이언트 연결 대기 중...");

            clientSocket = serverSocket.accept();
            System.out.println("클라이언트 연결됨");

            

            
            // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 생성
            InputStream in = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(in);

            // 받은 데이터를 Make 객체로 형변환
            Make receivedData = (Make) objectInputStream.readObject();
            byte mainCommandType = receivedData.getMainCommandType();


            // 서브클래스로 형변환하여 처리
            if (receivedData instanceof Make_Jog) {
            	Make_JogData.Make_Jog_Command((Make_Jog) receivedData);
            } else if (receivedData instanceof Make_User) {
            	Make_UserData.Make_User_Command((Make_User) receivedData);
            }else if (receivedData instanceof Make_Move) {
            	Make_MoveData.Make_Move_Command((Make_Move) receivedData);
            }else if (receivedData instanceof Make_Circle) {
            	Make_CircleData.Make_Circle_Command((Make_Circle) receivedData);
            }else if (receivedData instanceof Make_Debug) {
            	Make_DebugData.Make_Debug_Command((Make_Debug) receivedData);
            }else if (receivedData instanceof Make_Set) {
            	Make_SetData.Make_Set_Command((Make_Set) receivedData);
            }
            
            Make sendData1 = new Make_Get((byte)0x05, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);
            Make sendData2 = new Make_Debug((byte)0x05, (byte)0x01, "Debug");
            ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
            outputStream.writeObject(sendData2);
            
           
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeSocket(clientSocket);
            closeSocket(serverSocket);
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