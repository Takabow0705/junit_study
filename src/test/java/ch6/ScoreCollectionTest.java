package ch6;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.*;

import ch6.ScoreCollection;

public class ScoreCollectionTest{
    private ScoreCollection collection;

    @Before
    public void create(){
        collection = new ScoreCollection();
    }
    @Test
    public void test(){
        //fail("まだ実装されていません。");
    }

    @Test
    public void answersArthmeticMeanOfTwoNumbars(){
        //Arrange
        //ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 7);
        collection.add(() -> 5);

        //Act
        int actualResult = collection.arithmeticMean();

        //Assert
        assertThat(actualResult,equalTo(6));
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void throwsExceptionWhenAddingNull(){
        collection.add(null);
    }

    @Test
    public void whenCollectionIsEmptyReturnZero(){
        assertThat(collection.arithmeticMean(),equalTo(0));
    }

    @Test
    public void dealsWithIntegerOverflow(){
        collection.add(() -> Integer.MAX_VALUE);
        collection.add(() -> 1);

        assertThat(collection.arithmeticMean(),equalTo(1073741824));
    }
}