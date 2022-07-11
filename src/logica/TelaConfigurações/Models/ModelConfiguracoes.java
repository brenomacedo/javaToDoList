package logica.TelaConfigurações.Models;
import org.json.JSONObject;

import logica.TelaConfigurações.Observers.*;

/**
 * Model da tela de configurações do usuário
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ModelConfiguracoes{
  String nome;
  String nome_usuario;
  String senha;
  boolean apagar_registro;
  ObserverNome observador_nome;
  ObserverNomeUsuario observador_nome_usuario;
  ObserverSenha observador_senha;
  ObserverApagarRegistro observador_apagar_registro;

  String mensagem;

  /**
   * 
   * @param usuario
   */
  public ModelConfiguracoes(JSONObject usuario){

    this.nome = (String) usuario.get("nome");
    this.nome_usuario = (String) usuario.get("nome_usuario");
    this.senha = (String) usuario.get("senha");

    this.attachObserverNome(new ObserverNome());
    this.attachObserverSenha(new ObserverSenha());
    this.attachObserverNomeUsuario(new ObserverNomeUsuario());
    this.attachObserverApagarRegistro(new ObserverApagarRegistro());
  }

  /**
   * 
   * @param observador
   */
  public void attachObserverNome (ObserverNome observador){
    this.observador_nome = observador;
    observador.setModel(this);
  }

  /**
   * 
   * @param observador
   */
  public void attachObserverNomeUsuario (ObserverNomeUsuario observador){
    this.observador_nome_usuario = observador;
    observador.setModel(this);
  }

  /**
   * 
   * @param observador
   */
  public void attachObserverSenha(ObserverSenha observador){
    this.observador_senha = observador;
    observador.setModel(this);
  }

  /**
   * 
   * @param observador
   */
  public void attachObserverApagarRegistro(ObserverApagarRegistro observador){
    this.observador_apagar_registro = observador;
    observador.setModel(this);
  }

  public void NotifyNome(){
    this.observador_nome.update();
  }

  public void NotifyNomeUsuario(){
    this.observador_nome_usuario.update();
  }

  public void NotifySenha(){
    this.observador_senha.update();
  }

  public void NotifyApagarRegistro(){
    this.observador_apagar_registro.update();
  }

  /**
   * 
   * @param nome
   */
  public void setNome(String nome){
    this.nome = nome;
    this.NotifyNome();
  }

  /**
   * 
   * @param nome_usuario
   */
  public void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
    this.NotifyNomeUsuario();
  }

  /**
   * 
   * @param senha
   */
  public void setSenha(String senha){
    this.senha = senha;
    this.NotifySenha();
  }

  /**
   * 
   * @param mensagem
   */
  public void setMensagem(String mensagem){
    this.mensagem = mensagem;
  }

  /**
   * 
   * @param apagar_registro
   */
  public void setApagarRegistro(boolean apagar_registro){
    this.apagar_registro = apagar_registro;
    this.NotifyApagarRegistro();
  }

  public String getNome(){
    return this.nome;
  }

  public String getNomeUsuario(){
    return this.nome_usuario;
  }

  public String getSenha(){
    return this.senha;
  }

  public String getMensagem(){
    return this.mensagem;
  }

  public boolean getApagarRegistro(){
    return this.apagar_registro;
  }
}
