package com.utfpr_fpoo;

import com.utfpr_fpoo.semaphore.light.AbstractLight;

public class Main {

    public static void main (String[] args){
        AbstractLight simpleLight = new AbstractLight();
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