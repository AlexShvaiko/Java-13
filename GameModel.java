import javax.swing.*;

public class GameModel implements IGameModel{
    private static final int LENGTH=7;
    private static final int HIGH=6;
    private static final int RED=1;
    private static final int BlUE=2;
    private static final int TOWIN=4;
    private static int bord [][]=new int [HIGH][LENGTH];


    GameModel() {
    }

    public static int getBord(int x,int y) {
        return bord[x][y];
    }
    public  void setBord(int x,int color) throws Exception
    {
        int i=HIGH-1;
        while(bord[i][x]!=0&&i>=0)
        {
            i--;
        }
        if(i<0)
        {
            throw new Exception("the column is full");
        }
        bord[i][x]=color;




    }
    public static void setBord(int x,int y,int val) {
        bord[x][y] = val;

    }
    public boolean checkWinner(int color)
    {
       if(checkColumn(color)||checkRow(color)||checkDeg(color)||checkDeg2(color))
       {
           return true;
       }
       else
           return false;


    }
    private boolean checkColumn(int color){
        int counter=0;
        for(int j=0;j<LENGTH;j++)
        for(int i=HIGH-1;i>=0;i--)
        {
            if(bord[i][j]==color)
                counter++;
            else
                counter=0;
            if(counter>=TOWIN)
                return true;

        }
        return false;
    }
    private boolean checkRow(int color){
       int counter=0;
       for(int i=HIGH-1;i>=0;i--)
       {
           for(int j=0;j<LENGTH;j++) {
               if (bord[i][j] == color)
                   counter++;
               else
                   counter = 0;
               if (counter >= TOWIN)
                   return true;
           }

       }
        return false;

    }
    private boolean checkDeg(int color) {
        int counter=0,j=0,k;
        for(k=0;k<HIGH;k++){

        for(int i=k;i<HIGH&&j<LENGTH;i++,j++)
        {
            if(bord[i][j]==color)
                counter++;
            if(counter==TOWIN)
                return true;
        }
        j=0;

        counter=0;
        }
        j=0;
        for(k=0;k<LENGTH;k++){
            for(int i=k;j<HIGH&&i<LENGTH;i++,j++)
            {
                if(bord[j][i]==color)
                    counter++;
                if(counter==TOWIN)
                    return true;
            }
            counter=0;
        j=0;
        }




    return false;
    }
    private static boolean checkDeg2(int color)
    {
        int counter=0,j=LENGTH-1,k;
        for(k=0;k<HIGH;k++){

        for(int i=k;i<HIGH&&j>=0;i++,j--)
        {
            if(bord[i][j]==color)
                counter++;
            if(counter==TOWIN)
                return true;
        }
        counter=0;


    }
        j=LENGTH-1;
        for(k=LENGTH-1;k>=0;k--){
            for(int i=0;i<HIGH&&j>=0;i++,j--)
            {
                if(bord[i][j]==color)
                    counter++;
                if(counter==TOWIN)
                    return true;
            }
            counter=0;


        }
        return false;
    }
    public void reset()
    {
        bord=new int [HIGH][LENGTH];
    }
    public void youWin(int color )
    {
        if(color==RED)
            JOptionPane.showMessageDialog(
                    null,
                    "RED wins ",
                    "Winner",
                    JOptionPane.INFORMATION_MESSAGE,null);
        else
            JOptionPane.showMessageDialog(
                    null,
                    "Blue  wins ",
                    "Winner",
                    JOptionPane.INFORMATION_MESSAGE,null);


    }

}
