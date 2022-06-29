package logica.TelasBasicas.Observers;
import logica.TelasBasicas.Models.ModelTelasIniciais;

public class ObservadorMensagem{
  String mensagem;
  ModelTelasIniciais model;

  public void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  public void update(){
    this.mensagem = (this.model).getMensagem();
    // Abrir uma telinha exibindo "mensagem"
  }
}