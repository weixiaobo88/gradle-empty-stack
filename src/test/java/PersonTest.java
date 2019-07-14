import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;

public class PersonTest {
    private Person person;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        person = new Person("Zhaoyu");
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void shouldPersonHasName() {
        assertThat(person.getName()).isEqualTo("Zhaoyu");
    }

    @Test
    public void shouldGetCLIMessageWhenPersonUseIPhone() {
        IPhone iPhone = new IPhone("iPhone 7", "white", "Apple");
        person.call(iPhone, "Hello i am using iPhone");
        assertThat(systemOut()).isEqualTo("<iPhone>Message : Hello i am using iPhone\n");
    }

    @Test
    public void shouldGetCLIMessageWhenPersonUseIPhoneWithLongMessageExceedingTheLimit() {
        IPhone iPhone = new IPhone("iPhone 7", "white", "Apple");
        person.call(iPhone, "Hello i am using iPhone, i am sending a very looooong message");
        assertThat(systemOut()).isEqualTo("<iPhone> Message cannot be sent\n");
    }

    @Test
    public void shouldGetCLIMessageWhenPersonUseAndroidWithLongMessageExceedingTheLimit() {
        Android android = new Android("plus 11", "white", "Huawei");
        person.call(android, "Hello i am using android, i am sending a very looooong message");
        assertThat(systemOut()).isEqualTo("<Android> Message cannot be sent\n");
    }
}