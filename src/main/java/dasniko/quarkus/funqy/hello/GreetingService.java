package dasniko.quarkus.funqy.hello;

import javax.enterprise.context.ApplicationScoped;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
@ApplicationScoped
public class GreetingService {

    public Greeting greet(String value) {
        Greeting greeting = new Greeting();
        greeting.setMessage("Hello, " + value);
        return greeting;
    }
}
