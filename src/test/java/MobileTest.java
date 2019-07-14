import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;


public class MobileTest {
    private Mobile mobile;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        mobile = new Mobile("plus10", "black", "Huawei");
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void shouldMobileHasName() {
        assertThat(mobile.getName()).isEqualTo("plus10");
        assertThat(mobile.getColor()).isEqualTo("black");
        assertThat(mobile.getBrand()).isEqualTo("Huawei");
    }

    @Test
    public void shouldGetCLIMessageWhenMakeACall() {
        mobile.call("Hello Huawei");
        assertThat(systemOut()).isEqualTo("Message : Hello Huawei\n");
    }

    @Test
    public void shouldGetCLIMessageWhenMakeACallFromIPhone() {
        IPhone iPhone = new IPhone("iPhone 7", "white", "Apple");
        iPhone.call("Hello iPhone");
        assertThat(systemOut()).isEqualTo("<iPhone>Message : Hello iPhone\n");
    }


    @Test
    public void shouldGetCLIMessageWhenMakeACallFromAndroid() {
        Android android = new Android("plus 10", "white", "Huawei");
        android.call("Hello android");
        assertThat(systemOut()).isEqualTo("<Android>Message : Hello android\n");
    }

    @Test
    public void shouldMobileHasBasicInfo() {
        assertThat(mobile.getBasicInfo()).isEqualTo("name: plus10, color: black, brand: Huawei");
    }
}