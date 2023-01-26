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
        Image i=t.getImage(this.illustration);
        g.drawImage(i,Math.round(this.position.getX()),Math.round(this.position.getY()),100,100,c);
    }

    public int getX() {
        return this.position.getX();
    }
    public int getY() {
        return this.position.getY();
    }

    public float collides(SpelObjekt s) {
/*        float x1 = this.getX() + this.fyrkantGetX() + this.getWidth();
        float x2 = s.getX() + s.fyrkantGetX();
        float x3 = s.getX() + s.getWidth() + s.fyrkantGetX();
        float x4 = this.getX() + this.fyrkantGetX();
        float y1 = this.getY() + this.fyrkantGetY() + this.getHeight();
        float y2 = s.getY() + s.fyrkantGetY();
        float y3 = s.getY() + s.getHeight() + s.fyrkantGetY();
        float y4 = this.getY() + this.fyrkantGetY();*/
        /*float x1 = this.getX() +  this.getWidth();
        float x2 = s.getX() ;
        float x3 = s.getX() + s.getWidth() ;
        float x4 = this.getX() ;
        float y1 = this.getY() + this.getHeight();
        float y2 = s.getY() ;
        float y3 = s.getY() + s.getHeight() ;
        float y4 = this.getY() ;*/

        Punkt a1 = new Punkt(s.getX(), s.getY());
        Punkt a2 = new Punkt(s.getX() + s.getWidth(), s.getY());
        Punkt a3 = new Punkt(s.getX() + s.getWidth(), s.getY() + s.getHeight());
        Punkt a4 = new Punkt(s.getX(), s.getY() + s.getHeight());

        Punkt a5 = new Punkt(this.getX(), this.getY());
        Punkt a6 = new Punkt(this.getX() + this.getWidth(), this.getY());
        Punkt a7 = new Punkt(this.getX() + this.getWidth(), this.getY() + this.getHeight());
        Punkt a8 = new Punkt(this.getX(), this.getY() + this.getHeight());

        if (a6.getX() > a4.getX() && a5.getX() < a2.getX() && a7.getY() > a1.getY() && a5.getY() < a3.getY()) {
            //System.out.println("Kriock");
            return 1;
        }

        return 0;

//        if (a1 > a5 &&  a1 > a8 && a1 < a6 && a1 < a7 && a2 > a5 && a2 > a8 && a2 > a6 && a2 > a7)
        /*if (x1>=x2 && x3>=x4 && y1>=y2 && y3>=y4)
            System.out.println("Krock någonstans"+ y1+" "+y2+" "+y3+" "+y4);
            return false;*/
        /*if (y3 > y4 && y3 < y1 && x3 > x4 && x3<x1) {
            s.position.setX(x1);*/
/*            System.out.println("högra botten");
            System.out.println(x3 + " " + x4);
            System.out.println("Goomba XY: "+this.position);
            System.out.println("Mario X: "+s.fyrkantGetX());
            System.out.println("Mario Y: "+s.fyrkantGetY());*/
            /*return 1;
        }*/
        /*else if(y3>y4 && y3<y1 && x2<x1) {
            s.position.setX(x1);
            System.out.println("vänstra botten");
            System.out.println(x2+"DEETA SAKA VARA SAMMA VÄRDE! "+x1);
            koll = 2;
            return koll;
        }
        else if(y2<y1 && y3>y1 && x3>x4) {
            s.position.setX(x4);
            System.out.println("högra toppen");
            System.out.println(x3+" "+x4);
            koll = 3;
            return koll;
        }
        else if(y2<y1 && y3>y1 && x2<x1) {
            s.position.setX(x1);
            System.out.println("vänstra toppen");
            System.out.println(x2+" "+x1);
            koll = 4;
            return koll;
        }
        else{
            koll = 0;
            return koll;
            }

         */

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