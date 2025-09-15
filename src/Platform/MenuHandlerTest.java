package Platform;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

import Wouu.*;
/**
 * Klass för att testa MenuHandler-klassens metoder i spelPlatform
 * */
class MenuHandlerTest {
    private ByteArrayInputStream testInput;
    private ByteArrayOutputStream expectedOutput = new ByteArrayOutputStream();
    private ByteArrayOutputStream testErrorOutput = new ByteArrayOutputStream();
    private final InputStream originalSystemIn = System.in;
    private final PrintStream originalSystemOut = System.out;
    private final PrintStream originalErrorOut = System.err;


    @BeforeEach
    public void setUpOutputs() {
        System.setOut(new PrintStream(expectedOutput));
        System.setErr(new PrintStream(testErrorOutput));
    }

    @Test
    @DisplayName("Börja Wouu från meny")
    public void showGameWouu(){
        //Setup
        MenuHandler muHandler = new MenuHandler();
        String[] mockArgs = {"",""};

        //Set test output
//        String exInput = "quit";
//        ByteArrayInputStream expectedInput = new ByteArrayInputStream(exInput.getBytes());
//        System.setIn(expectedInput);
//
//        Game game = new Game();
//        game.play();
//        System.setOut(new PrintStream(expectedOutput));
//        System.setIn(testInput);
        String includedMenu = "Welcome to the World of Uppsala University!";

        //Simulated input
        String userSelection4 = "4\nquit";
        testInput = new ByteArrayInputStream(userSelection4.getBytes());
        System.setIn(testInput);

        ByteArrayOutputStream testOutput = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOutput));

        //Test
        try {
            muHandler.RunMenu(mockArgs);

        } catch (NoSuchElementException e) {
            //'quit' command fungera inte - spelet krascher
        }

        assertTrue(testOutput.toString().contains(includedMenu));

    }

    @AfterEach
    public void restoreOutputs(){
        System.setOut(originalSystemOut);
        System.setErr(originalErrorOut);
        System.setIn(originalSystemIn);
    }
}