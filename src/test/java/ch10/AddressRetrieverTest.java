package ch10;

import java.io.*;
import org.json.simple.parser.*;
import org.junit.*;
import org.mockito.*;
import ch10.util.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class AddressRetrieverTest{
    @Mock
    private Http http;
    @InjectMocks
    private AddressRetriever retriever;

    @Before
    public void createRetriever(){
        retriever = new AddressRetriever();
        MockitoAnnotations.initMocks(this);
    }
    /*
    @Test
    public void answerAppropriateAddressForValidCoordinates() throws IOException, ParseException{

        //スタブオブジェクト
        Http http = new Http(){
            @Override
            public String get(String url){
                return         "{\"address\":{"
                + "\"house_number\":\"324\","
                + "\"road\":\"ノーステジョンストリート\","
                + "\"city\":\"コロラドスプリングス\","
                + "\"state\":\"コロラド\","
                + "\"postcode\":\"80903\","
                + "\"country_code\":\"us\"}"
                + "}";
            }
        };
        AddressRetriever retriever = new AddressRetriever();

        Address address = retriever.retrieve(38.0,-104.0);
        
        assertThat(address.houseNumber, equalTo("324"));
        assertThat(address.road, equalTo("ノーステジョンストリート"));
        assertThat(address.city, equalTo("コロラドスプリングス"));
        assertThat(address.state, equalTo("コロラド"));
        assertThat(address.zip, equalTo("80903"));
    }*/

    @Test
    public void answerAppropriateAddressForValidCoordinates2() throws IOException, ParseException{
        when(http.get(contains("lat=38.000000&lon=-104.000000")))
        .thenReturn("{\"address\":{"
                       + "\"house_number\":\"324\","
                       + "\"road\":\"North Tejon Street\","
                       + "\"city\":\"Colorado Springs\","
                       + "\"state\":\"Colorado\","
                       + "\"postcode\":\"80903\","
                       + "\"country_code\":\"us\"}"
                       + "}");
        
    Address address = retriever.retrieve(38.0,-104.0);
      
    assertThat(address.houseNumber, equalTo("324"));
    assertThat(address.road, equalTo("North Tejon Street"));
    assertThat(address.city, equalTo("Colorado Springs"));
    assertThat(address.state, equalTo("Colorado"));
    assertThat(address.zip, equalTo("80903"));
    
    }
}