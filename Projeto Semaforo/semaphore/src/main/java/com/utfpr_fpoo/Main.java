package com.utfpr_fpoo;

import com.utfpr_fpoo.semaphore_light.SimpleLight;

public class Main {

    public static void main (String[] args){
        SimpleLight simpleLight = new SimpleLight();
        simpleLight.turnOn();
        boolean state = simpleLight.isOn();

        if(state == true) 
            {
            System.out.println("ON");
         }
        else
        {
            System.out.println("OFF");
        }
    }
    
}