package iloveyouboss;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

import iloveyouboss.ScoreCollection;

public class ScoreCollectionTest{

    @Test
    public void test(){
        //fail("まだ実装されていません。");
    }

    @Test
    public void answersArthmeticMeanOfTwoNumbars(){
        //Arrange
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 7);
        collection.add(() -> 5);

        //Act
        int actualResult = collection.arithmeticMean();

        //Assert
        assertThat(actualResult,equalTo(6));
    }
}