package br.com.manager.order_manager.repository;

import br.com.manager.order_manager.model.entity.Pedido;
import br.com.manager.order_manager.model.enums.StatusPedEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedEnum status);
    List<Pedido> findByArchivedFalse();
    List<Pedido> findByStatusAndArchivedFalse(StatusPedEnum status);
}
