package com.example.MyFirstSuperMarket.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.util.UUID;

@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="SY003_FORNECEDORES")
public class Fornecedores {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID id;

    @Column(name="NAME", length = 40)
    @NotBlank(message="é necessario colocar o nome")
    private @Getter @Setter String nome;

    @Pattern(
            regexp = "^\\d{2}\\.\\d{3}\\.\\d{3}/\\d{4}-\\d{2}$|^\\d{14}$",
            message = "CNPJ deve estar no formato 00.000.000/0000-00 ou apenas os 14 números"
    )
    @Column(name = "CNPJ", length = 18)
    @NotBlank(message = "É obrigatório o CNPJ da empresa")
    private @Getter @Setter String cnpj;

    @Column(name="PRAZOENTREGA")
    @PositiveOrZero(message="O prazo deve ser positivo")
    private @Getter @Setter int prazoEntrega;

    @Column(name="LOCALIZACAO",length= 50)
    @NotBlank(message="É necessario o endereço do fornececedor")
    private @Getter @Setter String localização;

    @Override
    public String toString() {
        return "Fornecedoress{" +
                "nome='" + nome + '\'' +
                ", cnpj=" + cnpj +
                ", prazoEntrega=" + prazoEntrega +
                ", localização='" + localização + '\'' +
                '}';
    }
}
//encerramos por hoje, amanha continuo com outras classes e irei colocar joincoluns
