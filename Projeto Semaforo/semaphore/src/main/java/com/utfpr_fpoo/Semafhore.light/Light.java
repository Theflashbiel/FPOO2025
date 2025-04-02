package com.utfpr_fpoo.Semafhore.light;

public interface Light {

    enum OnOff{ON,OFF};

    void turnOn();
    void turnOff();

    boolean isOn();
    boolean isOff();
    
}
