import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Icono extends JPanel{
    private String nomImg;
    public Icono(String nomImg){
        this.nomImg = nomImg;
    }
    @Override
    public void paintComponent(Graphics g){        
        Dimension dim = getSize();
        ImageIcon imagen = new ImageIcon(new ImageIcon(getClass().getResource(this.nomImg)).getImage());
        g.drawImage(imagen.getImage(), 0, 0,dim.width,dim.height, null);                
    }
}
