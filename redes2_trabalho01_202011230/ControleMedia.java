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
import javafx.scene.media.MediaView;

public class ControleMedia implements Initializable{

  @FXML
  private MediaView mediaView;

  @FXML
  private ImageView nextImageButton;

  private File file;
  private Media media;
  private MediaPlayer mediaPlayer;
  private String dir = System.getProperty("user.dir");
  Image nextBefore = new Image ("Imagens/NextButton.png");
  Image nextAfter = new Image("Imagens/NextButtonSelected.png");

  

  @FXML
  void nextImageButtonOnMouseClicked(MouseEvent event) {
    Principal.changeScreenMenu(event);
  }

  @FXML
  void nextImageButtonOnMouseEntered(MouseEvent event) {
    nextImageButton.setImage(nextAfter);
  }

  @FXML
  void nextImageButtonOnMouseExited(MouseEvent event) {
    nextImageButton.setImage(nextBefore);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    
    file = new File(dir,"Intro.mp4");
    media = new Media(file.toURI().toString());
    mediaPlayer = new MediaPlayer(media);
    mediaView.setMediaPlayer(mediaPlayer);
    mediaPlayer.play();
  }

}
