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
    int valor_retorno = -2;

    // 1) Verificamos se senha ou nome_usuario são vazios
    int i = Verificadora.verifica_senha_nomeUsuario(nome_usuario, senha);

    // nome_usuario e senha não são vazios
    if (i == 0)
      valor_retorno = (this.getDados()).verificarLogin(nome_usuario, senha);

      // Login existe
      if (valor_retorno == 0)
        (this.getModelLogin()).setUsuario(dados.getUsuario());


    // 2) Setamos a mensagem no Model
    String mensagem = Mensagens.gera_mensagem_login(i, valor_retorno);
    (this.getModelLogin()).setMensagem(mensagem);
  }
}