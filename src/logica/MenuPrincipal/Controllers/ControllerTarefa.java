package logica.MenuPrincipal.Controllers;
import logica.MenuPrincipal.Models.*;

public class ControllerTarefa{
  Tarefa tarefa;
  String vazio = "";

  // 1) concluir
  void concluirTarefa(){
    this.tarefa.setConclusao("Concluída");
  }


  // 2) editar
  void editarTarefa(String titulo, String prioridade, String descricao, String hora, String data){
    if (titulo.equals(vazio))
      this.tarefa.setTitulo(titulo);

    if (prioridade.equals(vazio))
      this.tarefa.setPrioridade(prioridade);

    if (descricao.equals(vazio))
      this.tarefa.setDescricao(descricao);

    if (hora.equals(vazio))
      this.tarefa.setHora(hora);

    if (data.equals(vazio))
      this.tarefa.setData(data);
  }

  // void removerTarefa()
}