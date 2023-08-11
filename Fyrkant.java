public class Fyrkant {
    //region Variables
    Punkt fyrkantPosition;
    float width;
    float height;
    //endregion

    //region Constructors
    public Fyrkant(Punkt p, float width, float height) {
        this.fyrkantPosition = p;
        this.width = width;
        this.height = height;
    }
    //endregion

    //region Getters and Setters
    public void setFyrkant(Fyrkant f){
        fyrkantSetX(f.fyrkantGetX());
        fyrkantSetY(f.fyrkantGetY());
        setWidth(f.getWidth());
        setHeight(f.getHeight());
    }
    public Fyrkant getFyrkant(){
        return this;
    }

    public int fyrkantGetX() {
        return fyrkantPosition.getX();
    }

    public void fyrkantSetX(float x) {
        this.fyrkantPosition.setX(x);
    }

    public int fyrkantGetY() {
        return fyrkantPosition.getY();
    }

    public void fyrkantSetY(float y) {
        this.fyrkantPosition.setY(y);
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
    //endregion
}
