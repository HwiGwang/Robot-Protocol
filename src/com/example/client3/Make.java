package com.example.client3;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class Make implements Serializable {
    private static final long serialVersionUID = 1L;
    private byte mainCommandType;

    public Make(byte mainCommandType) {
        this.mainCommandType = mainCommandType;
    }

    public byte getMainCommandType() {
        return mainCommandType;
    }

    // Abstract method for getting output based on MainCommandType
    public abstract byte getSubCommandType();

    public abstract byte[] getBytes();
}

class Make_Jog extends Make {
    private byte subCommandType;
    private Robo_Position robo_Position;


    public Make_Jog(byte[] readBytes) {
        super(readBytes[0]);

        ByteBuffer buffer = ByteBuffer.wrap(readBytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.get();

        this.subCommandType = buffer.get();
        this.robo_Position = new Robo_Position();
        
        if (getMainCommandType() == 0x00) {
            // 기존 global 변수 사용
            this.robo_Position.global_x = buffer.getFloat();
            this.robo_Position.global_y = buffer.getFloat();
            this.robo_Position.global_z = buffer.getFloat();
            this.robo_Position.global_Rx = buffer.getFloat();
            this.robo_Position.global_Ry = buffer.getFloat();
            this.robo_Position.global_Rz = buffer.getFloat();
        }else if(getMainCommandType() == 0x01) {
            this.robo_Position.local_x = buffer.getFloat();
            this.robo_Position.local_y = buffer.getFloat();
            this.robo_Position.local_z = buffer.getFloat();
            this.robo_Position.local_Rx = buffer.getFloat();
            this.robo_Position.local_Ry = buffer.getFloat();
            this.robo_Position.local_Rz = buffer.getFloat();
        }else if(getMainCommandType() == 0X02) {
            // user 변수로 변경
            this.robo_Position.user_x = buffer.getFloat();
            this.robo_Position.user_y = buffer.getFloat();
            this.robo_Position.user_z = buffer.getFloat();
            this.robo_Position.user_Rx = buffer.getFloat();
            this.robo_Position.user_Ry = buffer.getFloat();
            this.robo_Position.user_Rz = buffer.getFloat();
        }

        this.robo_Position.dist = buffer.getFloat();
        this.robo_Position.ori = buffer.getFloat();
        this.robo_Position.joint = buffer.getFloat();

    }
    @Override
    public byte getSubCommandType() {
        return subCommandType;
    }
    
    public Robo_Position getRoboPosition() {
    	return robo_Position;
    }
    


    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(39);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(getMainCommandType());
        buffer.put(getSubCommandType());
        
        if (getMainCommandType() == 0x00) {
            // 기존 global 변수 사용
            buffer.putFloat(robo_Position.global_x);
            buffer.putFloat(robo_Position.global_y);
            buffer.putFloat(robo_Position.global_z);
            buffer.putFloat(robo_Position.global_Rx);
            buffer.putFloat(robo_Position.global_Ry);
            buffer.putFloat(robo_Position.global_Rz);
        } else if (getMainCommandType() == 0x02) {
            // user 변수로 변경
            buffer.putFloat(robo_Position.user_x);
            buffer.putFloat(robo_Position.user_y);
            buffer.putFloat(robo_Position.user_z);
            buffer.putFloat(robo_Position.user_Rx);
            buffer.putFloat(robo_Position.user_Ry);
            buffer.putFloat(robo_Position.user_Rz);
        } else if (getMainCommandType() == 0x01) {
            buffer.putFloat(robo_Position.local_x);
            buffer.putFloat(robo_Position.local_y);
            buffer.putFloat(robo_Position.local_z);
            buffer.putFloat(robo_Position.local_Rx);
            buffer.putFloat(robo_Position.local_Ry);
            buffer.putFloat(robo_Position.local_Rz);
        }
        
        buffer.putFloat(robo_Position.dist);
        buffer.putFloat(robo_Position.ori);
        buffer.putFloat(robo_Position.joint);
        buffer.put((byte) 0x00); // 예약된 바이트

        return buffer.array();
    }
    
}

class Make_Joint extends Make {
    private byte subCommandType;
    private Robo_Position robo_Position;


    public Make_Joint(byte[] readBytes) {
        super(readBytes[0]);

        ByteBuffer buffer = ByteBuffer.wrap(readBytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.get();

        this.subCommandType = buffer.get();
        this.robo_Position = new Robo_Position();
        this.robo_Position.joint1 = buffer.getFloat();
        this.robo_Position.joint2 = buffer.getFloat();
        this.robo_Position.joint3 = buffer.getFloat();
        this.robo_Position.joint4 = buffer.getFloat();

        // 추가된 부분: dist, ori, joint 데이터를 읽음
        this.robo_Position.dist = buffer.getFloat();
        this.robo_Position.ori = buffer.getFloat();
        this.robo_Position.joint = buffer.getFloat();
    }
    
    @Override
    public byte getSubCommandType() {
        return subCommandType;
    }

    public Robo_Position getRoboPosition() {
    	return robo_Position;
    }
    

    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(31);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(getMainCommandType());
        buffer.put(getSubCommandType());
        buffer.putFloat(robo_Position.joint1);
        buffer.putFloat(robo_Position.joint2);
        buffer.putFloat(robo_Position.joint3);
        buffer.putFloat(robo_Position.joint4);
        buffer.putFloat(robo_Position.dist);
        buffer.putFloat(robo_Position.ori);
        buffer.putFloat(robo_Position.joint);
        buffer.put((byte) 0x00); // 예약된 바이트

        return buffer.array();
    }

}

class Make_RoboCoordiante extends Make{
	
	private byte subCommandType;
    private Robo_Position robo_Position;
    private float DigitalOut;

    public Make_RoboCoordiante(byte[] readBytes) {
        super(readBytes[0]);

        ByteBuffer buffer = ByteBuffer.wrap(readBytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.get();

        this.subCommandType = buffer.get();
        this.robo_Position.joint1 = buffer.getFloat();
        this.robo_Position.joint2 = buffer.getFloat();
        this.robo_Position.joint3 = buffer.getFloat();
        this.robo_Position.joint4 = buffer.getFloat();
        this.DigitalOut = buffer.getFloat();

    }
    @Override
    public byte getSubCommandType() {
        return subCommandType;
    }

    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(19);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(getMainCommandType());
        buffer.put(getSubCommandType());
        buffer.putFloat(robo_Position.joint1);
        buffer.putFloat(robo_Position.joint2);
        buffer.putFloat(robo_Position.joint3);
        buffer.putFloat(robo_Position.joint4);
        buffer.putFloat(DigitalOut);
        buffer.put((byte) 0x00); // 예약된 바이트

        return buffer.array();
    }
}
