package Platform;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Klass för att testa MenuHandler-klassens metoder i spelPlatform
 * */
class MenuHandlerTest {

    @Test
    @DisplayName("Börja rätt spel från meny")
    public void showGameWouu(){
        //Setup
        MenuHandler muHandler = new MenuHandler();
        String[] mockArgs = {"",""};
        //Simulated input
        String userSelection4 = "4";
        ByteArrayInputStream testInput = new ByteArrayInputStream(userSelection4.getBytes());
        System.setIn(testInput);

        //Test
        muHandler.RunMenu(mockArgs);

    }
}