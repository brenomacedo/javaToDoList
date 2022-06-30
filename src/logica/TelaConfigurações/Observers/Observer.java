package logica.TelaConfigurações.Observers;

import logica.TelaConfigurações.Models.ModelConfiguracoes;

public class Observer{
  ModelConfiguracoes model;

  public void setModel(ModelConfiguracoes model) {
    this.model = model;
  }

  public ModelConfiguracoes getModel() {
    return this.model;
  }
}
