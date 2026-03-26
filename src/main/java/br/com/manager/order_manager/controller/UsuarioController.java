package br.com.manager.order_manager.controller;

import br.com.manager.order_manager.dto.UsuarioDTO.RequestUsuarioDTO;
import br.com.manager.order_manager.dto.UsuarioDTO.ResponseUsuarioDTO;
import br.com.manager.order_manager.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<ResponseUsuarioDTO> criarUsuario(
            @RequestBody @Valid RequestUsuarioDTO dto) {
        ResponseUsuarioDTO usuarioCriado = usuarioService.criarUsuario(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

}
