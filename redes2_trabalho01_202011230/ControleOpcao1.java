/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 03/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: ControleOpcao1
* Funcao...........: 
*************************************************************** */
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ControleOpcao1 implements Initializable {

  @FXML
  private ImageView destinoImage, iniciarImage, voltarImage, soundImage;

  private Image iniciarOnMouseEntered = new Image("Imagens/iniciarButtonPressed.png");
  private Image iniciarOnMouseExited = new Image("Imagens/iniciarButton.png");
  private Image voltarOnMouseEntered = new Image("Imagens/voltarPressed.png");
  private Image voltarOnMouseExited = new Image("Imagens/voltar.png");
  private Image soundExited = new Image ("Imagens/sound_on.png");
  private Image soundEntered = new Image ("Imagens/sound_off.png");
  private int somStatus = 1; //1 == ON

  private static String musicFile = "Songs/Persona5_song_opcao1.mp3";
  private static Media sound;
  private static MediaPlayer mediaPlayer;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    sound = new Media(new File(musicFile).toURI().toString());
    mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.setVolume(0);
    mediaPlayer.play();
    mediaPlayer.stop();
    
  }

  @FXML
  public void iniciarImageOnMouseClicked(MouseEvent event) {
    iniciarImage.setVisible(false);
    voltarImage.setVisible(true);
    sound = new Media(new File(musicFile).toURI().toString());
    mediaPlayer = new MediaPlayer(sound);
    mediaPlayer.setVolume(0.125);
    mediaPlayer.play();
    mediaPlayer.getOnRepeat();
    soundImage.setVisible(true);



  }

  @FXML
  public void iniciarImageOnMouseEntered(MouseEvent event) {
    iniciarImage.setImage(iniciarOnMouseEntered);
  }

  @FXML
  public void iniciarImageOnMouseExited(MouseEvent event) {
    iniciarImage.setImage(iniciarOnMouseExited);
  }

  @FXML
  public void voltarImageOnMouseClicked(MouseEvent event) {
    iniciarImage.setVisible(true);
    soundImage.setVisible(false);
    soundImage.setImage(soundExited);//soundExited == som ligado
    if (mediaPlayer.getStatus().toString().equals("PLAYING")){
      mediaPlayer.stop();
    }
    Principal.changeScreenMenu(event);
  }

  @FXML
  public void voltarImageOnMouseEntered(MouseEvent event) {
    voltarImage.setImage(voltarOnMouseEntered);
  }

  @FXML
  public void voltarImageOnMouseExited(MouseEvent event) {
    voltarImage.setImage(voltarOnMouseExited);
  }

  @FXML
  public void soundImageOnMouseClicked(MouseEvent event) {
    if (somStatus == 1) {
      somStatus = 0;
      soundImage.setImage(soundEntered);//Som off
      mediaPlayer.setMute(true);
    } else {
      somStatus = 1;
      soundImage.setImage(soundExited);//Som on
      mediaPlayer.setMute(false);
    }
  }

  @FXML
  public void soundImageOnMouseEntered(MouseEvent event) {
    if (somStatus == 1){
      soundImage.setImage(soundEntered);
    } else {
      soundImage.setImage(soundExited);
    }
  }

  @FXML
  public void soundImageOnMouseExited(MouseEvent event) {
    if (somStatus == 1){
      soundImage.setImage(soundExited);
    } else {
      soundImage.setImage(soundEntered);
    }
  }

  public void hostToRouter(){

  }

  public void routerToHost(){
    
  }

}
