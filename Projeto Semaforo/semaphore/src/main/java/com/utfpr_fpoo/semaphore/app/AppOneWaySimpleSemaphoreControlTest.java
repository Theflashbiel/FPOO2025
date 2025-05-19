package com.utfpr_fpoo.semaphore.app;

import java.io.IOException;
import java.time.LocalTime;

import com.utfpr_fpoo.semaphore.trafficLight.control.SimpleTrafficLightControl;
import com.utfpr_fpoo.semaphore.trafficLight.control.TrafficLightControl;
import com.utfpr_fpoo.semaphore.trafficLight.control.simple.SemaphoreControl;
import com.utfpr_fpoo.semaphore.trafficLight.simple.SimpleTrafficLight;
import com.utfpr_fpoo.semaphore.util.gui.MyWindow;
import com.utfpr_fpoo.semaphore.trafficLight.control.simple.OneWaySemaphoreControl;

public class AppOneWaySimpleSemaphoreControlTest {
    
    static private void oneWaySimpleSemaphoreTest() throws IOException {

        SimpleTrafficLight defauteOne = new SimpleTrafficLight();
        TrafficLightControl trafficLightControl = new SimpleTrafficLightControl(defauteOne);
        SemaphoreControl semaphoreControl = new OneWaySemaphoreControl(trafficLightControl);

        semaphoreControl.setAlertPeriod(LocalTime.now(), LocalTime.now().plusSeconds(30));
        semaphoreControl.turnOn();

        MyWindow window = new MyWindow();
        window.add(defauteOne);

     }
    
    static public void main (String[] args) throws IOException{

        oneWaySimpleSemaphoreTest();
    }
}
