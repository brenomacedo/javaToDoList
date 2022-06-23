public class ModelApagarRegistro{
  String nome_usuario;
  String senha;

  ModelApagarRegistro(String nome_usuario, String senha){
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

  // Função apagar
  int apagar(){
    // 1) Criamos uma ModelLogin e verificamos se o login existe
    ModelLogin teste = new ModelLogin(ModelApagarRegistro.getNomeUsuario(), ModelApagarRegistro.getSenha());
    int valor_retorno = teste.verificarLogin();

    // 2) Se o login não existir, então retornamos valor_retorno para que a View exiba alguma mensagem de erro
    if (valor_retorno < 0)
      return valor_retorno;

    // 3) Caso contrário, apagamos o registro e então retornamos 0 para que a View exiba uma mensagem de
    // "Registro apagado com sucesso"
    else{
      DadosRegistros.apagar(valor_retorno);
      return 0;
    }
  }
}