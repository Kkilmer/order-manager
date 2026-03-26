package br.com.manager.order_manager.dto.PedidoDTO;

import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestPedidoDTO {

    @Id
    private Long usuarioId;
    @NotBlank
    private String titulo;
    @NotBlank
    private String descricao;


}
