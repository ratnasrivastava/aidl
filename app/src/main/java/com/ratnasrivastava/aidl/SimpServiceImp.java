package com.ratnasrivastava.aidl;

import android.os.RemoteException;

import com.ratnasrivastava.mylib.ISimp;

public class SimpServiceImp extends ISimp.Stub {
    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public int sub(int a, int b) throws RemoteException {
        return a - b;
    }
}
