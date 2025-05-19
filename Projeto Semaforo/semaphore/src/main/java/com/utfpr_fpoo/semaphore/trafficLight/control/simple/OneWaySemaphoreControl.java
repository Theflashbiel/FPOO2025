package com.utfpr_fpoo.semaphore.trafficLight.control.simple;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.utfpr_fpoo.semaphore.trafficLight.control.TrafficLightControl;

public class OneWaySemaphoreControl implements SemaphoreControl {

    private List<TrafficLightControl> trafficsLights = new ArrayList<>();

    private int greenMillis = 10000;
    private int yellowMillis = 2000;
    private int redMillis = 5000;

    private LocalTime alertStart = LocalTime.of(0, 0);
    private LocalTime alertEnd = LocalTime.of(0, 0);

    private OnOff state = OnOff.OFF;

    public OneWaySemaphoreControl(List<TrafficLightControl> trafficLights) {

        this.trafficsLights = trafficLights;
    }

    public OneWaySemaphoreControl(TrafficLightControl... trafficLights) {

        this(Arrays.asList(trafficLights));
    }

    private boolean isAlertPeriod() {

        boolean START_MIDNIGHT_END = alertStart.isAfter(alertEnd);

        LocalTime now = LocalTime.now();

        if (START_MIDNIGHT_END)
            return (now.isAfter(alertStart) || now.isBefore(alertEnd));

        return (now.isAfter(alertStart) && now.isBefore(alertEnd));
    }

    private void doAlert() throws InterruptedException {
        while (isAlertPeriod()) {

            trafficsLights.forEach(e -> e.turnAlert());
            Thread.sleep(1000);
        }
    }

    private void doYellowRedGreen() throws InterruptedException {

        trafficsLights.forEach(e -> e.turnGreen());
        Thread.sleep(greenMillis);

        trafficsLights.forEach(e -> e.turnYellow());
        Thread.sleep(yellowMillis);

        trafficsLights.forEach(e -> e.turnRed());
        Thread.sleep(redMillis);
    }

    private void run() {
        Runnable runnable = () -> {
            while (state == OnOff.ON) {
                try {
                    doAlert();
                    doYellowRedGreen();
                } catch (InterruptedException exception) {
                    trafficsLights.forEach(e -> e.turnAlert());
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }

    @Override
    public void turnOn() {
        this.state = OnOff.ON;
        run();
    }

    @Override
    public void turnOff() {
        this.state = OnOff.OFF;
    }

    @Override
    public boolean isOn() {
        return this.state == OnOff.ON;
    }

    @Override
    public boolean isOff() {
        return this.state == OnOff.OFF;
    }

    @Override
    public void setGreenSeconds(int seconds) {

        this.greenMillis = seconds * 1_000;
    }

    @Override
    public void setYellowSeconds(int seconds) {

        this.yellowMillis = seconds * 1_000;
    }

    @Override
    public void setRedSeconds(int seconds) {
        this.redMillis = seconds * 1_000;
    }

    @Override
    public void setAlertPeriod(LocalTime start, LocalTime end) {

        this.alertStart = start;
        this.alertEnd = end;
    }
}