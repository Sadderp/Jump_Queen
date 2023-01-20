import java.awt.*;

public abstract class SpelObjekt extends Hitbox {
    float koll = 0;
    Image i;
    String illustration;
    Punkt position = new Punkt(0, 0);

    public SpelObjekt(String illustration, Punkt position, Fyrkant hitbox) {
        super(hitbox);
        this.position.setX(position.getX());
        this.position.setY(position.getY());
        this.illustration = illustration;
    }

    public void ritaut(Graphics g,Canvas c){
        Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(illustration);
        g.drawImage(i,Math.round(position.getX()),Math.round(position.getY()),100,100,c);
    }

    public int getX() {
        return this.position.getX();
    }
    public int getY() {
        return this.position.getY();
    }

    public float collides(SpelObjekt s) {
        float x1 = 150;   //this.getX() + this.fyrkantGetX() +this.getWidth();
        float x2 = 100;   //s.getX() + s.fyrkantGetX();
        float x3 = 0;   //s.getX() + s.getWidth() + s.fyrkantGetX();
        float x4 = 50;   //this.getX() + this.fyrkantGetX();
        float y1 = 100;   //this.getY() + this.fyrkantGetY() + this.getHeight();
        float y2 = 170;   //s.getY() + s.fyrkantGetY();
        float y3 = 70;   //s.getY() + s.getHeight() + s.fyrkantGetY();
        float y4 = 0;   //this.getY() + this.fyrkantGetY();
        /*if (x1>=x2 && x3>=x4 && y1>=y2 && y3>=y4)
            System.out.println("Krock någonstans"+ y1+" "+y2+" "+y3+" "+y4);
            return false;*/
        if(y3>y4 && y3<y1 && x3>x4) {
            fyrkantSetX(x4);
            System.out.println("högra botten");
            x3=x4;
            System.out.println(x3+" "+x4);
            koll = 1;
            return koll;
        }
        else if(y3>y4 && y3<y1 && x2<x1) {
            fyrkantSetX(x1);
            System.out.println("vänstra botten");
            x2=x1;
            System.out.println(x2+"DEETA SAKA VARA SAMMA VÄRDE! "+x1);
            koll = 2;
            return koll;
        }
        else if(y2<y1 && y3>y1 && x3>x4) {
            fyrkantSetX(x4);
            System.out.println("högra toppen");
            x3=x4;
            System.out.println(x3+" "+x4);
            koll = 3;
            return koll;
        }
        else if(y2<y1 && y3>y1 && x2<x1) {
            fyrkantSetX(x1);
            System.out.println("vänstra toppen");
            x2=x1;
            System.out.println(x2+" "+x1);
            koll = 4;
            return koll;
        }
        else
            koll = 0;
            return koll;
    }
//      "Krock någonstans"+ y1+" "+y2+" "+y3+" "+y4
    public String getIll(){
        return illustration;
    }

    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {
        this.position = position;
    }
}