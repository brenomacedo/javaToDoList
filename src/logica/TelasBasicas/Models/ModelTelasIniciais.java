package logica.TelasBasicas.Models;

import logica.TelasBasicas.Observers.*;
import org.json.JSONObject;

public class ModelTelasIniciais{
  // Essa classe vai ser a superclasse dos 4 Models de Telas Iniciais
  String mensagem;
  JSONObject usuario;
  ObservadorMensagem observador_mensagem;
  ObservadorLogin observador_login;

  public ModelTelasIniciais(){
    this.attachObservadorMensagem(new ObservadorMensagem());
    this.attachObservadorLogin(new ObservadorLogin());
  }

  public void attachObservadorMensagem(ObservadorMensagem observador){
    this.observador_mensagem = observador;
    observador.setModel(this);
  }

  public void attachObservadorLogin(ObservadorLogin observador){
    this.observador_login = observador;
    observador.setModel(this);
  }

  public void NotifyMensagem(){
    (this.observador_mensagem).update();
  }

  public void setMensagem(String mensagem){
    this.mensagem = mensagem;
    this.NotifyMensagem();
  }

  public String getMensagem(){
    return this.mensagem;
  }

  public void NotifyLogin(){
    (this.observador_login).update();
  }

  public void setUsuario(JSONObject usuario){
    this.usuario = usuario;
    this.NotifyLogin();
  }

  public JSONObject getUsuario(){
    return this.usuario;
  }
}