package com.utfpr_fpoo.semaphore.trafficLight;

import com.utfpr_fpoo.semaphore.util.TurnOnOff;

public interface TrafficLight {

    TurnOnOff spotGreen();
    TurnOnOff spotYellow();
    TurnOnOff spotRed();
} 
