package logica.MenuPrincipal.Models;

/**
 * Model de Tarefa
 * @author Tiago Brandão e Gustavo Wendell
 */
public class Tarefa{
  String titulo;
  String prioridade;
  String conclusao;
  String descricao;
  String hora;
  String data;
  // Observadores

  /**
   * Construtor para "Adicionar Tarefas"
   * @param titulo
   */
  public Tarefa(String titulo){
    this.setTitulo(titulo);
    this.setPrioridade("0");
    this.setConclusao("");
    this.setDescricao("");
    this.setHora("");
    this.setData("");
  }

  /**
   * Construtor para puxar os dados do banco de dados
   * @param titulo
   * @param prioridade
   * @param conclusao
   * @param descricao
   * @param hora
   * @param data
   */
  public Tarefa(String titulo, String prioridade, String conclusao, String descricao, String hora, String data){
    this.setTitulo(titulo);
    this.setPrioridade(prioridade);
    this.setConclusao(conclusao);
    this.setDescricao(descricao);
    this.setHora(hora);
    this.setData(data);
  }

  /**
   * 
   * @param titulo
   */
  public void setTitulo(String titulo){
    this.titulo = titulo;
  }

  /**
   * 
   * @param prioridade
   */
  public void setPrioridade(String prioridade){
    this.prioridade = prioridade;
  }

  /**
   * 
   * @param conclusao
   */
  public void setConclusao(String conclusao){
    this.conclusao = conclusao;
  }

  /**
   * 
   * @param descricao
   */
  public void setDescricao(String descricao){
    this.descricao = descricao;
  }

  /**
   * 
   * @param hora
   */
  public void setHora(String hora){
    this.hora = hora;
  }

  /**
   * 
   * @param data
   */
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