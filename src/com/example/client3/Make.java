package com.example.client3;

import java.io.Serializable;

public class Make implements Serializable {
    private static final long serialVersionUID = 1L;
    private byte mainCommandType;
    private byte subCommandType;
    private float x;
    private float y;
    private float z;
    private float rx;
    private float ry;
    private float rz;
    private float Dist;
    private float Ori;
    private float Joint;
    private float Base;
    private float Shoulder;
    private float Elbow;
    private float Wrist1;
    private float Wrist2;
    private float Wrist3;
    


    public Make() {
    	this.mainCommandType = 0;
        this.subCommandType = 0;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.rx = 0.0f;
        this.ry = 0.0f;
        this.rz = 0.0f;
        this.Dist = 0.0f;
        this.Ori = 0.0f;
        this.Joint = 0.0f;
        this.Base = 0.0f;
        this.Shoulder = 0.0f;
        this.Elbow = 0.0f;
        this.Wrist1 = 0.0f;
        this.Wrist2 = 0.0f;
        this.Wrist3 = 0.0f;
    }
    
    public static Make initializeWithDefaults(byte mainCommandType, byte subCommandType) {
        Make make = new Make();
        make.mainCommandType = mainCommandType;
        make.subCommandType = subCommandType;
        return make;
    }




    public byte getMainCommandType() {
        return mainCommandType;
    }

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

    public float getRX() {
        return rx;
    }

    public float getRY() {
        return ry;
    }

    public float getRZ() {
        return rz;
    }
    public float getDist() {
        return Dist;
    }

    public float getOri() {
        return Ori;
    }

    public float getJoint() {
        return Joint;
    }
    public float getBase() {
        return Base;
    }
    public float getShoulder() {
        return Shoulder;
    }
    public float getElbow() {
        return Elbow;
    }
    public float getWrist1() {
        return Wrist1;
    }
    public float getWrist2() {
        return Wrist2;
    }
    public float getWrist3() {
        return Wrist3;
    }
}