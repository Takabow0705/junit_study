package learn_mockito;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.*;
import org.mockito.*;
import learn_mockito.*;

public class SampleATest{
    //name指定が推奨される
    @Mock(name="sampleB")
    private SampleB sampleBMock;
    @InjectMocks
    private SampleA sampleA = new SampleA();
 
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerify() {
         
        // モックを用意する。
        when(sampleBMock.getName((Integer)anyObject())).thenReturn("mock");
 
        // テスト対象のクラスを実行します。
        String ret = sampleA.createName();
         
        // 戻り値を確認する。
        assertEquals("mock", ret);
    }
}