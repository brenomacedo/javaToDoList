package logica.TelaConfigurações.Observers;

public class ObserverSenha extends Observer{
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
