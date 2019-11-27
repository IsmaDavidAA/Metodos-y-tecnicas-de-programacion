import java.awt.*;
import java.awt.Dimension;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PantallaSalida extends JFrame{
    private JPanel panel;
    private JLabel saludo;
    private JButton boton1;
    private JButton boton2;
    private JTextField cajaTexto;
    private int nivel;
    private int movimientos;
    private Editor editor;
    public PantallaSalida(int nivel, int movimientos){
        this.setSize(900,450);
        this.movimientos = movimientos;
        this.nivel = nivel;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("PUZZLE COMPLETADO");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(200,200));
        this.setVisible(true);
        iniciarComponentes();
        editor = new Editor();
    }
    
    private void iniciarComponentes(){
        crearPanel();
        crearEtiquetas();
        crearBotones();   
        cajaDeTexto();
    }
    
    public void crearPanel(){
        panel= new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }
    
    public void crearEtiquetas(){
        JLabel etiqueta=new JLabel("FELICIDADES!!!");
        etiqueta.setOpaque(true);
        etiqueta.setBounds(400,20,800,30);
        etiqueta.setForeground(Color.BLACK);
        etiqueta.setBackground(Color.WHITE);
        etiqueta.setFont(new Font("harrington",Font.PLAIN,28));
        panel.add(etiqueta);
        JLabel movimientosT=new JLabel("Mis marca es: "+ this.movimientos);
        movimientosT.setOpaque(true);
        movimientosT.setBounds(170, 140,200,20);
        movimientosT.setForeground(Color.BLACK);
        movimientosT.setBackground(Color.WHITE);
        movimientosT.setFont(new Font("cooper black",Font.PLAIN,16));
        panel.add(movimientosT);
        JLabel etiqueta2=new JLabel("Lograste resolver el Puzzle");
        etiqueta2.setOpaque(true);
        etiqueta2.setBounds(450,50,800,30);
        etiqueta2.setForeground(Color.BLACK);
        etiqueta2.setBackground(Color.WHITE);
        etiqueta2.setFont(new Font("harrington",Font.PLAIN,28));
        panel.add(etiqueta2);
        JLabel etiqueta3=new JLabel(new ImageIcon("Puzzle4.GIF"));
        etiqueta3.setBounds(250,70,880,440);
        panel.add(etiqueta3);
    }
    
    public void crearBotones(){
        boton1= new JButton("Registrar mi marca");
        boton1.setBounds(170,170,250,50);
        boton1.setForeground(Color.BLACK);
        boton1.setFont(new Font("cooper black",Font.PLAIN,20));
        boton1.setBackground(Color.ORANGE);
        panel.add(boton1);
        boton2= new JButton("Salir del juego");
        boton2.setBounds(170,230,250,50);
        boton2.setForeground(Color.BLACK);
        boton2.setFont(new Font("cooper black",Font.PLAIN,20));
        boton2.setBackground(Color.PINK);
        panel.add(boton2);
        eventoOyenteAccion();
        eventoOyenteAccion2();
    }
    
    public void cajaDeTexto(){
        cajaTexto=new JTextField();
        cajaTexto.setBounds(170, 100, 250, 40);
        panel.add(cajaTexto);
    }
    
    public void eventoOyenteAccion(){
        ActionListener oyenteAccion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                if(cajaTexto.getText().isBlank()){
                    JOptionPane.showMessageDialog(new JPanel(), "Debe colocar su Nickname primero", "Recomendación", JOptionPane.INFORMATION_MESSAGE);
                }else if(esValido(nivel)){
                    editor.leer(nivel);
                    if(editor.getNombresJugadores().contains(cajaTexto.getText())){
                        JOptionPane.showMessageDialog(new JPanel(), "El nombre ya existe", "Denegado", JOptionPane.INFORMATION_MESSAGE);
                    }else{
                        Jugador jugador= new Jugador(cajaTexto.getText(), movimientos);
                        editor.addJugador(jugador);
                        editor.escribir(nivel);
                        System.exit(-1);
                    }
                }else if(esValido(nivel)){
                    JOptionPane.showMessageDialog(new JPanel(), "El Nickname no puede contener espacios y carácteres especiales, solo letras y si fuera necesario números al final.Si todo esta correcto entonces el Nickname ya existe, debe crear otro", "Nickname invalido", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }; 
        boton1.addActionListener(oyenteAccion);
    }
    
    public void eventoOyenteAccion2(){
        ActionListener oyenteAccion=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae){
                System.exit(-1);
            }
        }; 
        boton2.addActionListener(oyenteAccion);
    }
    
    private boolean esValido(int nivel){
        this.editor.leer(nivel);
        String nombre = cajaTexto.getText().toLowerCase();
        boolean res = true;
        boolean limit = false;
        String permitidos = "a.b.c.d.e.f.g.h.i.j.k.l.m.n.o.p.q.r.s.t.u.v.w.x.y.z.";
        String numeros = "1.2.3.4.5.6.7.8.9.0.";
        for(int i = 0;i<nombre.length();i++){
            if(permitidos.contains(nombre.charAt(i) + ".")  && limit == true)   res = false;
            if(!permitidos.contains(nombre.charAt(i) + ".") && !numeros.contains(nombre.charAt(i) + "."))   res = false;
            if(numeros.contains(nombre.charAt(i) + "."))  limit = true;
        }
        
        this.editor.escribir(nivel);
        return res;
    }
}