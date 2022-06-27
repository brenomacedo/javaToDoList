class ModelMudarSenha extends ModelTelasIniciais{
  String senha_nova;
  // ModelMudarSenha (Observador_mensagem observador_mensagem){
  //  super(Observador_mensagem);
  //}

  void setSenhaNova(String senha_nova){
    this.senha_nova = senha_nova;
  }

  String getSenhaNova(){
    return this.senha_nova;
  }
}