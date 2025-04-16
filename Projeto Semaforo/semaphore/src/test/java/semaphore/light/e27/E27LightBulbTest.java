package semaphore.light.e27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.utfpr_fpoo.semaphore.light.e27.E27LightBulb;
import com.utfpr_fpoo.semaphore.util.TurnOnOff;


 class E27LightBulbTest {
    
    @Test
    void shouldTurnOn (){
        
        //given 
        TurnOnOff light = new E27LightBulb();
        //do Action
        light.turnOff();
        light.turnOn();
        //check
        assertTrue(light.isOn());
    }
    @Test
    void shouldTurnOff (){
        
        //given 
        TurnOnOff light = new E27LightBulb();
        //do Action
        light.turnOn();
        light.turnOff();
        //check
        assertTrue(light.isOff());
    }
 
}
