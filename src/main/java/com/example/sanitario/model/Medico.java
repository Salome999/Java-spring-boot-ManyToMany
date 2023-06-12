package com.example.sanitario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Medici")
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medico_id")
    private Long id;
    private String nome;
    private String cognome;
    private String cf;
    private String matricola;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "medico_paziente",
            joinColumns = {@JoinColumn(name = "medico_id")},
            inverseJoinColumns = {@JoinColumn(name = "paziente_id")}
    )
    private List<Paziente> pazienti = new ArrayList<>();
    
    

    public Medico(Long id, String nome, String cognome, String cf, String matricola) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
        this.matricola = matricola;
    }

    public Medico() {

    }
}