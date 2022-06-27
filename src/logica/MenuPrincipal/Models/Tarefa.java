public class Tarefa{
  String titulo;
  String prioridade;
  String conclusao;
  String descricao;
  String hora;
  String data;
  Pagina pagina_fonte;
  // Observadores

  // Construtor para "Adicionar Tarefas"
  Tarefa(String titulo){
    this.setTitulo(titulo);
    this.setPrioridade("0");
    this.setConclusao("");
    this.setDescricao("");
    this.setHora("");
    this.setData("");
  }

  // Construtor para puxar os dados do banco de dados
  Tarefa(String titulo, String prioridade, String conclusao, String descricao, String hora, String data){
    this.setTitulo(titulo);
    this.setPrioridade(prioridade);
    this.setConclusao(conclusao);
    this.setDescricao(descricao);
    this.setHora(hora);
    this.setData(data);
  }

  void setTitulo(String titulo){
    this.titulo = titulo;
  }

  void setPrioridade(String prioridade){
    this.prioridade = prioridade;
  }

  void setConclusao(String conclusao){
    this.conclusao = conclusao;
  }

  void setDescricao(String descricao){
    this.descricao = descricao;
  }

  void setHora(String hora){
    this.hora = hora;
  }

  void setData(String data){
    this.data = data;
  }

  String getTitulo(){
    return titulo;
  }

  String getPrioridade(){
    return prioridade;
  }

  String getConclusao(){
    return conclusao;
  }

  String getDescricao(){
    return descricao;
  }

  String getHora(){
    return hora;
  }

  String getData(){
    return data;
  }
}