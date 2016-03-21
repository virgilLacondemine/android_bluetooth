package com.example.leprunih.bluetooth;

import android.app.Activity;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

import fr.iutvalence.android.BTConnectionHandlerLib.BTConnectionHandler;
import fr.iutvalence.android.BTConnectionHandlerLib.exceptions.BTHandlingException;

import static com.example.leprunih.bluetooth.R.*;

/**
 * Created by leprunih on 04/03/16.
 */
public class MakeBlockBluetooth extends Activity{

    private EditText command;
    private EditText deviceName;
    private Button send;
    private Button connect;
    private Button disconnect;
    private Button up;
    private Button left;
    private Button stop;
    private Button right;
    private Button down;
    private BTConnectionHandler bluetooth;
    //private JoystickView joystick;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeblockbluetooth);

        final BTApplication BTApp = (BTApplication) getApplication();
        this.bluetooth = BTApp.getBluetooth();

        this.setLayout();

        //this.joystick = new JoystickView(this);
        //this.addContentView(this.joystick, this.joystick.getLayoutParams());
        //this.joystick.onDraw(new Canvas());

        this.setListener();


    }

    public void setLayout(){
        this.command = (EditText) findViewById(id.commandField);
        this.deviceName = (EditText) findViewById(id.deviceNameField);
        this.send = (Button) findViewById(id.sendButton);
        this.connect = (Button) findViewById(id.connectButton);
        this.disconnect = (Button) findViewById(id.disconnectButton);
        this.up = (Button) findViewById(id.up_button);
        this.down = (Button) findViewById(id.down_button);
        this.left = (Button) findViewById(id.left_button);
        this.right = (Button) findViewById(id.right_button);
        this.stop = (Button) findViewById(id.stop_button);

    }

    public void setListener(){
        this.connect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.connectToBTDevice(deviceName.getText().toString());
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        this.disconnect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bluetooth.closeConnection();
            }
        });
        this.send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.sendData(command.getText().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                }
            }
        });

        this.up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.sendData("a");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                }
            }
        });

        this.down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.sendData("r");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                }
            }
        });


        this.left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.sendData("g");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                }
            }
        });

        this.right.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.sendData("d");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                }
            }
        }));

        this.stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    bluetooth.sendData("s");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (BTHandlingException e) {
                    e.printStackTrace();
                }
            }
        });
    }


}
