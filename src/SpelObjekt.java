import java.awt.*;

public abstract class SpelObjekt extends Hitbox {
    Image i;
    String illustration;


    public void ritaut(Graphics g,Canvas c){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(illustration);
        g.drawImage(i,Math.round(position.getX()),Math.round(position.getY()),100,100,c);
    }

    @Override
    public int getX() {
        return this.position.getX();
    }
    @Override
    public int getY() {
        return this.position.getY();
    }

    public boolean collides(SpelObjekt s) {
        float x1=this.getX() + this.getFyrkant().getX() +this.getFyrkant().getWidth();
        float x2=s.getX() + s.getFyrkant().getX();
        float x3=s.getX() + s.getFyrkant().getWidth() + s.getFyrkant().getX();
        float x4=this.getX() + this.getFyrkant().getX();
        float y1=this.getY() + this.getFyrkant().getY() + this.getFyrkant().getHeight();
        float y2 = s.getY() + s.getFyrkant().getY();
        float y3=s.getY() + s.getFyrkant().getHeight() + s.getFyrkant().getY();
        float y4=this.getY() + this.getFyrkant().getY();
        if(x1>=x2 && x3>=x4 && y1>=y2 && y3>=y4)
            System.out.println("Krock "+x1+" "+x2+" "+x3+" "+x4);
        return x1>=x2 && x3>=x4 && y1>=y2 && y3>=y4;
    }

    public String getIll(){
        return illustration;
    }
    Punkt position = new Punkt(0, 0);

    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {
        this.position = position;
    }

    public SpelObjekt(String illustration, Punkt postion, Fyrkant hitbox) {
        super(hitbox);
        this.position = postion;
        this.illustration = illustration;
    }
}