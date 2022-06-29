package logica.TelaConfigurações.Controller;

import org.json.JSONObject;
import logica.TelaConfigurações.Models.ModelConfiguracoes;

public class ControllerConfiguracoes{
  JSONObject usuario;
  ModelConfiguracoes model;

  public ControllerConfiguracoes(JSONObject usuario){
    this.setModel(new ModelConfiguracoes());
    this.usuario = usuario;
  }

  public void setUsuario(JSONObject usuario){
    this.usuario = usuario;
  }

  public JSONObject getUsuario(){
    return this.usuario;
  }

  public void setModel(ModelConfiguracoes model){
    this.model = model;
  }

  public ModelConfiguracoes getModel(){
    return this.model;
  }

  // 1) Mudar nome do Usuário
  public void MudarNome(String nome_novo, String senha){

  }


  // 2) Mudar nome de usuário do Usuário
  public void MudarNomeUsuario (String nome_usuario_novo, String senha){

  }

  // 3) Mudar senha
  public void MudarSenha (String senha_nova, String senha_atual){

  }

  // 4) Apagar registro
  public void ApagarRegistro(String senha){

  }
}
