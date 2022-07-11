package logica.MenuPrincipal.Controllers;

import org.json.JSONObject;
import logica.MenuPrincipal.Models.*;

import java.util.Iterator;

import org.json.JSONArray;

import logica.Arquivos.Dados;
import logica.Arquivos.Dados_tarefas;
import views.EditarTask;
import views.Menu;
import views.VisualizarTask;

/**
 * Controller do menu principal
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ControllerMenuPrincipal{
  ModelMenuPrincipal model_menu_principal;
  JSONObject usuario;
  Menu menu;

  /**
   * constructor do controller
   * @param usuario
   * @param menu
   */
  public ControllerMenuPrincipal(JSONObject usuario, Menu menu){
    this.setUsuario(usuario);
    this.setMenu(menu);
    this.iniciar();
  } 

  /**
   * 
   * @param usuario
   */
  public void setUsuario(JSONObject usuario){
    this.usuario = usuario;
  }

  public JSONObject getUsuario(){
    return this.usuario;
  }

  /**
   * 
   * @param menu
   */
  public void setMenu(Menu menu){
    this.menu = menu;
  }

  public Menu getMenu(){
    return this.menu;
  }

  /**
   * 
   * @param model_menu_principal
   */
  public void setModelMenuPrincipal(ModelMenuPrincipal model_menu_principal){
    this.model_menu_principal = model_menu_principal;
  }

  public ModelMenuPrincipal getModelMenuPrincipal(){
    return this.model_menu_principal;
  }

  /**
   * Função de inicializar o MenuPrincipal (após fazer o login)
   */
  public void iniciar(){
    ModelMenuPrincipal model_menu_principal = new ModelMenuPrincipal(this.getUsuario(), this.getMenu());
    this.setModelMenuPrincipal(model_menu_principal);
  }

  /**
   * Função de adicionar tarefas
   * Como essa função foi chamada, então podemos adicionar mais uma tarefa em "model_menu_tarefas" do
   * "model_menu_principal".
   * Precisamos atualizar "porcentagem_tarefas_concluidas" e atualizar "model_menu_tarefas"
   */
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


  /**
   * Função de limpar tarefas concluídas
   * Como essa função foi chamada, então há ao menos 1 tarefa concluída em "model_menu_tarefas" do
   * "model_menu_principal"
   * Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" todas as tarefas concluídas do "model_menu_tarefas" do "model_menu_principal".
   */
  public void limpar_tarefas_concluidas(){
    JSONArray tarefas = Dados_tarefas.limparConcluidas(((this.model_menu_principal).getTarefas()));
    (this.model_menu_principal).setTarefas(tarefas);
  }


  /**
   * Função de limpar todas as tarefas
   * Como essa função foi chamada, então há ao menos 1 tarefa em "model_menu_tarefas" do
   * "model_menu_principal".
   * Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" o "model_menu_tarefas" do "model_menu_principal".
   */
  public void limpar_tudo(){
    (this.model_menu_principal).setTarefas(new JSONArray());
  }

  /**
   * Função de visualizar tarefa
   * @param index
   */
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

  /**
   * muda o valor de conclusao da tarefa
   * @param index
   * @param value
   */
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

  /**
   * abre a tela de edição de tarefa
   * @param index
   */
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

  /**
   * edita uma tarefa
   * @param index
   * @param titulo
   * @param descricao
   * @param data
   * @param hora
   * @param prioridade
   */
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

  /**
   * deleta uma tarefa
   * @param index
   */
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

    this.menu.botaoAdicionar.setEnabled(true);

    if (!temConcluido) {
      this.model_menu_principal.setLimparTarefasConcluidas(false);
      this.menu.botaoLimparConcluidas.setEnabled(false);
    }
  }

  /**
   * limpa as tarefas concluidas
   */
  public void limparConcluidas () {
    this.model_menu_principal.setTarefas(
      Dados_tarefas.limparConcluidas(this.model_menu_principal.getTarefas())
    );

    this.model_menu_principal.setLimparTarefasConcluidas(false);
    this.menu.botaoLimparConcluidas.setEnabled(false);
    
    this.model_menu_principal.setAdicionarTarefa(true);
    this.menu.botaoAdicionar.setEnabled(true);

    if (this.model_menu_principal.getTarefas().length() == 0) {
      this.model_menu_principal.setLimparTudo(false);
      this.menu.botaoLimparTudo.setEnabled(false);
    }
  }

  /**
   * limpa todas as tarefas
   */
  public void limparTudo () {
    this.model_menu_principal.getTarefas().clear();

    this.model_menu_principal.setLimparTarefasConcluidas(false);
    this.menu.botaoLimparConcluidas.setEnabled(false);

    this.model_menu_principal.setLimparTudo(false);
    this.menu.botaoLimparTudo.setEnabled(false);
    this.model_menu_principal.setAdicionarTarefa(true);
    this.menu.botaoAdicionar.setEnabled(true);
  }

  /**
   * salva os dados
   */
  public void salvarDados () {
    Dados dados = new Dados();
    dados.salvarUsuario(usuario);
  }
}