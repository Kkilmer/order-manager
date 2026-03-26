package br.com.manager.order_manager.exception;

public class UsuarioNaoEncontradoException extends RuntimeException{

    public UsuarioNaoEncontradoException(String message){
        super(message);
    }
}
