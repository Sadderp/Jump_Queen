public class Punkt {
    public int getX() {
        return Math.round(x);
    }

    public void setX(float x) {
        this.x = x;
    }

    private float x;

    public int getY() {
        return Math.round(y);
    }

    public void setY(float y) {
        this.y = y;
    }
    public void relY(float y) {
        this.y += y;
    }
    public void relX(float x) {
        this.x += x;
    }

    private float y;
    Punkt(float x,float y){
        this.x=x;
        this.y=y;
    }

}

