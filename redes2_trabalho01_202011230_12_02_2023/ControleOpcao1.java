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
import java.util.concurrent.Semaphore;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class ControleOpcao1 implements Initializable {

  @FXML
  private ImageView destinoImage, iniciarImage, voltarImage, soundImage;


  @FXML
  static public ImageView packageImage, packageImage1, packageImage2, packageImage3, packageImage4, packageImage5, packageImage6, packageImage7, packageImage8, packageImage9, packageImage10, packageImage11, packageImage12, packageImage13, packageImage14, packageImage15, packageImage16, packageImage17, packageImage18, packageImage19, packageImage20, packageImage21, packageImage22, packageImage23, packageImage24, packageImage25, packageImage26;

 

  private Image iniciarOnMouseEntered = new Image("Imagens/iniciarButtonPressed.png");
  private Image iniciarOnMouseExited = new Image("Imagens/iniciarButton.png");
  private Image voltarOnMouseEntered = new Image("Imagens/voltarPressed.png");
  private Image voltarOnMouseExited = new Image("Imagens/voltar.png");
  private Image soundExited = new Image ("Imagens/sound_on.png");
  private Image soundEntered = new Image ("Imagens/sound_off.png");
  private int somStatus = 1; //valor 1 corresponde ao som ON; valor 0 corresponde ao som OFF

  File musicFile = new File ("Songs/Persona5_song_opcao1.wav");
  public static Clip clip;

  static Semaphore mutex = new Semaphore(8);
  static int roteadorPermitido = 0;
  static Pacote[] pacotes = new Pacote[8];

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    try {
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
      clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();
      clip.stop();
      clip.close();

    } catch (Exception e) {
      System.out.println("Excecao na musica: " + e.getMessage());
    }
    
  }

  @FXML
  public void iniciarImageOnMouseClicked(MouseEvent event) {
    iniciarImage.setVisible(false);
    voltarImage.setVisible(true);

    try {
      AudioInputStream audioStream = AudioSystem.getAudioInputStream(musicFile);
      clip = AudioSystem.getClip();
      clip.open(audioStream);
      clip.start();

    } catch (Exception e) {
      System.out.println("Excecao na musica: " + e.getMessage());
    }

    soundImage.setVisible(true);

    //Instanciar as threads dos roteadores
    // for (int i = 0; i < 8; i++) {
    //   pacotes[i] = new Pacote(i);
    //   pacotes[i].start();
    // }
    //packageImage = new ImageView("Imagens/Package.jpg");
    packageImage.setVisible(true);
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
    if (clip.isActive()){
      clip.stop();
      clip.close();

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
      clip.stop();
    } else {
      somStatus = 1;
      soundImage.setImage(soundExited);//Som on
      clip.start();
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

  public class Pacote extends Thread{
    
    final String imagemDoPacote = "Imagens/Package.jpg";
    
    private int id;

    public Pacote (int id){
      this.id = id;
    }

    @Override
    public void run(){
      try {
        while (true){
          if (ControleOpcao1.roteadorPermitido >= id){
            ControleOpcao1.mutex.acquire(ControleOpcao1.roteadorPermitido);
            roteamento(id);
            Thread.sleep(3000);
            ControleOpcao1.mutex.release(ControleOpcao1.roteadorPermitido);
            ControleOpcao1.roteadorPermitido++;
          } else {
            Thread.sleep(1000);
          }
        }
      } catch (InterruptedException ie) {
        System.out.println("Excecao na run do pacote: "+ie.getMessage());
      }
      
    }

    public void roteamento (int roteador){
      switch (roteador){
        case 0: {//host to router 1
          System.out.println("Host to router 1");
          //chama método de animação e ele inicializa uma nova thread
          enviar_pacote(123, 235, 218, 286);

          break;
        }
        case 1: {//router 1 to host and router 2, 3 ,4
          System.out.println("Roteador: " + roteador);
          System.out.println("Roteador: "+roteador+"Enviando para host");
          //metodo ?? O jeito vai ser implementar a animação
          System.out.println("Roteador: "+roteador+"Enviando para roteador 2");
          //metodo
          System.out.println("Roteador: "+roteador+"Enviando para roteador 3");
          //metodo
          System.out.println("Roteador: "+roteador+"Enviando para roteador 4");
          //metodo
          break;
        }
        case 2: {//router 2 to router 1, 4
          
          break;
        }
        case 3: {// router 3 to 1, 5, 6
          
          break;
        }
        case 4: {// router 4 to 1, 3, 6, destination
          
          break;
        }
        case 5: {//router 5 to 3, 6, 7
          
          break;
        }
        case 6: {//router 6 to 3, 4, 5, 7
          
          break;
        }
        case 7: {//router 7 to 5, 6
          
          break;
        }
        default: {//none
          
          break;
        }
        
      }
    }

    public void enviar_pacote(double xInicial, double yInicial, double xFinal, double yFinal){
      Image cartaImage = new Image(imagemDoPacote);
      ImageView carta = new ImageView(cartaImage);
      carta.setFitWidth(29);
      carta.setFitHeight(19);
      carta.setX(xInicial);
      carta.setY(yInicial);
      carta.setVisible(true);
      
      

      try {
        //Os ifs abaixo são para que a movimentação seja realizada em qualquer situação
        if ((xInicial > xFinal) && (yInicial > yFinal)) {
          while((xInicial != xFinal) && (yInicial != yFinal)){
          Thread.sleep((long) 25);
          final double posicaoConstanteX = xInicial;
          final double posicaoConstanteY = yInicial;
          Platform.runLater( () -> carta.setX(posicaoConstanteX));
          Platform.runLater(() -> carta.setY(posicaoConstanteY));
          xInicial--;
          yInicial--;
          }
        } else if ((xInicial < xFinal) && (yInicial < yFinal)) {
          while((xInicial != xFinal) && (yInicial != yFinal)){
          Thread.sleep((long) 25);
          final double posicaoConstanteX = xInicial;
          final double posicaoConstanteY = yInicial;
          Platform.runLater( () -> carta.setX(posicaoConstanteX));
          Platform.runLater(() -> carta.setY(posicaoConstanteY));
          xInicial++;
          yInicial++;
          }
        } else if ((xInicial > xFinal) && (yInicial < yFinal)){
          while((xInicial != xFinal) && (yInicial != yFinal)){
          Thread.sleep((long) 25);
          final double posicaoConstanteX = xInicial;
          final double posicaoConstanteY = yInicial;
          Platform.runLater( () -> carta.setX(posicaoConstanteX));
          Platform.runLater(() -> carta.setY(posicaoConstanteY));
          xInicial--;
          yInicial++;
          }
        } else {
          while((xInicial != xFinal) && (yInicial != yFinal)){
          Thread.sleep((long) 25);
          final double posicaoConstanteX = xInicial;
          final double posicaoConstanteY = yInicial;
          Platform.runLater( () -> carta.setX(posicaoConstanteX));
          Platform.runLater(() -> carta.setY(posicaoConstanteY));
          xInicial++;
          yInicial--;
          }
        }
        // while((xInicial != xFinal) && (yInicial != yFinal)){
        //   Thread.sleep((long) 25);
        //   final double posicaoConstanteX = xInicial;
        //   final double posicaoConstanteY = yInicial;
        //   Platform.runLater( () -> carta.setX(posicaoConstanteX));
        //   Platform.runLater(() -> carta.setY(posicaoConstanteY));
        //   xInicial++;
        //   yInicial--;
        // }
      } catch (InterruptedException ie) {
        System.out.println("Excecao na animacao: " + ie.getMessage());
      }
    }
  }
}

