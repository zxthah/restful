package zx.boot.restful.control;

import org.springframework.web.bind.annotation.*;
import zx.boot.restful.dao.Echo;
import zx.boot.restful.dao.Message;

import java.util.concurrent.atomic.AtomicLong;

//http://www.mamicode.com/info-detail-1961197.html

@RestController
@RequestMapping(value = "/echo")
public class EchoController {
    private static final String echoTemplate1 = "received %s!";
    private static final String echoTemplate2 = "%s speaks to %s \'%s\'";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(value = "/getter/pattern1", method = RequestMethod.GET)
    public Echo getterPattern1(String content) {
        return new Echo(counter.incrementAndGet(), String.format(echoTemplate1, content));
    }

    @RequestMapping(value = "/getter/pattern2", method = RequestMethod.GET)
    public Echo getterPattern2(@RequestParam(value = "content", required = true) String alias) {
        return new Echo(counter.incrementAndGet(), String.format(echoTemplate1, alias));

    }
    @RequestMapping(value="/getter/pattern3/{content}", method=RequestMethod.GET)
    public Echo getterPattern3(@PathVariable String content) {
        return new Echo(counter.incrementAndGet(), String.format(echoTemplate1, content));
    }
    @RequestMapping(value="/setter/message1", method=RequestMethod.POST)
    public Echo setterMessage1(@RequestBody Message message) {
        return new Echo(counter.incrementAndGet(), String.format(echoTemplate2, message.getFrom(), message.getTo(),
                message.getContent()));
    }
    @RequestMapping(value="/setter/message2", method=RequestMethod.POST)
    public Echo setterMessage2(@ModelAttribute Message message) {
        return new Echo(counter.incrementAndGet(), String.format(echoTemplate2, message.getFrom(), message.getTo(), message.getContent()));
    }
}
