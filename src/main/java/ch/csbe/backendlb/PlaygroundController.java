package ch.csbe.backendlb;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playground")
public class PlaygroundController {

    public int Test = 12;
    private String v1;
    private String v2;
    @GetMapping("hello-world")
    public String helloWorld(){
        v1 = "Hello Java Boot";

        if (Test == 12) {
            v2 = "WOOOW, its 12";
        }
        else {
            v2 = "wow, its not 12";
        }

        return (v1 + v2);
    }
}
