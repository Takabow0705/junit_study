package ch3;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.number.IsCloseTo.*;
import static org.hamcrest.CoreMatchers.*;

public class AssertHamcrestTest{
    @Test
    @Ignore
    public void assertDoubleEqual(){
        assertThat(3 * 2.32,equalTo(6.96));
    }

    @Test
    public void assertWithTolerance(){
        assertTrue(Math.abs(2.32 * 3 - 6.96) < 0.005);
    }

    @Test
    public void assertDoublesCloseTo(){
       assertThat(2.32 * 3,closeTo(6.96,0.0005));
    }
}