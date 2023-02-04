/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 02/02/2023
* Ultima alteracao.: /02/2023
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Principal extends Application{
  private static Stage stage;
  private static Scene telaMenu;
  private static Scene telaOpcao1, telaOpcao2, telaOpcao3, telaOpcao4;

  private static String musicFile = "Songs/Persona5_song_menu.mp3";
  private static Media sound;
  public static MediaPlayer mediaPlayer;

/* ***************************************************************
* Metodo: main
* Funcao: lançar o programa
* Parametros: args=essencial para tornar o arquivo como principal
* Retorno: void
*************************************************************** */
  public static void main (String [] args) {
    launch (args);
  }//Fim do metodo main

/* ***************************************************************
* Metodo: start
* Funcao: Iniciar a exibição de telas
* Parametros: cenario=responsavel por permitir o uso de telas
* Retorno: void
*************************************************************** */
  @Override
  public void start (Stage cenario) throws IOException {
    ControleMenu cM = new ControleMenu();
    ControleOpcao1 cO1 = new ControleOpcao1();
    stage = cenario;
    cenario.setTitle("Algoritmo de roteamento");
    Parent fxmlTelaInicial = FXMLLoader.load(getClass().getResource("telaMenu.fxml"));
    telaMenu = new Scene (fxmlTelaInicial);
    Parent fxmlTelaOpcao1 = FXMLLoader.load(getClass().getResource("opcao1.fxml"));
    telaOpcao1 = new Scene (fxmlTelaOpcao1);    

    //Inicializando a musica
    sound = new Media(new File(musicFile).toURI().toString());
    mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.setVolume(0.125);
    mediaPlayer.play();
    mediaPlayer.getOnRepeat();

    cenario.setResizable(false);
    cenario.getIcons().add(new Image("Imagens/host.png"));
    cenario.setScene(telaMenu);
    cenario.show();
  }//Fim do metodo start

  public static void changeScreenOpcao1 (MouseEvent event) {
    stage.setScene(telaOpcao1);
    mediaPlayer.stop();
  }

  public static void changeScreenOpcao2 (MouseEvent event) {
    stage.setScene(telaOpcao2);
    mediaPlayer.stop();
  }

  public static void changeScreenOpcao3 (MouseEvent event) {
    stage.setScene(telaOpcao3);
    mediaPlayer.stop();
  }

  public static void changeScreenOpcao4 (MouseEvent event) {
    stage.setScene(telaOpcao4);
    mediaPlayer.stop();
  }

  public static void changeScreenMenu(MouseEvent event){
    stage.setScene(telaMenu);
    sound = new Media(new File(musicFile).toURI().toString());
    mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.setVolume(0.125);
    mediaPlayer.play();
    mediaPlayer.getOnRepeat();
  }
}//Fim da classe Principal
