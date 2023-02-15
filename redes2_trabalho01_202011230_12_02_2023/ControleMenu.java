/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 03/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: ControleMenu
* Funcao...........: 
*************************************************************** */
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleMenu {

  @FXML
  private ImageView imageAbout, aboutBackButton, aboutScreen;

  public ImageView soundImage;
  private Image aboutExited = new Image("Imagens/about.png");
  private Image aboutEntered = new Image ("Imagens/aboutClicked.png");
  private Image soundExited = new Image ("Imagens/sound_on.png");
  private Image soundEntered = new Image ("Imagens/sound_off.png");
  private Image aboutReturnButtonExited = new Image ("Imagens/aboutScreenBackButton.png");
  private Image aboutReturnButtonEntered = new Image ("Imagens/aboutScreenBackButtonOnMouse.png");
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
    imageAbout.setImage(aboutEntered);
  }

  @FXML
  public void imageAboutOnMouseExited(MouseEvent event) {
    imageAbout.setImage(aboutExited);
  }

  @FXML
  public void changeBackButtonEffectEntered(MouseEvent event) {
    aboutBackButton.setImage(aboutReturnButtonEntered);
  }

  @FXML
  public void changeBackButtonEffectExited(MouseEvent event) {
    aboutBackButton.setImage(aboutReturnButtonExited);
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
      soundImage.setImage(soundEntered);//Som off
      Principal.clip.stop();
    } else {
      somStatus = 1;
      soundImage.setImage(soundExited);//Som on
      Principal.clip.start();
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

}
