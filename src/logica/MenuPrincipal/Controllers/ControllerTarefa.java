public class ControllerTarefa{
  Tarefa tarefa;

  // 1) concluir
  void concluirTarefa(){
    this.setConclusao("Concluída");
  }


  // 2) editar
  void editarTarefa(String titulo, String prioridade, String descricao, String hora, String data){
    if (titulo != "")
      this.setTitulo(titulo);

    if (prioridade != "")
      this.setPrioridade(prioridade);

    if (descricao != "")
      this.setDescricao(descricao);

    if (hora != "")
      this.setHora(hora);

    if (datos != "")
      this.setData(data);
  }
}