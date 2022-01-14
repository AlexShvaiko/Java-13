public interface IGameModel {
    public  void setBord(int x,int color) throws Exception;
    public boolean checkWinner(int color);
    public void reset();
    public void youWin(int color);
}
