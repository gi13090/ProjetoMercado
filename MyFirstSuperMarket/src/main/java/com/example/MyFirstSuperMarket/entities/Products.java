package com.example.MyFirstSuperMarket.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="SY001_PRODUCTS")
@Builder
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter @Setter UUID Id;

    @Column(name="NAME" ,length=100)
    @NotBlank(message = "É obrigatório o nome")
    private @Getter @Setter String name;

    @Column(name="MARCA_PRODUCT", length=15)
    @NotBlank(message="É obrigatório o uso da marca")
    private @Getter @Setter String marca;

    @Column(name="VAlOR_PRODUCT", length= 10)
    @Positive(message="È necessario um valor positivo")
    @NotBlank(message="É obrigatório o valor do produto")
    private @Getter @Setter BigDecimal valor;

    @Column(name="QTDD_PRODUCTS", length = 10)
    @NotBlank(message="É obrigatório informar se possui o produto")
    @PositiveOrZero(message="Quantidade não pode ser negativa ")
    private @Getter @Setter int quantidadeEstoque;

    @Column(name= "PRODUCT_DISPONIVEL", length= 10)
    @NotBlank(message= "É obrigatório avisar se o produto esta disponivel")
    private @Getter @Setter boolean ativo;

    private boolean isDisponivelParaVenda() {
        return ativo && quantidadeEstoque > 0;
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Products products = (Products) o;
        return Objects.equals(Id, products.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Id);
    }

    @Override
    public String toString() {
        return "Products{" +
                "Id=" + Id +
                ", Name='" + name + '\'' +
                ", Marca='" + marca + '\'' +
                ", Valor=" + valor +
                ", QuantidadeEstoque=" + quantidadeEstoque +
                ", ativo=" + ativo +
                '}';
    }
}
