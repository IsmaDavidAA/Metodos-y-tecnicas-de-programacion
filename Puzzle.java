import java.awt.Container;
import java.awt.image.BufferedImage;
import java.awt.GridLayout;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.util.*;
public class Puzzle extends JFrame{
    public static Container contenedor;
    public static Board board;
    public static Informacion informacion;
    public static int movimientos;
    private BufferedImage img;
    private int numImagen;
    public static int dificultad;
    public Puzzle(int dificultad){
        movimientos = 0;
        this. dificultad = dificultad;
        this.setTitle("Rompecabezas");
        this.setSize(1005, 679);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);       
        contenedor = this.getContentPane();
        contenedor.setLayout(new FlowLayout(FlowLayout.LEFT));
        numImagen = (int) (Math.random() * 9) + 1;
        leerImagen();
        board = new Board(dificultad, img);
        Informacion info = new Informacion(dificultad, numImagen);
        contenedor.add(board);
        contenedor.add(info);
        this.setVisible(true);
    }
    public void leerImagen(){
          try {
            img = ImageIO.read(new File("image\\" + numImagen + ".jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}