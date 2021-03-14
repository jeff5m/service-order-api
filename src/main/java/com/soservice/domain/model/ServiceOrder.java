package com.soservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Client client;
    private String description;
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ServiceOrderStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime finishedAt;
}
