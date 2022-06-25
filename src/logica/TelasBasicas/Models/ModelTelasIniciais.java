class ModelTelasIniciais{
  // Essa classe vai ser a superclasse dos 4 Models de Telas Iniciais
  // Serve apenas para evitar a repetição do código abaixo, pois os 4 Models de Telas
  // Iniciais terão todos os seguintes métodos e atributos

  String mensagem;
  // Observador_mensagem observador_mensagem;

  // ModelTelasIniciais(Observador_mensagem observador_mensagem){
  //   this.attach(observador);
  //   this.setMensagem(""); 
  // }

  // void attach(Observador observador){}

  void setMensagem(String mensagem){
    this.mensagem = mensagem;
    // if (mensagem != "")
      // this.Notify();
  }

  String getMensagem(){
    return this.mensagem;
  }

  // void Notify(){}
}