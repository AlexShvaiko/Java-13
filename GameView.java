import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView extends JFrame implements IGameView {
    private JButton [] m_myButton= new JButton[LENGTH] ;
    private   MyPanel [][] game=new MyPanel[HIGH][LENGTH];
    private JButton reset= new JButton("reset");
    private  JPanel  r1=new JPanel();
    private  JPanel  r2=new JPanel();
    private  JPanel  r3=new JPanel();
    private static final int LENGTH=7;
    private static final int HIGH=6;
    private IGameModel m_model;
    GameView(IGameModel model) {


        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        GridLayout layout2=new GridLayout(HIGH+1,LENGTH);
        GridLayout layout3=new GridLayout(2,1);
        r1.setLayout(layout);
        r1.add(reset);
        r1.setSize(300,300);

        this.setLayout(layout3);
        r2.setLayout(layout2);


// You're original code...
// Why are you using `BorderLayout.CENTER` on a `GridLayout`
        setVisible(true);
        m_model = model;

        for (int a = 0; a < HIGH; a++) {

            for (int b = 0; b < LENGTH; b++) {

                game[a][b] = new MyPanel(a,b);
                r2.add(game[a][b],gbc);


            }}
      for (int i = 0; i < LENGTH; i++) {
            m_myButton [i]= new JButton(""+(i+1));
            r2.add(m_myButton[i],gbc); }
        this.add(r2);
        this.add(r1);
        this.setTitle("MY project");
        this.pack();


        // The window closing event should probably be passed to the
        // Controller in a real program, but this is a short example.
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }



    public MyPanel getGame(int x,int y) {
        return game[x][y];
    }
    public void addListener(ActionListener mal) {
        int i = 0;
        while (i < LENGTH){
            m_myButton[i].addActionListener(mal);

        i++;
    }
        reset.addActionListener(mal);
    }

    public JButton getM_myButton(int x) {
        return m_myButton[x];
    }
    public JButton getReset() {
        return reset;
    }

}
