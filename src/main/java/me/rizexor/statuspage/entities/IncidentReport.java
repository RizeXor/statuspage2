package me.rizexor.statuspage.entities;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class IncidentReport implements Serializable {

    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false)
    private IncidentReportStatus status;
    @Column(nullable = false)
    private String message;
    @Column(nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime updated;

}
