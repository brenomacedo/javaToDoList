public class ModelMudarSenha{
  String nome_usuario;
  String senha_atual;
  String senha_nova;

  ModelMudarSenha(String nome_usuario, String senha_atual, String senha_nova){
    this.setNomeUsuario(nome_usuario);
    this.setSenha(senha_atual);
    this.setSenhaNova(senha_nova);
  }

  void setNomeUsuario(String nome_usuario){
    this.nome_usuario = nome_usuario;
  }

  void setSenha(String senha_atual){
    this.senha_atual = senha_atual;
  }

  void setSenhaNova(String senha_nova){
    this.senha_nova = senha_nova;
  }

  void TrocarSenha(){
    this.setSenha(this.getSenhaNova());
  }

  String getNomeUsuario(){
    return this.nome_usuario;
  }

  String getSenhaAtual(){
    return this.senha_atual;
  }

  String getSenhaNova(){
    return this.senha_nova;
  }

  // Função mudarSenha
  int mudarSenha(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    String senha_nova = this.getSenhaNova();

    // 1) Verificamos se senha, nome_usuario ou senha_nova são vazios
    if (senha == "")
      return -1;
    
    if (senha_nova == "")
      return -2;

    if (nome_usuario == "")
      return -3;

    if (senha == "" && senha_nova == "")
      return -4;

    if (senha == "" && nome_usuario == "")
      return -5;

    if (senha_nova == "" && nome_usuario == "")
      return -6;

    if (senha == "" && senha_nova == "" && nome_usuario =="")
      return -7;

    // 2) Como chegamos até aqui -> senha != "", nome_usuario != "" e senha_nova != ""
    // 3) Agora verificamos se esse login existe
    ModelLogin teste = new ModelLogin(nome_usuario, senha);
    int valor_retorno = teste.verificarLogin();

    // 4) Caso não exista esse login
    if (valor_retorno < 0)
      return valor_retorno;

    // 5) Caso exista esse login
    else{
      DadosRegistros.atualizar(valor_retorno, this);
      return 0;
    }
  }
}