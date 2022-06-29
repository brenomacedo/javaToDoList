package logica.Arquivos;

import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Iterator;
import java.io.FileWriter;

// Formato do arquivo .json
// - ArrayList de "Usuários"
// - Usuário:
// . "nome" : String
// . "nome_usuario": String
// . "senha" : String
// . "id_usuario" : int
// . "Tarefas": ArrayList Tarefas

// - Tarefa:
// . "Título" : String
// . "Descrição" : String
// . "Data" : String
// . "Horas" : String
// . "Prioridade" : String
// . "Conclusão" : String

public class Dados{
  JSONArray usuarios;
  JSONObject usuario_logado;
  int prox_id_livre;

  // Sempre que instanciado, um objeto "Dados" já tem o atributo "usuários" atualizado
  public Dados(){
    this.carregar();
  }

  // Puxa os dados dos arquivos "dados.json" e "prox_id_livre.json"
  public void carregar(){
    try{
      // Lendo os dados dos usuários
      List<String> lines = Files.readAllLines(Paths.get("./dados.json"));
      String data = lines.get(0);
      this.usuarios = new JSONArray(data);

      // Lendo a próxima id livre
      lines = Files.readAllLines(Paths.get("./prox_id_livre.json"));
      data = lines.get(0);

      JSONObject id = new JSONObject(data);
      this.prox_id_livre = (int) id.get("id");
    }

    catch(Exception e){}
  }

  // 1) Verificar login
  // Verifica se determinado registro existe no banco de dados
  // Se retorna 0, existe registro e salva os dados do usuario em "usuario_logado"
  // Se retorna 1, "nome_usuário" existe, mas "senha" está errada
  // Se retorna -1, "nome_usuário" não existe
  public int verificarLogin(String nome_usuario_ent, String senha_ent){
    Iterator<Object> iterator_usuarios = (this.usuarios).iterator();
    JSONObject usuario;
    String nome_usuario;
    String senha;

    // Verificamos cada usuário do banco de dados
    while (iterator_usuarios.hasNext()){
      usuario = (JSONObject) iterator_usuarios.next();
      nome_usuario = (String) usuario.get("nome_usuario");
      senha = (String) usuario.get("senha");

      if (nome_usuario == nome_usuario_ent){
        if (senha == senha_ent){
          this.usuario_logado = usuario;

          // Usuário existe e a senha está correta
          return 0;
        }
        
        else

          // Senha errada
          return 1;
      }
    }

    // Usuário não existe
    return -1;
  }

  // 2) Cadastrar
  // Verifica se "nome_usuario_ent" é válido e adiciona um novo cadastro ao banco de dados
  public int cadastrar(String nome_ent, String nome_usuario_ent, String senha_ent){
    int i = this.verificarLogin(nome_usuario_ent, senha_ent);

    // "nome_usuario_ent" é válido
    if (i == -1){
      // Criamos um novo_usuario
      JSONObject novo_usuario = new JSONObject();
      JSONArray tarefas = new JSONArray();

      // Adicionamos os dados
      novo_usuario.put("nome", nome_ent);
      novo_usuario.put("nome_usuario", nome_usuario_ent);
      novo_usuario.put("senha", senha_ent);
      novo_usuario.put("id_usuario", this.prox_id_livre);
      novo_usuario.put("tarefas", tarefas);

      // Adicionamos um novo usuário ao banco de dados
      (this.usuarios).put(novo_usuario);

      // Atualizamos a próxima id livre
      this.atualizar_prox_id_livre();

      this.salvar();

      // Cadastro realizado com sucesso!
      return 0;
    }

    // Existe algum registro no banco de dados com "nome_usuario_ent"
    // Não foi possível efetuar o cadastro
    return 1;
  }

  // 3) Apagar registro
  public boolean apagar_registro(JSONObject usuario, String senha){
    if (senha == usuario.getString("senha")){
      int index = this.getIndex(usuario);
      this.usuarios.remove(index);
      this.salvar();

      return true;
    }
    return false;
  }

  // 4) Mudar senha
  public boolean mudar_senha(JSONObject usuario, String senha, String senha_nova){
    if (senha == usuario.getString("senha")){
      int index = this.getIndex(usuario);
      this.usuarios.remove(index);

      usuario.put("senha", senha_nova);
      this.usuarios.put(usuario);
      this.salvar();

      return true;
    }
    return false;
  }

  // 5) Acrescenta 1 ao atributo "prox_id_livre"
  public void atualizar_prox_id_livre(){
    this.prox_id_livre++;
  }

  // 6) salvar
  // Salva os dados nos arquivos
  public void salvar(){
    try {
      // Salvando dados dos usuários
      FileWriter filewriter = new FileWriter("./dados.json");

      filewriter.write((this.usuarios).toString());

      filewriter.close();

      // Salvando id
      JSONObject id = new JSONObject();
      id.put("id", this.prox_id_livre);

      filewriter = new FileWriter("./prox_id_livre.json");
      filewriter.write(id.toString());
      filewriter.close();
    }
    catch (Exception e) {}
  }

  // 7)
  public JSONObject getUsuario(){
    return this.usuario_logado;
  }

  // 8) Função auxiliar que retorna o index de um usuário no Arraylist do
  public int getIndex(JSONObject usuario){
    int id_usuario = (int) usuario.get("id_usuario");

    int i = -1;
    JSONObject var_usuario;
    int var_id_usuario;
    Iterator<Object> iterator_usuarios = (this.usuarios).iterator();

    while (iterator_usuarios.hasNext()){
      var_usuario = (JSONObject)iterator_usuarios.next();
      var_id_usuario = (int) var_usuario.get("id_usuario");
      i++;
      if (var_id_usuario == id_usuario)
        return i;
    }

    return -1;
  }
}