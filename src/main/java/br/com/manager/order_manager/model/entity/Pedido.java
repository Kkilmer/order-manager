package br.com.manager.order_manager.model.entity;

import br.com.manager.order_manager.model.enums.StatusPedEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pedidoId;

    @NotBlank
    private String titulo;

    @NotBlank
    private String descricao;

    @Enumerated(EnumType.STRING)
    private StatusPedEnum status;

    @CreationTimestamp
    private LocalDateTime createdAt; //data criação

    @UpdateTimestamp
    private LocalDateTime updatedAt;//data atualização

    private Boolean archived = false;

    @NotNull
    @ManyToOne
    private Usuario usuario;


}
