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
    @Spy
    private SampleC sampleCMock = new SampleC();

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testVerify() {
         
        // モックを用意する。
        when(sampleBMock.getName((Integer)anyObject())).thenReturn("mock")
                                                       .thenReturn("mock2");
 
        // テスト対象のクラスを実行します。
        String ret = sampleA.createName();

        // 呼び出し回数を確認する。
        // sampleBMock.getName() メソッドの引数が、1で、
        // sampleBMock.getName() メソッドの呼び出し回数が、1回
        // の場合はエラーにならずにここを通過する。
        verify(sampleBMock, times(1)).getName(1);      
        // 戻り値を確認する。
        assertEquals("mock", ret);

        String ret2 = sampleA.createName();

        assertEquals("mock2", ret2);      
    }

    @Test
    public void createNameBySampleCTest() {
         
        // モックを用意する。
        // getPrice()メソッドのみをモック化します。
        doReturn(555).when(sampleCMock).getPrice((Integer)anyObject());
         
        // テスト対象のクラスを実行します。
        String ret = sampleA.createNameBySampleC();
         
        // 戻り値を確認する。
        assertEquals("id:3 price:555", ret);
    }
}