
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.PriorityQueue;
public class JugadorTest
{
    @Before
    public void setUp()
    {
    }
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void insertarJugador(){
        Jugador jugador1 = new Jugador("will",234);
        PriorityQueue<Jugador> topJugadores = new PriorityQueue<Jugador>();
        topJugadores.add(jugador1);
        assertEquals(false, topJugadores.isEmpty());
    }
    
    @Test
    public void insertarJugador1(){
        Jugador jugador1 = new Jugador("will",234);
        PriorityQueue<Jugador> topJugadores = new PriorityQueue<Jugador>();
        topJugadores.add(jugador1);
        topJugadores.poll();
        assertEquals(true, topJugadores.isEmpty());
    }
    
    @Test
    public void topJugadores1(){
        Jugador jugador1 = new Jugador("will",234);
        Jugador jugador2 = new Jugador("mary",134);
        Jugador jugador3 = new Jugador("sylvanas",343);
        Jugador jugador4 = new Jugador("joaquin",104);
        Jugador jugador5 = new Jugador("kael",94);
        PriorityQueue<Jugador> topJugadores = new PriorityQueue<Jugador>();
        topJugadores.add(jugador1);
        topJugadores.add(jugador2);
        topJugadores.add(jugador3);
        topJugadores.add(jugador4);
        topJugadores.add(jugador5);
        String nombre = jugador5.getNombre();
        String primero = topJugadores.poll().getNombre(); 
        assertEquals(nombre , primero);
    }
    
    @Test
    public void topJugadores2(){
        Jugador jugador1 = new Jugador("will",234);
        Jugador jugador2 = new Jugador("mary",134);
        Jugador jugador3 = new Jugador("sylvanas",343);
        Jugador jugador4 = new Jugador("joaquin",104);
        Jugador jugador5 = new Jugador("kael",94);
        PriorityQueue<Jugador> topJugadores = new PriorityQueue<Jugador>();
        topJugadores.add(jugador1);
        topJugadores.add(jugador2);
        topJugadores.add(jugador3);
        topJugadores.add(jugador4);
        topJugadores.add(jugador5);
        String nombre = jugador3.getNombre();
        topJugadores.poll();
        topJugadores.poll();
        topJugadores.poll();
        topJugadores.poll();
        String ultimo = topJugadores.poll().getNombre(); 
        assertEquals(nombre , ultimo);
    }
}
