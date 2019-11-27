import java.lang.*;
import java.io.*;
import java.util.*;
import java.util.PriorityQueue;
public class Editor
{
    static Hashtable ht;
    static String currString;
    static PriorityQueue<Jugador> topJugadores;
    private int categoria;
    public Editor(){
        topJugadores = new PriorityQueue<>();
    }
    
    public PriorityQueue<Jugador> getJugadores(){
        return this.topJugadores;
    }
    
    public ArrayList<String> getTopJugadores(){
        ArrayList<String> res= new ArrayList<String>();
        PriorityQueue<Jugador> topAux = new PriorityQueue<Jugador>();
        while(!topJugadores.isEmpty()){
            Jugador aux = topJugadores.poll();
            res.add("  " +aux.getTop() + "             " + aux.getNombre() +"                                   "+aux.getPuntuacion());
            topAux.add(aux);
        }
        this.topJugadores = topAux;
        return res;
    }
    public void leer(int categoriaTop){
        ht=new Hashtable();
        try{
            DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("top\\"+categoriaTop+"top5.txt")));
            while((currString = in.readLine())!=null){
                String crea = currString;
                Jugador nuevo = new Jugador(crea);
                topJugadores.add(nuevo);
            }
            BufferedWriter bw = new BufferedWriter(new FileWriter("top\\"+categoriaTop + "top5.txt"));
            bw.write("");
            bw.close();
        }
        catch(IOException ioe){
            System.out.println("IO exception");
        }
    }
    
    public void escribir(int categoriaTop){
        try(FileWriter fw = new FileWriter("top\\"+categoriaTop + "top5.txt", true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        PrintWriter out = new PrintWriter(bw))
        {
            int jugTop = 1;
            while(jugTop < 6 && !topJugadores.isEmpty()){
                Jugador jug = new Jugador(topJugadores.poll().toString());
                jug.setTop(jugTop);
                out.println(jug.toString());
                jugTop++;
            }
        } catch (IOException e) {
            System.out.println("IO exception");
        }
    }
    
    public void addJugador(Jugador nuevoJugador){
        topJugadores.add(nuevoJugador);
    }
    
    public ArrayList<String> getNombresJugadores(){
        ArrayList<String> res= new ArrayList<String>();
        PriorityQueue<Jugador> topAux = new PriorityQueue<Jugador>();
        while(!topJugadores.isEmpty()){
            Jugador aux = topJugadores.poll();
            res.add(aux.getNombre());
            topAux.add(aux);
        }
        this.topJugadores = topAux;
        return res;
    }
    
    
}