package be.ehb.derdehandjes.controller;

import be.ehb.derdehandjes.model.product;
import be.ehb.derdehandjes.model.productDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class productController {

    private productDao dao;
    private product product;

    @Autowired
    public productController(productDao dao){
        this.dao = dao;
    }



    @ModelAttribute("all")
    public Iterable<product> findAll(){
        return dao.findAll();
    }


    @ModelAttribute("new_product")
    public product createNew(){
        return new product();
    }

    @GetMapping("formulier")
    public String newPage(ModelMap map){
        return "formulier";
    }

    @GetMapping("about")
    public String aboutPage(ModelMap map){
        return "about";
    }

    @GetMapping("detail")
    public String detailPage(ModelMap map){
        return "detail";
    }

    @GetMapping("categorie")
    public String categoriePage(ModelMap map){
        return "categorie";
    }



    @RequestMapping(value = {"/index", "/"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map){
        return "index";
    }


    @RequestMapping(value = { "/formulier"}, method = RequestMethod.POST)
    public String saveBlog(@ModelAttribute("new_product") @Valid product newProduct, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "formulier";
        }
        dao.save(newProduct);
        return "redirect:/index";
    }





}
