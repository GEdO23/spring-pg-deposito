package br.com.fiap.springpgdeposito.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "TB_ITEM_ESTOCADO")
public class ItemEstocado {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ITEM_ESTOCADO")
    @SequenceGenerator(name = "SQ_ITEM_ESTOCADO", sequenceName = "SQ_ITEM_ESTOCADO", allocationSize = 1)
    @Column(name = "ID_ITEM_ESTOCADO")
    Long id;

    String numeroDeSerie;

    LocalDateTime entrada;

    LocalDateTime saida;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PRODUTO",
            referencedColumnName = "ID_PRODUTO",
            foreignKey = @ForeignKey(name = "FK_PRODUTO_ITEM_ESTOCADO")
    )
    Produto produto;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "DEPOSITO",
            referencedColumnName = "ID_DEPOSITO",
            foreignKey = @ForeignKey(name = "FK_DEPOSITO_ITEM_ESTOCADO")
    )
    Deposito deposito;

}
