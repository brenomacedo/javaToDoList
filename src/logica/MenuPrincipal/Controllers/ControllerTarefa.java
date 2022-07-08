package logica.MenuPrincipal.Controllers;
import org.json.JSONArray;
import org.json.JSONObject;

import logica.Arquivos.Dados_tarefas;
import logica.MenuPrincipal.Models.*;

public class ControllerTarefa{
  int index;

  ModelMenuPrincipal model;

  ControllerTarefa (int index, ModelMenuPrincipal model) {
    this.model = model;
    this.index = index;
  }

  void concluirTarefa () {
    JSONObject tarefa = Dados_tarefas.buscarTarefa(index, model.getTarefas());
    String estadoAtual = (String) tarefa.get("conclusao");
    tarefa.put("conclusao", estadoAtual == "concluido" ? "nao concluido" : "concluido");
    JSONArray tarefasAtualizadas = Dados_tarefas.atualizarDados(index, model.getTarefas(), tarefa);
    model.setTarefas(tarefasAtualizadas);
  }
}