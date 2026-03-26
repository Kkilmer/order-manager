package br.com.manager.order_manager.dto.UsuarioDTO;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RequestUsuarioDTO {
    @NotNull
    private String nomeUsuario;
    @NotNull
    private String cpf;
    @NotNull
    private String email;
    @NotNull
    private LocalDate dataNasc;
}
