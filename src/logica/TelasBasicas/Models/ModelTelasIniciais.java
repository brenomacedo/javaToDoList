import org.json.JSONObject;

class ModelTelasIniciais{
  // Essa classe vai ser a superclasse dos 4 Models de Telas Iniciais
  String mensagem;
  JSONObject usuario;
  ObservadorMensagem observador_mensagem;
  ObservadorLogin observador_login;

  ModelTelasIniciais(){
    this.attachObservadorMensagem(new ObservadorMensagem());
    this.attachObservadorLogin(new ObservadorLogin());
  }

  void attachObservadorMensagem(ObservadorMensagem observador){
    this.observador_mensagem = observador;
    observador.setModel(this);
  }

  void attachObservadorLogin(ObservadorLogin observador){
    this.observador_login = observador;
    observador.setModel(this);
  }

  void NotifyMensagem(){
    (this.observador_mensagem).update();
  }

  void setMensagem(String mensagem){
    this.mensagem = mensagem;
    this.NotifyMensagem();
  }

  String getMensagem(){
    return this.mensagem;
  }

  void NotifyLogin(){
    (this.observador_login).update();
  }

  void setUsuario(JSONObject usuario){
    this.usuario = usuario;
    this.NotifyLogin();
  }

  JSONObject getUsuario(){
    return this.usuario;
  }
}