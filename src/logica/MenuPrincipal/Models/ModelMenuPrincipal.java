class ModelMenuPrincipal{
  String nome_usuario;
  ModelMenuTarefas model_menu_tarefas;
  int porcentagem_tarefas_concluidas;
  boolean adicionar_tarefa; // True se podemos adicionar mais tarefas.
  boolean limpar_tarefas_concluidas; // True se há alguma tarefa concluída para limparmos
  boolean limpar_tudo_; // True se há alguma tarefa para limparmos

  // Adicionar observadores
  // Fazer attach
  // Fazer notify
  // Fazer construtor
  void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
  }

  void setModelMenuTarefas(ModelMenuTarefas model_menu_tarefas){
    this.model_menu_tarefas = model_menu_tarefas;
  }

  void setPorcentagemTarefasConcluidas(int porcentagem_tarefas_concluidas){
    this.porcentagem_tarefas_concluidas = porcentagem_tarefas_concluidas;
  }

  void setAdicionarTarefa(boolean adicionar_tarefa){
    this.adicionar_tarefa = adicionar_tarefa;
  }

  void setLimparTarefasConcluidas(boolean limpar_tarefas_concluidas){
    this.limpar_tarefas_concluidas = limpar_tarefas_concluidas;
  }

  void setLimparTudo(boolean limpar_tudo){
    this.limpar_tudo = limpar_tudo;
  }

  // Fazer os getter's
}