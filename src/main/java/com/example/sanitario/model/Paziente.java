package com.example.sanitario.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "pazienti")
public class Paziente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paziente_id")
    private Long id;

    private String nome;
    private String cognome;
    private String cf;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "pazienti", cascade = CascadeType.REMOVE)
    private List<Medico> medici = new ArrayList<>();
    

    public Paziente(Long id, String nome, String cognome, String cf) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.cf = cf;
    }

    public Paziente() {

    }
}
