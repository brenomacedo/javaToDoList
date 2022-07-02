package logica.MenuPrincipal.Models;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;

public class ModelMenuPrincipal{
  String nome_usuario;
  JSONArray tarefas;
  String porcentagem_tarefas_concluidas;
  boolean adicionar_tarefa; // True se podemos adicionar mais tarefas.
  boolean limpar_tarefas_concluidas; // True se há alguma tarefa concluída para limparmos
  boolean limpar_tudo; // True se há alguma tarefa para limparmos
  JSONObject usuario;

  // Adicionar observadores
  // Fazer attach
  // Fazer notify
  // Fazer construtor
  public ModelMenuPrincipal(JSONObject usuario){
    this.usuario = usuario;

    String nome_usuario = (String) usuario.get("nome_usuario");
    JSONArray tarefas = (JSONArray) usuario.get("tarefas");

    int contador_tarefas = 0;
    int concluidas = 0;
    String porcentagem_tarefas_concluidas;
    boolean adicionar_tarefa, limpar_tarefas_concluidas, limpar_tudo;

    Iterator<Object> iterator_tarefas = tarefas.iterator();
    JSONObject tarefa;
    String conclusão_tarefa;

    // Verificamos cada tarefa em tarefas
    while (iterator_tarefas.hasNext()){
      contador_tarefas++;
      tarefa = (JSONObject) iterator_tarefas.next();
      conclusão_tarefa = (String) tarefa.get("conclusao");
      String conclusao__ = "Concluido";
      if (conclusão_tarefa.equals(conclusao__))
        concluidas++;
    }

    if (contador_tarefas > 0){
      limpar_tudo = true;

      if (concluidas > 0)
        limpar_tarefas_concluidas = true;
      else
        limpar_tarefas_concluidas = false;

      if (contador_tarefas == 14)
        adicionar_tarefa = false;
      else
        adicionar_tarefa = true;

      int num = (concluidas * 100) / contador_tarefas;
      porcentagem_tarefas_concluidas = String.valueOf(num) + "%";
    }

    else{
      porcentagem_tarefas_concluidas = "0%";
      adicionar_tarefa = true;
      limpar_tarefas_concluidas = false;
      limpar_tudo = false;
    }


    this.setNomeUsuario(nome_usuario);
    this.setTarefas(tarefas);
    this.setAdicionarTarefa(adicionar_tarefa);
    this.setLimparTarefasConcluidas(limpar_tarefas_concluidas);
    this.setLimparTudo(limpar_tudo);
    this.setPorcentagemTarefasConcluidas(porcentagem_tarefas_concluidas);
  }

  public void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
  }

  public void setTarefas(JSONArray tarefas){
    this.tarefas = tarefas;
  }

  public void setPorcentagemTarefasConcluidas(String porcentagem_tarefas_concluidas){
    this.porcentagem_tarefas_concluidas = porcentagem_tarefas_concluidas;
  }

  public void setAdicionarTarefa(boolean adicionar_tarefa){
    this.adicionar_tarefa = adicionar_tarefa;
  }

  public void setLimparTarefasConcluidas(boolean limpar_tarefas_concluidas){
    this.limpar_tarefas_concluidas = limpar_tarefas_concluidas;
  }

  public void setLimparTudo(boolean limpar_tudo){
    this.limpar_tudo = limpar_tudo;
  }

  public String getNomeUsuario(){
    return this.nome_usuario;
  }

  public JSONArray getTarefas(){
    return this.tarefas;
  }

  public String getPorcentagemTarefasConcluidas(){
    return this.porcentagem_tarefas_concluidas;
  }

  public boolean getAdicionarTarefa(){
    return this.adicionar_tarefa;
  }

  public boolean getLimparTarefasConcluidas(){
    return this.limpar_tarefas_concluidas;
  }

  public boolean getLimparTudo(){
    return this.limpar_tudo;
  }

  public String getSenha() {
    return (String) this.usuario.get("senha");
  }

  public String getNome() {
    return (String) this.usuario.get("nome");
  }
}