package com.example.client3;

public class Make_UserData {
	public static void Make_User_Command(Make_User receivedData) {
		   byte subCommandType = receivedData.getSubCommandType();
		   
		   if(subCommandType == 0x00) { //Smooth
			   Make_User_Smooth(receivedData);
		   } else if (subCommandType == 0x01) { //Tick
			   Make_User_Tick(receivedData);

		   }
	}
	
	private static void Make_User_Smooth(Make_User receivedData) {
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
	}
	
	private static void Make_User_Tick(Make_User receivedData) {
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
