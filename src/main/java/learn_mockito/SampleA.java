package learn_mockito;

public class SampleA{
    private SampleB sampleB;
 
    public String createName() {
        String ret = sampleB.getName(1);
        return ret;
    }
}