package jp.canetrash.sample.json;

import static org.junit.Assert.assertEquals;

import java.io.StringReader;
import java.util.Map.Entry;

import jp.canetrash.sample.json.Bean;
import jp.canetrash.sample.json.Data;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void testOriginalJSON() throws Exception {
    	
        // 元々のJSON
        String json = "{ " +
                        "\"hoge\" : {\r" +
                            "\"name\" : \"データ\", \r"+
                            "\"data\":{\r" +
                                    "\"1\" : { \r" +
                                            "\"value\" : \"テスト\", \r" +
                                            "\"id\" : \"1\" \r" +
                                         "},\r" + 
                                    "\"2\" : { \r" +
                                            "\"value\" : \"テスト2\", \r" +
                                            "\"id\" : \"2\" \r" +
                                        "}," + 
                                    "\"3\" : { \r" +
                                            "\"value\" : \"テスト3\", \r" +
                                            "\"id\" : \"3\" \r" +
                                        "} " + 
                                   "} " +
                               "}" +
                           "}";
        ObjectMapper mapper = new ObjectMapper();
        Bean actual = mapper.readValue(new StringReader(json), Bean.class);
        assertEquals("データ", actual.getHoge().getName());
        for(Entry<Integer, Data> entry : actual.getHoge().getData().entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue().getValue());
            System.out.println(entry.getValue().getId());
        }
    }
    
    @Test
    public void testCustomJSON() throws Exception {
        // 変更したJSON
        String json = "{ " +
                        "\"hoge\" : {\r" +
                            "\"name\" : \"データ\", \r"+
                            "\"data\":[\r" +
                                    "{ \r" +
                                        "\"value\" : \"テスト\", \r" +
                                        "\"id\" : \"1\" \r" +
                                    "},\r" + 
                                    "{ \r" +
                                        "\"value\" : \"テスト2\", \r" +
                                        "\"id\" : \"2\" \r" +
                                    "}," + 
                                    "{ \r" +
                                        "\"value\" : \"テスト3\", \r" +
                                        "\"id\" : \"3\" \r" +
                                    "} " + 
                                   "] " +
                               "}" +
                           "}";
        ObjectMapper mapper = new ObjectMapper();
        Bean2 actual = mapper.readValue(new StringReader(json), Bean2.class);
        assertEquals("データ", actual.getHoge().getName());
        assertEquals(3, actual.getHoge().getData().size());
    }
}