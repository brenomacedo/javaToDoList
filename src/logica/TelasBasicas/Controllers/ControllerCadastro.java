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
    int i = 0;

    // 1) Verificamos se senha ou nome_usuario são vazios
    // 2) Caso i == 0, então sabemos que nome_usuario e senha são válidos
    if (i == 0)
      // Nesse caso, verificamos se nome_usuario é válido.
      // Se sim, fazemos o cadastro
      if (DadosRegistros.verificarNomeUsuario(nome_usuario))
        DadosRegistros.cadastrar(nome_usuario, senha);
      else
        i = -4;
    else
      i = -5;

    // 3) Setamos a mensagem no Model
    String mensagem_model = Mensagens.mensagem(i);
    (this.getModelCadastro()).setMensagem(mensagem_model);
  }
}