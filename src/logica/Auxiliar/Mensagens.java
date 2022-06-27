public class Mensagens{
  static String gera_mensagem_login(int i, int valor_retorno){
    if (i == 0){
      if (valor_retorno == -1)
        return "Nome de usuário não existe!";
      if (valor_retorno == 0)
        return "Login realizado com sucesso!";
      if (valor_retorno == 1)
        return "Senha errada!";
    }

    else{
      if (i == -1)
        return "Por favor, digite nome de usuário e senha!";
      if (i == -2)
        return "Por favor, digite a senha!";
      if (i == -3)
        return "Por favor, digite o nome de usuário!";
    }
  }

  static String gera_mensagem_cadastro(int i, int valor_retorno){
    if (i == 0){
      if (valor_retorno == 0)
        return "Cadastro realizado com sucesso!";
      if (valor_retorno == 1)
        return "Já existe um registro com esse nome de usuário!";
    }

    else{
      if (i == -1)
        return "Por favor, digite nome de usuário e senha!";

      if (i == -2)
        return "Por favor, digite a senha!";

      if (i == -3)
        return "Por favor, digite o nome de usuário!";
    }
  }

  static String gera_mensagem_mudarsenha(int i, int valor retorno){
    if (i == 0){
      if (valor_retorno == -1)
        return "Nome de usuário não existe!";
      if (valor_retorno == 0)
        return "Senha modificada com sucesso!";
      if (valor_retorno == 1)
        return "Senha errada!";
    }

    else{
      if (i == -1)
        return "Por favor, digite nome de usuário, senha atual e senha nova!";
      if (i == -2)
        return "Por favor, digite nome de usuário e senha atual!";
      if (i == -3)
        return "Por favor, digite nome de usuário e senha nova!";
      if (i == -4)
        return "Por favor, digite senha atual e senha nova!";
      if (i == -5)
        return "Por favor, digite a senha atual!";
      if (i == -6)
        return "Por favor, digite a senha nova!";
      if (i == -7)
        return "Por favor, digite o nome de usuário!";
    }
  }

  static String gera_mensagem_apagarRegistro(int i, int valor_retorno){
    if (i == 0){
      if (valor_retorno == -1)
        return "Nome de usuário não existe!";
      if (valor_retorno == 0)
        return "Registro excluído com sucesso!";
      if (valor_retorno == 1)
        return "Senha errada!";
    }

    else{
      if (i == -1)
        return "Por favor, digite nome de usuário e senha!";
      if (i == -2)
        return "Por favor, digite a senha!";
      if (i == -3)
        return "Por favor, digite o nome de usuário!";
    }
  }
}