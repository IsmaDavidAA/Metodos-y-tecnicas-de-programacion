import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Thread;
public class PantallaInicio extends JFrame
{
    private JPanel panel;
    private JButton boton1;
    private JButton boton2;
    public PantallaInicio(){
        this.setSize(900,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Inicio");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200,200));
        this.setVisible(true);
        iniciarComponentes();
    }
    private void iniciarComponentes(){
      crearPanel();
      crearEtiquetas();
      crearBotones();
    }  
    private void crearEtiquetas(){
        JLabel etiqueta1=new JLabel(new ImageIcon("Puzzle4.GIF"));
        etiqueta1.setBounds(250,110,880,440);
        panel.add(etiqueta1);
        JLabel etiqueta2=new JLabel(new ImageIcon("Titulo2.JPG"));
        etiqueta2.setBounds(80,2,488,167);
        panel.add(etiqueta2);
    }
    public void crearPanel(){
        panel= new JPanel();
        panel.setLayout(null); 
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }
    public void crearBotones(){
        boton1= new JButton("COMENZAR");
        boton1.setBounds(200,250,200,80);
        boton1.setFont(new Font("cooper black",Font.BOLD,16));
        boton1.setBackground(Color.ORANGE);
        panel.add(boton1);
        boton2= new JButton("SALIR");
        boton2.setBounds(200,350,200,80);
        boton2.setFont(new Font("cooper black",Font.BOLD,16));
        boton2.setBackground(Color.PINK);
        panel.add(boton2);
        eventoOyenteAccion1();
        eventoOyenteAccion2();
    }
        
    public void eventoOyenteAccion1(){
        ActionListener oyenteAccion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                Niveles nivel=new Niveles();
                dispose();
            }
        }; 
        boton1.addActionListener(oyenteAccion);
    }
    
    public void eventoOyenteAccion2(){
        ActionListener oyenteAccion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                dispose();
            }
        }; 
        boton2.addActionListener(oyenteAccion);
    }

}   
    
    