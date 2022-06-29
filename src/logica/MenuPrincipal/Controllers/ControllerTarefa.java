package logica.MenuPrincipal.Controllers;
import logica.MenuPrincipal.Models.*;

public class ControllerTarefa{
  Tarefa tarefa;

  // 1) concluir
  void concluirTarefa(){
    this.tarefa.setConclusao("Concluída");
  }


  // 2) editar
  void editarTarefa(String titulo, String prioridade, String descricao, String hora, String data){
    if (titulo != "")
      this.tarefa.setTitulo(titulo);

    if (prioridade != "")
      this.tarefa.setPrioridade(prioridade);

    if (descricao != "")
      this.tarefa.setDescricao(descricao);

    if (hora != "")
      this.tarefa.setHora(hora);

    if (data != "")
      this.tarefa.setData(data);
  }
}