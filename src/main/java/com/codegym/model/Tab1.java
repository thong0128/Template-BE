package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Tab1 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "Tab2_id")
    private Tab2 tab2;
}
