package com.example.client3;

public class Make_JogData {
	
   public static void Make_Jog_Command(Make_Jog receivedData) {

	   byte subCommandType = receivedData.getSubCommandType();
	   
	   if(subCommandType == 0x00) { //Smooth
		   Make_Jog_Smooth(receivedData);
	   } else if (subCommandType == 0x01) { //Tick
		   Make_Jog_Tick(receivedData);

	   }
	   
   }
   
   private static void Make_Jog_Smooth(Make_Jog receivedData) {
	   float x = receivedData.getX();
       float y = receivedData.getY();
       float z = receivedData.getZ();
       float rx = receivedData.getRx();
       float ry = receivedData.getRy();
       float rz = receivedData.getRz();

       // 데이터 출력 또는 처리
       System.out.println("Main Command Type: " + receivedData.getMainCommandType());
       System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
       System.out.println("x: " + x);
       System.out.println("y: " + y);
       System.out.println("z: " + z);
       System.out.println("rx: " + rx);
       System.out.println("ry: " + ry);
       System.out.println("rz: " + rz);
   }
   
   private static void Make_Jog_Tick(Make_Jog receivedData) {
	   float x = receivedData.getX();
       float y = receivedData.getY();
       float z = receivedData.getZ();
       float rx = receivedData.getRx();
       float ry = receivedData.getRy();
       float rz = receivedData.getRz();
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
