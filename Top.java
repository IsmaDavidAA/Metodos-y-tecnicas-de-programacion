import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
public class Top extends JPanel{
    public static Container contenedor;
    public static Editor editor;
    private int cat;
    private JLabel etiqueta;
    private JLabel etiqueta2;
    public Top(int cat){
        this.setLayout(new GridLayout(7,1));
        this.setVisible(true);
        this.cat = cat;
        editor = new Editor();
        editor.leer(cat);
        crearEtiquetas();
        for(int i=0;i<editor.getTopJugadores().size();i++)  this.add(new JLabel(editor.getTopJugadores().get(i)));
        editor.escribir(cat);
    }
    
    public int getCat(){
        return this.cat;
    }
    
    public  void crearEtiquetas(){
        etiqueta=new JLabel("   Top Gamers");
        etiqueta.setOpaque(true);
        etiqueta.setBounds(400,1,100,30);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setFont(new Font("cooper black",Font.PLAIN,34));
        this.add(etiqueta);
        etiqueta2=new JLabel("Top | Nickname  |Movimientos    ");
        etiqueta2.setOpaque(true);
        etiqueta2.setBounds(400,5,100,30);
        etiqueta2.setForeground(Color.BLACK);
        etiqueta2.setFont(new Font("cooper black",Font.PLAIN,20));
        this.add(etiqueta2);
    }
    
    public void generarTop(String nombre, int movimientos){
        Jugador jugador= new Jugador(nombre, movimientos);
        editor.addJugador(jugador);
        editor.escribir(this.cat);
    }
}
