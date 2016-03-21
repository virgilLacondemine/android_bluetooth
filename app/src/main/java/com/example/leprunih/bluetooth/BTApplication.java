package com.example.leprunih.bluetooth;

import android.app.Application;
import android.content.Context;

import java.io.IOException;

import fr.iutvalence.android.BTConnectionHandlerLib.BTConnectionHandler;
import fr.iutvalence.android.BTConnectionHandlerLib.exceptions.BTHandlingException;

/**
 * Created by leprunih on 11/03/16.
 */
public class BTApplication extends Application{
    private BTConnectionHandler bluetooth;

    public BTApplication(Context context){
        super();
        this.bluetooth = new BTConnectionHandler(context);

    }

    public BTApplication() {
        super();
        this.bluetooth = new BTConnectionHandler();
    }


    public BTConnectionHandler getBluetooth(){
        return this.bluetooth;
    }

}
