package logica.TelasBasicas.Observers;

import org.json.JSONObject;
import logica.TelasBasicas.Models.ModelTelasIniciais;

public class ObservadorLogin{
  JSONObject usuario;
  ModelTelasIniciais model;

  public void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  public void update(){
    this.usuario = (this.model).getUsuario();
    // Abrir o menu principal. Passar "this.usuario" como parâmetro
  }
}