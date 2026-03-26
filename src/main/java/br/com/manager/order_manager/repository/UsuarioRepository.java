package br.com.manager.order_manager.repository;

import br.com.manager.order_manager.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);
    Optional<Usuario> findByEmail(String email);
    Optional<Usuario> findByCpf(String cpf);

}
