package logica.MenuPrincipal.Controllers;
import org.json.JSONArray;
import org.json.JSONObject;

import logica.Arquivos.Dados_tarefas;
import logica.MenuPrincipal.Models.*;

public class ControllerTarefa{
  Tarefa tarefa;
  int index;

  ModelMenuPrincipal model;

  ControllerTarefa (int index, ModelMenuPrincipal model) {
    this.model = model;
    this.index = index;
  }

  void concluirTarefa () {
    JSONObject tarefa = Dados_tarefas.buscarTarefa(index, model.getTarefas());
    String estadoAtual = (String) tarefa.get("conclusao");
    tarefa.put("conclusao", estadoAtual == "concluido" ? "naoconcluido" : "concluido");
    JSONArray tarefasAtualizadas = Dados_tarefas.atualizarDados(index, model.getTarefas(), tarefa);
    model.setTarefas(tarefasAtualizadas);
  }

  void addTarefa (String titulo, String descricao, String data, String hora, int prioridade, String conclusao) {
    JSONObject tarefa = new JSONObject();
    tarefa.put("titulo", titulo);
    tarefa.put("descricao", descricao);
    tarefa.put("data", data);
    tarefa.put("hora", hora);
    tarefa.put("prioridade", prioridade);
    tarefa.put("conclusao", conclusao);
  }
}