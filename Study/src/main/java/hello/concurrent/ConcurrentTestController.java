package hello.concurrent;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
    @RequestMapping("/concurrenttest")
public class ConcurrentTestController {
    private volatile OneValueCache cache = new OneValueCache(null,null);

    @RequestMapping("/test")
    public String test(@RequestParam Integer param) throws InterruptedException {
        System.out.println("before"+cache);
        Thread.sleep(8000);
        System.out.println(cache);
        Integer i = param;
        Integer[] factors = cache.getFactors(i);
        if(factors == null){
            factors = factor(i);
            cache = new OneValueCache(i,factors);
        }
        return null;
    }

    private static Integer[] factor(Integer i){
        return new Integer[]{i,i};
    }

}
