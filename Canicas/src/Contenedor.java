import java.util.ArrayList;

public class Contenedor implements Runnable {
    private int canicas = 0;
    private int contenedorLimite;
    private ArrayList<Niño> listaNiños;
    private int azul, rojo, negro;
    private boolean parar = false;
    private Thread hilo;

    public Contenedor(int contenedorLimite) {
        this.contenedorLimite = contenedorLimite;
        hilo = new Thread(this);
    }

    public int getCanicas() {
        return canicas;
    }

    public void setCanicas(int canicas) {
        this.canicas = canicas;
    }

    public int getContenedorLimite() {
        return contenedorLimite;
    }

    public void setListaNiños(ArrayList<Niño> listaNiños) {
        this.listaNiños = listaNiños;
    }

    public void contarPorColor() {

        listaNiños.forEach(nino -> azul += nino.totalPorColor(1));
        listaNiños.forEach(nino -> rojo += nino.totalPorColor(2));
        listaNiños.forEach(nino -> negro += nino.totalPorColor(3));
        System.out.println("Total Canicas Azules: " + azul);
        System.out.println("Total Canicas Rojas: " + rojo);
        System.out.println("Total Canicas Negras: " + negro);
        System.out.println("Total Canicas : " + (azul + rojo + negro));

    }

    public void start() {
        hilo.start();
    }

    @Override
    public void run() {
        while (!parar) {
            if (canicas == contenedorLimite) {
                parar = true;
            }
            listaNiños.get(0).dormir(300);
            if(parar == true){
                System.out.println("");
                contarPorColor();
            }
        }

    }

    public static void main(String[] args) {

        Contenedor contenedor1 = new Contenedor(100);
        Niño juan = new Niño(contenedor1);
        Niño pedro = new Niño(contenedor1);
        Niño miguel = new Niño(contenedor1);
        Niño olga = new Niño(contenedor1);
        Niño margarita = new Niño(contenedor1);
        ArrayList<Niño> listaNiños = new ArrayList<Niño>();
        listaNiños.add(juan);
        listaNiños.add(pedro);
        listaNiños.add(miguel);
        listaNiños.add(olga);
        listaNiños.add(margarita);
        contenedor1.setListaNiños(listaNiños);
        contenedor1.start();
        listaNiños.forEach(nino -> nino.start());

    }

}
