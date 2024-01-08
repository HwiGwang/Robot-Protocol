//package com.example.client3;
//
//
//public class Make_SetData {
//    public static void Make_Set_Command(Make_Set receivedData) {
//        byte subCommandType = receivedData.getSubCommandType();
//
//        if (subCommandType == 0x00) { // 충돌감도 조절
//            Make_Set_Threshold(receivedData);
//        } else if (subCommandType == 0x01) { // Tcp하중
//            Make_Set_Tcppayload(receivedData);
//        } else if (subCommandType == 0x02) { // 동작오프렛
//            Make_Set_MoveOffset(receivedData);
//
//        } else if (subCommandType == 0x03) { // 인박스
//            Make_Set_Inbox(receivedData);
//
//        } else if (subCommandType == 0x04) { // TCP 좌표 임시 설정
//            Make_Set_Tcppposistion(receivedData);
//
//        } else if (subCommandType == 0x05) { // 툴 안전영역 설정
//            Make_Set_CollisionBox(receivedData);
//
//        } else if (subCommandType == 0x06) { // 작업 안전영역 설정
//            Make_Set_Workspace(receivedData);
//
//        } else if (subCommandType == 0x07) { //0x07 : 인박스 영역 설정
//        	Make_Set_Inbox_Size(receivedData);
//
//        } else if (subCommandType == 0x08) { //0x08 : 충돌 감지 On, Off
//        	Make_Set_Collision_OnOff(receivedData);
//        	
//        } else if (subCommandType == 0x09) { //0x09 : 시리얼 통신 설정
//        	Make_Set_Serial_Configuration(receivedData);
//        	
//        }else if (subCommandType == 0x0A) { //0x0A : 속도 조절 바 제어
//        	Make_Set_Speed_Bar_Control(receivedData);
//        	
//        }else if (subCommandType == 0x0B) { //0x0B : 충돌 감지 후 로봇 정지 모드
//        	Make_Set_Collision_Stop_Mode(receivedData);
//        	
//        }else if (subCommandType == 0x0C) { //0x0C : 사용자 좌표계 시프팅
//        	Make_Set_UserCoordinate_Shift(receivedData);
//        	
//        }else if (subCommandType == 0x0D) { //0x0D : 충돌 감지 후 프로그램 흐름
//        	Make_Set_After_Collision_Detect(receivedData);
//        	
//        }else if (subCommandType == 0x0E) { //0x0E : 제어박스 출력 임시 제어
//        	Make_Set_Disable_Box_D_Out(receivedData);
//        	
//        }else if (subCommandType == 0x0F) { //0x0F : 사용자 좌표계 임시 설정
//        	Make_Set_User_Coordinate_Config(receivedData);
//        	
//        }else if (subCommandType == 0x10) { //0x10 : 진동 센서 감지 On, Off
//        	Make_Set_Vibration_Senosor(receivedData);
//        	
//        }else if (subCommandType == 0x11) { //0x11 : 목표 지점 위치 값 시프트 2
//        	Make_Set_High_Acceleration_Mode(receivedData);
//        	
//        }else if (subCommandType == 0x12) { //0x12 : 고 민감도 충돌 감지
//        	Make_Set_High_Sensitivity_Detect(receivedData);
//        	
//        }else if (subCommandType == 0x13) {//0x13 : 노아크 동작 속도
//        	Make_Set_No_Arc_Move_Speed(receivedData);
//        }
//
//
//    }
//
//    private static void Make_Set_Threshold(Make_Set receivedData) {
//        float threshold = receivedData.getThreshold();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Threshold: " + threshold);
//    }
//
//    private static void Make_Set_Tcppayload(Make_Set receivedData) {
//        float mass = receivedData.getMass();
//        float mass_x = receivedData.getMassX();
//        float mass_y = receivedData.getMassY();
//        float mass_z = receivedData.getMassZ();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Mass: " + mass);
//        System.out.println("Mass_X: " + mass_x);
//        System.out.println("Mass_Y: " + mass_y);
//        System.out.println("Mass_Z: " + mass_z);
//
//    }
//
//    private static void Make_Set_MoveOffset(Make_Set receivedData) {
//        float base_x = receivedData.getBaseX();
//        float base_y = receivedData.getBaseY();
//        float base_z = receivedData.getBaseZ();
//        float base_rx = receivedData.getBaseRX();
//        float base_ry = receivedData.getBaseRY();
//        float base_rz = receivedData.getBaseRZ();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Base_X: " + base_x);
//        System.out.println("Base_Y: " + base_y);
//        System.out.println("Base_Z: " + base_z);
//        System.out.println("Base_RX: " + base_rx);
//        System.out.println("Base_RY: " + base_ry);
//        System.out.println("Base_RZ: " + base_rz);
//    }
//
//    private static void Make_Set_Inbox(Make_Set receivedData) {
//        byte inbox_Box = receivedData.getInboxBox();
//        byte inbox_Mode = receivedData.getInboxMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Inbox_Box: " + inbox_Box);
//        System.out.println("Inbox_Mode: " + inbox_Mode);
//    }
//
//    private static void Make_Set_Tcppposistion(Make_Set receivedData) {
//        float tcp_x = receivedData.getTCPX();
//        float tcp_y = receivedData.getTCPY();
//        float tcp_z = receivedData.getTCPZ();
//        float tcp_rx = receivedData.getTCPRX();
//        float tcp_ry = receivedData.getTCPRY();
//        float tcp_rz = receivedData.getTCPRZ();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("TCP_X: " + tcp_x);
//        System.out.println("TCP_Y: " + tcp_y);
//        System.out.println("TCP_Z: " + tcp_z);
//        System.out.println("TCP_RX: " + tcp_rx);
//        System.out.println("TCP_RY: " + tcp_ry);
//        System.out.println("TCP_RZ: " + tcp_rz);
//    }
//
//    private static void Make_Set_CollisionBox(Make_Set receivedData) {
//        float box_x_width = receivedData.getBoxXWidth();
//        float box_y_width = receivedData.getBoxYWidth();
//        float box_z_width = receivedData.getBoxZWidth();
//        float box_x = receivedData.getBoxX();
//        float box_y = receivedData.getBoxY();
//        float box_z = receivedData.getBoxZ();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Box_X_Width: " + box_x_width);
//        System.out.println("Box_Y_Width: " + box_y_width);
//        System.out.println("Box_Z_Width: " + box_z_width);
//        System.out.println("Box_X: " + box_x);
//        System.out.println("Box_Y: " + box_y);
//        System.out.println("Box_Z: " + box_z);
//    }
//
//    private static void Make_Set_Workspace(Make_Set receivedData) {
//        float workspace_x_width = receivedData.getWorkspaceXWidth();
//        float workspace_y_width = receivedData.getWorkspaceYWidth();
//        float workspace_z_width = receivedData.getWorkspaceZWidth();
//        float workspace_x = receivedData.getWorkspaceX();
//        float workspace_y = receivedData.getWorkspaceY();
//        float workspace_z = receivedData.getWorkspaceZ();
//        byte enable_Workspace = receivedData.getEnableWorkspace();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Workspace_X_Width: " + workspace_x_width);
//        System.out.println("Workspace_Y_Width: " + workspace_y_width);
//        System.out.println("Workspace_Z_Width: " + workspace_z_width);
//        System.out.println("Workspace_X: " + workspace_x);
//        System.out.println("Workspace_Y: " + workspace_y);
//        System.out.println("Workspace_Z: " + workspace_z);
//        System.out.println("Enable_Workspace: " + enable_Workspace);
//    }
//    
//    private static void Make_Set_Inbox_Size(Make_Set receivedData) {
//        float inbox_x_width = receivedData.getInboxXWidth();
//        float inbox_y_width = receivedData.getInboxYWidth();
//        float inbox_z_width = receivedData.getInboxZWidth();
//        float inbox_x = receivedData.getInboxX();
//        float inbox_y = receivedData.getInboxY();
//        float inbox_z = receivedData.getInboxZ();
//        byte inbox_Number = receivedData.getInboxNumber();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Inbox_X_Width: " + inbox_x_width);
//        System.out.println("Inbox_Y_Width: " + inbox_y_width);
//        System.out.println("Inbox_Z_Width: " + inbox_z_width);
//        System.out.println("Inbox_X: " + inbox_x);
//        System.out.println("Inbox_Y: " + inbox_y);
//        System.out.println("Inbox_Z: " + inbox_z);
//        System.out.println("Inbox_Number: " + inbox_Number);
//    }
//    
//    private static void Make_Set_Collision_OnOff(Make_Set receivedData) {
//        byte collsion_on_off_enable = receivedData.getCollisionOnOffEnable();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Collision_On_Off_Enable: " + collsion_on_off_enable);
//    }
//
//    private static void Make_Set_Serial_Configuration(Make_Set receivedData) {
//        byte serial_Configuration_Device = receivedData.getSerialConfigurationDevice();
//        byte serial_Configuration_Baud_Rate = receivedData.getSerialConfigurationBaudRate();
//        byte serial_Configuration_Stop_Bit = receivedData.getSerialConfigurationStopBit();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Serial_Configuration_Device: " + serial_Configuration_Device);
//        System.out.println("Serial_Configuration_Baud_Rate: " + serial_Configuration_Baud_Rate);
//        System.out.println("Serial_Configuration_Stop_Bit: " + serial_Configuration_Stop_Bit);
//    }
//
//    private static void Make_Set_Speed_Bar_Control(Make_Set receivedData) {
//        float speed_Bar_Speen_Bar = receivedData.getSpeedBarSpeenBar();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Speed_Bar_Speen_Bar: " + speed_Bar_Speen_Bar);
//    }
//
//    private static void Make_Set_Collision_Stop_Mode(Make_Set receivedData) {
//        byte collsion_stop_Mode = receivedData.getCollisionStopMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Collision_Stop_Mode: " + collsion_stop_Mode);
//    }
//
//    private static void Make_Set_UserCoordinate_Shift(Make_Set receivedData) {
//        byte user_Coordinate_Shift_User_Coordinate = receivedData.getUserCoordinateShiftUserCoordinate();
//        byte user_Coordinate_Shift_Shift_Reference_Coordinate = receivedData.getUserCoordinateShiftShiftReferenceCoordinate();
//        float user_Coordinate_Shift_x = receivedData.getUserCoordinateShiftX();
//        float user_Coordinate_Shift_y = receivedData.getUserCoordinateShiftY();
//        float user_Coordinate_Shift_z = receivedData.getUserCoordinateShiftZ();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("User_Coordinate_Shift_User_Coordinate: " + user_Coordinate_Shift_User_Coordinate);
//        System.out.println("User_Coordinate_Shift_Shift_Reference_Coordinate: " + user_Coordinate_Shift_Shift_Reference_Coordinate);
//        System.out.println("User_Coordinate_Shift_X: " + user_Coordinate_Shift_x);
//        System.out.println("User_Coordinate_Shift_Y: " + user_Coordinate_Shift_y);
//        System.out.println("User_Coordinate_Shift_Z: " + user_Coordinate_Shift_z);
//    }
//
//    private static void Make_Set_After_Collision_Detect(Make_Set receivedData) {
//        byte after_Collision_Detect_Mode = receivedData.getAfterCollisionDetectMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("After_Collision_Detect_Mode: " + after_Collision_Detect_Mode);
//    }
//
//    private static void Make_Set_Disable_Box_D_Out(Make_Set receivedData) {
//        byte disable_Box_Mode = receivedData.getDisableBoxMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Disable_Box_Mode: " + disable_Box_Mode);
//    }
//
//    private static void Make_Set_User_Coordinate_Config(Make_Set receivedData) {
//        byte user_Coordinate_Config_User_Coord = receivedData.getUserCoordinateConfigUserCoord();
//        byte user_Coordinate_Config_Temporory = receivedData.getUserCoordinateConfigTemporory();
//        byte user_Coordinate_Config_Option = receivedData.getUserCoordinateConfigOption();
//        byte user_Coordinate_Config_Point1 = receivedData.getUserCoordinateConfigPoint1();
//        byte user_Coordinate_Config_Point2 = receivedData.getUserCoordinateConfigPoint2();
//        byte user_Coordinate_Config_Point3 = receivedData.getUserCoordinateConfigPoint3();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("User_Coordinate_Config_User_Coord: " + user_Coordinate_Config_User_Coord);
//        System.out.println("User_Coordinate_Config_Temporory: " + user_Coordinate_Config_Temporory);
//        System.out.println("User_Coordinate_Config_Option: " + user_Coordinate_Config_Option);
//        System.out.println("User_Coordinate_Config_Point1: " + user_Coordinate_Config_Point1);
//        System.out.println("User_Coordinate_Config_Point2: " + user_Coordinate_Config_Point2);
//        System.out.println("User_Coordinate_Config_Point3: " + user_Coordinate_Config_Point3);
//    }
//
//    private static void Make_Set_Vibration_Senosor(Make_Set receivedData) {
//        byte vibration_Senosor_Mode = receivedData.getVibrationSenosorMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Vibration_Senosor_Mode: " + vibration_Senosor_Mode);
//    }
//
//    private static void Make_Set_High_Acceleration_Mode(Make_Set receivedData) {
//        byte high_Acceleration_Mode = receivedData.getHighAccelerationMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("High_Acceleration_Mode: " + high_Acceleration_Mode);
//    }
//
//    private static void Make_Set_High_Sensitivity_Detect(Make_Set receivedData) {
//        byte high_Sensitivity_Mode = receivedData.getHighSensitivityMode();
//
//        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("High_Sensitivity_Mode: " + high_Sensitivity_Mode);
//    }
//    
//    private static void Make_Set_No_Arc_Move_Speed(Make_Set receivedData) {
//    	float no_Arc_Move_Speed_Vel = receivedData.getNoArcMoveSpeedVel();
//    	float no_Arc_Move_Speed_ACC = receivedData.getNoArcMoveSpeedACC();
//    	
//    	System.out.println("Main Command Type: " + receivedData.getMainCommandType());
//        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
//        System.out.println("Move Speed Vel: " + no_Arc_Move_Speed_Vel);
//        System.out.println("Move Speed ACC: " + no_Arc_Move_Speed_ACC);
//    }
//}
