/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 02/02/2023
* Ultima alteracao.: 05/02/2023
* Nome.............: Principal
* Funcao...........: 
*************************************************************** */

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class Principal extends Application{
  private static Stage stage;
  private static Scene telaMenu;
  private static Scene telaOpcao1, telaOpcao2, telaOpcao3, telaOpcao4;

/* ***************************************************************
* Metodo: main
* Funcao: lançar o programa
* Parametros: args=essencial para tornar o arquivo como principal
* Retorno: void
*************************************************************** */
  public static void main (String [] args) {
    launch (args);
  }//Fim do metodo main

  private String Dir = System.getProperty("user.dir");
/* ***************************************************************
* Metodo: start
* Funcao: Iniciar a exibição de telas
* Parametros: cenario=responsavel por permitir o uso de telas
* Retorno: void
*************************************************************** */
  @Override
  public void start (Stage cenario) throws IOException {
    ControleMenu cM = new ControleMenu();
    stage = cenario;
    cenario.setTitle("Algoritmo de roteamento");
    Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("TelaMenu.fxml"));
    telaMenu = new Scene (fxmlTelaInicial);
    //Parent fxmlTelaSecundaria = FXMLLoader.load(getClass().getResource("TelaSecundaria.fxml"));
    //telaSecundaria = new Scene (fxmlTelaSecundaria);


    
    // File f = new File(Dir,"intro.mp4");
    // Media media = new Media(f.toURI().toString());
    // MediaPlayer player = new MediaPlayer(media);
    // MediaView viewer = new MediaView(player);
    // //viewer.setPreserveRatio(true);
    // StackPane root = new StackPane();
    // root.getChildren().add(viewer);
    // Scene video = new Scene (root);
    // cenario.setScene(video);
    // player.play();
    
    
    cenario.setResizable(false);
    cenario.getIcons().add(new Image("Imagens/host.png"));
    cenario.setScene(telaMenu);
    cenario.show();
  }//Fim do metodo start

  public static void changeScreenOpcao1 (MouseEvent event) {
    stage.setScene(telaOpcao1);
  }

  public static void changeScreenOpcao2 (MouseEvent event) {
    stage.setScene(telaOpcao2);
  }

  public static void changeScreenOpcao3 (MouseEvent event) {
    stage.setScene(telaOpcao3);
  }

  public static void changeScreenOpcao4 (MouseEvent event) {
    stage.setScene(telaOpcao4);
  }
}//Fim da classe Principal
