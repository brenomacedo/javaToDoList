package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.JTextFieldLimit;
import utils.Theme;

public class Task extends JPanel implements ActionListener {

  int index;
  JButton botaoVisualizar;
  JButton botaoEditar;
  JButton botaoDeletar;
  JCheckBox tarefaConcluida;
  Menu menu;

  public Task(int index, String titulo, String prioridade, boolean concluido, Menu menu) {
    this.index = index;
    this.menu = menu;

    this.setLayout(new BorderLayout());
    this.setBorder(BorderFactory.createMatteBorder(4, 8, 4, 8, Theme.bgColor));
    this.setBackground(Color.WHITE);
    JPanel botoes = new JPanel();
    botoes.setBorder(new EmptyBorder(0, 8, 0, 8));
    botoes.setBackground(Color.WHITE);
    GridLayout botoesLayout = new GridLayout(1, 4);
    botoesLayout.setHgap(4);
    botoes.setLayout(botoesLayout);
    botoes.setPreferredSize(new Dimension(140, 28));

    // Icone icone tarefa concluida
    ImageIcon iconeConcluido = new ImageIcon("images/concluded-task.png");
    Image imageIconeConcluido = iconeConcluido.getImage();
    Image novoIconeConcluido = imageIconeConcluido.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeConcluido = new ImageIcon(novoIconeConcluido);

    // Icone icone tarefa nao concluida
    ImageIcon iconeNaoConcluido = new ImageIcon("images/empty-checkbox.png");
    Image imageIconeNaoConcluido = iconeNaoConcluido.getImage();
    Image novoIconeNaoConcluido = imageIconeNaoConcluido.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeNaoConcluido = new ImageIcon(novoIconeNaoConcluido);

    // Checkbox tarefa concluída
    tarefaConcluida = new JCheckBox();
    tarefaConcluida.addActionListener(this);
    tarefaConcluida.setSize(24, 24);
    tarefaConcluida.setSelectedIcon(iconeConcluido);
    tarefaConcluida.setIcon(iconeNaoConcluido);
    tarefaConcluida.setBackground(Color.WHITE);
    tarefaConcluida.setSelected(concluido);

    // Icone botao deletar
    ImageIcon iconeDeletar = new ImageIcon("images/delete.png");
    Image imageIconeDeletar = iconeDeletar.getImage();
    Image novoIconeDeletar = imageIconeDeletar.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeDeletar = new ImageIcon(novoIconeDeletar);

    // borda botoes
    Border emptyBorder = BorderFactory.createEmptyBorder();

    // botao deletar
    botaoDeletar = new JButton();
    botaoDeletar.addActionListener(this);
    botaoDeletar.setFocusable(false);
    botaoDeletar.setIcon(iconeDeletar);
    botaoDeletar.setBackground(Color.WHITE);
    botaoDeletar.setBorder(emptyBorder);

    // Icone botao editar
    ImageIcon iconeEditar = new ImageIcon("images/edit.png");
    Image imageIconeEditar = iconeEditar.getImage();
    Image novoIconeEditar = imageIconeEditar.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeEditar = new ImageIcon(novoIconeEditar);

    // Botao editar
    botaoEditar = new JButton();
    botaoEditar.addActionListener(this);
    botaoEditar.setFocusable(false);
    botaoEditar.setIcon(iconeEditar);
    botaoEditar.setBackground(Color.WHITE);
    botaoEditar.setBorder(emptyBorder);

    // Icone botao visualizar
    ImageIcon iconeVisualizar = new ImageIcon("images/visualize.png");
    Image imageIconeVisualizar = iconeVisualizar.getImage();
    Image novoIconeVisualiar = imageIconeVisualizar.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeVisualizar = new ImageIcon(novoIconeVisualiar);

    // Botao visualizar
    botaoVisualizar = new JButton();
    botaoVisualizar.addActionListener(this);
    botaoVisualizar.setFocusable(false);
    botaoVisualizar.setIcon(iconeVisualizar);
    botaoVisualizar.setBackground(Color.WHITE);
    botaoVisualizar.setBorder(emptyBorder);
    
    botoes.add(tarefaConcluida);
    botoes.add(botaoDeletar);
    botoes.add(botaoEditar);
    botoes.add(botaoVisualizar);

    JTextField campoTarefa = new JTextField();
    campoTarefa.setEditable(false);
    campoTarefa.setPreferredSize(new Dimension(425, 28));
    campoTarefa.setBorder(new EmptyBorder(8,8,8,8));
    campoTarefa.setFont(new Font(null, Font.BOLD, 18));

    Color corPrioridade = null;

    if (prioridade.equals("1")) {
      corPrioridade = new Color(186, 246, 247);
    } else if (prioridade.equals("2")) {
      corPrioridade = new Color(159, 243, 245);
    } else if (prioridade.equals("3")) {
      corPrioridade = new Color(185, 245, 171);
    } else if (prioridade.equals("4")) {
      corPrioridade = new Color(255, 201, 150);
    } else if (prioridade.equals("5")) {
      corPrioridade = new Color(255, 150, 150);
    }

    campoTarefa.setBackground(corPrioridade);
    
    campoTarefa.setDocument(
      new JTextFieldLimit(30)
    );

    campoTarefa.setText(titulo);

    // campoTarefa.setFocusable(false);


    this.add(campoTarefa, BorderLayout.WEST);
    this.add(botoes, BorderLayout.EAST);

  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.botaoVisualizar) {
      this.menu.visualizarTarefa(this.index);
    }

    if (e.getSource() == this.tarefaConcluida) {
      boolean newValue = this.tarefaConcluida.isSelected();
      this.menu.concluirTarefa(index, newValue);
    }

    if (e.getSource() == this.botaoEditar) {
      this.menu.abrirEditarTarefa(index);
    }

    if (e.getSource() == this.botaoDeletar) {
      this.menu.deletarTarefa(this.index);
    }
  }

}
