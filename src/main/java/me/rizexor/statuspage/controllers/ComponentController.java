package me.rizexor.statuspage.controllers;

import me.rizexor.statuspage.entities.Component;
import me.rizexor.statuspage.services.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/components")
public class ComponentController {

    @Autowired
    private ComponentService componentService;

    @GetMapping
    public List<Component> getComponents() {
        return componentService.getComponents();
    }

    @PutMapping("{id}")
    public Component updateComponent(@PathVariable("id") Long id, @RequestBody Component component) {
        return componentService.updateComponent(id, component);
    }

    @PostMapping
    public Component createComponent(@RequestBody Component component) {
        return componentService.createComponent(component);
    }

}
