
public class Jugador implements Comparable<Jugador>{
    private String nombre;
    private int top;
    private int puntuacion;
    public Jugador(String text){
        String[] res = new String[text.length()];
        res = text.split("-");
        this.top = Integer.parseInt(res[0]);
        this.nombre = res[1];
        this.puntuacion = Integer.parseInt(res[2]);
    }
    
    public Jugador(String nombre, int puntuacion){
        this.nombre = nombre;
        this.puntuacion = puntuacion;
        this.top = 0;
    }
    
    public String getNombre(){
        return this.nombre;
    }
    
    public int getTop(){
        return this.top;
    }
    
    public void setTop(int top){
        this.top = top;
    }
    
    public void setPuntuacion(int puntuacion){
        this.puntuacion = puntuacion;
    }
    
    public int getPuntuacion(){
        return this.puntuacion;
    }
    
    public int compareTo(Jugador otro) {
        int res;
        if(this.puntuacion > otro.getPuntuacion()) res = 1;
        else if(this.puntuacion < otro.getPuntuacion()) res = -1;
        else res = 0;
        return res;
    }
    
    @Override
    public String toString() {
        return this.top + "-" + this.nombre + "-" + this.puntuacion;
    }
}
