package logica.TelasBasicas.Controllers;

import logica.Arquivos.Dados;
import logica.TelasBasicas.Models.ModelTelasIniciais;

/**
 * Controller das telas iniciais
 * Essa classe vai ser a superclasse dos 4 Controllers de Telas Iniciais
 * Serve apenas para evitar a repetição do código abaixo, pois os 4 Controllers de Telas
 * Iniciais terão todos os seguintes métodos e atributos
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ControllerTelasIniciais{
  String nome_usuario;
  String senha;
  Dados dados;
  ModelTelasIniciais model;

  /**
   * 
   * @param nome_usuario
   * @param senha
   * @param model
   */
  public ControllerTelasIniciais(String nome_usuario, String senha, ModelTelasIniciais model) {
    this.setNomeUsuario(nome_usuario);
    this.setSenha(senha);
    this.setDados(new Dados());
    this.setModel(model);
  }

  /**
   * 
   * @param nome_usuario
   */
  public void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
  }

  /**
   * 
   * @param senha
   */
  public void setSenha(String senha){
    this.senha = senha;
  }

  /**
   * 
   * @param dados
   */
  public void setDados(Dados dados){
    this.dados = dados;
  }

  /**
   * 
   * @param model
   */
  public void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  public String getNomeUsuario(){
    return this.nome_usuario;
  }

  public String getSenha(){
    return this.senha;
  }

  public Dados getDados(){
    return this.dados;
  }

  public ModelTelasIniciais getModel(){
    return this.model;
  }
}