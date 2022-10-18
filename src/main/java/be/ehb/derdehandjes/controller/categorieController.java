package be.ehb.derdehandjes.controller;

import be.ehb.derdehandjes.model.productDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class categorieController {

    productDao dao;


    @Autowired
    public categorieController(productDao dao){
        this.dao = dao;
    }

    @RequestMapping(value = "/categorie/{categorie}", method = RequestMethod.GET)

    public String showCategorie(ModelMap map, @PathVariable(value = "categorie") String categorie) {
        map.addAttribute ("findByCat", dao.search(categorie) );
        return "categorie";
    }
}
