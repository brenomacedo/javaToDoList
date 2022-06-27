public class ControllerMudarSenha extends ControllerTelasIniciais{
  String senha_nova;

  ControllerMudarSenha(String nome_usuario, String senha, String senha_nova, ModelTelasIniciais model){
    super(nome_usuario, senha, model)
    this.setSenhaNova(senha_nova);
  }

  void setSenhaNova(String senha_nova){
    this.senha_nova = senha_nova;
  }

  String getSenhaNova(){
    return this.senha_nova;
  }

  // Função mudarSenha
  void mudarSenha(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    String senha_nova = this.getSenhaNova();
    int valor_retorno = -2;

    // 1) Verificamos se senha, nome_usuario ou senha_nova são vazios
    int i = Verificadora.verifica_senha_nomeUsuario_senhaNova(nome_usuario, senha, senha_nova);
    
    // 2) senha, nome_usuario e senha_nova não são vazios
    if (i == 0)
      valor_retorno = (this.getDados()).mudar_senha(nome_usuario, senha, senha_nova);
      
    // 3) Setamos a mensagem no model
    String mensagem = Mensagens.gerar_mensagem_mudarsenha(i, valor_retorno);
    (this.getModel()).setMensagem(mensagem);
  }
}