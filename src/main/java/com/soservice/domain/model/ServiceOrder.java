package com.soservice.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus serviceOrderStatus;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
}
