package me.rizexor.statuspage.services;

import me.rizexor.statuspage.entities.Component;
import me.rizexor.statuspage.exceptions.ComponentNotFoundException;
import me.rizexor.statuspage.repositories.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {

    @Autowired
    private ComponentRepository componentRepository;

    public List<Component> getComponents() {
        return componentRepository.findAll();
    }

    public Component createComponent(Component component) {
        return componentRepository.save(component);
    }

    public Component updateComponent(Long id, Component component) {
        return componentRepository.findById(id).map(component1 -> {
            component1.setName(component.getName());
            component1.setStatus(component.getStatus());
            return componentRepository.save(component1);
        }).orElseThrow(ComponentNotFoundException::new);
    }
}
