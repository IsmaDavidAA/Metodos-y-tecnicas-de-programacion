import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;

public class Board extends JPanel{
    public static Cell[][] board;
    private ArrayList<Cell> completeBoard = new ArrayList<Cell>();
    private int dimension;
    private int x, y;
    private int figuraWidth, figuraHeight;
    private JLabel empty;
    public Board(int dimension, BufferedImage imagen){
        this.setPreferredSize(new Dimension(640, 640));
        this.dimension = dimension;
        board = new Cell[dimension][dimension];
        this.setBackground(Color.BLACK);
        x = 0;
        y = 0;
        this.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        recortar(imagen);
        desordenar();
        remover();
        this.setVisible(true);
    }
    
    private void recortar(BufferedImage imagen){
        figuraWidth = imagen.getWidth()/ dimension;
        figuraHeight = imagen.getHeight()/ dimension;
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                if(i == dimension -1 && j == dimension -1) continue;
                completeBoard.add(new Cell(i, j, new Figura(i, j, new ImageIcon(imagen.getSubimage(x, y, figuraWidth, figuraHeight)), dimension)));
                x += figuraWidth;
            }
            x = 0;
            y += figuraHeight;
        }
    }
    
    private void desordenar(){
        Random generador = new Random();
        ArrayList<Cell> copia = new ArrayList<Cell>(completeBoard);
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                if(i == dimension -1 && j == dimension -1){
                    board[i][j] = new Cell(i, j);
                    continue;
                }
                int aleatorio = generador.nextInt(completeBoard.size());
                completeBoard.get(aleatorio).getFigura().setXYPos(i, j);
                board[i][j] = new Cell(i, j, completeBoard.get(aleatorio).getFigura());
                completeBoard.remove(aleatorio);
            }
        }
        completeBoard = copia;
        remover();
    }
    
    private void actualizar(){
        for(int i = 0; i< dimension; i++){
            for(int j = 0; j< dimension; j++){
                if(board[i][j].getFigura() == null){
                    empty = new JLabel();
                    empty.setPreferredSize(new Dimension(figuraWidth, figuraHeight));
                    this.add(empty);
                    continue;
                }
                this.add(board[i][j].getFigura());
            }
        }
        Puzzle.contenedor.validate();
    }
    
    public void remover(){
        this.removeAll();
        actualizar();
    }
}