/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 23/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: GerarGrafo
* Funcao...........: Criar a estrutura de dados e exibir na interface
*************************************************************** */
package Controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.Cursor;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class GerarGrafo {
  private static String nome_do_arquivo = "backbone.txt";
  private Text[] metrica;
  private Text[] roteador;
  private int[][] nos_de_ida_e_volta;
  private int numero_de_nos;
  private Line[] linhas;
  private RadioButton[] nodes;
  private int status = 1;
  private String roteador_origem, roteador_destino;
  Pane root;
  Label infoLabel;
  ToggleGroup group = new ToggleGroup();

  ControleMenu controle;

  public GerarGrafo(ControleMenu controle) {
    this.controle = controle;
    root = controle.getPane();
    infoLabel = controle.getInfoLabel();
  }

  public void lerArquivo() {
    try {
      BufferedReader br = new BufferedReader(new FileReader(nome_do_arquivo));
      String primeira_linha = br.readLine();
      int index = primeira_linha.indexOf(";");
      numero_de_nos = Integer.parseInt(primeira_linha.substring(0, index));
      nos_de_ida_e_volta = new int[numero_de_nos][numero_de_nos];

      String linha_atual;
      while ((linha_atual = br.readLine()) != null) {
        String[] parts = linha_atual.split(";");
        int no1 = Integer.parseInt(parts[0]) - 1;
        int no2 = Integer.parseInt(parts[1]) - 1;
        int peso = Integer.parseInt(parts[2]);
        nos_de_ida_e_volta[no1][no2] = peso;
        nos_de_ida_e_volta[no2][no1] = peso;
      }
      br.close();
    } catch (IOException ioe) {
      System.out.println("Excecao em ler o arquivo: " + ioe.getMessage());
    }
  }

  public void gerarGrafo() {
    File file = new File(nome_do_arquivo);
    if (!file.exists()) {
      System.out.println("Arquivo inexistente");
    }
    lerArquivo();
    double angulo = 105;//105, 115
    //  double angulo = 2 * Math.PI / numero_de_nos;
    nodes = new RadioButton[numero_de_nos];
    definirRoteadores(angulo, nodes);
    int count = 0;
    linhas = new Line[numero_de_nos * (numero_de_nos - 1) / 2];
    roteador = new Text[numero_de_nos + 1];
    metrica = new Text[numero_de_nos * (numero_de_nos - 1) / 2];
    interligarOGrafo(linhas, roteador, metrica, count);
    setRoot(root);
  }

  public void setRoot(Pane pane) {
    this.root = pane;
  }

  public Pane getRoot() {
    System.out.println("LayoutX: " + root.getLayoutX());
    System.out.println("LayoutY: " + root.getLayoutY());
    System.out.println("Height: " + root.getPrefHeight());
    System.out.println("Width: " + root.getPrefWidth());
    return root;
  }

  public void definirRoteadores(double angle, RadioButton[] nodes){
    for (int i = 0; i < numero_de_nos; i++) {
      double x = 220 + 160 * Math.cos(i * angle);
      double y = 200 + 160 * Math.sin(i * angle);
      RadioButton radio = new RadioButton();
      radio = instanciarRoteadores(radio, x, y, i);
      root.getChildren().add(radio);
      nodes[i] = radio;
    }
  }

  public RadioButton instanciarRoteadores(RadioButton radio, double x, double y, int i) {
    radio.setLayoutX(x);
    radio.setLayoutY(y);
    radio.setToggleGroup(group);
    radio.setCursor(Cursor.HAND);
    radio.setId("Roteador" + i);
    radio.setOnMouseClicked(e -> {
      System.out.println(radio.getId()+" selecionado");
      if (status == 1) {
        infoLabel.setText("Origem: " + radio.getId());
        radio.setDisable(true);
        //Metodo de setar a origem
        roteador_origem = radio.getId();
      }
      if (status == 2) {
        infoLabel.setText(infoLabel.getText()+ "\n" + "Destino: "+radio.getId());
        radio.setDisable(true);
        //Metodo de setar o destino e iniciar o algoritmo. Ao terminar mostrar o botao refazer
        roteador_destino = radio.getId();
        iniciarAlgoritmo(roteador_origem, roteador_destino);
      }
      status++;
    });
    return radio;
  }

  public void interligarOGrafo(Line[] linhas, Text[] roteador, Text[] metrica, int count){
    for (int i = 0; i < numero_de_nos; i++) {//Para a origem
      for (int j = i + 1; j < numero_de_nos; j++) {//Para o destino
        if (nos_de_ida_e_volta[i][j] > 0) {
          Line line = new Line(nodes[i].getLayoutX()+10, nodes[i].getLayoutY()+10, nodes[j].getLayoutX()+10, nodes[j].getLayoutY()+10);
          line.setStroke(Color.rgb(72, 70, 58));
          // line.setStroke(Color.rgb(255, 0, 0));
          root.getChildren().add(line);
          linhas[count] = line;
          Text text = new Text((nodes[i].getLayoutX() + nodes[j].getLayoutX()) / 2,
              (nodes[i].getLayoutY() + nodes[j].getLayoutY()) / 2, Integer.toString(nos_de_ida_e_volta[i][j]));
          root.getChildren().add(text);
          metrica[count] = text;
          count++;
        }
      }
      Text router = new Text(nodes[i].getLayoutX() - 25, nodes[i].getLayoutY() - 5, "Roteador: " + Integer.toString(i));
      root.getChildren().add(router);
      roteador[i] = router;
    }
  }

  public void iniciarAlgoritmo (String origem, String destino) {
    
  }

}
