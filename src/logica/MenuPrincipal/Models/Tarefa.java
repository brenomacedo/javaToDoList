package logica.MenuPrincipal.Models;

public class Tarefa{
  String titulo;
  String prioridade;
  String conclusao;
  String descricao;
  String hora;
  String data;
  // Observadores

  // Construtor para "Adicionar Tarefas"
  public Tarefa(String titulo){
    this.setTitulo(titulo);
    this.setPrioridade("0");
    this.setConclusao("");
    this.setDescricao("");
    this.setHora("");
    this.setData("");
  }

  // Construtor para puxar os dados do banco de dados
  public Tarefa(String titulo, String prioridade, String conclusao, String descricao, String hora, String data){
    this.setTitulo(titulo);
    this.setPrioridade(prioridade);
    this.setConclusao(conclusao);
    this.setDescricao(descricao);
    this.setHora(hora);
    this.setData(data);
  }

  public void setTitulo(String titulo){
    this.titulo = titulo;
  }

  public void setPrioridade(String prioridade){
    this.prioridade = prioridade;
  }

  public void setConclusao(String conclusao){
    this.conclusao = conclusao;
  }

  public void setDescricao(String descricao){
    this.descricao = descricao;
  }

  public void setHora(String hora){
    this.hora = hora;
  }

  public void setData(String data){
    this.data = data;
  }

  public String getTitulo(){
    return titulo;
  }

  public String getPrioridade(){
    return prioridade;
  }

  public String getConclusao(){
    return conclusao;
  }

  public String getDescricao(){
    return descricao;
  }

  public String getHora(){
    return hora;
  }

  public String getData(){
    return data;
  }
}