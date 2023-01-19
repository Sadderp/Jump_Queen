public class Fyrkant {

    Punkt position;
    float width;
    float height;

    public Fyrkant(Punkt p, float width, float height) {
        this.position = p;
        this.width = width;
        this.height = height;
    }
    public void setFyrkant(Fyrkant f){
        setX(f.getX());
        setY(f.getY());
        setWidth(f.getWidth());
        setHeight(f.getHeight());
    }
    public Fyrkant getFyrkant(){
        return this;
    }

    public int getX() {
        return position.getX();
    }

    public void setX(float x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }

    public void setY(float y) {
        this.position.setY(y);
    }

    public int getWidth() {
        return Math.round(width);
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public int getHeight() {
        return Math.round(height);
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
