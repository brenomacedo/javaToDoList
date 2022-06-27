class ControllerTelasIniciais{
  // Essa classe vai ser a superclasse dos 4 Controllers de Telas Iniciais
  // Serve apenas para evitar a repetição do código abaixo, pois os 4 Controllers de Telas
  // Iniciais terão todos os seguintes métodos e atributos
  String nome_usuario;
  String senha;
  Dados dados;
  ModelTelasIniciais model;

  ControllerTelasIniciais(String nome_usuario, String senha, ModelTelasIniciais model) {
    this.setNomeUsuario(nome_usuario);
    this.setSenha(senha);
    this.setDados(new Dados());
  }

  void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
  }

  void setSenha(String senha){
    this.senha = senha;
  }

  void setDados(Dados dados){
    this.dados = dados;
  }

  void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  String getNomeUsuario(){
    return this.nome_usuario;
  }

  String getSenha(){
    return this.senha;
  }

  Dados getDados(){
    return this.dados;
  }

  ModelTelasIniciais getModel(){
    return this.model;
  }
}