package com.utfpr_fpoo.semaphore.util;

public interface TurnOnOff {
    
    enum OnOff{ON,OFF};

    void turnOn();
    void turnOff();

    boolean isOn();
    boolean isOff();

}
