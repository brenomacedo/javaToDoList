package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import utils.Theme;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;

public class Menu extends JFrame {
  
  public Menu () {

    // configurações da tela
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(600, 920); 
    this.setResizable(false);
    this.setTitle("To Do List");

    this.getContentPane().setBackground(Theme.bgColor);

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
    JButton botaoConfig = new JButton();
    botaoConfig.setPreferredSize(new Dimension(60, 76));
    botaoConfig.setIcon(iconeConfiguracoes);
    botaoConfig.setFocusable(false);
    botaoConfig.setBorder(emptyBorder);
    botaoConfig.setBackground(Theme.bgColor);
    
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

    JButton botaoAdicionar = new JButton("Adicionar");
    JButton botaoLimparConcluidas = new JButton("Limpar Conc.");
    JButton botaoLimparTudo = new JButton("Limpar tudo");

    Font fonteBotao = new Font("Monospaced", Font.BOLD, 14);
    botaoAdicionar.setFont(fonteBotao);
    botaoAdicionar.setForeground(Color.BLACK);
    botaoAdicionar.setBackground(Color.WHITE);
    botaoAdicionar.setFocusable(false);
    botaoAdicionar.setIcon(iconeAdicionar);
    botaoAdicionar.setIconTextGap(10);

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

    JPanel listaDeTarefas = new JPanel();
    listaDeTarefas.setBackground(Theme.bgColor);
    listaDeTarefas.setLayout(new GridLayout(14, 1));

    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );
    listaDeTarefas.add(
      new Task("Ola mundo", 3)
    );

    this.add(listaDeTarefas, BorderLayout.CENTER);
    this.add(tituloContainer, BorderLayout.NORTH);
    this.add(campoBotoes, BorderLayout.SOUTH);
    this.setVisible(true);
  }
}
