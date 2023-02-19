/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 18/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: ControleOpcao3
* Funcao...........: 
*************************************************************** */
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.sound.sampled.Clip;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleOpcao3 implements Initializable {

  @FXML
  private ImageView destinoImage;

  @FXML
  private ImageView iniciarImage;

  @FXML
  private ImageView packageImage, packageImage1, packageImage2, packageImage3, packageImage4, packageImage5,
      packageImage6, packageImage7, packageImage8, packageImage9, packageImage10, packageImage11, packageImage12,
      packageImage13, packageImage14, packageImage15, packageImage16, packageImage17, packageImage18, packageImage19,
      packageImage20, packageImage21, packageImage22, packageImage23, packageImage24, packageImage25, packageImage26;

  @FXML
  private ImageView soundImage;

  @FXML
  private ImageView voltarImage;

  private int somStatus = 1; // valor 1 corresponde ao som ON; valor 0 corresponde ao som OFF

  File musicFile = new File("Songs/Persona5_song_opcao3.wav");
  public static Clip clip;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    AudioFiles.audioInitializeOpcao3(musicFile, clip);
    
  }

  @FXML
  void iniciarImageOnMouseClicked(MouseEvent event) {
    iniciarImage.setVisible(false);
    voltarImage.setVisible(true);
    soundImage.setVisible(true);
    AudioFiles.audioStartButtonOpcao3(musicFile, clip);
  }

  @FXML
  public void iniciarImageOnMouseEntered(MouseEvent event) {
    iniciarImage.setImage(Gallery.iniciarOnMouseEntered);
  }

  @FXML
  public void iniciarImageOnMouseExited(MouseEvent event) {
    iniciarImage.setImage(Gallery.iniciarOnMouseExited);
  }

  @FXML
  public void voltarImageOnMouseClicked(MouseEvent event) {
    iniciarImage.setVisible(true);
    soundImage.setVisible(false);
    soundImage.setImage(Gallery.soundExited);// soundExited == som ligado
    if (clip.isActive()) {
      clip.stop();
      clip.close();
    }
    Principal.changeScreenMenu(event);
  }

  @FXML
  public void voltarImageOnMouseEntered(MouseEvent event) {
    voltarImage.setImage(Gallery.voltarOnMouseEntered);
  }

  @FXML
  public void voltarImageOnMouseExited(MouseEvent event) {
    voltarImage.setImage(Gallery.voltarOnMouseExited);
  }

  @FXML
  public void soundImageOnMouseClicked(MouseEvent event) {
    if (somStatus == 1) {
      somStatus = 0;
      soundImage.setImage(Gallery.soundEntered);// Som off
      clip.stop();
    } else {
      somStatus = 1;
      soundImage.setImage(Gallery.soundExited);// Som on
      clip.start();
    }
  }

  @FXML
  public void soundImageOnMouseEntered(MouseEvent event) {
    if (somStatus == 1) {
      soundImage.setImage(Gallery.soundEntered);
    } else {
      soundImage.setImage(Gallery.soundExited);
    }
  }

  @FXML
  public void soundImageOnMouseExited(MouseEvent event) {
    if (somStatus == 1) {
      soundImage.setImage(Gallery.soundExited);
    } else {
      soundImage.setImage(Gallery.soundEntered);
    }
  }

}
