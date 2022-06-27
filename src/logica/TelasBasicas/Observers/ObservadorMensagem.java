class ObservadorMensagem{
  String mensagem;
  ModelTelasIniciais model;

  void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  void update(){
    this.mensagem = (this.model).getMensagem();
    // Abrir uma telinha exibindo "mensagem"
  }
}