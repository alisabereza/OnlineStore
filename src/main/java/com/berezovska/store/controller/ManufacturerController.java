package com.berezovska.store.controller;


import com.berezovska.store.controller.exception.ErrorMessage;
import com.berezovska.store.controller.exception.ManufacturerAlreadyExistsError;
import com.berezovska.store.controller.exception.ManufacturerNotExistsException;
import com.berezovska.store.model.Manufacturer;
import com.berezovska.store.service.ManufacturerService;
import com.berezovska.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;


@Controller
@RequestMapping(path = "/manufacturer")
public class ManufacturerController {
    private ManufacturerService manufacturerService;
    private ProductService productService;

    @Autowired
    public void setManufacturers(ManufacturerService manufacturerService, ProductService productService) {
        this.manufacturerService = manufacturerService;
        this.productService = productService;
    }

    @GetMapping(path = "/showManufacturers")
    public String showManufacturers(Model model) {
            model.addAttribute("manufacturers", manufacturerService.getAll());
        return "show_manufacturers";
    }

    @GetMapping(path = "/get")
    public ModelAndView getManufacturer(@RequestParam(name = "id") java.util.UUID id, ModelAndView model) {
        final Manufacturer manufacturer = manufacturerService.getById(id);
        model.setViewName("manufacturer_details");
        model.addObject("manufacturer", manufacturer);
        return model;
    }

    @GetMapping(path = "/createManufacturer")
    public String getCreateManufacturerView(Model model) {
        return "create_manufacturer";
    }


    @PostMapping(path = "/createManufacturer")
    public String createManufacturer(@ModelAttribute("manufacturer") @Valid Manufacturer manufacturer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "create_manufacturer";
        }
        try {
            manufacturerService.save(manufacturer);
            model.addAttribute("name", manufacturer.getName());
            return "manufacturer_created";
        } catch (ManufacturerAlreadyExistsError e) {

            model.addAttribute("errors", List.of(new ErrorMessage("", e.getMessage())));
            return "create_manufacturer";
        }
    }

    @GetMapping(path = "/findPage")
    public String showFindUserPage() {
        return "find_manufacturer";
    }

    @GetMapping(path = "/find")
    public String findManufacturer(@RequestParam("name") String name, Model model) {
        Manufacturer manufacturer  = null;
        try {
            manufacturer = manufacturerService.getByName(name);
        } catch (ManufacturerNotExistsException e) {
            model.addAttribute("error", e.getMessage());
            return "find_manufacturer";
        }
        model.addAttribute("manufacturer", manufacturer);
        return "manufacturer_details";
    }


    /* It opens the record for the given id in editManufacturer page */
    @RequestMapping(value="/edit/{id}")
    public String edit(@PathVariable UUID id, Model model){
        Manufacturer manufacturer=manufacturerService.getById(id);
        model.addAttribute("manufacturer", manufacturer);
        return "editManufacturer";
    }

    /* It updates record for the given id in editManufacturer */
    @RequestMapping(value="/editsave",method = RequestMethod.POST)
    public ModelAndView editsave(@ModelAttribute("manufacturer") Manufacturer manufacturer){
        manufacturerService.update(manufacturer);
        return new ModelAndView("redirect:/manufacturer/showManufacturers");
    }

    /* It deletes record for the given id  and redirects to /show_manufacturers */
    @RequestMapping(value="/delete/{id}",method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable java.util.UUID id){
        manufacturerService.delete(id);
        return new ModelAndView("redirect:/manufacturer/showManufacturers");
    }

    @ModelAttribute("manufacturer")
    public Manufacturer getDefaultCourse() {
        return new Manufacturer();
    }
}