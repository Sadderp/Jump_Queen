import java.awt.*;

public abstract class SpelObjekt {
    Image i;
    String illustration;

    public void ritaut(Graphics g,Canvas c){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(illustration);
        g.drawImage(i,Math.round(position.getX()),Math.round(position.getY()),100,100,c);
    }
    Punkt position = new Punkt(0, 0);
    Fyrkant hitbox = new Fyrkant(new Punkt(0,0), 100, 100);

    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {
        this.position = position;
    }

    public Fyrkant getHitbox() {
        return hitbox;
    }

    public void setHitbox(Fyrkant hitbox) {
        this.hitbox = hitbox;
    }

    public SpelObjekt(String illustration, Punkt postion, Fyrkant hitbox) {
        this.position = postion;
        this.hitbox = hitbox;
        this.illustration = illustration;
    }
}