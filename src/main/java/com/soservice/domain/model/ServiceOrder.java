package com.soservice.domain.model;

import com.soservice.api.exceptionhandler.ServiceOrderException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Valid
    @ManyToOne
    private Client client;

    private String description;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status;
    private OffsetDateTime createdAt;
    private OffsetDateTime finishedAt;

    @OneToMany(mappedBy = "serviceOrder")
    private List<Comment> comments = new ArrayList<>();

    public void finish() {
        if(canNotBeFinished()) {
            throw new ServiceOrderException("This service order it is not OPEN. It cannot be finished.");
        }
        this.setStatus(ServiceOrderStatus.FINISHED);
        this.setFinishedAt(OffsetDateTime.now());
    }

    private boolean canNotBeFinished() {
        return !ServiceOrderStatus.OPEN.equals(getStatus());
    }
}
