package lt.arnoldas.medziagu_skaiciuokle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    // http://localhost:8888/
    @GetMapping(path = "/")
    public String displayHomePage() {
        return "home";
    }
}
