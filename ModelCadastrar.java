public class ModelCadastrar{
  String nome_usuario;
  String senha;

  ModelCadastrar(String nome_usuario, String senha){
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

  // Função cadastrar
  int cadastrar(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();

    // 1) Verificamos se senha ou nome_usuario são vazios
    if (senha == "")
      return -1;
    
    if (nome_usuario =="")
      return -2;

    if (nome_usuario == "" && senha == "")
      return -3;

    // 2) Como chegamos até aqui -> senha != "" e nome_usuario != ""
    // 3) Agora verificamos se nome_usuario é válido, isto é, se é um nome que ainda não foi usado
    if (DadosRegistros.verificarNomeUsuario(this)){
      DadosRegistros.cadastrar(this);
      return 0;
    }
    else
      return -4;
  }
}