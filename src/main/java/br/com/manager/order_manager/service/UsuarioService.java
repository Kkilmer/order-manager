package br.com.manager.order_manager.service;

import br.com.manager.order_manager.dto.UsuarioDTO.RequestUsuarioDTO;
import br.com.manager.order_manager.dto.UsuarioDTO.ResponseUsuarioDTO;
import br.com.manager.order_manager.exception.CpfJaCadastradoException;
import br.com.manager.order_manager.exception.EmailJaCadastradoException;
import br.com.manager.order_manager.model.entity.Usuario;
import br.com.manager.order_manager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ResponseUsuarioDTO responseUserDTO;

    public ResponseUsuarioDTO criarUsuario(RequestUsuarioDTO usuarioDTO){

        if (usuarioRepository.findByEmail(usuarioDTO.getEmail()).isPresent()) {
            throw new EmailJaCadastradoException("Email já cadastrado");
        }

        if (usuarioRepository.findByCpf(usuarioDTO.getCpf()).isPresent()) {
            throw new CpfJaCadastradoException("CPF já cadastrado");
        }
            Usuario userCreate = new Usuario();
            userCreate.setNomeUsuario(usuarioDTO.getNomeUsuario());
            userCreate.setCpf(usuarioDTO.getCpf());
            userCreate.setEmail(usuarioDTO.getEmail());
            userCreate.setDataNasc(usuarioDTO.getDataNasc());

            Usuario userSave = usuarioRepository.save(userCreate);

            responseUserDTO.setUsuarioId(userSave.getUsuarioId());
            responseUserDTO.setNomeUsuario(userSave.getNomeUsuario());
            responseUserDTO.setCpf(userSave.getCpf());
            responseUserDTO.setDataNasc(userSave.getDataNasc());

            return  responseUserDTO;
    }
}
