import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Figura extends JButton implements ActionListener{
    private final int xSolPos, ySolPos;
    private int xPos, yPos;
    private int dimension;
    public Figura(int xSolPos, int ySolPos, ImageIcon subimage, int dimension)
    {
        this.xSolPos = xSolPos;
        this.ySolPos = ySolPos;
        this.dimension = dimension;
        this.xPos = xSolPos;
        this.yPos = ySolPos;
        this.setIcon(subimage);
        this.setPreferredSize(new Dimension(subimage.getIconWidth(), subimage.getIconHeight()));
        this.addActionListener(this); 
    }

    public int getxPos() { return xPos; }
    public void setxPos(int xPos) { this.xPos = xPos; }
    public int getyPos() { return yPos; }
    public void setyPos(int yPos) { this.yPos = yPos; }
    public int getxSolPos() { return xSolPos; }
    public int getySolPos() { return ySolPos; }
    public void setXYPos(int xPos, int yPos) { 
        this.xPos = xPos;
        this.yPos = yPos;
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0) {
        Mover();
    }
    
    private void Mover(){
        Cell[][] board = Board.board;
        Puzzle.movimientos++;
        if(!arriba(board)){ 
            if(!abajo(board)){
                if(!derecha(board))  izquierda(board);
            }
        }
        Puzzle.board.remover();
        if(ComprobarRespuesta()){
            PantallaSalida ps= new PantallaSalida(Puzzle.dificultad,Puzzle.movimientos);
        }
    }
    
    public boolean arriba(Cell[][] board){
        boolean res = false;
        try{
            if(board[xPos][yPos-1].getFigura() == null){
                Board.board[xPos][yPos-1].setFigure(this);
                Board.board[xPos][yPos].setFigure(null);
                yPos --;
                res = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        return res;
    }
    
    private boolean abajo(Cell[][] board){
        boolean res = false;
        try{
            if(board[xPos][yPos +1].getFigura() == null){
                Board.board[xPos][yPos +1].setFigure(this);
                Board.board[xPos][yPos].setFigure(null);
                yPos ++;
                res = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        return res;
    }
    
    private boolean derecha(Cell[][] board){
        boolean res = false;
        try{
            if(board[xPos + 1][yPos].getFigura() == null){
                Board.board[xPos + 1][yPos].setFigure(this);
                Board.board[xPos][yPos].setFigure(null);
                xPos ++;
                res = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        return res;
    }
    
    private boolean izquierda(Cell[][] board){
        boolean res = false;
        try{
            if(board[xPos - 1][yPos].getFigura() == null){
                Board.board[xPos - 1][yPos].setFigure(this);
                Board.board[xPos][yPos].setFigure(null);
                xPos --;
                res = true;
            }
        }catch(ArrayIndexOutOfBoundsException e){}
        return res;
    }
    
    private boolean ComprobarRespuesta(){
        Figura figura = null;
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                figura = Board.board[i][j].getFigura();
                if(figura == null) continue;
                if(figura.getxPos() != figura.getxSolPos() || figura.getyPos() != figura.getySolPos()) return false;
            }
        }
        return true;
    }
}