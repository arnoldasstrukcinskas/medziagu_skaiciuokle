package lt.arnoldas.medziagu_skaiciuokle.controller;

import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import lt.arnoldas.medziagu_skaiciuokle.service.KlientasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class KlientasController {

    @Autowired
    private KlientasService klientasService;

    // http://localhost:8888/klientai
    @RequestMapping(value = "/klientai", method = RequestMethod.GET)
    public String getKlientai(Model model){
    model.addAttribute("key_klientas", new Klientas());
    model.addAttribute("key_klientai", klientasService.getAll());
    return "klientu_list";
    }

    // http://localhost:8888/create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String saveKlientas(Model model){
        model.addAttribute("key_klientas", new Klientas());
        return "klientas_create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String saveKlientas(Model model, @ModelAttribute(value = "key_klientas") Klientas klientas){
        String customerId = klientasService.save(klientas);
        model.addAttribute("key_klientas", klientas);
        return "klientas_create";
    }

}
