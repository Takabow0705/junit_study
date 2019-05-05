package learn_mockito;

import java.lang.reflect.*;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class BookUtilTest{

    @Test
    public void noArg() throws Exception {
        Method method = BookUtil.class.getDeclaredMethod("getTitle");
        method.setAccessible(true);
          
        // staticの場合、invokeの第一引数はnullになります。
        String result = (String)method.invoke(null);
          
        assertThat(result, is("コンビニ人間"));
    }

    @Test
    public void arg() throws Exception {
        Method method = 
                BookUtil.class.getDeclaredMethod("getArgTitle", Integer.class);
        method.setAccessible(true);
          
        // staticの場合、invokeの第一引数はnullになります。
        String result = (String)method.invoke(null, 1);
          
        assertThat(result, is("火花1"));
    }
}