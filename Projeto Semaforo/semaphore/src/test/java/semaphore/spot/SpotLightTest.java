package semaphore.spot;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.utfpr_fpoo.semaphore.light.e27.AbstractLightE27;
import com.utfpr_fpoo.semaphore.spot.SpotLight;

class SpotLightTest {
    @Test
    void shouldTurnOn (){

    AbstractLightE27 light = new AbstractLightE27();
    SpotLight spot = new SpotLight(null);
    spot.setLight(light);

    light.turnOn();
    spot.turnOn();

    assertTrue(light.isOn());
    assertTrue(spot.isOn());
    }
    @Test
    void shouldTurnOff (){

    AbstractLightE27 light = new AbstractLightE27();
    SpotLight spot = new SpotLight(null);
    spot.setLight(light);

    light.turnOff();
    spot.turnOff();

    assertTrue(light.isOff());
    assertTrue(spot.isOff());
    }
}
