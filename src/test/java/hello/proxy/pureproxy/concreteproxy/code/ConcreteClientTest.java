package hello.proxy.pureproxy.concreteproxy.code;

import com.sun.tools.jconsole.JConsoleContext;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteClientTest {

    @Test
    void noProxy() {
        ConcreteLogic concreteLogic = new ConcreteLogic();
        ConcreteClient concreteClient = new ConcreteClient(concreteLogic);

        concreteClient.execute();
    }

    @Test

}