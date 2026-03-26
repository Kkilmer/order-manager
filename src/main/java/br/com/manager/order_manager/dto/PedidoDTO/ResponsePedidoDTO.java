package br.com.manager.order_manager.dto.PedidoDTO;

import br.com.manager.order_manager.model.enums.StatusPedEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ResponsePedidoDTO {

    private Long pedidoId;
    private String titulo;
    private String descricao;
    private StatusPedEnum status;
    private LocalDateTime createdAt;
    private Long usuarioId;
    private String nomeUsuario;
}
