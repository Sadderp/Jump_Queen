public abstract class Hitbox extends Fyrkant{

    public Hitbox(Fyrkant f) {
        super(f.fyrkantPosition, f.getWidth(), f.getHeight());
    }

    // shifts coordinates by dx on x-axis and dy on y-axis
    public void offset(float dx, float dy) {
        fyrkantSetX(fyrkantGetX()+dx);
        fyrkantSetY(fyrkantGetY()+dy);
    }

    // reset fields
    public void setHitbox(Fyrkant f) {
        this.setFyrkant(f);
    }
    public Fyrkant getHitbox(){
        return this.getFyrkant();
    }
}
