package logica.MenuPrincipal.Controllers;

import org.json.JSONObject;
import logica.MenuPrincipal.Models.*;

class ControllerMenuPrincipal{
  ModelMenuPrincipal model_menu_principal;
  JSONObject usuario;

  ControllerMenuPrincipal(JSONObject usuario){
    this.setUsuario(usuario);
    this.iniciar();
  } 

  void setUsuario(JSONObject usuario){
    this.usuario = usuario;
  }

  JSONObject getUsuario(){
    return this.usuario;
  }

  void setModelMenuPrincipal(ModelMenuPrincipal model_menu_principal){
    this.model_menu_principal = model_menu_principal;
  }

  ModelMenuPrincipal getModelMenuPrincipal(){
    return this.model_menu_principal;
  }

  // 1) Função de inicializar o MenuPrincipal (após fazer o login)
  void iniciar(){
    ModelMenuPrincipal model_menu_principal = new ModelMenuPrincipal(this.getUsuario());
    this.setModelMenuPrincipal(model_menu_principal);
  }

  // 2) Função de adicionar tarefas
  // Como essa função foi chamada, então podemos adicionar mais uma tarefa em "model_menu_tarefas" do
  // "model_menu_principal".
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e atualizar "model_menu_tarefas"
  void adicionar_tarefa(){

  }


  // 3) Função de limpar tarefas concluídas
  // Como essa função foi chamada, então há ao menos 1 tarefa concluída em "model_menu_tarefas" do
  // "model_menu_principal"
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" todas as tarefas concluídas do "model_menu_tarefas" do "model_menu_principal".
  void limpar_tarefas_concluidas(){

  }


  // 4) Função de limpar todas as tarefas
  // Como essa função foi chamada, então há ao menos 1 tarefa em "model_menu_tarefas" do
  // "model_menu_principal".
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" o "model_menu_tarefas" do "model_menu_principal".
  void limpar_tudo(){

  }
}