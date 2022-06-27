class ModelLogin extends ModelTelasIniciais{
  JSONObject usuario;
  // Observador_login observador_login;

  // ModelLogin(Observador_mensagem observador_mensagem, Observador_login observador_login){
  //   super(Observador_mensagem);
  // }

  void setUsuario(JSONObject usuario){
    this.usuario = usuario;
    // if (idusuario != 0)
      // this.Notify
  }

  JSONObject getUsuario(){
    return this.usuario;
  }
}