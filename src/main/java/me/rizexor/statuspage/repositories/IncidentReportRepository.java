package me.rizexor.statuspage.repositories;

import me.rizexor.statuspage.entities.IncidentReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IncidentReportRepository extends JpaRepository<IncidentReport, Long> {
}
