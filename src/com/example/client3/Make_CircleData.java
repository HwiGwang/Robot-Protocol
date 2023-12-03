package com.example.client3;

public class Make_CircleData {
	public static void Make_Circle_Command(Make_Circle receivedData) {
		byte subCommandType = receivedData.getSubCommandType();
		
		if(subCommandType == 0x00) { //3Point
	 		   Make_Circle_3Point(receivedData);
	        }
	        else if(subCommandType == 0x01) { // Axis/Center
	  		   Make_Circle_AxisCenter(receivedData);
	        }
	        else {
	        	System.out.println("SubCommandType 오류");
	        }

	     }

	private static void Make_Circle_3Point(Make_Circle receivedData) {
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
	}
	
	private static void Make_Circle_AxisCenter(Make_Circle receivedData) {
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
