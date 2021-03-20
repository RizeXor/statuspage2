package me.rizexor.statuspage.services;

import lombok.extern.log4j.Log4j2;
import me.rizexor.statuspage.entities.Incident;
import me.rizexor.statuspage.entities.IncidentReport;
import me.rizexor.statuspage.exceptions.IncidentNotFoundException;
import me.rizexor.statuspage.repositories.IncidentReportRepository;
import me.rizexor.statuspage.repositories.IncidentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class IncidentService {

    @Autowired
    private IncidentRepository incidentRepository;
    @Autowired
    private IncidentReportRepository incidentReportRepository;

    public Optional<Incident> getIncident(String id) {
        return incidentRepository.findById(id);
    }

    public Incident createIncident(Incident incident) {
        return incidentRepository.save(incident);
    }

    public List<Incident> getIncidents() {
        return incidentRepository.findAll();
    }

    public Incident addIncidentReport(String id, IncidentReport incidentReport) {
        return incidentRepository.findById(id).map(incident -> {
            // Create new array list and replace in incident class
            ArrayList<IncidentReport> reports = new ArrayList<IncidentReport>(incident.getIncidentReports());
            reports.add(incidentReport);
            incident.setIncidentReports(reports);

            log.info(incident);
            log.info(incidentReport);

            return incidentRepository.save(incident);
        }).orElseThrow(IncidentNotFoundException::new);
    }

    public void deleteIncident(String id) {
        incidentRepository.deleteById(id);
    }

    public Incident updateIncident(String id, Incident incident) {
        return incidentRepository.findById(id).map(resultIncident -> {
            resultIncident.setMessage(incident.getMessage());
            resultIncident.setImpact(incident.getImpact());

            return incidentRepository.save(resultIncident);
        }).orElseThrow(IncidentNotFoundException::new);
    }
}
