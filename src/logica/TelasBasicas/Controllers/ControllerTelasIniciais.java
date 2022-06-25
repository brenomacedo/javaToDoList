class ControllerTelasIniciais{
  // Essa classe vai ser a superclasse dos 4 Controllers de Telas Iniciais
  // Serve apenas para evitar a repetição do código abaixo, pois os 4 Controllers de Telas
  // Iniciais terão todos os seguintes métodos e atributos
  String nome_usuario;
  String senha;

  ControllerTelasIniciais(String nome_usuario, String senha) {
    this.setNomeUsuario(nome_usuario);
    this.setSenha(senha);
  }

  void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
  }

  void setSenha(String senha){
    this.senha = senha;
  }

  String getNomeUsuario(){
    return this.nome_usuario;
  }

  String getSenha(){
    return this.senha;
  }
}