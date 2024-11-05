package os.sa.pituusvertailija.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VertController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
