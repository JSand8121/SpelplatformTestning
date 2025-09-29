import com.sun.tools.javac.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.JUnitException;
import platform.HighScoreHandler;
import platform.Score;

import java.io.FileNotFoundException;
import java.io.InvalidObjectException;
import java.io.StreamCorruptedException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for HighScoreHandler methods
 * */
public class HighScoreHandlerTest {
    private HighScoreHandler scoreHandler;

    @BeforeEach
    public void setupHighScore(){
        scoreHandler = new HighScoreHandler();
    }

    @Test
    public void givenNoFileFound_whenLoadingHighScore_thenErrorMessageShown(){
        //Setup
        scoreHandler = new HighScoreHandler("Not Valid URL");

        //Test
        FileNotFoundException expectedException = assertThrows(FileNotFoundException.class, () -> scoreHandler.getHighScores());

        //Conclusion
        assertEquals("File Not Found", expectedException.getMessage());
    }

    @Test
    public void givenCorruptedFile_whenLoadingHighScore_thenErrorMessageShown() {
        //Setup
        scoreHandler = new HighScoreHandler("../intentionallyCorruptedFile.txt");

        //Test
        StreamCorruptedException expectedException = assertThrows(StreamCorruptedException.class, () -> scoreHandler.getHighScores());

        //Conclusion
        assertEquals("Could not read file", expectedException.getMessage());
    }

    @Test
    public void  givenNewHighScoreAsInput_whenSavingHighScore_thenScoreSavedSuccessfully(){
        //Setup
        Score newGoodScore = new Score("New Player", 1000);
        boolean actualSuccess = false;

        //Test
        try {
           actualSuccess = scoreHandler.addNewScore(newGoodScore);
        } catch (Exception e) {
            fail();
        }

        //Conclusion
        assertTrue(actualSuccess);
    }

    @Test
    public void givenBadDataAsInput_whenSavingHighScore_thenErrorMessageShown(){
        //Setup
        Score newBadScore = new Score("", -10000);
        InvalidObjectException actualException;

        //Test
        actualException = assertThrows(InvalidObjectException.class, () -> scoreHandler.addNewScore(newBadScore));

        //Conclusion
        assertEquals("Something Went Wrong", actualException.getMessage());
    }


}
