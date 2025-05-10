package com.utfpr_fpoo.semaphore.trafficLight.control;

import java.util.TimerTask;

import com.utfpr_fpoo.semaphore.spot.SpotLight;
import com.utfpr_fpoo.semaphore.trafficLight.TrafficLight;
import com.utfpr_fpoo.semaphore.trafficLight.control.TrafficLightControl.State;
import java.util.Timer;
import java.util.TimerTask;

public class SimpleTrafficLightControl implements TrafficLightControl {
    
    final TrafficLight trafficLight;
    State state = State.OFF;
    
    private Timer timer;
    private TimerTask task;

    public SimpleTrafficLightControl(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;
    }

    private void configureAlert() {
        
        

        task = new TimerTask() {

            @Override
            public void run() {

                if (trafficLight.spotYellow().isOn())
                    trafficLight.spotYellow().turnOff();

                else
                    trafficLight.spotYellow().turnOn();

            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 2_000);
    }

    private void stopAlert() {
       
        if (timer != null) {
            timer.cancel();
           
        }
    }

    @Override
    public void turnAlert() {
        this.state = State.ALERT;
        trafficLight.spotGreen().turnOff();
        trafficLight.spotYellow().turnOn();
        trafficLight.spotRed().turnOff();

        configureAlert();
    }

    @Override
    public void turnGreen() {
        if (state == State.ALERT){
            stopAlert();
        }
        
        this.state = State.GREEN;
        trafficLight.spotGreen().turnOn();
        trafficLight.spotYellow().turnOff();
        trafficLight.spotRed().turnOff();
    }

    @Override
    public void turnYellow() {
         if (state == State.ALERT){
            stopAlert();
        }
        this.state = State.YELLOW;
        trafficLight.spotGreen().turnOff();
        trafficLight.spotYellow().turnOn();
        trafficLight.spotRed().turnOff();
    }

    @Override
    public void turnRed() {
         if (state == State.ALERT){
            stopAlert();
        }
        this.state = State.RED;
        trafficLight.spotGreen().turnOff();
        trafficLight.spotYellow().turnOff();
        trafficLight.spotRed().turnOn();
    }

    @Override
    public void turnOff() {
         if (state == State.ALERT){
            stopAlert();
        }
        this.state = State.OFF;
        trafficLight.spotGreen().turnOff();
        trafficLight.spotYellow().turnOff();
        trafficLight.spotRed().turnOff();

    }

}
