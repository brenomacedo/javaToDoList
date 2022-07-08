package logica.MenuPrincipal.Controllers;

import org.json.JSONObject;
import logica.MenuPrincipal.Models.*;

import java.util.Iterator;

import org.json.JSONArray;
import logica.Arquivos.Dados_tarefas;
import views.EditarTask;
import views.Menu;
import views.VisualizarTask;


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
    tarefa.put("titulo", "Nova Tarefa");
    tarefa.put("descricao", "");
    tarefa.put("data", "");
    tarefa.put("hora", "");
    tarefa.put("prioridade", "0");
    tarefa.put("conclusao", "");

    
    model_menu_principal.setTarefas(
      model_menu_principal.getTarefas().put(tarefa)
    );

    this.menu.botaoLimparTudo.setEnabled(true);

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

  // 5) Função de visualizar tarefa
  public void visualizarTarefa(int index) {
    Iterator<Object> tarefas = this.model_menu_principal.getTarefas().iterator();
    
    JSONObject tarefa = null;

    int indexTarefa = 0;
    while (tarefas.hasNext() && indexTarefa <= index) {
      tarefa = (JSONObject) tarefas.next();
      indexTarefa++;
    }

    String titulo = (String) tarefa.get("titulo");
    String descricao = (String) tarefa.get("descricao");
    String data = (String) tarefa.get("data");
    String hora = (String) tarefa.get("hora");
    String prioridade = (String) tarefa.get("prioridade");
    String conclusao = (String) tarefa.get("conclusao");

    new VisualizarTask(
      titulo, descricao, data, hora, prioridade, conclusao, this.menu
    );
  }

  public void concluirTarefa (int index, boolean value) {
    JSONObject tarefa = Dados_tarefas.buscarTarefa(index, this.model_menu_principal.getTarefas());
    tarefa.put("conclusao", value ? "concluido" : "nao concluido");
    JSONArray tarefasAtualizadas = Dados_tarefas.atualizarDados(index, this.model_menu_principal.getTarefas(), tarefa);
    this.model_menu_principal.setTarefas(tarefasAtualizadas);

    Iterator<Object> iterator = this.model_menu_principal.getTarefas().iterator();

    JSONObject verificaTarefa;
    boolean temConcluido = false;
    while (iterator.hasNext() && !temConcluido) {
      verificaTarefa = (JSONObject) iterator.next();
      if (verificaTarefa.get("conclusao").equals("concluido")) {
        temConcluido = true;
      }
    }

    if (temConcluido) {
      this.model_menu_principal.setLimparTarefasConcluidas(true);
      this.menu.botaoLimparConcluidas.setEnabled(true);
    } else {
      this.model_menu_principal.setLimparTarefasConcluidas(false);
      this.menu.botaoLimparConcluidas.setEnabled(false);
    }
  }

  public void abrirEditarTarefa (int index) {
    Iterator<Object> tarefas = this.model_menu_principal.getTarefas().iterator();
    
    JSONObject tarefa = null;

    int indexTarefa = 0;
    while (tarefas.hasNext() && indexTarefa <= index) {
      tarefa = (JSONObject) tarefas.next();
      indexTarefa++;
    }

    String titulo = (String) tarefa.get("titulo");
    String descricao = (String) tarefa.get("descricao");
    String data = (String) tarefa.get("data");
    String hora = (String) tarefa.get("hora");
    String prioridade = (String) tarefa.get("prioridade");
    String conclusao = (String) tarefa.get("conclusao");
    new EditarTask(
      index,
      titulo,
      descricao,
      data,
      hora,
      prioridade,
      conclusao,
      this.menu
    );
  }

  public void editarTarefa (
    int index,
    String titulo,
    String descricao,
    String data,
    String hora,
    String prioridade
  ) {
    JSONObject tarefaAntiga = Dados_tarefas.buscarTarefa(index, this.model_menu_principal.getTarefas());
    JSONObject novaTarefa = new JSONObject();

    String conclusao = (String) tarefaAntiga.get("conclusao");

    novaTarefa.put("titulo", titulo);
    novaTarefa.put("descricao", descricao);
    novaTarefa.put("data", data);
    novaTarefa.put("hora", hora);
    novaTarefa.put("prioridade", prioridade);
    novaTarefa.put("conclusao", conclusao);

    Dados_tarefas.atualizarDados(index, this.model_menu_principal.getTarefas(), novaTarefa);
  }

  public void deletarTarefa (int index) {
    this.model_menu_principal.getTarefas().remove(index);

    this.model_menu_principal.setAdicionarTarefa(true);
    
    if (this.model_menu_principal.getTarefas().length() == 0) {
      this.model_menu_principal.setLimparTudo(false);
      this.menu.botaoLimparTudo.setEnabled(false);
    }

    Iterator<Object> iterator = this.model_menu_principal.getTarefas().iterator();

    JSONObject tarefa;
    boolean temConcluido = false;
    while (iterator.hasNext() && !temConcluido) {
      tarefa = (JSONObject) iterator.next();
      if (tarefa.get("conclusao").equals("concluido")) {
        temConcluido = true;
      }
    }

    if (!temConcluido) {
      this.model_menu_principal.setLimparTarefasConcluidas(false);
      this.menu.botaoLimparConcluidas.setEnabled(false);
    }
  }
}