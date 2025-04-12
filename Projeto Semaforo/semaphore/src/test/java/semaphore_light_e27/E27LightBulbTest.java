package semaphore_light_e27;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.utfpr_fpoo.semaphore_light.Light;
import com.utfpr_fpoo.semaphore_light.e27.E27LightBulb;


 class E27LightBulbTest {
    
    @Test
    void shouldTurnOn (){
        
        //given 
        Light light = new E27LightBulb();
        //do Action
        light.turnOff();
        light.turnOn();
        //check
        assertTrue(light.isOn());
    }
    @Test
    void shouldTurnOff (){
        
        //given 
        Light light = new E27LightBulb();
        //do Action
        light.turnOn();
        light.turnOff();
        //check
        assertTrue(light.isOff());
    }
 
}
