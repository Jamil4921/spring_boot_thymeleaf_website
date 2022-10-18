package be.ehb.derdehandjes.controller;

import be.ehb.derdehandjes.model.product;
import be.ehb.derdehandjes.model.productDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Optional;

@Controller
public class detailController {

    productDao dao;


    @Autowired
    public detailController(productDao dao){
        this.dao = dao;
    }


    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public String detailProduct(ModelMap map, @PathVariable(value = "id") int id) {
        Optional<product> optional = dao.findById(id);
        if (optional.isPresent()) {
            map.addAttribute("producten", optional.get());
            return "detail";
        }
        return "redirect:../index";
    }


}
