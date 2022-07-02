package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import utils.Theme;
import utils.JTextFieldLimit;

public class EditarTask extends JFrame {
  public EditarTask() {
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.getContentPane().setBackground(Theme.bgColor);
    this.setResizable(false);
    this.setSize(400, 570);
    this.setLayout(new BorderLayout());

    JPanel secaoTitulo = new JPanel();
    secaoTitulo.setBackground(Theme.bgColor);
    secaoTitulo.setPreferredSize(new Dimension(400, 80));
    secaoTitulo.setLayout(new GridLayout(2, 1));
    secaoTitulo.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel labelTitulo = new JLabel("Titulo");
    labelTitulo.setFont(new Font(null, Font.BOLD, 18));

    // Receber como parametro a entrada da model (Tiago big brand)
    JTextField campoTitulo = new JTextField();
    campoTitulo.setFont(new Font(null, Font.BOLD, 18));
    campoTitulo.setEditable(true);

    secaoTitulo.add(labelTitulo);
    secaoTitulo.add(campoTitulo);

    // Limitando a entrada do JTextField
    campoTitulo.setDocument(
      new JTextFieldLimit(30)
    );

    campoTitulo.setText("Minha tarefa interessante");

    JPanel centroSecaoTitulo = new JPanel();
    centroSecaoTitulo.setLayout(new BorderLayout());

    JPanel secaoDescricao = new JPanel();
    secaoDescricao.setLayout(new BorderLayout());
    secaoDescricao.setPreferredSize(new Dimension(400, 152));
    secaoDescricao.setBorder(new EmptyBorder(8, 8, 16, 8));
    secaoDescricao.setBackground(Theme.bgColor);

    JLabel tituloDescricao = new JLabel("Descricao");
    tituloDescricao.setFont(new Font(null, Font.BOLD, 18));
    tituloDescricao.setPreferredSize(new Dimension(400, 24));

    JTextArea campoDescricao = new JTextArea();
    campoDescricao.setFont(new Font(null, Font.BOLD, 18));
    campoDescricao.setEditable(true);
    campoDescricao.setPreferredSize(new Dimension(400, 96));
    campoDescricao.setLineWrap(true);
    campoDescricao.setWrapStyleWord(true);

    secaoDescricao.add(tituloDescricao, BorderLayout.NORTH);
    secaoDescricao.add(campoDescricao, BorderLayout.CENTER);

    centroSecaoTitulo.add(secaoDescricao, BorderLayout.NORTH);

    campoDescricao.setDocument(
      new JTextFieldLimit(140)
    );

    campoDescricao.setText("Minha descricao pika");

    JPanel centroSecaoDescricao = new JPanel();
    centroSecaoDescricao.setLayout(new BorderLayout());

    JPanel secaoData = new JPanel();
    secaoData.setLayout(new GridLayout(2, 1));
    secaoData.setBackground(Theme.bgColor);
    secaoData.setPreferredSize(new Dimension(400, 80));
    secaoData.setLayout(new GridLayout(2, 1));
    secaoData.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel tituloData = new JLabel("Data");
    tituloData.setFont(new Font(null, Font.BOLD, 18));
    tituloData.setPreferredSize(new Dimension(400, 24));

    JTextField campoData = new JTextField();
    campoData.setFont(new Font(null, Font.BOLD, 18));
    campoData.setEditable(true);

    campoData.setDocument(
      new JTextFieldLimit(30)
    );

    campoData.setText("14/01/2023");

    secaoData.add(tituloData);
    secaoData.add(campoData);
    
    JPanel centroSecaoData = new JPanel();
    centroSecaoData.setLayout(new BorderLayout());

    JPanel secaoHora = new JPanel();
    secaoHora.setLayout(new GridLayout(2, 1));
    secaoHora.setBackground(Theme.bgColor);
    secaoHora.setPreferredSize(new Dimension(400, 80));
    secaoHora.setLayout(new GridLayout(2, 1));
    secaoHora.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel tituloHora = new JLabel("Hora");
    tituloHora.setFont(new Font(null, Font.BOLD, 18));
    tituloHora.setPreferredSize(new Dimension(400, 24));

    JTextField campoHora = new JTextField();
    campoHora.setFont(new Font(null, Font.BOLD, 18));
    campoHora.setEditable(true);
    
    campoHora.setDocument(
      new JTextFieldLimit(30)
    );

    campoHora.setText("04:20");

    secaoHora.add(tituloHora);
    secaoHora.add(campoHora);

    JPanel centroSecaoHora = new JPanel();
    centroSecaoHora.setLayout(new BorderLayout());

    JPanel secaoPrioridade = new JPanel();
    secaoPrioridade.setLayout(new GridLayout(2, 1));
    secaoPrioridade.setBackground(Theme.bgColor);
    secaoPrioridade.setPreferredSize(new Dimension(400, 80));
    secaoPrioridade.setLayout(new GridLayout(2, 1));
    secaoPrioridade.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel tituloPrioridade = new JLabel("Prioridade");
    tituloPrioridade.setFont(new Font(null, Font.BOLD, 18));
    tituloPrioridade.setPreferredSize(new Dimension(400, 24));

    String[] options = { "0", "1", "2", "3", "4", "5" };

    JComboBox<String> campoPrioridade = new JComboBox<>(options);
    campoPrioridade.setFont(new Font(null, Font.BOLD, 18));
    campoPrioridade.setEditable(false);
    campoPrioridade.setBackground(Color.WHITE);

    secaoPrioridade.add(tituloPrioridade);
    secaoPrioridade.add(campoPrioridade);

    JPanel centroSecaoPrioridade = new JPanel();
    centroSecaoPrioridade.setLayout(new BorderLayout());

    JButton botaoSalvar = new JButton("Salvar");
    botaoSalvar.setPreferredSize(new Dimension(400, 60));
    botaoSalvar.setBackground(new Color(33, 255, 174));
    botaoSalvar.setFont(new Font(null, Font.BOLD, 18));
    botaoSalvar.setForeground(Color.DARK_GRAY);
    botaoSalvar.setFocusable(false);
    botaoSalvar.setBorder(
      BorderFactory.createMatteBorder(0, 0, 6, 0, Color.DARK_GRAY)
    );
    
    centroSecaoPrioridade.add(botaoSalvar, BorderLayout.NORTH);
    centroSecaoHora.add(centroSecaoPrioridade, BorderLayout.CENTER);
    centroSecaoHora.add(secaoPrioridade, BorderLayout.NORTH);
    centroSecaoData.add(centroSecaoHora, BorderLayout.CENTER);
    centroSecaoData.add(secaoHora, BorderLayout.NORTH);
    centroSecaoDescricao.add(centroSecaoData, BorderLayout.CENTER);
    centroSecaoDescricao.add(secaoData, BorderLayout.NORTH);
    centroSecaoTitulo.add(centroSecaoDescricao, BorderLayout.CENTER);
    this.add(secaoTitulo, BorderLayout.NORTH);
    this.add(centroSecaoTitulo);
    this.setVisible(true);
  }
}
