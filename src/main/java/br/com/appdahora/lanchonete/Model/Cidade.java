package br.com.appdahora.lanchonete.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cidade{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Estado estado;
}
