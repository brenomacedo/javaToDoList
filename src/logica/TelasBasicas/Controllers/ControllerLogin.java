package logica.TelasBasicas.Controllers;

import logica.TelasBasicas.Models.ModelTelasIniciais;
import logica.Auxiliar.*;

public class ControllerLogin extends ControllerTelasIniciais{
  public ControllerLogin(String nome_usuario, String senha, ModelTelasIniciais model){
    super(nome_usuario, senha, model);
  }

  // Função verificarLogin
  public void verificarLogin(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    int valor_retorno = -2;

    // 1) Verificamos se senha ou nome_usuario são vazios
    int i = Verificadora.verifica_senha_nomeUsuario(nome_usuario, senha);

    // nome_usuario e senha não são vazios
    if (i == 0)
      valor_retorno = (this.getDados()).verificarLogin(nome_usuario, senha);
      
    // 2) Setamos a mensagem no Model
    String mensagem = Mensagens.gera_mensagem_login(i, valor_retorno);
    (this.getModel()).setMensagem(mensagem);

    // 3) Login existe
      if (valor_retorno == 0)
        (this.getModel()).setUsuario(dados.getUsuario());
  }
}