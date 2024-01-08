//package com.example.client3;
//
//public class Make_DebugData {
//	public static void Make_Debug_Command(Make_Debug receivedData) {
//		byte subCommandType = receivedData.getSubCommandType();
//
//		if(subCommandType == 0x00) { //FromControlBox
//	 		   Make_Debug_FromControlBox(receivedData);
//	        }
//		else
//		{
//        	System.out.println("SubCommandType 오류");
//
//		}
//	}
//	
//	private static void Make_Debug_FromControlBox(Make_Debug receivedData) {
//        String name = receivedData.getName();
//
//        // 데이터 출력 또는 처리
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("name: " + name);
//	}
//
//}
