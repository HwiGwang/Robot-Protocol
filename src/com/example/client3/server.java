package com.example.client3;

import com.example.client3.Make;
import com.example.client3.MakeType00;
import com.example.client3.MakeType01;
import com.example.client3.MakeType02;
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
            byte subCommandType;
            byte type;

            // 서브클래스로 형변환하여 처리
            if (receivedData instanceof MakeType00) {
                MakeType00 type00Data = (MakeType00) receivedData;
                subCommandType = type00Data.getSubCommandType();
                handleGlobalCommands(subCommandType, type00Data);
            } else if (receivedData instanceof MakeType01) {
                MakeType01 type01Data = (MakeType01) receivedData;
                subCommandType = type01Data.getSubCommandType();
                handleLocalCommands(subCommandType, type01Data);
            }else if (receivedData instanceof MakeType02) {
            	MakeType02 makeType02Data = (MakeType02) receivedData;
                subCommandType = makeType02Data.getSubCommandType();
                type = makeType02Data.getType();
                handleLocalCommands(subCommandType, type, makeType02Data);
            }else if (receivedData instanceof MakeType04) {
            	MakeType04 makeType04Data = (MakeType04) receivedData;
                subCommandType = makeType04Data.getSubCommandType();
                               handleLocalCommands(subCommandType, makeType04Data);
                
                
                // 클라이언트에 응답 전송
                OutputStream out = clientSocket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);
                String responseMessage = "안녕하세요";
                objectOutputStream.writeObject(responseMessage);
                objectOutputStream.close();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeSocket(clientSocket);
            closeSocket(serverSocket);
        }
    }

    private static void handleGlobalCommands(byte subCommandType, MakeType00 receivedData) {
        // 전역 명령 처리
        if (subCommandType == 0x00) { // Smooth
            float x = receivedData.getX();
            float y = receivedData.getY();
            float z = receivedData.getZ();
            float rx = receivedData.getRX();
            float ry = receivedData.getRY();
            float rz = receivedData.getRZ();

            // 데이터 출력 또는 처리
            System.out.println("Main Command Type: " + receivedData.getMainCommandType());
            System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("z: " + z);
            System.out.println("rx: " + rx);
            System.out.println("ry: " + ry);
            System.out.println("rz: " + rz);
            
        } else if (subCommandType == 0x01) { // Tick
            float x = receivedData.getX();
            float y = receivedData.getY();
            float z = receivedData.getZ();
            float rx = receivedData.getRX();
            float ry = receivedData.getRY();
            float rz = receivedData.getRZ();
            float dist = receivedData.getDist();
            float ori = receivedData.getOri();
            float joint = receivedData.getJoint();
            
            System.out.println("Main Command Type: " + receivedData.getMainCommandType());
            System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
            System.out.println("x: " + x);
            System.out.println("y: " + y);
            System.out.println("z: " + z);
            System.out.println("rx: " + rx);
            System.out.println("ry: " + ry);
            System.out.println("rz: " + rz);
            System.out.println("dist: " + dist);
            System.out.println("ori: " + ori);
            System.out.println("joint: " + joint);
        }
    }

     
    private static void handleLocalCommands(byte subCommandType, MakeType01 receivedData) {
        // 로컬 명령 처리
    	if (subCommandType == 0x00) { // Smooth
            float base = receivedData.getBase();
            float shoulder = receivedData.getShoulder();
            float elbow = receivedData.getElbow();
            float wrist1 = receivedData.getWrist1();
            float wrist2 = receivedData.getWrist2();
            float wrist3 = receivedData.getWrist3();

            // 데이터 출력 또는 처리
            System.out.println("Main Command Type: " + receivedData.getMainCommandType());
            System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
            System.out.println("Base: " + base);
            System.out.println("Shoulder: " + shoulder);
            System.out.println("Elbow: " + elbow);
            System.out.println("Wrist1: " + wrist1);
            System.out.println("Wrist2: " + wrist2);
            System.out.println("Wrist3: " + wrist3);
            
        } else if (subCommandType == 0x01) { // Tick
        	float base = receivedData.getBase();
            float shoulder = receivedData.getShoulder();
            float elbow = receivedData.getElbow();
            float wrist1 = receivedData.getWrist1();
            float wrist2 = receivedData.getWrist2();
            float wrist3 = receivedData.getWrist3();
            float dist = receivedData.getDist();
            float ori = receivedData.getOri();
            float joint = receivedData.getJoint();
            
            System.out.println("Main Command Type: " + receivedData.getMainCommandType());
            System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
            System.out.println("Base: " + base);
            System.out.println("Shoulder: " + shoulder);
            System.out.println("Elbow: " + elbow);
            System.out.println("Wrist1: " + wrist1);
            System.out.println("Wrist2: " + wrist2);
            System.out.println("Wrist3: " + wrist3);
            System.out.println("dist: " + dist);
            System.out.println("ori: " + ori);
            System.out.println("joint: " + joint);
        }
    }
    
    
    private static void handleLocalCommands(byte subCommandType, byte type, MakeType02 receivedData) {
        // 로컬 명령 처리
    	byte moveType = receivedData.getMoveType();
        String name = receivedData.getName();
        float speed = receivedData.getSpeed();
        float acc = receivedData.getAcc();
        float finish_at = receivedData.getFinishAt();
        float stopping_time = receivedData.getStoppingTime();
    	if (subCommandType == 0x00) { //MoveJ
    		if(type==0x00){ //Absoulte
    			float x = receivedData.getX();
                float y = receivedData.getY();
                float z = receivedData.getZ();
                float rx = receivedData.getRX();
                float ry = receivedData.getRY();
                float rz = receivedData.getRZ();
                float base = receivedData.getBase();
                float shoulder = receivedData.getShoulder();
                float elbow = receivedData.getElbow();
                float wrist1 = receivedData.getWrist1();
                float wrist2 = receivedData.getWrist2();
                float wrist3 = receivedData.getWrist3();
                
                // 데이터 출력 또는 처리
                System.out.println("Main Command Type: " + receivedData.getMainCommandType());
                System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                System.out.println("Type: "+ receivedData.getType());
                System.out.println("moveType: " + moveType);
                System.out.println("Name: " + name);
                System.out.println("Speed: " + speed);
                System.out.println("ACC: " + acc);
                System.out.println("finish_at: " + finish_at);
                System.out.println("stopping_time: " + stopping_time);
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                System.out.println("z: " + z);
                System.out.println("rx: " + rx);
                System.out.println("ry: " + ry);
                System.out.println("rz: " + rz);
                System.out.println("Base: " + base);
                System.out.println("Shoulder: " + shoulder);
                System.out.println("Elbow: " + elbow);
                System.out.println("Wrist1: " + wrist1);
                System.out.println("Wrist2: " + wrist2);
                System.out.println("Wrist3: " + wrist3);
    		}
    		else if(type==0x01) { //Variable
    			 float j0 = receivedData.getJ0();
    	         float j1 = receivedData.getJ1();
    	         float j2 = receivedData.getJ2();
    	         float j3 = receivedData.getJ3();
    	         float j4 = receivedData.getJ4();
    	         float j5 = receivedData.getJ5();
    	         
    	         System.out.println("Main Command Type: " + receivedData.getMainCommandType());
    	         System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                 System.out.println("Type: "+ receivedData.getType());
    	         System.out.println("moveType: " + moveType);
    	         System.out.println("Name: " + name);
    	         System.out.println("Speed: " + speed);
    	         System.out.println("ACC: " + acc);
    	         System.out.println("finish_at: " + finish_at);
    	         System.out.println("stopping_time: " + stopping_time);
    	         System.out.println("J0: " + j0);
    	         System.out.println("J1: " + j1);
    	         System.out.println("J2: " + j2);
    	         System.out.println("J3: " + j3);
    	         System.out.println("J4: " + j4);
    	         System.out.println("J5: " + j5);
    		}
    		else if(type ==0x02) {//Relative
    			 float jj0 = receivedData.getJJ0();
    	         float jj1 = receivedData.getJJ1();
    	         float jj2 = receivedData.getJJ2();
    	         float jj3 = receivedData.getJJ3();
    	         float jj4 = receivedData.getJJ4();
    	         float jj5 = receivedData.getJJ5();
    	         
    	         System.out.println("Main Command Type: " + receivedData.getMainCommandType());
    	         System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                 System.out.println("Type: "+ receivedData.getType());
    	         System.out.println("moveType: " + moveType);
    	         System.out.println("Name: " + name);
    	         System.out.println("Speed: " + speed);
    	         System.out.println("ACC: " + acc);
    	         System.out.println("finish_at: " + finish_at);
    	         System.out.println("stopping_time: " + stopping_time);
    	         System.out.println("J0: " + jj0);
    	         System.out.println("J1: " + jj1);
    	         System.out.println("J2: " + jj2);
    	         System.out.println("J3: " + jj3);
    	         System.out.println("J4: " + jj4);
    	         System.out.println("J5: " + jj5);
    	         
    		}
    		else {
    			System.out.println("Type 값 오류");
    		}

        } else if (subCommandType == 0x02) { //MoveJ
           	if(type == 0x03) { //Absoulte
           	 float x = receivedData.getX();
             float y = receivedData.getY();
             float z = receivedData.getZ();
             float rx = receivedData.getRX();
             float ry = receivedData.getRY();
             float rz = receivedData.getRZ();
             float base = receivedData.getBase();
             float shoulder = receivedData.getShoulder();
             float elbow = receivedData.getElbow();
             float wrist1 = receivedData.getWrist1();
             float wrist2 = receivedData.getWrist2();
             float wrist3 = receivedData.getWrist3();
             
          // 데이터 출력 또는 처리
             System.out.println("Main Command Type: " + receivedData.getMainCommandType());
             System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
             System.out.println("Type: "+ receivedData.getType());
             System.out.println("moveType: " + moveType);
             System.out.println("Name: " + name);
             System.out.println("Speed: " + speed);
             System.out.println("ACC: " + acc);
             System.out.println("finish_at: " + finish_at);
             System.out.println("stopping_time: " + stopping_time);
             System.out.println("x: " + x);
             System.out.println("y: " + y);
             System.out.println("z: " + z);
             System.out.println("rx: " + rx);
             System.out.println("ry: " + ry);
             System.out.println("rz: " + rz);
             System.out.println("Base: " + base);
             System.out.println("Shoulder: " + shoulder);
             System.out.println("Elbow: " + elbow);
             System.out.println("Wrist1: " + wrist1);
             System.out.println("Wrist2: " + wrist2);
             System.out.println("Wrist3: " + wrist3);
        		
        	}
           	else if(type == 0x04) { //Variable
           		float j0 = receivedData.getJ0();
                float j1 = receivedData.getJ1();
                float j2 = receivedData.getJ2();
                float j3 = receivedData.getJ3();
                float j4 = receivedData.getJ4();
                float j5 = receivedData.getJ5();
                
                System.out.println("Main Command Type: " + receivedData.getMainCommandType());
                System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                System.out.println("Type: "+ receivedData.getType());
                System.out.println("moveType: " + moveType);
                System.out.println("Name: " + name);
                System.out.println("Speed: " + speed);
                System.out.println("ACC: " + acc);
                System.out.println("finish_at: " + finish_at);
                System.out.println("stopping_time: " + stopping_time);
                System.out.println("J0: " + j0);
                System.out.println("J1: " + j1);
                System.out.println("J2: " + j2);
                System.out.println("J3: " + j3);
                System.out.println("J4: " + j4);
                System.out.println("J5: " + j5);
           	}
           	else if(type == 0x05) { //Relative
           		float jj0 = receivedData.getJJ0();
                float jj1 = receivedData.getJJ1();
                float jj2 = receivedData.getJJ2();
                float jj3 = receivedData.getJJ3();
                float jj4 = receivedData.getJJ4();
                float jj5 = receivedData.getJJ5();
                byte reference_Point = (byte) receivedData.getReference_Point();
                byte reference_Coordinate =(byte) receivedData.getReference_Coordinate();
            	
                System.out.println("Main Command Type: " + receivedData.getMainCommandType());
                System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                System.out.println("Type: "+ receivedData.getType());
                System.out.println("moveType: " + moveType);
                System.out.println("Name: " + name);
                System.out.println("Speed: " + speed);
                System.out.println("ACC: " + acc);
                System.out.println("finish_at: " + finish_at);
                System.out.println("stopping_time: " + stopping_time);
                System.out.println("J0: " + jj0);
                System.out.println("J1: " + jj1);
                System.out.println("J2: " + jj2);
                System.out.println("J3: " + jj3);
                System.out.println("J4: " + jj4);
                System.out.println("J5: " + jj5);
                System.out.println("Reference_Point:"+reference_Point);
                System.out.println("Reference_Coordinate:"+reference_Coordinate);
           	}
           	else if(type==0x06) { //UserCoordinate
           		float x = receivedData.getX();
                float y = receivedData.getY();
                float z = receivedData.getZ();
                float rx = receivedData.getRX();
                float ry = receivedData.getRY();
                float rz = receivedData.getRZ();
                byte reference_Coordinate = (byte) receivedData.getReference_Coordinate();
                
                // 데이터 출력 또는 처리
                System.out.println("Main Command Type: " + receivedData.getMainCommandType());
                System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                System.out.println("Type: "+ receivedData.getType());
                System.out.println("moveType: " + moveType);
                System.out.println("Name: " + name);
                System.out.println("Speed: " + speed);
                System.out.println("ACC: " + acc);
                System.out.println("finish_at: " + finish_at);
                System.out.println("stopping_time: " + stopping_time);
                System.out.println("x: " + x);
                System.out.println("y: " + y);
                System.out.println("z: " + z);
                System.out.println("rx: " + rx);
                System.out.println("ry: " + ry);
                System.out.println("rz: " + rz);
                System.out.println("Reference_Coordiante" + reference_Coordinate);
           	}
           	else {
           		System.out.println("Type 값 오류");
           	}
        }else {
        	System.out.println("SubCommandType 값 오류");
        }
        	
       

    }
    	private static void handleLocalCommands(byte subCommandType, MakeType04 receivedData) {
            // 로컬 명령 처리
        	if (subCommandType == 0x00) { // 3Point
        		byte ori_Type = receivedData.getOri_Type();
                byte type = receivedData.getType();
                float speed = receivedData.getSpeed();
                float acc = receivedData.getAcc();
                float finish_at = receivedData.getFinishAt();
                float stopping_time = receivedData.getStoppingTime();
                float x1 = receivedData.getX1();
                float y1 = receivedData.getY1();
                float z1 = receivedData.getZ1();
                float rx1 = receivedData.getRX1();
                float ry1 = receivedData.getRY1();
                float rz1 = receivedData.getRZ1();
                float base1 = receivedData.getBase1();
                float shoulder1 = receivedData.getShoulder1();
                float elbow1 = receivedData.getElbow1();
                float wrist1_1 = receivedData.getWrist1_1();
                float wrist2_1 = receivedData.getWrist2_1();
                float wrist3_1 = receivedData.getWrist3_1();
                float x2 = receivedData.getX2();
                float y2 = receivedData.getY2();
                float z2 = receivedData.getZ2();
                float rx2 = receivedData.getRX2();
                float ry2 = receivedData.getRY2();
                float rz2 = receivedData.getRZ2();
                float base2 = receivedData.getBase2();
                float shoulder2 = receivedData.getShoulder2();
                float elbow2 = receivedData.getElbow2();
                float wrist1_2 = receivedData.getWrist1_2();
                float wrist2_2 = receivedData.getWrist2_2();
                float wrist3_2 = receivedData.getWrist3_2();
                
                // 데이터 출력 또는 처리
                System.out.println("Main Command Type: " + receivedData.getMainCommandType());
                System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                System.out.println("Ori_Type " + ori_Type);
                System.out.println("Type: " + type);
                System.out.println("Speed: " + speed);
                System.out.println("ACC: " + acc);
                System.out.println("finish_at: " + finish_at);
                System.out.println("stopping_time: " + stopping_time);
                System.out.println("x1: " + x1);
                System.out.println("y1: " + y1);
                System.out.println("z1: " + z1);
                System.out.println("rx1: " + rx1);
                System.out.println("ry1: " + ry1);
                System.out.println("rz1: " + rz1);
                System.out.println("Base1: " + base1);
                System.out.println("Shoulder1: " + shoulder1);
                System.out.println("Elbow1: " + elbow1);
                System.out.println("Wrist1_1: " + wrist1_1);
                System.out.println("Wrist2_1: " + wrist2_1);
                System.out.println("Wrist3_1: " + wrist3_1);
                System.out.println("x2: " + x2);
                System.out.println("y2: " + y2);
                System.out.println("z2: " + z2);
                System.out.println("rx2: " + rx2);
                System.out.println("ry2: " + ry2);
                System.out.println("rz2: " + rz2);
                System.out.println("Base2: " + base2);
                System.out.println("Shoulder2: " + shoulder2);
                System.out.println("Elbow2: " + elbow2);
                System.out.println("Wrist1_2: " + wrist1_2);
                System.out.println("Wrist2_2: " + wrist2_2);
                System.out.println("Wrist3_2: " + wrist3_2);
                
            } else if (subCommandType == 0x01) { // Axis/Center
            	
        		byte ori_Type = receivedData.getOri_Type();
                byte type = receivedData.getType();
                float speed = receivedData.getSpeed();
                float acc = receivedData.getAcc();
                float finish_at = receivedData.getFinishAt();
                float stopping_time = receivedData.getStoppingTime();
                float x1 = receivedData.getX1();
                float y1 = receivedData.getY1();
                float z1 = receivedData.getZ1();
                float x2 = receivedData.getX2();
                float y2 = receivedData.getY2();
                float z2 = receivedData.getZ2();
                float degree = receivedData.getDegree();
                
                // 데이터 출력 또는 처리
                System.out.println("Main Command Type: " + receivedData.getMainCommandType());
                System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
                System.out.println("Ori_Type " + ori_Type);
                System.out.println("Type: " + type);
                System.out.println("Speed: " + speed);
                System.out.println("ACC: " + acc);
                System.out.println("finish_at: " + finish_at);
                System.out.println("stopping_time: " + stopping_time);
                System.out.println("x1: " + x1);
                System.out.println("y1: " + y1);
                System.out.println("z1: " + z1);
                System.out.println("x2: " + x2);
                System.out.println("y2: " + y2);
                System.out.println("z2: " + z2);
                System.out.println("Degree:"+ degree);
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