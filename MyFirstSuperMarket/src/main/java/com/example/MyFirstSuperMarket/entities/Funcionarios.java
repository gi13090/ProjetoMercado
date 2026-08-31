package com.example.MyFirstSuperMarket.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Objects;
import java.util.UUID;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="SY002_MEMBERS")
public class Funcionarios {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID idColaborador;

    @Column(name="NAME", length = 30)
    @NotBlank(message="é necessario colocar o nome")
    private @Getter @Setter String name;

    @Email(message = "E-mail inválido")
    @Size(max = 50, message = "E-mail muito longo")
    @NotBlank(message = "É obrigatório o email")
    private @Getter @Setter String email;

    @Column(name="ENDERECO", length= 50)
    @NotBlank(message="É necessario o endereço do colaborador")
    private @Getter @Setter String endereço;

    @Column(name="TURNO", length = 10)
    @NotBlank(message="O colaborador precisa ter um turno registrado")
    private @Getter @Setter String turno;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionarios that = (Funcionarios) o;
        return Objects.equals(idColaborador, that.idColaborador);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idColaborador);
    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "id_colaborador=" + idColaborador +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", endereço='" + endereço + '\'' +
                ", turno='" + turno + '\'' +
                '}';
    }
}
