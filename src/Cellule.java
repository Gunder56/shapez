package src;

public class Cellule {
    private int x;
    private int y;
    private Forme forme;
    private Machine machine;

    public Cellule(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean est_libre() {
        return forme == null && machine == null;
    }

    public void setMachine(Machine machine) {
        this.machine = machine;
    }

    public Machine getMachine() {
        return machine;
    }
    public void setForme(Forme forme) {
        this.forme = forme;
    }
    public Forme getForme() {
        return forme;
    }
}
