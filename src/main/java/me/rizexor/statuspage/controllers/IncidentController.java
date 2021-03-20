package me.rizexor.statuspage.controllers;

import me.rizexor.statuspage.entities.Incident;
import me.rizexor.statuspage.entities.IncidentReport;
import me.rizexor.statuspage.services.IncidentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/incidents")
public class IncidentController {

    @Autowired
    private IncidentService incidentService;

    @GetMapping
    public List<Incident> getIncidents() {
        return incidentService.getIncidents();
    }

    @GetMapping("{id}")
    public Optional<Incident> getIncident(@PathVariable("id") String id) {
        return incidentService.getIncident(id);
    }

    @PutMapping("{id}")
    public Incident addIncidentReport(@PathVariable("id") String id, @RequestBody IncidentReport incidentReport) {
        return incidentService.addIncidentReport(id, incidentReport);
    }

    @PostMapping
    public Incident createIncident(@RequestBody Incident incident) {
        return incidentService.createIncident(incident);
    }

    @DeleteMapping("{id}")
    public void deleteIncident(@PathVariable("id") String id) {
        incidentService.deleteIncident(id);
    }

}
