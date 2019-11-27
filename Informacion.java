import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Informacion extends JPanel{
    public static Top top;
    public static Container contenedor;
    public Informacion(int dificultad, int numImagen){
        this.setVisible(true);
        this.top = new Top(dificultad);
        this.setLayout(new GridLayout(2, 1));
        this.add(new Icono("image\\" + numImagen + ".jpg"));
        this.add(top);
    }
}
