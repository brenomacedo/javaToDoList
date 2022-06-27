public class ControllerApagarRegistro extends ControllerTelasIniciais{
  ModelApagarRegistro model_apagar_registro;

  ControllerApagarRegistro(String nome_usuario, String senha, ModelApagarRegistro model_apagar_registro){
    super(nome_usuario, senha);
    this.setModelApagarRegistro(model_apagar_registro);
  }

  void setModelApagarRegistro(ModelApagarRegistro model_apagar_registro){
    this.model_apagar_registro = model_apagar_registro;
  }

  ModelApagarRegistro getModelApagarRegistro(){
    return this.model_apagar_registro;
  }

  // Função apagar
  void apagar(){
    String nome_usuario = (this.getNomeUsuario()).toUpperCase();
    String senha = this.getSenha();
    int valor_retorno = -2;

    // 1) Verificamos se senha ou nome_usuario são vazios
    int i = Verificadora.verifica_senha_nomeUsuario(nome_usuario, senha);
    
    // 2) nome_usuario e senha não são vazios
    if (i == 0)
      valor_retorno = (this.getDados()).apagar_registro(nome_usuario, senha);

    // 3) Setamos a mensagem no Model
    String mensagem = Mensagens.gera_mensagem_apagarRegistro(i, valor_retorno);
    (this.getModelApagarRegistro()).setMensagem(mensagem);
  }
}