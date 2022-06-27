public class ControllerCadastro extends ControllerTelasIniciais{
  ControllerCadastro(String nome_usuario, String senha, ModelTelasIniciais model) {
    super(nome_usuario, senha, model);
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
    (this.getModel()).setMensagem(mensagem);
  }
}