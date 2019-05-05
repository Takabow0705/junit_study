package learn_mockito;

public class SampleA{
    private SampleB sampleB;
    private SampleC sampleC;

    public String createName() {
        String ret = sampleB.getName(1);
        return ret;
    }

    public String createNameBySampleC(){
        Integer id = sampleC.getId();
 
        Integer price = sampleC.getPrice(id);
 
        String ret = "id:" + id + " price:" + price;
        return ret;
    }
}