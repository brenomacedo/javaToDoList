package logica.TelaConfigurações.Observers;

public class ObserverNome extends Observer{
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
