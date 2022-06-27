class ModelMudarSenha extends ModelTelasIniciais{
  String senha_nova;
  
  ModelMudarSenha (){
    super();
  }

  void setSenhaNova(String senha_nova){
    this.senha_nova = senha_nova;
  }

  String getSenhaNova(){
    return this.senha_nova;
  }
}