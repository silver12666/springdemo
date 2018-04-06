package com.akhambir.controllers;

import com.akhambir.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(path = "/categories", method = RequestMethod.GET)
    public ModelAndView getAllCategories(ModelAndView vm) {
        vm.addObject("categories", categoryService.findAll());
        vm.setViewName("categories");
        return vm;
    }

    @RequestMapping(path = "/category/get/{cId}")
    public ModelAndView getCategory(@PathVariable Long cId, ModelAndView vm) {
        vm.addObject("category", categoryService.findById(cId));
        vm.setViewName("category");
        return vm;
    }


}
