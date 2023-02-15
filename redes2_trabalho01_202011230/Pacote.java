/* ***************************************************************
* Autor............: Gustavo Pereira Nunes
* Matricula........: 202011230
* Inicio...........: 13/02/2023
* Ultima alteracao.: /02/2023
* Nome.............: Pacote
* Funcao...........: 
*************************************************************** */
import javafx.application.Platform;
import javafx.scene.image.ImageView;

public class Pacote extends Thread{
    
  public int contadorDePacote = 0;
  private int roteador_origem;
  private int roteador_destino;

  private final int posicaoXDoRoteador1 = 218;    private final int posicaoYDoRoteador1 = 286;
  private final int posicaoXDoRoteador2 = 000;    private final int posicaoYDoRoteador2 = 000;
  private final int posicaoXDoRoteador3 = 000;    private final int posicaoYDoRoteador3 = 000;
  private final int posicaoXDoRoteador4 = 000;    private final int posicaoYDoRoteador4 = 000;
  private final int posicaoXDoRoteador5 = 000;    private final int posicaoYDoRoteador5 = 000;
  private final int posicaoXDoRoteador6 = 000;    private final int posicaoYDoRoteador6 = 000;
  private final int posicaoXDoRoteador7 = 000;    private final int posicaoYDoRoteador7 = 000;
  
  private final int posicaoXDoHost = 0;         private final int posicaoYDoHost = 0;

  private ImageView carta;

  public Pacote (int roteador_origem, ImageView carta, int roteador_destino){
    this.roteador_origem = roteador_origem;
    this.roteador_destino = roteador_destino;
    // this.carta = carta;
    carta = new ImageView(Gallery.carta);
    carta.setFitWidth(19);
    carta.setFitHeight(29);
    this.carta = carta;
    contadorDePacote++;
  }

  @Override
  public void run() {

  }

  public void roteamentoOpcao1 (int roteadorDeOrigem){
    switch (roteadorDeOrigem){
      case 0: {//host to router 1,2,3
        System.out.println("Host to router 1");
        //chama método de animação e ele inicializa uma nova thread
        enviar_pacote(posicaoXDoHost, posicaoYDoHost, posicaoXDoRoteador1, posicaoYDoRoteador1);
        enviar_pacote(posicaoXDoHost, posicaoYDoHost, posicaoXDoRoteador2, posicaoYDoRoteador2);
        enviar_pacote(posicaoXDoHost, posicaoYDoHost, posicaoXDoRoteador3, posicaoYDoRoteador3);
        contadorDePacote += 3;
        
        break;
      }
      case 1: {//router 1 to host and router 2, 3 ,4
        
        contadorDePacote +=3;
        break;
      }
      case 2: {//router 2 to router 1, 4
        
        contadorDePacote+=2;
        break;
      }
      case 3: {// router 3 to 1, 5, 6
        
        contadorDePacote+=3;
        break;
      }
      case 4: {// router 4 to 1, 3, 6, destination
        
        contadorDePacote+=3;
        break;
      }
      case 5: {//router 5 to 3, 6, 7
        
        contadorDePacote+=3;
        break;
      }
      case 6: {//router 6 to 3, 4, 5, 7
        
        contadorDePacote+=4;
        break;
      }
      case 7: {//router 7 to 5, 6
        
        contadorDePacote+=2;
        break;
      }
      default: {//none
        
        break;
      }
      
    }
  }

  public void enviar_pacote(double xInicial, double yInicial, double xFinal, double yFinal){
    /* Roteador de origem
     * Roteador de destino
     * Animacao
     */

    
    carta.setVisible(false);
  }

  public void animacaoDoPacote (double xInicial, double yInicial, double xFinal, double yFinal) {
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
    } catch (InterruptedException ie) {
      System.out.println("Excecao na animacao: " + ie.getMessage());
    }
  }
}