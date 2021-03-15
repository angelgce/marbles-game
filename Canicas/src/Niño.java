import java.util.ArrayList;
import java.util.function.Predicate;

public class Niño implements Runnable {
    private Canicas canicas;
    private ArrayList<Canicas> misCanicas = new ArrayList<Canicas>();
    private boolean parar = false;
    private Thread hilo;
    private Contenedor contenedor;

    public Niño(Contenedor contenedor) {
        this.contenedor = contenedor;
        hilo = new Thread(this);
    }


    public int totalPorColor(int color) {
        Predicate<Canicas> colorCanica = canicaC -> canicaC.getColor() == color;
        return (int) misCanicas.stream().filter(colorCanica).count();

    }

    public void lanzarCanica() {
        canicas = new Canicas();
        misCanicas.add(canicas);
        System.out.println("Cae Canica color: " + canicas.colorString());

    }

    public void dormir(int numero) {
        try {
            Thread.sleep(numero);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        hilo.start();
    }


    @Override
    public void run() {
        while (!parar) {
            if (contenedor.getCanicas() < contenedor.getContenedorLimite()) {
                lanzarCanica();
                contenedor.setCanicas(contenedor.getCanicas()+1);
            } else {
                parar = true;
            }
            dormir(300);
        }
    }
}
