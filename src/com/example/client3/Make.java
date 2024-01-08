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
    private float x;
    private float y;
    private float z;
    private float rx;
    private float ry;
    private float rz;
    private float dist;
    private float ori;
    private float joint;

    public Make_Jog(byte[] readBytes) {
        super(readBytes[0]);

        ByteBuffer buffer = ByteBuffer.wrap(readBytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.get();

        this.subCommandType = buffer.get();
        this.x = buffer.getFloat();
        this.y = buffer.getFloat();
        this.z = buffer.getFloat();
        this.rx = buffer.getFloat();
        this.ry = buffer.getFloat();
        this.rz = buffer.getFloat();
        this.dist = buffer.getFloat();
        this.ori = buffer.getFloat();
        this.joint = buffer.getFloat();
    }
    @Override
    public byte getSubCommandType() {
        return subCommandType;
    }
    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getZ() {
        return z;
    }

    public float getRx() {
        return rx;
    }

    public float getRy() {
        return ry;
    }

    public float getRz() {
        return rz;
    }

    public float getOri() {
        return ori;
    }

    public float getDist() {
        return dist;
    }

    public float getJoint() {
        return joint;
    }


    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(39);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(getMainCommandType());
        buffer.put(getSubCommandType());
        buffer.putFloat(x);
        buffer.putFloat(y);
        buffer.putFloat(z);
        buffer.putFloat(rx);
        buffer.putFloat(ry);
        buffer.putFloat(rz);
        buffer.putFloat(dist);
        buffer.putFloat(ori);
        buffer.putFloat(joint);
        buffer.put((byte) 0x00); // 예약된 바이트

        return buffer.array();
    }
    
    


}

class Make_Joint extends Make {
    private byte subCommandType;
    private float joint1;
    private float joint2;
    private float joint3;
    private float joint4;
    private float dist;
    private float ori;
    private float joint;

    public Make_Joint(byte[] readBytes) {
        super(readBytes[0]);

        ByteBuffer buffer = ByteBuffer.wrap(readBytes);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.get();

        this.subCommandType = buffer.get();
        this.joint1 = buffer.getFloat();
        this.joint2 = buffer.getFloat();
        this.joint3 = buffer.getFloat();
        this.joint4 = buffer.getFloat();
        this.dist = buffer.getFloat();
        this.ori = buffer.getFloat();
        this.joint = buffer.getFloat();
    }
    @Override
    public byte getSubCommandType() {
        return subCommandType;
    }
    public float getJoint1() {
        return joint1;
    }

    public float getJoint2() {
        return joint2;
    }
    public float getJoint3() {
        return joint3;
    }
    public float getJoint4() {
        return joint4;
    }

    public float getOri() {
        return ori;
    }

    public float getDist() {
        return dist;
    }

    public float getJoint() {
        return joint;
    }


    @Override
    public byte[] getBytes() {
        ByteBuffer buffer = ByteBuffer.allocate(31);
        buffer.order(ByteOrder.LITTLE_ENDIAN);
        buffer.put(getMainCommandType());
        buffer.put(getSubCommandType());
        buffer.putFloat(joint1);
        buffer.putFloat(joint2);
        buffer.putFloat(joint3);
        buffer.putFloat(joint4);
        buffer.putFloat(dist);
        buffer.putFloat(ori);
        buffer.putFloat(joint);
        buffer.put((byte) 0x00); // 예약된 바이트

        return buffer.array();
    }

}

