package logica.TelasBasicas.Observers;
import javax.swing.JOptionPane;

import logica.TelasBasicas.Models.ModelTelasIniciais;

public class ObservadorMensagem{
  String mensagem;
  ModelTelasIniciais model;

  public void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  public void update(){
    this.mensagem = (this.model).getMensagem();
    
    JOptionPane.showMessageDialog(null, this.mensagem, "Aviso", JOptionPane.INFORMATION_MESSAGE);
  }
}