package logica.TelaConfigurações.Controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.json.JSONObject;

import logica.Auxiliar.Mensagens;
import logica.TelaConfigurações.Models.ModelConfiguracoes;
import views.Login_Register_Frame;
import views.Menu;
import views.Sett_frame;
import logica.Arquivos.Dados;
import java.awt.event.WindowEvent;

/**
 * Controller das telas de configurações
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ControllerConfiguracoes{
  JSONObject usuario;
  ModelConfiguracoes model;

  /**
   * 
   * @param usuario
   */
  public ControllerConfiguracoes(JSONObject usuario){
    this.setModel(new ModelConfiguracoes(usuario));
    this.usuario = usuario;
  }

  /**
   * 
   * @param usuario
   */
  public void setUsuario(JSONObject usuario){
    this.usuario = usuario;
  }

  public JSONObject getUsuario(){
    return this.usuario;
  }

  /**
   * 
   * @param model
   */
  public void setModel(ModelConfiguracoes model){
    this.model = model;
  }

  public ModelConfiguracoes getModel(){
    return this.model;
  }

  /**
   * Edita 1 tipo de dado, dependendo de tipo_mudanca
   * Se tipo_mudanca == "nome", modifica o nome do Usuário
   * Se tipo_mudanca == "senha", modifica a senha do Usuário
   * Se tipo_mudanca == "nome_usuario", modifica o nome de usuario do Usuário
   * @param mudanca
   * @param senha
   * @param tipo_mudanca
   */
  public void editarPerfil(String mudanca, String senha, String tipo_mudanca){
    String mensagem = "";

    if (tipo_mudanca.equals("nome_usuario")) {
      mudanca = mudanca.toUpperCase();
    }
    
    if (!mudanca.isEmpty()) {
      String senha_usuario = (String) (this.usuario).get("senha");

      mensagem = Mensagens.gera_mensagem_EditarPerfil(senha_usuario, senha, tipo_mudanca);

      (this.model).setMensagem(mensagem);

      if (senha_usuario.equals(senha)){
        Dados arquivo = new Dados();
        arquivo.atualizarUsuario((this.usuario), mudanca, tipo_mudanca);
        this.usuario.put(tipo_mudanca, mudanca);
        String nome_ = "nome";
        String senha_ = "senha";

        if (tipo_mudanca.equals(nome_))
          (this.model).setNome(mudanca);
        else if (tipo_mudanca.equals(senha_))
          (this.model).setSenha(mudanca);
        else
          (this.model).setNomeUsuario(mudanca);
      }
    } else {
      if (tipo_mudanca.equals("nome")) {
        mensagem = "Por favor, digite um nome";
      } else if (tipo_mudanca.equals("senha")) {
        mensagem = "Por favor, digite uma senha";
      } else {
        mensagem = "Por favor, digite um nome de usuário";
      }
    }

    JOptionPane.showMessageDialog(null, mensagem, "Mensagem", JOptionPane.INFORMATION_MESSAGE);
  }

  /**
   * Apagar registro
   * @param frame
   */
  public void ApagarRegistro(Sett_frame frame){
    Dados arquivo = new Dados();
    arquivo.apagar_registro(usuario);

    (this.model).setApagarRegistro(true);

    this.logout(frame);
  }

  /**
   * Fazer logout
   * @param frame
   */
  public void logout (Sett_frame frame) {
    ((JFrame) frame.menuFrame).setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    ((Menu) frame.menuFrame).dispatchEvent(new WindowEvent(((Menu) frame.menuFrame), WindowEvent.WINDOW_CLOSING));
    frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));

    new Login_Register_Frame();
  }
}
