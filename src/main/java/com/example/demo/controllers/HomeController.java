package com.example.demo.controllers;

import com.example.demo.dto.SearchFormData;
import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private ProductService srv;

    // model adalah penghubung data yg ada di controller ke template/htmlnya
    @GetMapping("/")
    public String main(Model model){
        String msg = "Hello World, have a nice day!";
        model.addAttribute("msg", msg);
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("products", srv.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String add(Model model){
        //untuk di binding ke form
        model.addAttribute("product", new Product());
        model.addAttribute("searchForm", new SearchFormData());
        return "add";
    }

    @PostMapping("/save")
    public String save(Product product, Model model){
        srv.addProduct(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") long id){
        srv.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") long id, Model model){
        model.addAttribute("searchForm", new SearchFormData());
        model.addAttribute("product", srv.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product, Model model){
        srv.editProduct(product);
        return "redirect:/";
    }

    @PostMapping("/search")
    public String search(SearchFormData searchFormData, Model model){
        String msg = "Hello World, have a nice day!";
        model.addAttribute("msg", msg);
        model.addAttribute("searchForm", searchFormData);
        model.addAttribute("products", srv.findByName(searchFormData.getKeyword()));
        return "index";
    }

}