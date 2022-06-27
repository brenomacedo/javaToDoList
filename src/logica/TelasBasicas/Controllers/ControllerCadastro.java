public class ControllerCadastro extends ControllerTelasIniciais{
  ModelCadastro model_cadastro;

  ControllerCadastro(String nome_usuario, String senha, ModelCadastro model_cadastro) {
    super(nome_usuario, senha);
    this.setModelcadastrar(model_cadastro);
  }

  void setModelcadastro(ModelCadastro model_cadastro){
    this.model_cadastro = model_cadastro;
  }

  ModelCadastro getModelCadastro(){
    return this.model_cadastro;
  }

  // Função cadastrar
  void cadastrar(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    int valor_retorno = -2;

    // 1) Verificamos se senha ou nome_usuario são vazios
    int i = Verificadora.verifica_senha_nomeUsuario(nome_usuario, senha);
    
    // 2) nome_usuario e senha não são vazios
    if (i == 0)
      valor_retorno = (this.getDados()).cadastrar(nome_usuario, senha);

    // 3) Setamos a mensagem no Model
    String mensagem = Mensagens.gera_mensagem_cadastro(i, valor_retorno);
    (this.getModelCadastro()).setMensagem(mensagem);
  }
}