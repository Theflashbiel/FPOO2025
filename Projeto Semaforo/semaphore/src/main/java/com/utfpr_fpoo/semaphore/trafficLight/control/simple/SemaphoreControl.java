package com.utfpr_fpoo.semaphore.trafficLight.control.simple;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.utfpr_fpoo.semaphore.trafficLight.control.TrafficLightControl;
import com.utfpr_fpoo.semaphore.util.TurnOnOff;

public interface SemaphoreControl extends TurnOnOff{

        void setGreenSeconds(int seconds);
        void setYellowSeconds(int seconds);
        void setRedSeconds(int seconds);

        void setAlertPeriod (LocalTime start, LocalTime end);
}

