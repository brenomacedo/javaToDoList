package logica.Teste;

import org.json.JSONObject;
import logica.TelaConfigurações.Controller.*;
import logica.TelasBasicas.Controllers.*;
import logica.TelasBasicas.Models.*;

public class TesteTelaConfiguracoes {
  public static void main(String[] args){

    String nome_usuario = "Brandao";
    String senha = "12345";


    String senha_nova = "500";
    String nome_novo = "Brandinho";
    String nome_usuario_novo = "Tiagoso";

    String outro_usuario = "E GAY";
    String senha_outro_usuario = "eu sou gay";
    
    // Antes:
    // {"nome_usuario":"BRANDAO","senha":"12345","id_usuario":0,"tarefas":[],"nome":"Tiago"}
    // {"nome_usuario":"E GAY","senha":"eu sou gay","id_usuario":2,"tarefas":[],"nome":"Gustoso"}
    ControllerLogin controle1 = new ControllerLogin(nome_usuario, senha, new ModelLogin());
    controle1.verificarLogin();
    JSONObject usuario1 = (controle1.getDados()).getUsuario();

    ControllerLogin controle2 = new ControllerLogin(outro_usuario, senha_outro_usuario, new ModelLogin());
    controle2.verificarLogin();
    JSONObject usuario2 = (controle2.getDados()).getUsuario();

    ControllerConfiguracoes controle_Brandao = new ControllerConfiguracoes(usuario1);
    String tipo_mudanca = "nome";
    controle_Brandao.editarPerfil(nome_novo, senha, tipo_mudanca);

    tipo_mudanca = "nome_usuario";
    controle_Brandao.editarPerfil(nome_usuario_novo, senha, tipo_mudanca);

    tipo_mudanca = "senha";
    controle_Brandao.editarPerfil(senha_nova, senha, tipo_mudanca);


    ControllerConfiguracoes controle_outro = new ControllerConfiguracoes(usuario2);
    controle_outro.ApagarRegistro(senha);
    controle_outro.ApagarRegistro(senha_outro_usuario);
  }
}
