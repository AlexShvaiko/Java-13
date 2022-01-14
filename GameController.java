import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController  implements IGameController{
    private IGameModel m_model;
    private IGameView m_view;
    private static final int RED=1;
    private static final int BlUE=2;
    private static int turnOf=RED;

    GameController(IGameModel model, IGameView view) {
        m_model = model;
        m_view = view;
        view.addListener(new ButtonListener());


    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
    if(e.getSource()==m_view.getReset())
    {
         m_model.reset();
        changeColor();
     }
            int i=0;
            while(i<7) {
                if (e.getSource() == m_view.getM_myButton(i)) {

                    try {
                        //  Block of code to try
                        m_model.setBord(i,turnOf);
                    }
                    catch(Exception c) {
                        JOptionPane.showMessageDialog(
                                null,
                                "The column is full fry again",
                                "Error",
                                JOptionPane.INFORMATION_MESSAGE,null
                                );
                        return;
                        //  Block of code to handle errors
                    }
                   if( m_model.checkWinner(turnOf)){
                       m_model.youWin(turnOf);
                       m_model.reset();
                   }

                    changeColor();



                }
                i++;
            }


        }
    }
    private static void changeColor()
    { if (turnOf==RED)
        turnOf=BlUE;
    else
        turnOf=RED;

    }
}





