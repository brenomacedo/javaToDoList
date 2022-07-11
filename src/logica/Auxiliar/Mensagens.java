package logica.Auxiliar;

/**
 * Classe que guarda as mensagens a serem exibidas durante o programa
 * @author Tiago Brandão e Gustavo Wendell
 */
public class Mensagens{
  public static String nome = "nome";
  public static String nome_usuario = "nome_usuario";
  public static String senha = "senha";

  /**
   * gera a mensagem de login
   * @param numero_da_mensagem
   * @param valor_retorno
   * @return
   */
  public static String gera_mensagem_login(int i, int valor_retorno){
    String mensagem = "";
    if (i == 0){
      if (valor_retorno == -1)
        mensagem = "Nome de usuário não existe!";
      else if (valor_retorno == 0)
        mensagem = "Login realizado com sucesso!";
      else if (valor_retorno == 1)
        mensagem = "Senha errada!";
    }

    else{
      if (i == -1)
        mensagem = "Por favor, digite nome de usuário e senha!";
      else if (i == -2)
        mensagem = "Por favor, digite a senha!";
      else if (i == -3)
        mensagem = "Por favor, digite o nome de usuário!";
    }

    return mensagem;
  }

  /**
   * gera a mensagem de cadastro
   * @param numero_da_mensagem
   * @param valor_retorno
   * @param senha
   * @param confirmaSenha
   * @return
   */
  public static String gera_mensagem_cadastro(int i, int valor_retorno, String senha, String confirmaSenha){
    String mensagem = "";
    if (i == 0){
      if (senha.equals(confirmaSenha)){
        if (valor_retorno == 0)
          mensagem = "Cadastro realizado com sucesso!";
        else if (valor_retorno == 1)
          mensagem = "Já existe um registro com esse nome de usuário!";
      } else {
        mensagem = "As senhas não conferem!";
      }
    }

    else{
      mensagem = "Por favor, digite os dados corretamente!";
    }

    return mensagem;
  }

  /**
   * gera a mensagem de editar perfil
   * @param senha_atual
   * @param senha_ent
   * @param tipo_mudanca
   * @return
   */
  public static String gera_mensagem_EditarPerfil(String senha_atual, String senha_ent, String tipo_mudanca){
    String mensagem = "";
    if (senha_ent.equals(mensagem))
      mensagem = "Por favor, digite a senha!"; 
    else if (senha_ent.equals(senha_atual)){
      if (tipo_mudanca.equals(nome))
        mensagem = "Nome modificado com sucesso!";
      else if (tipo_mudanca.equals(senha))
        mensagem = "Senha modificada com sucesso!";
      else
        mensagem = "Nome de usuário modificado com sucesso!";
    }
    else
      mensagem = "Senha errada!";

    return mensagem;
  }

  /**
   * gera a mensagem de apagar o registro
   * @param senha_atual
   * @param senha_ent
   * @return
   */
  public static String gera_mensagem_ApagarRegistro(String senha_atual, String senha_ent){
    String mensagem = "";
    if (senha_ent.equals(mensagem))
      mensagem = "Por favor, digite a senha!"; 
    else if (senha_ent.equals(senha_atual))
      mensagem = "Registro apagado com sucesso!";
    else
      mensagem = "Senha errada!";

    return mensagem;
  }
}