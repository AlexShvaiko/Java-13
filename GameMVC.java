import javax.swing.*;

public class GameMVC {
    public static void main(String[] args) {

      IGameModel    model      = new GameModel();
       IGameView    view      = new GameView(model);
       IGameController    controller     = new GameController(model,view);




    }
}
