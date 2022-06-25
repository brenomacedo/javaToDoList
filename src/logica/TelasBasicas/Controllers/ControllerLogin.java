public class ControllerLogin extends ControllerTelasIniciais{
  ModelLogin model_login;

  ControllerLogin(String nome_usuario, String senha, ModelLogin model_login){
    super(nome_usuario, senha);
    this.setModellogin(model_login);
  }

  void setModelLogin(ModelLogin model_login){
    this.model_login = model_login;
  }

  ModelLogin getModelLogin(){
    return this.model_login;
  }

  // Função verificarLogin
  void verificarLogin(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    int i = 0;

    // 1) Verificamos se senha ou nome_usuario são vazios
    // 2) Caso i == 0, então sabemos que nome_usuario e senha são válidos
    // Nesse caso, verificamos se o login existe.
    if (i == 0)
      i = DadosRegistros.verificarLogin(nome_usuario, senha);

    // 3) Setamos a mensagem no Model
    String mensagem_model = Mensagens.mensagem(i);
    (this.getModelLogin()).setMensagem(mensagem_model);

    // 4) Setamos "i" como "id_usuario" no Model
    (this.getModelLogin()).setIdUsuario(i);
  }
}