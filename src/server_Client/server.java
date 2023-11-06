package server_Client;

import java.io.*;
import java.net.*;
import com.example.client3.*;

public class server {

    public static void main(String[] args) throws IOException {
        Socket clientSocket = null;
        ServerSocket serverSocket = null;
        serverSocket = new ServerSocket(64321);

        try {
            System.out.println("클라이언트와의 연결을 대기중");

            clientSocket = serverSocket.accept();
            System.out.println("서버 접속");

            // 클라이언트로부터 데이터를 읽기 위한 입력 스트림 생성
            InputStream in = clientSocket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(in);
            

            
            Make receivedData = (Make) objectInputStream.readObject();
            byte mainCommandType = receivedData.getMainCommandType();
            byte subCommandType = receivedData.getSubCommandType();
            if(mainCommandType == 0x00) //Global
            {
            	if(subCommandType == 0x00) //Smooth
            	{
            		float x = receivedData.getX();
            		float y = receivedData.getY();
            		float z = receivedData.getZ();
            		float rx = receivedData.getRX();
            		float ry = receivedData.getRY();
            		float rz = receivedData.getRZ();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("x:" + x);
            		System.out.println("y:" + y);
            		System.out.println("z:" + z);
            		System.out.println("rx:" + rx);
            		System.out.println("ry:" + ry);
            		System.out.println("rz:" + rz);
            		
            	}
            	else if(subCommandType== 0x01) //Tick
            	{
            		float x = receivedData.getX();
            		float y = receivedData.getY();
            		float z = receivedData.getZ();
            		float rx = receivedData.getRX();
            		float ry = receivedData.getRY();
            		float rz = receivedData.getRZ();
            		float Dist = receivedData.getDist();
            		float Ori = receivedData.getOri();
            		float Joint = receivedData.getJoint();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("x:" + x);
            		System.out.println("y:" + y);
            		System.out.println("z:" + z);
            		System.out.println("rx:" + rx);
            		System.out.println("ry:" + ry);
            		System.out.println("rz:" + rz);
            		System.out.println("Dist" + Dist);
            		System.out.println("Ori:" + Ori);
            		System.out.println("Joint:" + Joint);
            		
            	}
            }else if(mainCommandType == 0x01) //Local
            {
            	if(subCommandType == 0x00) //Smooth
            	{
            		float x = receivedData.getX();
            		float y = receivedData.getY();
            		float z = receivedData.getZ();
            		float rx = receivedData.getRX();
            		float ry = receivedData.getRY();
            		float rz = receivedData.getRZ();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("x:" + x);
            		System.out.println("y:" + y);
            		System.out.println("z:" + z);
            		System.out.println("rx:" + rx);
            		System.out.println("ry:" + ry);
            		System.out.println("rz:" + rz);
            		
            	}
            	else if(subCommandType== 0x01) //Tick
            	{
            		float x = receivedData.getX();
            		float y = receivedData.getY();
            		float z = receivedData.getZ();
            		float rx = receivedData.getRX();
            		float ry = receivedData.getRY();
            		float rz = receivedData.getRZ();
            		float Dist = receivedData.getDist();
            		float Ori = receivedData.getOri();
            		float Joint = receivedData.getJoint();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("x:" + x);
            		System.out.println("y:" + y);
            		System.out.println("z:" + z);
            		System.out.println("rx:" + rx);
            		System.out.println("ry:" + ry);
            		System.out.println("rz:" + rz);
            		System.out.println("Dist" + Dist);
            		System.out.println("Ori:" + Ori);
            		System.out.println("Joint:" + Joint);
            		
            	}
            }else if(mainCommandType == 0x02) //User
            {
            	if(subCommandType == 0x00) //Smooth
            	{
            		float x = receivedData.getX();
            		float y = receivedData.getY();
            		float z = receivedData.getZ();
            		float rx = receivedData.getRX();
            		float ry = receivedData.getRY();
            		float rz = receivedData.getRZ();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("x:" + x);
            		System.out.println("y:" + y);
            		System.out.println("z:" + z);
            		System.out.println("rx:" + rx);
            		System.out.println("ry:" + ry);
            		System.out.println("rz:" + rz);
            		
            	}
            	else if(subCommandType== 0x01) //Tick
            	{
            		float x = receivedData.getX();
            		float y = receivedData.getY();
            		float z = receivedData.getZ();
            		float rx = receivedData.getRX();
            		float ry = receivedData.getRY();
            		float rz = receivedData.getRZ();
            		float Dist = receivedData.getDist();
            		float Ori = receivedData.getOri();
            		float Joint = receivedData.getJoint();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("x:" + x);
            		System.out.println("y:" + y);
            		System.out.println("z:" + z);
            		System.out.println("rx:" + rx);
            		System.out.println("ry:" + ry);
            		System.out.println("rz:" + rz);
            		System.out.println("Dist" + Dist);
            		System.out.println("Ori:" + Ori);
            		System.out.println("Joint:" + Joint);
            		
            	}
            }else if(mainCommandType == 0x03) //Joint
            {
            	if(subCommandType == 0x00) //Smooth
            	{
            		float Base = receivedData.getBase();
            		float Shoulder = receivedData.getShoulder();
            		float Elbow = receivedData.getElbow();
            		float Wrist1 = receivedData.getWrist1();
            		float Wrist2 = receivedData.getWrist2();
            		float Wrist3 = receivedData.getWrist3();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("Base:" + Base);
            		System.out.println("Shoulder:" + Shoulder);
            		System.out.println("Elbow:" + Elbow);
            		System.out.println("Wrist1:" + Wrist1);
            		System.out.println("Wirst2:" + Wrist2);
            		System.out.println("Wirst3:" + Wrist3);
            		
            	}
            	else if(subCommandType== 0x01) //Tick
            	{
            		float Base = receivedData.getBase();
            		float Shoulder = receivedData.getShoulder();
            		float Elbow = receivedData.getElbow();
            		float Wrist1 = receivedData.getWrist1();
            		float Wrist2 = receivedData.getWrist2();
            		float Wrist3 = receivedData.getWrist3();
            		float Dist = receivedData.getDist();
            		float Ori = receivedData.getOri();
            		float Joint = receivedData.getJoint();
            		
            		System.out.println("Main Command Type : "+mainCommandType);
            		System.out.println("Sub Command Type : "+subCommandType);
            		System.out.println("Base:" + Base);
            		System.out.println("Shoulder:" + Shoulder);
            		System.out.println("Elbow:" + Elbow);
            		System.out.println("Wrist1:" + Wrist1);
            		System.out.println("Wirst2:" + Wrist2);
            		System.out.println("Wirst3:" + Wrist3);
            		System.out.println("Dist" + Dist);
            		System.out.println("Ori:" + Ori);
            		System.out.println("Joint:" + Joint);
            		
            	}
            }
            
            
         
            // 클라이언트에 전송할 데이터
            OutputStream out = clientSocket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(out);

            // 서버로부터 데이터를 읽어온 후 필요한 작업을 수행합니다.
            // 예를 들어, 클라이언트로 응답 데이터를 보내고, 클라이언트에서 받은 데이터를 가공합니다.
            // 여기서는 단순히 "Hello" 메시지를 클라이언트에 보냅니다.
            String responseMessage = "Hello";
            objectOutputStream.writeObject(responseMessage);

            objectInputStream.close();
            objectOutputStream.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                clientSocket.close();
            }
        }
    }
}