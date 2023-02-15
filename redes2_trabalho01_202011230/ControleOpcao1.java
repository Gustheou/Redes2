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
import javax.sound.sampled.Clip;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleOpcao1 implements Initializable {

  @FXML
  private ImageView destinoImage, iniciarImage, voltarImage, soundImage;


  @FXML
  private ImageView packageImage, packageImage1, packageImage2, packageImage3, packageImage4, packageImage5, packageImage6, packageImage7, packageImage8, packageImage9, packageImage10, packageImage11, packageImage12, packageImage13, packageImage14, packageImage15, packageImage16, packageImage17, packageImage18, packageImage19, packageImage20, packageImage21, packageImage22, packageImage23, packageImage24, packageImage25, packageImage26;
  
  private ImageView[] packageImageArray = {packageImage, packageImage1, packageImage2, packageImage3, packageImage4, packageImage5, packageImage6, packageImage7, 
                              packageImage8, packageImage9, packageImage10, packageImage11, packageImage12, packageImage13, packageImage14, packageImage15, 
                              packageImage16, packageImage17, packageImage18, packageImage19, packageImage20, packageImage21, packageImage22, packageImage23, 
                              packageImage24, packageImage25, packageImage26};
 
  private int somStatus = 1; //valor 1 corresponde ao som ON; valor 0 corresponde ao som OFF

  File musicFile = new File ("Songs/Persona5_song_opcao1.wav");
  public static Clip clip;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    AudioFiles.audioInitializeOpcao1(musicFile, clip);
    
    // for (int i = 0; i < packageImageArray.length; i++) {
    //   packageImageArray[i].setImage(Gallery.carta);
    //   packageImageArray[i].setVisible(false);
    // }
    // packageImage.setImage(Gallery.carta); 
    // packageImage.setVisible(false); 
    
    
  }

  @FXML
  public void iniciarImageOnMouseClicked(MouseEvent event) {
    iniciarImage.setVisible(false);
    voltarImage.setVisible(true);

    AudioFiles.audioStartButtonOpcao1(musicFile, clip);
    soundImage.setVisible(true);

    //Instanciar as threads dos roteadores
    // for (int i = 0; i < 8; i++) {
    //   pacotes[i] = new Pacote(i);
    //   pacotes[i].start();
    // }
    //packageImageArray[0].setVisible(true);
    
      // ImageView carta = new ImageView("Imagens/Package.jpg");
      // carta.setFitWidth(29);
      // carta.setFitHeight(19);
      // carta.setX(123);
      // carta.setY(250);
      // carta.setVisible(true);
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
    soundImage.setImage(Gallery.soundExited);//soundExited == som ligado
    if (clip.isActive()){
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
      soundImage.setImage(Gallery.soundEntered);//Som off
      clip.stop();
    } else {
      somStatus = 1;
      soundImage.setImage(Gallery.soundExited);//Som on
      clip.start();
    }
  }

  @FXML
  public void soundImageOnMouseEntered(MouseEvent event) {
    if (somStatus == 1){
      soundImage.setImage(Gallery.soundEntered);
    } else {
      soundImage.setImage(Gallery.soundExited);
    }
  }

  @FXML
  public void soundImageOnMouseExited(MouseEvent event) {
    if (somStatus == 1){
      soundImage.setImage(Gallery.soundExited);
    } else {
      soundImage.setImage(Gallery.soundEntered);
    }
  }
}

