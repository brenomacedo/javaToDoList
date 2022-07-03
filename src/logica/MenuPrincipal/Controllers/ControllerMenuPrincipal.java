package logica.MenuPrincipal.Controllers;

import org.json.JSONObject;
import logica.MenuPrincipal.Models.*;
import org.json.JSONArray;
import logica.Arquivos.Dados_tarefas;
import views.Menu;


public class ControllerMenuPrincipal{
  ModelMenuPrincipal model_menu_principal;
  JSONObject usuario;
  Menu menu;

  public ControllerMenuPrincipal(JSONObject usuario, Menu menu){
    this.setUsuario(usuario);
    this.setMenu(menu);
    this.iniciar();
  } 

  public void setUsuario(JSONObject usuario){
    this.usuario = usuario;
  }

  public JSONObject getUsuario(){
    return this.usuario;
  }

  public void setMenu(Menu menu){
    this.menu = menu;
  }

  public Menu getMenu(){
    return this.menu;
  }

  public void setModelMenuPrincipal(ModelMenuPrincipal model_menu_principal){
    this.model_menu_principal = model_menu_principal;
  }

  public ModelMenuPrincipal getModelMenuPrincipal(){
    return this.model_menu_principal;
  }

  // 1) Função de inicializar o MenuPrincipal (após fazer o login)
  public void iniciar(){
    ModelMenuPrincipal model_menu_principal = new ModelMenuPrincipal(this.getUsuario(), this.getMenu());
    this.setModelMenuPrincipal(model_menu_principal);
  }

  // 2) Função de adicionar tarefas
  // Como essa função foi chamada, então podemos adicionar mais uma tarefa em "model_menu_tarefas" do
  // "model_menu_principal".
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e atualizar "model_menu_tarefas"
  public void addTarefa () {
    JSONObject tarefa = new JSONObject();
    tarefa.put("titulo", "Nova tarefa");
    tarefa.put("descricao", "");
    tarefa.put("data", "");
    tarefa.put("hora", "");
    tarefa.put("prioridade", 0);
    tarefa.put("conclusao", "");

    
    model_menu_principal.setTarefas(
      model_menu_principal.getTarefas().put(tarefa)
    );

    model_menu_principal.notifyAdicionarTarefa();
  }


  // 3) Função de limpar tarefas concluídas
  // Como essa função foi chamada, então há ao menos 1 tarefa concluída em "model_menu_tarefas" do
  // "model_menu_principal"
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" todas as tarefas concluídas do "model_menu_tarefas" do "model_menu_principal".
  public void limpar_tarefas_concluidas(){
    JSONArray tarefas = Dados_tarefas.limparConcluidas(((this.model_menu_principal).getTarefas()));
    (this.model_menu_principal).setTarefas(tarefas);
  }


  // 4) Função de limpar todas as tarefas
  // Como essa função foi chamada, então há ao menos 1 tarefa em "model_menu_tarefas" do
  // "model_menu_principal".
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" o "model_menu_tarefas" do "model_menu_principal".
  public void limpar_tudo(){
    (this.model_menu_principal).setTarefas(new JSONArray());
  }
}