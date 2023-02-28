/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 23/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: ControleMenu
* Funcao...........: Controlar a funcionalidade da tela principal
*************************************************************** */
package Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class ControleMenu {

  @FXML
  private ImageView buttonIniciarImage;
  private static Image mouseEntered = new Image("Imagens/BotaoSelected.png");
  private static Image mouseExited = new Image("Imagens/BotaoNormal.png");
  private static Image background = new Image("Imagens/BG.png");
  @FXML
  private ImageView backgroudImageView, extraImageView;
  @FXML
  private Pane grafoPane;
  @FXML
  private Label infoLabel;


  @FXML
  public void buttonIniciarImageOnMouseClicked(MouseEvent event) {
    buttonIniciarImage.setVisible(false);
    extraImageView.setVisible(false);
    backgroudImageView.setImage(background);
    showWarningDialog();
    exibirGrafo();
    
  }

  @FXML
  public void buttonIniciarImageOnMouseEntered(MouseEvent event) {
    buttonIniciarImage.setImage(mouseEntered);
  }

  @FXML
  public void buttonIniciarImageOnMouseExited(MouseEvent event) {
    buttonIniciarImage.setImage(mouseExited);
  }

  public void exibirGrafo(){
    GerarGrafo gerador = new GerarGrafo(this);
    gerador.gerarGrafo();
    grafoPane = gerador.getRoot();
    grafoPane.setVisible(true);
  }

  public Pane getPane(){
    return grafoPane;
  }

  public void showWarningDialog(){
    Alert dialogInfo = new Alert(Alert.AlertType.WARNING);
    dialogInfo.setContentText("Selecione a origem, posteriormente o destino");
    dialogInfo.show();
  }

  public Label getInfoLabel(){
    return infoLabel;
  }

}
