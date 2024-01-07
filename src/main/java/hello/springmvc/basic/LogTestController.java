package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

    //private final Logger log = LoggerFactory.getLogger(LogTestController.class); -> lombok으로 인해 안 써도 됨

    @GetMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        /*log.trace("log=" + name); 등과 같은 형식은 쓰지 말자!
        * 이유는 자바는 +연산이 있다면 String 형태로 치환을 하는 연산을 한다는 문제점이 있다.
        * 그래서 info 하위 로그들만 출력한다고 해도
        * trace 단에 걸리는 모든 로그들의 문자열이 필요없음에도 연산이 되는 불상사가 발생한다.*/

        log.trace(" info log = {}", name);
        log.debug(" debug log = {}", name);
        log.info(" info log = {}", name);
        log.warn(" warn log = {}", name);
        log.error(" error log = {}", name);

        return "ok";
    }
}
