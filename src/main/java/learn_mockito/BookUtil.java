package learn_mockito;

public class BookUtil {
 
    private static String getTitle() {
        return "コンビニ人間";
    }
 
    private static String getArgTitle(Integer num) {
        return "火花" + num;
    }
}