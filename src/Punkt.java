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
    public void relflyttaY(float y) {
        this.y += y;
    }
    public void relflyttaX(float x) {
        this.x += x;
    }

    private float y;
    Punkt(float x,float y){
        this.x=x;
        this.y=y;
    }
    public String toString(){
        return this.x+" "+this.y;
    }

}

