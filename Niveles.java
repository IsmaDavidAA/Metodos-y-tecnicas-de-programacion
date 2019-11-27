import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Niveles extends JFrame{
    private JPanel panel;
    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private String nombreJugador;
    public Niveles(){
        this.setSize(1000,650);
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
        JLabel etiqueta1=new JLabel("Dificultad:");
        etiqueta1.setOpaque(true);
        etiqueta1.setBounds(10,250,500,80);
        etiqueta1.setForeground(Color.BLUE);
        etiqueta1.setBackground(Color.WHITE);
        etiqueta1.setFont(new Font("cooper black",Font.PLAIN,30));
        panel.add(etiqueta1);
        JLabel etiqueta2=new JLabel(new ImageIcon("Puzzle4.GIF"));
        etiqueta2.setBounds(350,200,880,440);
        panel.add(etiqueta2);
        JLabel etiqueta3=new JLabel(new ImageIcon("Titulo2.JPG"));
        etiqueta3.setBounds(230,2,488,167);
        panel.add(etiqueta3);
    }
    public void crearPanel(){
        panel= new JPanel();
        panel.setLayout(null); 
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }
    public void crearBotones(){
        boton1= new JButton("FACIL");
        boton1.setBounds(250,340,200,50);
        boton1.setFont(new Font("cooper black",Font.BOLD,16));
        boton1.setBackground(Color.ORANGE);
        panel.add(boton1);
        boton2= new JButton("INTERMEDIO");
        boton2.setBounds(250,400,200,50);
        boton2.setFont(new Font("cooper black",Font.BOLD,16));
        boton2.setBackground(Color.ORANGE);
        panel.add(boton2);
        boton3= new JButton("DIFICIL");
        boton3.setBounds(250,460,200,50);
        boton3.setFont(new Font("cooper black",Font.BOLD,16));
        boton3.setBackground(Color.ORANGE);
        panel.add(boton3);
        eventoOyenteAccion1();
        eventoOyenteAccion2();
        eventoOyenteAccion3();
    }
    
    public void eventoOyenteAccion1(){
        ActionListener oyenteAccion1=new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae){
                Puzzle p=new Puzzle(3);
                dispose();
            } 
        };
        boton1.addActionListener(oyenteAccion1);       
    }       
    public void eventoOyenteAccion2(){
        ActionListener oyenteAccion2=new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae){
                Puzzle p=new Puzzle(4);
                dispose();
            } 
        };
        boton2.addActionListener(oyenteAccion2);       
    }   
    public void eventoOyenteAccion3(){
        ActionListener oyenteAccion3=new ActionListener() 
        {
            @Override
            public void actionPerformed(ActionEvent ae){
                Puzzle p=new Puzzle(5);
                dispose();
            } 
        };
        boton3.addActionListener(oyenteAccion3);       
    }
}