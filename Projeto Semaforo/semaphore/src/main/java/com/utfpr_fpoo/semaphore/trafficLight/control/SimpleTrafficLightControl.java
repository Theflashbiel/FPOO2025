package com.utfpr_fpoo.semaphore.trafficLight.control;

import java.util.TimerTask;

import com.utfpr_fpoo.semaphore.spot.SpotLight;
import com.utfpr_fpoo.semaphore.trafficLight.TrafficLight;
import com.utfpr_fpoo.semaphore.trafficLight.control.TrafficLightControl.State;
import com.utfpr_fpoo.semaphore.util.TurnOnOff;

import java.util.Timer;
import java.util.TimerTask;

public class SimpleTrafficLightControl implements TrafficLightControl {
    
    private final TrafficLight trafficLight;
    private final TurnOnOff green, yellow, red;

    private State state = State.OFF;
    
    private Timer timer = null;
    private TimerTask task;

    public SimpleTrafficLightControl(TrafficLight trafficLight) {
        this.trafficLight = trafficLight;

        this.green = trafficLight.spotGreen();
        this.yellow = trafficLight.spotYellow();
        this.red = trafficLight.spotRed();

    }

    public void reset(){

        if (state == State.ALERT)
            stopAlert();

        green.turnOff();
        yellow.turnOff();
        red.turnOff();

        state = State.OFF;
    }
    private void configureAlert() {
        
        

        task = new TimerTask() {

            @Override
            public void run() {

                if (yellow.isOn())
                    yellow.turnOff();

                else
                    yellow.turnOn();

            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(task, 0, 2_000);
    }

    private void stopAlert() {
       
        if (timer != null) {
            timer.cancel();
           yellow.turnOff();
        }
    }

    @Override
    public void turnAlert() {
        if (state == State.ALERT)
            return;
        
        this.reset();
        this.configureAlert();
        state = State.ALERT;
    }

    @Override
    public void turnGreen() {
       
        this.reset();
        green.turnOn();
        state = State.GREEN;
    }

    @Override
    public void turnYellow() {
      
        this.reset();
        yellow.turnOn();
        state = State.YELLOW;
    }

    @Override
    public void turnRed() {
        this.reset();
        red.turnOn();
        state = State.RED;
    }

    @Override
    public void turnOff() {

        this.reset();

    }
}
