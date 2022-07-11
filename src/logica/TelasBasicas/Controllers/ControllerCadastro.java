package logica.TelasBasicas.Controllers;

import logica.TelasBasicas.Models.ModelTelasIniciais;
import logica.Auxiliar.*;

/**
 * Controller das telas de cadastro
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ControllerCadastro extends ControllerTelasIniciais{
  String nome;
  String confirmaSenha;

  /**
   * 
   * @param nome
   * @param nome_usuario
   * @param senha
   * @param confirmaSenha
   * @param model
   */
  public ControllerCadastro(String nome, String nome_usuario, String senha, String confirmaSenha, ModelTelasIniciais model) {
    super(nome_usuario, senha, model);
    this.setNome(nome);
    this.setConfirmaSenha(confirmaSenha);
  }

  /**
   * 
   * @param nome
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getNome(){
    return this.nome;
  }

  /**
   * 
   * @param confirmaSenha
   */
  public void setConfirmaSenha (String confirmaSenha) {
    this.confirmaSenha = confirmaSenha;
  }

  public String getConfirmaSenha () {
    return this.confirmaSenha;
  }

  // Função cadastrar
  public void cadastrar(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    String confirmaSenha = this.getConfirmaSenha();
    String nome = this.getNome();
    int valor_retorno = -2;

    // 1) Verificamos se senha ou nome_usuario são vazios
    int i = Verificadora.verifica_nome_nomeUsuario_senha(nome, nome_usuario, senha, confirmaSenha);
    
    // 2) nome_usuario e senha não são vazios
    if (i == 0 && confirmaSenha.equals(senha))
      valor_retorno = (this.getDados()).cadastrar(nome, nome_usuario, senha);

    // 3) Setamos a mensagem no Model
    String mensagem = Mensagens.gera_mensagem_cadastro(i, valor_retorno, senha, confirmaSenha);
    (this.getModel()).setMensagem(mensagem);
  }
}