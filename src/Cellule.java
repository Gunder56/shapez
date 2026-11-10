class Cellule {

    private int x;
    private int y;

    public Cellule(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean est_libre() {
        return forme == null;
    }
}