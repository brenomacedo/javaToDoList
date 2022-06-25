public class ControllerMudarSenha extends ControllerTelasIniciais{
  String senha_nova;
  ModelMudarSenha model_mudar_senha;

  ControllerMudarSenha(String nome_usuario, String senha, String senha_nova, ModelMudarSenha model_mudar_senha){
    super(nome_usuario, senha)
    this.setSenhaNova(senha_nova);
    this.setModelMudarSenha(model_mudar_senha);
  }

  void setSenhaNova(String senha_nova){
    this.senha_nova = senha_nova;
  }

  void setModelMudarSenha(ModelMudarSenha model_mudar_senha){
    this.model_mudar_senha = model_mudar_senha;
  }

  String getSenhaNova(){
    return this.senha_nova;
  }

  ModelMudarSenha getModelMudarSenha(){
    return this.model_mudar_senha;
  }

  // Função mudarSenha
  void mudarSenha(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    String senha_nova = this.getSenhaNova();

    // 1) Verificamos se senha, nome_usuario ou senha_nova são vazios
    // 2) Agora verificamos se esse login existe
    // 3) Caso não exista esse login
    // 4) Caso exista esse login
  }
}