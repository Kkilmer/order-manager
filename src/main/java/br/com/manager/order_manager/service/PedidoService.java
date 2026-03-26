package br.com.manager.order_manager.service;

import br.com.manager.order_manager.dto.PedidoDTO.RequestPedidoDTO;
import br.com.manager.order_manager.dto.PedidoDTO.ResponsePedidoDTO;
import br.com.manager.order_manager.exception.UsuarioNaoEncontradoException;
import br.com.manager.order_manager.model.entity.Pedido;
import br.com.manager.order_manager.model.entity.Usuario;
import br.com.manager.order_manager.model.enums.StatusPedEnum;
import br.com.manager.order_manager.repository.PedidoRepository;
import br.com.manager.order_manager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    /*
       buscar usuário
       validar
       criar pedido
       preencher dados
       definir regras
       salvar
    */
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    PedidoRepository pedidoRepository;

    public ResponsePedidoDTO criarPedido(RequestPedidoDTO pedidoDTO){

        Usuario user = usuarioRepository
                .findById(pedidoDTO.getUsuarioId())
                .orElseThrow(() -> new UsuarioNaoEncontradoException("Usuário não encontrado"));

        Pedido ped = new Pedido();
        ped.setTitulo(pedidoDTO.getTitulo());
        ped.setDescricao(pedidoDTO.getDescricao());
        ped.setUsuario(user);
        ped.setStatus(StatusPedEnum.PENDENTE);
        ped.setArchived(false);

       Pedido salvo = pedidoRepository.save(ped);

        ResponsePedidoDTO responsePedDTO = new ResponsePedidoDTO();

        responsePedDTO.setPedidoId(salvo.getPedidoId());
        responsePedDTO.setTitulo(salvo.getTitulo());
        responsePedDTO.setDescricao(salvo.getDescricao());
        responsePedDTO.setStatus(salvo.getStatus());
        responsePedDTO.setCreatedAt(salvo.getCreatedAt());
        responsePedDTO.setUsuarioId(salvo.getUsuario().getUsuarioId());
        responsePedDTO.setNomeUsuario(salvo.getUsuario().getNomeUsuario());

        return responsePedDTO;
    }
}
