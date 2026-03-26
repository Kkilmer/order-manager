package br.com.manager.order_manager.dto.UsuarioDTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ResponseUsuarioDTO {
    private Long usuarioId;
    private String nomeUsuario;
    private String cpf;
    private String email;
    private LocalDate dataNasc;
    private LocalDateTime dataCreate;
}
