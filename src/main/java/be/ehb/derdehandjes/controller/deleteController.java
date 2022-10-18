package be.ehb.derdehandjes.controller;

import be.ehb.derdehandjes.model.product;
import be.ehb.derdehandjes.model.productDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class deleteController {
    productDao dao;


    @Autowired
    public deleteController(productDao dao){
        this.dao = dao;
    }


    @GetMapping( "/index/{id}")
    public String deleteProduct(@PathVariable(value = "id") int id) {
        dao.deleteById(id);
        return "redirect:../index";
    }
}
