package me.rizexor.statuspage.entities;

import lombok.*;
import me.rizexor.statuspage.generators.IncidentGenerator;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Incident implements Serializable {

    @Id
    @GeneratedValue(generator = IncidentGenerator.generatorName)
    @GenericGenerator(strategy = "me.rizexor.statuspage.generators.IncidentGenerator", name = IncidentGenerator.generatorName)
    private String id;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false)
    private IncidentImpact impact;
    @OneToMany(targetEntity = IncidentReport.class, cascade = CascadeType.ALL)
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @OrderBy("updated DESC")
    private List<IncidentReport> incidentReports;

}
