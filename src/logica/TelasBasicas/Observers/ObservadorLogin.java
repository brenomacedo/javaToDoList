class ObservadorLogin{
  JSONObject usuario;
  ModelTelasIniciais model;

  void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  void update(){
    this.usuario = (this.model).getUsuario();
    // Abrir o menu principal. Passar "this.usuario" como parâmetro
  }
}