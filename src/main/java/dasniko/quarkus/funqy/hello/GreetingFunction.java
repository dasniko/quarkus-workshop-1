package dasniko.quarkus.funqy.hello;

import io.quarkus.funqy.Funq;

import javax.inject.Inject;
import java.util.Collections;
import java.util.Map;

/**
 * @author Niko Köbler, https://www.n-k.de, @dasniko
 */
public class GreetingFunction {

    @Funq
    public Map<String, String> hello(Map<String, String> params) {
        return Collections.singletonMap("hello", params.get("name"));
    }

    @Inject
    GreetingService service;

    @Funq("greet")
    public Greeting greetingAPerson(Person person) {
        return service.greet(person.getFirst() + " " + person.getLast());
    }

    @Funq
    public String family(Family family) {
        return String.format("Hello Mom, %s %s and Dad, %s %s, with the kids %s!",
                family.getMom().getFirst(), family.getMom().getLast(),
                family.getDad().getFirst(), family.getDad().getLast(),
                String.join(", ", family.getKids()));
    }

}
