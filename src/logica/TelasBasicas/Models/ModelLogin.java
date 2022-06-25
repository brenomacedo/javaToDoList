class ModelLogin extends ModelTelasIniciais{
  int id_usuario;
  // Observador_login observador_login;

  // ModelLogin(Observador_mensagem observador_mensagem, Observador_login observador_login){
  //   super(Observador_mensagem);
  //   this.setIdUsuario(0)
  // }

  void setIdUsuario(int idusuario){
    this.id_usuario = idusuario;
    // if (idusuario != 0)
      // this.Notify
  }

  int getIdUsuario(){
    return this.id_usuario;
  }
}