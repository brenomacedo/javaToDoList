package logica.TelaConfigurações.Observers;

public class ObserverApagarRegistro extends Observer {
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
