import Bysen.Bysen;
import Snake.Snake;
import org.junit.jupiter.api.*;
import platform.MenuHandler;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.*;
import java.util.Arrays;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Klass för att testa MenuHandler-klassens metoder i spelPlatform
 * */
class MenuHandlerTest {

    private Robot bot;
    private MenuHandler handler;

    @BeforeEach
    public void setUpRobot() throws AWTException {
        bot = new Robot();
        handler = new MenuHandler();
        handler.RunMenu(new String[]{});
    }

    @Test
    public void givenWouuAsInput_whenSelectedOnInterface_thenCorrectGameStarts(){
        //Setup
        String expectedClassInStack = Wouu.Game.class.getCanonicalName();
        boolean actualIsInStackTrace = false;

        //Test
        try {
            Thread.sleep(1000);

            //Game Selection
            bot.keyPress(KeyEvent.VK_4);
            bot.keyRelease(KeyEvent.VK_4);

            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            bot.waitForIdle();
            //Capture Stacktrace
            StackTraceElement[] currentStackTrace = Thread.currentThread().getStackTrace();
            actualIsInStackTrace = Arrays.stream(currentStackTrace).map(StackTraceElement::getClassName).anyMatch(expectedClassInStack::equals);

            //Quit Game
            bot.keyPress(KeyEvent.VK_Q);
            bot.keyRelease(KeyEvent.VK_Q);
            bot.keyPress(KeyEvent.VK_U);
            bot.keyRelease(KeyEvent.VK_U);
            bot.keyPress(KeyEvent.VK_I);
            bot.keyRelease(KeyEvent.VK_I);
            bot.keyPress(KeyEvent.VK_T);
            bot.keyRelease(KeyEvent.VK_T);

        } catch (NoSuchElementException e) {
            //'quit'-command fungera inte - spelet krascher istället
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //Conclusion
        assertTrue(actualIsInStackTrace);

    }


    @Test
    public void givenSnakeAsInput_whenSelectedOnInterface_thenCorrectGameStarts() throws AWTException {
        //Setup
        String expectedClassName = Snake.class.getCanonicalName();
        boolean snakeInStack = false;

        //Test
        try {

            bot.keyPress(KeyEvent.VK_3);
            bot.keyRelease(KeyEvent.VK_3);

            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            StackTraceElement[] actualStack = Thread.currentThread().getStackTrace();
            snakeInStack = Arrays.stream(actualStack).map(StackTraceElement::getClassName).anyMatch(expectedClassName::equals);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Conclusion
        Assertions.assertTrue(snakeInStack);
    }

    @Test
    public void givenBurrAsInput_whenSelectedOnInterface_thenCorrectGameStarts(){
        //Setup
        String expectedClassName = Burr.Burr.class.getCanonicalName();
        boolean burrInStack = false;

        //Test
        try {

            bot.keyPress(KeyEvent.VK_1);
            bot.keyRelease(KeyEvent.VK_1);

            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            StackTraceElement[] actualStack = Thread.currentThread().getStackTrace();
            burrInStack = Arrays.stream(actualStack).map(StackTraceElement::getClassName).anyMatch(expectedClassName::equals);

        }catch (Exception e){
            fail();
        }

        //Conclusion
        assertTrue(burrInStack);

    }

    @Test
    public void givenBysenAsInput_whenSelectedOnInterface_thenCorrectGameStarts(){
        //Setup
        String expectedClassName = Bysen.class.getCanonicalName();
        boolean bysenInStack = false;

        //Test
        try {
            bot.keyPress(KeyEvent.VK_2);
            bot.keyRelease(KeyEvent.VK_2);

            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(1000);

            StackTraceElement[] actualStack = Thread.currentThread().getStackTrace();
            bysenInStack = Arrays.stream(actualStack).map(StackTraceElement::getClassName).anyMatch(expectedClassName::equals);
        } catch (Exception e) {
            fail();
        }

        //Conclusion
        assertTrue(bysenInStack);
    }

    @Test
    public void givenInvalidChoiceAsInput_whenSelectedOnInterface_thenNothingHappens(){
        //Setup
        StackTraceElement[] expectedStack = Thread.currentThread().getStackTrace();
        StackTraceElement[] actualStack = null;

        //Test
        try {

            bot.keyPress(KeyEvent.VK_E);
            bot.keyRelease(KeyEvent.VK_E);

            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(1000);

            actualStack = Thread.currentThread().getStackTrace();

        } catch (Exception e) {
            fail();
        }

        //Conclusion
        assertArrayEquals(expectedStack, actualStack);
    }

    @Test
    public void givenNothingAsInput_whenSelectedOnInterface_thenNothingHappens(){
        //Setup
        StackTraceElement[] expectedStack = Thread.currentThread().getStackTrace();
        StackTraceElement[] actualStack = null;

        //Test
        try {
            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(1000);
            actualStack = Thread.currentThread().getStackTrace();

        } catch (InterruptedException e) {
            fail();
        }

        //Conclusion
        assertArrayEquals(expectedStack,actualStack);
    }

    @Test
    public void givenMultipleChoicesAsInput_whenSelectedOnInterface_thenNothingHappens() {
        //Setup
        StackTraceElement[] expectedStack = Thread.currentThread().getStackTrace();
        StackTraceElement[] actualStack = null;

        //Test
        try {
            bot.keyPress(KeyEvent.VK_1);
            bot.keyRelease(KeyEvent.VK_1);

            bot.wait(1000);
            bot.keyPress(KeyEvent.VK_SPACE);
            bot.keyRelease(KeyEvent.VK_SPACE);

            bot.wait(1000);
            bot.keyPress(KeyEvent.VK_2);
            bot.keyRelease(KeyEvent.VK_2);

            bot.wait(1000);
            bot.keyPress(KeyEvent.VK_SPACE);
            bot.keyRelease(KeyEvent.VK_SPACE);

            bot.wait(1000);
            bot.keyPress(KeyEvent.VK_3);
            bot.keyRelease(KeyEvent.VK_3);

            bot.wait(1000);
            bot.keyPress(KeyEvent.VK_ENTER);
            bot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(1000);

            actualStack = Thread.currentThread().getStackTrace();

        }catch (Exception e){
            fail();
        }

        assertArrayEquals(expectedStack,actualStack);
    }



    @AfterEach
    public void resetBot(){
        bot.waitForIdle();
    }
}