
public class Canicas {
    private int color;

    public Canicas() {
        color = (int) (Math.random() * 3 + 1);
    }

    public int getColor() {
        return color;
    }

    public String colorString() {
        String colorString = "";
        switch (color) {
        case 1:
            colorString = "Azul ";
            break;
        case 2:
            colorString = "Rojo ";
            break;
        case 3:
            colorString = "Negro ";
            break;
        }
        return colorString;
    }

    public String miCanica() {
        return "Canica color : " + colorString();
    }
}
