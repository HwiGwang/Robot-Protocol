package com.example.client3;

public class Make_MoveData {
	public static void Make_Move_Command(Make_Move receivedData) {
		byte subCommandType = receivedData.getSubCommandType();
		byte type = receivedData.getType();

        
        if(subCommandType == 0x00) { //MoveJ
 		   Make_MoveJ(receivedData, type);
        }
        else if(subCommandType == 0x01) { // MoveL
  		   Make_MoveL(receivedData, type);
        }
        else {
        	System.out.println("SubCommandType 오류");
        }

     }
	

	private static void Make_MoveJ(Make_Move receivedData, byte type) {
		byte moveType = receivedData.getMoveType();
        String name = receivedData.getName();
        float speed = receivedData.getSpeed();
        float acc = receivedData.getAcc();
        float finish_at = receivedData.getFinishAt();
        float stopping_time = receivedData.getStoppingTime();
        
        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Type: "+ receivedData.getType());
        System.out.println("moveType: " + moveType);
        System.out.println("Name: " + name);
        System.out.println("Speed: " + speed);
        System.out.println("ACC: " + acc);
        System.out.println("finish_at: " + finish_at);
        System.out.println("stopping_time: " + stopping_time);
        
        if(type == 0x00) {//Absolute
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
            
        } else if(type == 0x01) { //Variable
        	float j0 = receivedData.getJ0();
	        float j1 = receivedData.getJ1();
	        float j2 = receivedData.getJ2();
	        float j3 = receivedData.getJ3();
	        float j4 = receivedData.getJ4();
	        float j5 = receivedData.getJ5();
	        
	        System.out.println("J0: " + j0);
	        System.out.println("J1: " + j1);
	        System.out.println("J2: " + j2);
	        System.out.println("J3: " + j3);
	        System.out.println("J4: " + j4);
	        System.out.println("J5: " + j5); 
        }else if(type == 0x02) { //Relative
        
        	float jj0 = receivedData.getJJ0();
	        float jj1 = receivedData.getJJ1();
	        float jj2 = receivedData.getJJ2();
	        float jj3 = receivedData.getJJ3();
	        float jj4 = receivedData.getJJ4();
	        float jj5 = receivedData.getJJ5();
	         

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
	}
        
	private static void Make_MoveL(Make_Move receivedData, byte type) {
		byte moveType = receivedData.getMoveType();
        String name = receivedData.getName();
        float speed = receivedData.getSpeed();
        float acc = receivedData.getAcc();
        float finish_at = receivedData.getFinishAt();
        float stopping_time = receivedData.getStoppingTime();
        
        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Type: "+ receivedData.getType());
        System.out.println("moveType: " + moveType);
        System.out.println("Name: " + name);
        System.out.println("Speed: " + speed);
        System.out.println("ACC: " + acc);
        System.out.println("finish_at: " + finish_at);
        System.out.println("stopping_time: " + stopping_time);
        
        if(type == 0x03) {//Absolute
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
            
        } else if(type == 0x04) { //Variable
        	float j0 = receivedData.getJ0();
	        float j1 = receivedData.getJ1();
	        float j2 = receivedData.getJ2();
	        float j3 = receivedData.getJ3();
	        float j4 = receivedData.getJ4();
	        float j5 = receivedData.getJ5();
	        
	        System.out.println("J0: " + j0);
	        System.out.println("J1: " + j1);
	        System.out.println("J2: " + j2);
	        System.out.println("J3: " + j3);
	        System.out.println("J4: " + j4);
	        System.out.println("J5: " + j5); 
        }else if(type == 0x05) { //Relative
        
        	float jj0 = receivedData.getJJ0();
	        float jj1 = receivedData.getJJ1();
	        float jj2 = receivedData.getJJ2();
	        float jj3 = receivedData.getJJ3();
	        float jj4 = receivedData.getJJ4();
	        float jj5 = receivedData.getJJ5();
	        byte reference_Point = (byte) receivedData.getReference_Point();
            byte reference_Coordinate =(byte) receivedData.getReference_Coordinate(); 

	        System.out.println("J0: " + jj0);
	        System.out.println("J1: " + jj1);
	        System.out.println("J2: " + jj2);
	        System.out.println("J3: " + jj3);
	        System.out.println("J4: " + jj4);
	        System.out.println("J5: " + jj5);
            System.out.println("Reference_Point:"+reference_Point);
            System.out.println("Reference_Coordinate:"+reference_Coordinate);
        }
        else if(type == 0x06) { //UserCoordinate
           		float x = receivedData.getX();
                float y = receivedData.getY();
                float z = receivedData.getZ();
                float rx = receivedData.getRX();
                float ry = receivedData.getRY();
                float rz = receivedData.getRZ();
                byte reference_Coordinate = (byte) receivedData.getReference_Coordinate();
                
                // 데이터 출력 또는 처리

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
        }

}
