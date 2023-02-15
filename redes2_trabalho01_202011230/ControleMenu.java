/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 03/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: ControleMenu
* Funcao...........: 
*************************************************************** */
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleMenu {

  @FXML
  private ImageView imageAbout, aboutBackButton, aboutScreen, soundImage;

  private int somStatus = 1;//1 == ON

  
  @FXML
  public void changeScreenOpcao1(MouseEvent event) {
    Principal.changeScreenOpcao1(event);
  }

  @FXML
  public void changeScreenOpcao2(MouseEvent event) {

  }

  @FXML
  public void changeScreenOpcao3(MouseEvent event) {

  }

  @FXML
  public void changeScreenOpcao4(MouseEvent event) {

  }

  @FXML
  public void imageAboutOnMouseClicked(MouseEvent event) {
    aboutScreen.setVisible(true);
    aboutBackButton.setVisible(true);
  }

  @FXML
  public void imageAboutOnMouseEntered(MouseEvent event) {
    imageAbout.setImage(Gallery.aboutEntered);
  }

  @FXML
  public void imageAboutOnMouseExited(MouseEvent event) {
    imageAbout.setImage(Gallery.aboutExited);
  }

  @FXML
  public void changeBackButtonEffectEntered(MouseEvent event) {
    aboutBackButton.setImage(Gallery.aboutReturnButtonEntered);
  }

  @FXML
  public void changeBackButtonEffectExited(MouseEvent event) {
    aboutBackButton.setImage(Gallery.aboutReturnButtonExited);
  }

  @FXML
  public void closeAboutMenuOnClicked(MouseEvent event) {
    aboutScreen.setVisible(false);
    aboutBackButton.setVisible(false);
  }

  
  @FXML
  public void soundImageOnMouseClicked(MouseEvent event) {
    if (somStatus == 1) {
      somStatus = 0;
      soundImage.setImage(Gallery.soundEntered);//Som off
      Principal.clip.stop();
    } else {
      somStatus = 1;
      soundImage.setImage(Gallery.soundExited);//Som on
      Principal.clip.start();
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
