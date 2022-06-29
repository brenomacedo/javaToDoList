package logica.TelaConfigurações.Models;
import logica.TelaConfigurações.Observers.*;

public class ModelConfiguracoes{
  String nome;
  String nome_usuario;
  String senha;
  ObserverNome observador_nome;
  ObserverNomeUsuario observador_nome_usuario;
  ObserverSenha observador_senha;

  public ModelConfiguracoes(){
    this.attachObserverNome(new ObserverNome());
    this.attachObserverSenha(new ObserverSenha());
    this.attachObserverNomeUsuario(new ObserverNomeUsuario());
  }

  void attachObserverNome (ObserverNome observador){
    this.observador_nome = observador;
    observador.setModel(this);
  }

  void attachObserverNomeUsuario (ObserverNomeUsuario observador){
    this.observador_nome_usuario = observador;
    observador.setModel(this);
  }

  void attachObserverSenha(ObserverSenha observador){
    this.observador_senha = observador;
    observador.setModel(this);
  }

  void NotifyNome(){
    this.observador_nome.update();
  }

  void NotifyNomeUsuario(){
    this.observador_nome_usuario.update();
  }

  void NotifySenha(){
    this.observador_senha.update();
  }

  void setNome(String nome){
    this.nome = nome;
    this.NotifyNome();
  }

  void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
    this.NotifyNomeUsuario();
  }

  void setSenha(String senha){
    this.senha = senha;
    this.NotifySenha();
  }

  String getNome(){
    return this.nome;
  }

  String getNomeUsuario(){
    return this.nome_usuario;
  }

  String getSenha(){
    return this.senha;
  }
}
