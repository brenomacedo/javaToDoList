package logica.Arquivos;

import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Iterator;

/**
 * Classe que realiza as operações com os dados das tarefas
 * @author Tiago Brandão e Gustavo Wendell
 */

public class Dados_tarefas{
  /**
   * Adiciona uma tarefa
   * @param tarefas
   * @param titulo
    */
  public static JSONArray adicionar_tarefa(JSONArray tarefas, String titulo){
    JSONObject objeto_tarefa = new JSONObject();
    objeto_tarefa.put("titulo", titulo);
    objeto_tarefa.put("descricao", "");
    objeto_tarefa.put("data", "");
    objeto_tarefa.put("horas", "");
    objeto_tarefa.put("prioridade", "");
    objeto_tarefa.put("conclusao", "nao concluido");

    tarefas.put(objeto_tarefa);
    return tarefas;
  }

  /**
   * Função auxiliar para limpar tarefas concluidas
   * @param tarefas
   * @return
   */
  public static int getIndexTarefaConcluida(JSONArray tarefas){
    int i = -1;
    JSONObject tarefa;
    String conclusao;
    String aux_conclusao = "concluido";
    Iterator<Object> iterator_tarefas = tarefas.iterator();

    while (iterator_tarefas.hasNext()){
      tarefa = (JSONObject)iterator_tarefas.next();
      conclusao = (String) tarefa.get("conclusao");
      i++;
      if (conclusao.equals(aux_conclusao))
        return i;
    }

    return -1;
  }

  /**
   * Limpar Tarefas concluídas
   * @param tarefas
   * @return
   */
  public static JSONArray limparConcluidas(JSONArray tarefas){
    int index = 0;
    while (index != -1){
      index = Dados_tarefas.getIndexTarefaConcluida(tarefas);
      tarefas.remove(index);
    }

    return tarefas;
  }

  /**
   * busca uma tarefa pelo index
   * @param index
   * @param tarefas
   * @return
   */
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

  /**
   * Atualiza os dados de uam tarefa
   * @param index
   * @param tarefas
   * @param tarefaAtualizada
   * @return
   */
  public static JSONArray atualizarDados (int index, JSONArray tarefas, JSONObject tarefaAtualizada) {
    tarefas.put(index, tarefaAtualizada);
    return tarefas;
  }
}