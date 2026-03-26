package br.com.manager.order_manager.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long usuarioId;

    @NotBlank
    private String nomeUsuario;

    @NotBlank
    private String cpf;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotNull
    private LocalDate dataNasc;

    @CreationTimestamp
    private LocalDateTime dataCreate;

    @OneToMany(mappedBy = "usuario")
    private List<Pedido> listaPedidos;

}
