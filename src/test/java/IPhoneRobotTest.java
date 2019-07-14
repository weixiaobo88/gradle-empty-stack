import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.api.Assertions.assertThat;

public class IPhoneRobotTest {
    private IPhoneRobot iPhoneRobot;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() {
        iPhoneRobot = new IPhoneRobot("robot");
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }


    @Test
    public void shouldGetCLIMessageWhenRobotUseIPhone() {
        IPhone iPhone = new IPhone("iPhone 7", "white", "Apple");
        iPhoneRobot.call(iPhone, "Hello i am using iPhone");
        assertThat(systemOut()).isEqualTo("<iPhone>Message : Hello i am using iPhone\n");
    }
}