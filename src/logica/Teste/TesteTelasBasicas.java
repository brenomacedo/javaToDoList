package logica.Teste;

import logica.TelasBasicas.Controllers.*;
import logica.TelasBasicas.Models.*;

public class TesteTelasBasicas {
  public static void main(String[] args){
    /*
    String nome = "Tiago";
    String nome_usuario = "Brandao";
    String senha = "12345";
    
    String nome1 = "Gustoso";
    String nome_usuario1 = "e gay";
    String senha1 = "eu sou gay";
    */

    String vazio = "";
    ControllerCadastro controle_cadastro = new ControllerCadastro(vazio, vazio, vazio, new ModelCadastro());
    controle_cadastro.cadastrar();

    ControllerLogin controle_login = new ControllerLogin(vazio, vazio, new ModelLogin());
    controle_login.verificarLogin();
  }
}