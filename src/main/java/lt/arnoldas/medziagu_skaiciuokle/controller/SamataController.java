package lt.arnoldas.medziagu_skaiciuokle.controller;

import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import lt.arnoldas.medziagu_skaiciuokle.repository.model.Samata;
import lt.arnoldas.medziagu_skaiciuokle.service.KlientasService;
import lt.arnoldas.medziagu_skaiciuokle.service.SamataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "/samatos")
public class SamataController {

    @Autowired
    private SamataService samataService;

    @Autowired
    private KlientasService klientasService;

//    http://localhost:8888/samatos/search
    @RequestMapping(value = "/search", method = RequestMethod.GET)          // ikelia visas samatas
    public String getSamatos(Model model){
        model.addAttribute("key_samata", new Samata());
        model.addAttribute("key_samatos_list", samataService.getAll());
        return "samata_list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)         // randa samata pagal struktura
    public String getSamatos(Model model, @ModelAttribute(value = "key_samata") Samata samata){
        model.addAttribute("key_samata", samata);
        model.addAttribute(
                "key_samatos_list",
                samataService.getSamataByStrukturaLike(samata.getStruktura())
        );
        return "samata_list";
    }

    // http://localhost:8888/samatos/create
    @RequestMapping(value = "/create/{klientoId}", method = RequestMethod.GET)      //samatos kurimas pagal id (kai ivedam udomenis)
    public String saveSamata(Model model, @PathVariable String klientoId){
        Klientas klientas = klientasService.getById(klientoId);
        Samata samata = new Samata();
        samata.setKlientas(klientas);
        model.addAttribute("key_samata", samata);
        return "samata_create";
    }

    @RequestMapping(value = "/create/{klientoId}", method = RequestMethod.POST)              //samatos kurimas pagal id (kai paspaudziam issaugoti)
    public String saveSamata(Model model, @ModelAttribute(value = "key_samata") Samata samata, @PathVariable String klientoId){
        samataService.setCalculations(samata);
        samataService.save(samata, klientoId);
        model.addAttribute("key_samata", samata);
        return "samata_create";
    }

    @GetMapping(value = "/struktura/{struktura}")         // Kad atidarytu viena samata
    public String getSamata(Model model, @PathVariable String struktura, Samata samata){
        model.addAttribute("key_samata", samata);
        model.addAttribute("key_samata_list", samataService.getSamataByStrukturaLike(struktura));
        return "samata_list";
    }

    @GetMapping(value = "/menu")                // atidaro menu langa
    private String getMenu(){
        return "samatos_menu";
    }
}
