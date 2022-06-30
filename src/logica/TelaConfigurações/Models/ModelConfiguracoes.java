package logica.TelaConfigurações.Models;
import logica.TelaConfigurações.Observers.*;

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

  public ModelConfiguracoes(){
    this.attachObserverNome(new ObserverNome());
    this.attachObserverSenha(new ObserverSenha());
    this.attachObserverNomeUsuario(new ObserverNomeUsuario());
    this.attachObserverApagarRegistro(new ObserverApagarRegistro());
  }

  public void attachObserverNome (ObserverNome observador){
    this.observador_nome = observador;
    observador.setModel(this);
  }

  public void attachObserverNomeUsuario (ObserverNomeUsuario observador){
    this.observador_nome_usuario = observador;
    observador.setModel(this);
  }

  public void attachObserverSenha(ObserverSenha observador){
    this.observador_senha = observador;
    observador.setModel(this);
  }

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

  public void setNome(String nome){
    this.nome = nome;
    this.NotifyNome();
  }

  public void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
    this.NotifyNomeUsuario();
  }

  public void setSenha(String senha){
    this.senha = senha;
    this.NotifySenha();
  }

  public void setMensagem(String mensagem){
    this.mensagem = mensagem;
  }

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
