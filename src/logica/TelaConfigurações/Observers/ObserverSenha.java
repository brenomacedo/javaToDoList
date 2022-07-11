package logica.TelaConfigurações.Observers;

/**
 * Observador da senha
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ObserverSenha extends Observer{
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
