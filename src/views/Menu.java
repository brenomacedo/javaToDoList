package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;
import utils.Theme;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.Iterator;
import logica.MenuPrincipal.Controllers.ControllerMenuPrincipal;

public class Menu extends JFrame implements ActionListener {
  
  public JPanel listaDeTarefas;
  public JButton botaoAdicionar;
  public JButton botaoLimparConcluidas;
  public JButton botaoLimparTudo;
  ModelMenuPrincipal model;
  JButton botaoConfig;
  ControllerMenuPrincipal controllerMenuPrincipal;
  boolean visualizandoTarefa = false;
  boolean editandoTarefa = false;

  public Menu (ModelMenuPrincipal model) {

    this.model = model;
    this.controllerMenuPrincipal = new ControllerMenuPrincipal(model.getUsuario(), this);
    // configurações da tela
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(600, 920); 
    this.setResizable(false);
    this.setTitle("To Do List");

    this.getContentPane().setBackground(Theme.bgColor);

    this.addWindowListener(new WindowAdapter()
    {
      @Override
      public void windowClosing(WindowEvent e)
      {
          try {
            controllerMenuPrincipal.salvarDados();
          } catch (Exception err) {
            System.out.println("Erro ao salvar dados - conta deletada.");
          }
          
          e.getWindow().dispose();
      }
    });

    // titulo
    JLabel titulo = new JLabel();
    titulo.setText("To Do List");

    titulo.setVerticalAlignment(JLabel.CENTER);
    titulo.setHorizontalAlignment(JLabel.CENTER);
    titulo.setBorder(new EmptyBorder(20, 60, 20, 0));
    titulo.setFont(new Font("Monospaced", Font.BOLD, 36));
    titulo.setForeground(Color.WHITE);

    JPanel tituloContainer = new JPanel();
    tituloContainer.setLayout(new BorderLayout());

    // icone do botao de configurações
    ImageIcon iconeConfiguracoes = new ImageIcon("images/config.png");
    Image imageIconeConfiguracoes = iconeConfiguracoes.getImage();
    Image novoIconeConfiguracoes = imageIconeConfiguracoes.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
    iconeConfiguracoes = new ImageIcon(novoIconeConfiguracoes);

    // remover borda do botao de configuração
    Border emptyBorder = BorderFactory.createEmptyBorder();

    // botao de configurações
    botaoConfig = new JButton();
    botaoConfig.setPreferredSize(new Dimension(60, 76));
    botaoConfig.setIcon(iconeConfiguracoes);
    botaoConfig.setFocusable(false);
    botaoConfig.setBorder(emptyBorder);
    botaoConfig.setBackground(Theme.bgColor);
    botaoConfig.addActionListener(this);
    
    tituloContainer.add(titulo, BorderLayout.CENTER);
    tituloContainer.setBackground(Theme.bgColor);
    tituloContainer.add(botaoConfig, BorderLayout.EAST);


    // botoes de controle
    JPanel campoBotoes = new JPanel();
    campoBotoes.setBackground(Theme.bgColor);
    campoBotoes.setBorder(new EmptyBorder(16, 16, 16, 16));

    GridLayout campoBotoesLayout = new GridLayout(1, 3);
    campoBotoesLayout.setHgap(16);

    campoBotoes.setLayout(campoBotoesLayout);
    campoBotoes.setPreferredSize(new Dimension(600, 80));

    // icones dos botoes
    ImageIcon iconeAdicionar = new ImageIcon("images/add.png");
    Image imageIconeAdicionar = iconeAdicionar.getImage();
    Image novoIconeAdicionar = imageIconeAdicionar.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
    iconeAdicionar = new ImageIcon(novoIconeAdicionar);

    ImageIcon iconeRemoverConcluidas = new ImageIcon("images/trash.png");
    Image imageIconeRemoverConcluidas = iconeRemoverConcluidas.getImage();
    Image novoIconeRemoverConcluidas = imageIconeRemoverConcluidas.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
    iconeRemoverConcluidas = new ImageIcon(novoIconeRemoverConcluidas);

    ImageIcon iconeRemoverTudo = new ImageIcon("images/delete.png");
    Image imageIconeRemoverTudo = iconeRemoverTudo.getImage();
    Image novoIconeRemoverTudo = imageIconeRemoverTudo.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
    iconeRemoverTudo = new ImageIcon(novoIconeRemoverTudo);
    // =================

    botaoAdicionar = new JButton("Adicionar");
    botaoLimparConcluidas = new JButton("Limpar Conc.");
    botaoLimparConcluidas.addActionListener(this);
    botaoLimparTudo = new JButton("Limpar tudo");
    botaoLimparTudo.addActionListener(this);

    Font fonteBotao = new Font("Monospaced", Font.BOLD, 14);
    botaoAdicionar.setFont(fonteBotao);
    botaoAdicionar.setForeground(Color.BLACK);
    botaoAdicionar.setBackground(Color.WHITE);
    botaoAdicionar.setFocusable(false);
    botaoAdicionar.setIcon(iconeAdicionar);
    botaoAdicionar.setIconTextGap(10);
    botaoAdicionar.addActionListener(this);

    botaoLimparConcluidas.setFont(fonteBotao);
    botaoLimparConcluidas.setForeground(Color.BLACK);
    botaoLimparConcluidas.setBackground(Color.WHITE);
    botaoLimparConcluidas.setFocusable(false);
    botaoLimparConcluidas.setIcon(iconeRemoverConcluidas);
    botaoLimparConcluidas.setIconTextGap(10);

    botaoLimparTudo.setFont(fonteBotao);
    botaoLimparTudo.setForeground(Color.BLACK);
    botaoLimparTudo.setBackground(Color.WHITE);
    botaoLimparTudo.setFocusable(false);
    botaoLimparTudo.setIcon(iconeRemoverTudo);
    botaoLimparTudo.setIconTextGap(10);

    campoBotoes.add(botaoAdicionar);
    campoBotoes.add(botaoLimparConcluidas);
    campoBotoes.add(botaoLimparTudo);

    listaDeTarefas = new JPanel();
    listaDeTarefas.setBackground(Theme.bgColor);
    listaDeTarefas.setLayout(new GridLayout(15, 1));

    this.carregarTarefas();

    this.add(listaDeTarefas, BorderLayout.CENTER);
    this.add(tituloContainer, BorderLayout.NORTH);
    this.add(campoBotoes, BorderLayout.SOUTH);
    this.setVisible(true);
  }

  public boolean getVisualizandoTarefa () {
    return this.visualizandoTarefa;
  }

  public void setVisualizandoTarefa (boolean visualizandoTarefa) {
    this.visualizandoTarefa = visualizandoTarefa;
  }

  public boolean getEditandoTarefa () {
    return this.editandoTarefa;
  }

  public void setEditandoTarefa (boolean editandoTarefa) {
    this.editandoTarefa = editandoTarefa;
  }

  public void carregarTarefas () {
    Iterator<Object> tarefas = this.model.getTarefas().iterator();

    boolean temConcluido = false;

    JSONObject tarefa;
    int index = 0;
    while (tarefas.hasNext()) {
      tarefa = (JSONObject) tarefas.next();

      String titulo = (String) tarefa.get("titulo");
      String prioridade = (String) tarefa.get("prioridade");
      boolean conclusao = ((String) tarefa.get("conclusao")).equals("concluido");

      temConcluido = temConcluido || conclusao;

      listaDeTarefas.add(
        new Task(index, titulo, prioridade, conclusao, this)
      );
      
      index++;
    }

    int numeroDeTarefas = this.model.getTarefas().length();

    if (!temConcluido) {
      this.botaoLimparConcluidas.setEnabled(false);
    }

    if (numeroDeTarefas == 0) {
      this.botaoLimparTudo.setEnabled(false);
    }

    if (numeroDeTarefas == 15) {
      this.botaoAdicionar.setEnabled(false);
    }
  }

  public void adicionarTarefa () {
    this.controllerMenuPrincipal.addTarefa();
  }

  public void recarregarTarefas () {
    this.listaDeTarefas.removeAll();
    this.carregarTarefas();
    this.repaint();
    this.setVisible(true);
  }

  public void visualizarTarefa (int index) {
    if (!this.visualizandoTarefa) {
      this.setVisualizandoTarefa(true);
      this.controllerMenuPrincipal.visualizarTarefa(index);
    }
  }

  public void concluirTarefa (int index, boolean value) {
    this.controllerMenuPrincipal.concluirTarefa(index, value);
  }

  public void abrirEditarTarefa (int index) {
    if (!this.editandoTarefa) { 
      this.setEditandoTarefa(true);
      this.controllerMenuPrincipal.abrirEditarTarefa(index);
    }
  }

  public void editarTarefa (
    int index,
    String titulo,
    String descricao,
    String data,
    String hora,
    String prioridade
  ) {
    this.controllerMenuPrincipal.editarTarefa(
      index,
      titulo,
      descricao,
      data,
      hora,
      prioridade
    );

    this.recarregarTarefas();
  }

  public void deletarTarefa (int index) {
    this.controllerMenuPrincipal.deletarTarefa(index);
    this.recarregarTarefas();
  }

  public void limparTudo () {
    this.controllerMenuPrincipal.limparTudo();
    this.recarregarTarefas();
  }

  public void limparConcluidas () {
    this.controllerMenuPrincipal.limparConcluidas();
    this.recarregarTarefas();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.botaoConfig) {
      this.botaoConfig.removeActionListener(this);
      new Sett_frame(this, this.botaoConfig, model);
    }

    if (e.getSource() == this.botaoAdicionar) {
      this.adicionarTarefa();
    }

    if (e.getSource() == this.botaoLimparConcluidas) {
      this.limparConcluidas();
    }

    if (e.getSource() == this.botaoLimparTudo) {
      this.limparTudo();
    }
  }
}
