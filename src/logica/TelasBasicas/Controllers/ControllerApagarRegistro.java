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
    // 1) Verificamos se o login existe

    // 2) Se o login não existir:

    // 3) Caso contrário, apagamos o registro e então retornamos 0 para que a View exiba uma mensagem de
    // "Registro apagado com sucesso"
  }
}