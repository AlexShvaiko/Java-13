import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private int x;
    private  int y;

public MyPanel(int x ,int y)
{
    this.x=x;
    this.y=y;

}

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setVisible(true);
        g.setColor(Color.BLACK);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        if(GameModel.getBord(this.x,this.y)==1)
        {
            g.setColor(Color.RED);
            g.fillOval(0,0,this.getWidth(),this.getHeight());
        }
        if(GameModel.getBord(this.x,this.y)==2){
            g.setColor(Color.blue);
        g.fillOval(0,0,this.getWidth(),this.getHeight());
    }

    }



}
