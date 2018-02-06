package letztechance.org.service;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootRestServiceController {

    private static final String template = "Welcome, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Message message(@RequestParam(value="name", defaultValue="World") String name) {
        return new Message(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
