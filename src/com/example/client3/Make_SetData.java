package com.example.client3;


public class Make_SetData {
    public static void Make_Set_Command(Make_Set receivedData) {
        byte subCommandType = receivedData.getSubCommandType();

        if (subCommandType == 0x00) { // 충돌감도 조절
            Make_Set_Threshold(receivedData);
        } else if (subCommandType == 0x01) { // Tcp하중
            Make_Set_Tcppayload(receivedData);
        } else if (subCommandType == 0x02) { // 동작오프렛
            Make_Set_MoveOffset(receivedData);

        } else if (subCommandType == 0x03) { // 인박스
            Make_Set_Inbox(receivedData);

        } else if (subCommandType == 0x04) { // TCP 좌표 임시 설정
            Make_Set_Tcppposistion(receivedData);

        } else if (subCommandType == 0x05) { // 툴 안전영역 설정
            Make_Set_CollisionBox(receivedData);

        } else if (subCommandType == 0x06) { // 작업 안전영역 설정
            Make_Set_Workspace(receivedData);

        }

    }

    private static void Make_Set_Threshold(Make_Set receivedData) {
        float threshold = receivedData.getThreshold();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Threshold: " + threshold);
    }

    private static void Make_Set_Tcppayload(Make_Set receivedData) {
        float mass = receivedData.getMass();
        float mass_x = receivedData.getMassX();
        float mass_y = receivedData.getMassY();
        float mass_z = receivedData.getMassZ();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Mass: " + mass);
        System.out.println("Mass_X: " + mass_x);
        System.out.println("Mass_Y: " + mass_y);
        System.out.println("Mass_Z: " + mass_z);

    }

    private static void Make_Set_MoveOffset(Make_Set receivedData) {
        float base_x = receivedData.getBaseX();
        float base_y = receivedData.getBaseY();
        float base_z = receivedData.getBaseZ();
        float base_rx = receivedData.getBaseRX();
        float base_ry = receivedData.getBaseRY();
        float base_rz = receivedData.getBaseRZ();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Base_X: " + base_x);
        System.out.println("Base_Y: " + base_y);
        System.out.println("Base_Z: " + base_z);
        System.out.println("Base_RX: " + base_rx);
        System.out.println("Base_RY: " + base_ry);
        System.out.println("Base_RZ: " + base_rz);
    }

    private static void Make_Set_Inbox(Make_Set receivedData) {
        byte inbox_Box = receivedData.getInboxBox();
        byte inbox_Mode = receivedData.getInboxMode();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Inbox_Box: " + inbox_Box);
        System.out.println("Inbox_Mode: " + inbox_Mode);
    }

    private static void Make_Set_Tcppposistion(Make_Set receivedData) {
        float tcp_x = receivedData.getTCPX();
        float tcp_y = receivedData.getTCPY();
        float tcp_z = receivedData.getTCPZ();
        float tcp_rx = receivedData.getTCPRX();
        float tcp_ry = receivedData.getTCPRY();
        float tcp_rz = receivedData.getTCPRZ();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("TCP_X: " + tcp_x);
        System.out.println("TCP_Y: " + tcp_y);
        System.out.println("TCP_Z: " + tcp_z);
        System.out.println("TCP_RX: " + tcp_rx);
        System.out.println("TCP_RY: " + tcp_ry);
        System.out.println("TCP_RZ: " + tcp_rz);
    }

    private static void Make_Set_CollisionBox(Make_Set receivedData) {
        float box_x_width = receivedData.getBoxXWidth();
        float box_y_width = receivedData.getBoxYWidth();
        float box_z_width = receivedData.getBoxZWidth();
        float box_x = receivedData.getBoxX();
        float box_y = receivedData.getBoxY();
        float box_z = receivedData.getBoxZ();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Box_X_Width: " + box_x_width);
        System.out.println("Box_Y_Width: " + box_y_width);
        System.out.println("Box_Z_Width: " + box_z_width);
        System.out.println("Box_X: " + box_x);
        System.out.println("Box_Y: " + box_y);
        System.out.println("Box_Z: " + box_z);
    }

    private static void Make_Set_Workspace(Make_Set receivedData) {
        float workspace_x_width = receivedData.getWorkspaceXWidth();
        float workspace_y_width = receivedData.getWorkspaceYWidth();
        float workspace_z_width = receivedData.getWorkspaceZWidth();
        float workspace_x = receivedData.getWorkspaceX();
        float workspace_y = receivedData.getWorkspaceY();
        float workspace_z = receivedData.getWorkspaceZ();
        byte enable_Workspace = receivedData.getEnableWorkspace();

        System.out.println("Main Command Type: " + receivedData.getMainCommandType());
        System.out.println("Sub Command Type: " + receivedData.getSubCommandType());
        System.out.println("Workspace_X_Width: " + workspace_x_width);
        System.out.println("Workspace_Y_Width: " + workspace_y_width);
        System.out.println("Workspace_Z_Width: " + workspace_z_width);
        System.out.println("Workspace_X: " + workspace_x);
        System.out.println("Workspace_Y: " + workspace_y);
        System.out.println("Workspace_Z: " + workspace_z);
        System.out.println("Enable_Workspace: " + enable_Workspace);
    }
}
