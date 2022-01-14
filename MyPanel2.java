import javax.swing.*;
import java.awt.*;

public class MyPanel2 extends JPanel {

    public MyPanel2()
    {
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        JButton reset= new JButton("reset");
        this.setSize(100,100);

        this.add(reset);
        

    }
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        this.setVisible(true);

    }
}
