package logica.TelaConfigurações.Controller;

import org.json.JSONObject;

import logica.Auxiliar.Mensagens;
import logica.TelaConfigurações.Models.ModelConfiguracoes;
import logica.Arquivos.Dados;

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

  // 1) editarPerfil
  // Edita 1 tipo de dado, dependendo de tipo_mudanca
  // Se tipo_mudanca == "nome", modifica o nome do Usuário
  // Se tipo_mudanca == "senha", modifica a senha do Usuário
  // Se tipo_mudanca == "nome_usuario", modifica o nome de usuario do Usuário
  public void editarPerfil(String mudanca, String senha, String tipo_mudanca){
    String senha_usuario = (String) (this.usuario).get("senha");

    String mensagem = Mensagens.gera_mensagem_EditarPerfil(senha_usuario, senha, tipo_mudanca);

    (this.model).setMensagem(mensagem);

    if (senha_usuario.equals(senha)){
      Dados arquivo = new Dados();
      arquivo.atualizarUsuario((this.usuario), mudanca, tipo_mudanca);
      String nome_ = "nome";
      String senha_ = "senha";

      if (tipo_mudanca.equals(nome_))
        (this.model).setNome(mudanca);
      else if (tipo_mudanca.equals(senha_))
        (this.model).setSenha(mudanca);
      else
        (this.model).setNomeUsuario(mudanca);
    }
  }

  // 2) Apagar registro
  public void ApagarRegistro(String senha){
    String senha_usuario = (String) (this.usuario).get("senha");

    String mensagem = Mensagens.gera_mensagem_ApagarRegistro(senha_usuario, senha);

    (this.model).setMensagem(mensagem);

    if (senha_usuario.equals(senha)){
      Dados arquivo = new Dados();
      arquivo.apagar_registro(usuario);

      (this.model).setApagarRegistro(true);
    }
  }
}
