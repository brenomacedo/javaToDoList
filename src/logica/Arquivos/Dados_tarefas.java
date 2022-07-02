package logica.Arquivos;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;

public class Dados_tarefas{
  // 1) Adicionar Tarefas
  public static JSONArray adicionar_tarefa(JSONArray tarefas, String titulo){
    JSONObject objeto_tarefa = new JSONObject();
    objeto_tarefa.put("Titulo", titulo);
    objeto_tarefa.put("Descricao", "");
    objeto_tarefa.put("Data", "");
    objeto_tarefa.put("Horas", "");
    objeto_tarefa.put("Prioridade", "");
    objeto_tarefa.put("Conclusao", "Nao concluida");

    tarefas.put(objeto_tarefa);
    return tarefas;
  }

  // Função auxiliar para limpar tarefas concluidas
  public static int getIndexTarefaConcluida(JSONArray tarefas){
    int i = -1;
    JSONObject tarefa;
    String conclusao;
    String aux_conclusao = "Concluida";
    Iterator<Object> iterator_tarefas = tarefas.iterator();

    while (iterator_tarefas.hasNext()){
      tarefa = (JSONObject)iterator_tarefas.next();
      conclusao = (String) tarefa.get("Conclusao");
      i++;
      if (conclusao.equals(aux_conclusao))
        return i;
    }

    return -1;
  }

  // 2) Limpar Tarefas concluídas
  public static JSONArray limparConcluidas(JSONArray tarefas){
    int index = 0;
    while (index != -1){
      index = Dados_tarefas.getIndexTarefaConcluida(tarefas);
      tarefas.remove(index);
    }

    return tarefas;
  }

  public static JSONObject buscarTarefa (int index, JSONArray tarefas) {
    Iterator<Object> iterator = tarefas.iterator();

    JSONObject tarefa = null;

    int i = 0;
    while (iterator.hasNext() && i <= index) {
      tarefa = (JSONObject) iterator.next();
      i++;
    }

    return tarefa;
  }

  public static JSONArray atualizarDados (int index, JSONArray tarefas, JSONObject tarefaAtualizada) {
    tarefas.put(index, tarefaAtualizada);
    return tarefas;
  }
}