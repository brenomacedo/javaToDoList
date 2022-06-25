class ControllerMenuPrincipal{
  ModelMenuPrincipal model_menu_principal;
  int id_usuario;

  ControllerMenuPrincipal(int id_usuario){
    this.setIdUsuario(id_usuario);
    this.iniciar();
  } 

  void setIdUsuario(int id_usuario){
    this.id_usuario = id_usuario;
  }

  int getIdUsuario(){
    return this.id_usuario;
  }

  // 1) Função de inicializar o MenuPrincipal (após fazer o login)
  void iniciar(){

  }

  // OBS: Ao "adicionar_tarefa", "limpar_tarefas_concluidas" ou "limpar_tudo", precisamos modificar
  // o "model_menu_tarefas" do "model_menu_principal"


  // 2) Função de adicionar tarefas
  // Como essa função foi chamada, então podemos adicionar mais uma tarefa em "model_menu_tarefas" do
  // "model_menu_principal".
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e atualizar "model_menu_tarefas"
  void adicionar_tarefa(){

  }


  // 3) Função de limpar tarefas concluídas
  // Como essa função foi chamada, então há ao menos 1 tarefa concluída em "model_menu_tarefas" do
  // "model_menu_principal"
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" todas as tarefas concluídas do "model_menu_tarefas" do "model_menu_principal".
  void limpar_tarefas_concluidas(){

  }


  // 4) Função de limpar todas as tarefas
  // Como essa função foi chamada, então há ao menos 1 tarefa em "model_menu_tarefas" do
  // "model_menu_principal".
  // Precisamos atualizar "porcentagem_tarefas_concluidas" e "zerar" o "model_menu_tarefas" do "model_menu_principal".
  void limpar_tudo(){

  }
}