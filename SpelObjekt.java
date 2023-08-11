import java.awt.*;

public class SpelObjekt extends Hitbox {
    //region Variables
    Image i;
    Color Color;
    Punkt position = new Punkt(0, 0);
    public boolean kollision = false;
    public boolean Interactable = false;
    public boolean Warpable = false;
    public boolean DealDamage = false;
    //endregion

    //region Constructors
    public SpelObjekt(Color color, Punkt position, Fyrkant hitbox) {
        super(hitbox);
        this.position.setX(position.getX());
        this.position.setY(position.getY());
        this.Color = color;
    }
    public SpelObjekt(Color color, Punkt position, Fyrkant hitbox, boolean interactable) {
        super(hitbox);
        this.position.setX(position.getX());
        this.position.setY(position.getY());
        this.Color = color;
        this.Interactable = interactable;
    }
    public SpelObjekt(Color color, Punkt position, Fyrkant hitbox, boolean interactable, boolean dealDamage) {
        super(hitbox);
        this.position.setX(position.getX());
        this.position.setY(position.getY());
        this.Color = color;
        this.Interactable = interactable;
        this.DealDamage = dealDamage;
    }
    public SpelObjekt(Color color, Punkt position, Fyrkant hitbox, boolean interactable, boolean dealDamage, boolean warpable) {
        super(hitbox);
        this.position.setX(position.getX());
        this.position.setY(position.getY());
        this.Color = color;
        this.Interactable = interactable;
        this.DealDamage = dealDamage;
        this.Warpable = warpable;
    }
    //endregion

    //region Functions
    public void ritaut(Graphics g,Canvas c){
        /*Toolkit t=Toolkit.getDefaultToolkit();
        Image i=t.getImage(this.Color);*/
        g.setColor(Color);
        g.fillRect(position.getX(), position.getY(), getHitbox().getWidth(), getHitbox().getHeight());
        //shows a hitbox for the interaction range for interactable objects
        //g.drawRect(position.getX() - 50, position.getY() - 50, getHitbox().getWidth() + 100, getHitbox().getHeight() + 100);
    }

    public float collides(SpelObjekt s) {

        //Players corners
        Punkt a1 = new Punkt(s.getX(), s.getY());
        Punkt a2 = new Punkt(s.getX() + s.getWidth(), s.getY());
        Punkt a3 = new Punkt(s.getX() + s.getWidth(), s.getY() + s.getHeight());
        Punkt a4 = new Punkt(s.getX(), s.getY() + s.getHeight());

        //Objects corners
        Punkt a5 = new Punkt(this.getX(), this.getY());
        Punkt a6 = new Punkt(this.getX() + this.getWidth(), this.getY());
        Punkt a7 = new Punkt(this.getX() + this.getWidth(), this.getY() + this.getHeight());
        Punkt a8 = new Punkt(this.getX(), this.getY() + this.getHeight());

        double diffX;
        double diffY;

        double vinkel;

        if(!kollision) {

            /*------------------------*\
            |  Kollision i kvadranter  |
            \*------------------------*/

            //Andra && tredje (Höger)
            if (a1.getX() > a5.getX() && a1.getY() == a5.getY() && a4.getX() > a8.getX() && a4.getY() == a8.getY() && a2.getX() > a6.getX() && a1.getX() < a6.getX()) {
                //System.out.println("Höger om objektet");
                return 1;
            }

            //Första && andra (Över)
            if (a4.getY() > a5.getY() && a5.getX() == a4.getX() && a3.getY() > a6.getY() && a3.getX() == a6.getX() && a4.getY() < a8.getY() && a3.getY() < a7.getY()) {
                //System.out.println("Ovanpå objektet");
                return 2;
            }

            //Första && fjärde (Vänster)
            if (a2.getX() > a5.getX() && a2.getY() == a5.getY() && a3.getX() > a8.getX() && a3.getY() == a8.getY() && a2.getX() < a6.getX() && a3.getX() < a7.getX()) {
                //System.out.println("Vänster om objektet");
                return 3;
            }

            //Tredje && fjärde (Under)
            if (a1.getY() < a8.getY() && a1.getX() == a8.getX() && a2.getY() < a7.getY() && a2.getX() == a7.getX() && a1.getY() > a5.getY() && a2.getY() > a6.getY()) {
                //System.out.println("Under objektet");
                return 4;
            }

            //Första
            if (a3.getX() > a5.getX() && a3.getY() > a5.getY() && a5.getX() < a2.getX() && a3.getX() < a7.getX() && a3.getY() < a7.getY()) {

                diffX = (a3.getX() - a5.getX());
                diffY = (a3.getY() - a5.getY());

                vinkel = Math.atan2(diffX, diffY) * (180 / Math.PI);
                //System.out.println(vinkel);

                if (vinkel >= 45) {
                    //System.out.println(">-45° i första kvadranten");
                    return 5;
                }
                if (vinkel < 45) {
                    //System.out.println("<-45° i första kvadranten");
                    return 6;
                }
            }

            //Andra
            if (a4.getX() < a6.getX() && a4.getY() > a6.getY() && a1.getY() < a6.getY() && a4.getX() > a8.getX() && a4.getY() < a8.getY()) {

                diffX = (a4.getX() - a6.getX());
                diffY = (a4.getY() - a6.getY());

                vinkel = Math.atan2(diffX, diffY) * (180 / Math.PI);
                //System.out.println(vinkel);

                if (vinkel >= -45) {
                    //System.out.println(">-45° i andra kvadranten");
                    return 8;
                }
                if (vinkel < -45) {
                    //System.out.println("<-45° i andra kvadranten");
                    return 7;
                }
            }

            //Tredje
            if (a1.getX() < a7.getX() && a1.getY() < a7.getY() && a4.getY() > a7.getY() && a1.getX() > a5.getX() && a1.getY() > a5.getY()) {

                diffX = (a1.getX() - a7.getX());
                diffY = (a1.getY() - a7.getY());

                vinkel = Math.atan2(diffX, diffY) * (180 / Math.PI);
                //System.out.println(vinkel);

                if (vinkel >= -135) {
                    //System.out.println(">45° i tredje kvadranten");
                    return 10;
                }
                if (vinkel < -135) {
                    //System.out.println("<45° i tredje kvadranten");
                    return 9;
                }
            }

            //Fjärde
            if (a2.getX() > a8.getX() && a2.getY() < a8.getY() && a3.getY() > a8.getY() && a4.getX() < a8.getX() && a4.getY() > a8.getY()) {

                diffX = (a2.getX() - a8.getX());
                diffY = (a2.getY() - a8.getY());

                vinkel = Math.atan2(diffX, diffY) * (180 / Math.PI);
                //System.out.println(vinkel);

                if (vinkel >= 135) {
                    //System.out.println(">45° i fjärde kvadranten");
                    return 11;
                }
                if (vinkel < 135) {
                    //System.out.println("<45° i fjärde kvadranten");
                    return 12;
                }
            }

            return 0;
        }
        return 0;
    }
    public boolean CanInteract(SpelObjekt s){

        //Players corners
        Punkt a1 = new Punkt(s.getX() - 50, s.getY() - 50);
        Punkt a2 = new Punkt(s.getX() + s.getWidth() + 50, s.getY() - 50);
        Punkt a3 = new Punkt(s.getX() + s.getWidth() + 50, s.getY() + s.getHeight() + 50);
        Punkt a4 = new Punkt(s.getX() - 50, s.getY() + s.getHeight() + 50);

        //Objects corners
        //sets interaction distance
        Punkt a5 = new Punkt(this.getX() - 50, this.getY() - 50);
        Punkt a6 = new Punkt(this.getX() + this.getWidth() + 50, this.getY() - 50);
        Punkt a7 = new Punkt(this.getX() + this.getWidth() + 50, this.getY() + this.getHeight() + 50);
        Punkt a8 = new Punkt(this.getX() - 50, this.getY() + this.getHeight() + 50);

        /*------------------------*\
        | Interaktion i kvadranter |
        \*------------------------*/

        //Andra && tredje (Höger)
        if (a1.getX() > a5.getX() && a1.getY() == a5.getY() && a4.getX() > a8.getX() && a4.getY() == a8.getY() && a2.getX() > a6.getX() && a1.getX() < a6.getX()) {
            //System.out.println("Höger om objektet");
            return true;
        }

        //Första && fjärde (Vänster)
        else if (a2.getX() > a5.getX() && a2.getY() == a5.getY() && a3.getX() > a8.getX() && a3.getY() == a8.getY() && a2.getX() < a6.getX() && a3.getX() < a7.getX()) {
            //System.out.println("Vänster om objektet");
            return true;
        }

        return false;
    }
    public boolean CanWarp(SpelObjekt s){

        //Players corners
        Punkt a1 = new Punkt(s.getX() - 50, s.getY() - 50);
        Punkt a2 = new Punkt(s.getX() + s.getWidth() + 50, s.getY() - 50);
        Punkt a3 = new Punkt(s.getX() + s.getWidth() + 50, s.getY() + s.getHeight() + 50);
        Punkt a4 = new Punkt(s.getX() - 50, s.getY() + s.getHeight() + 50);

        //Objects corners
        //sets interaction distance
        Punkt a5 = new Punkt(this.getX() - 50, this.getY() - 50);
        Punkt a6 = new Punkt(this.getX() + this.getWidth() + 50, this.getY() - 50);
        Punkt a7 = new Punkt(this.getX() + this.getWidth() + 50, this.getY() + this.getHeight() + 50);
        Punkt a8 = new Punkt(this.getX() - 50, this.getY() + this.getHeight() + 50);

        double diffX;
        double diffY;

        double vinkel;

        /*------------------------*\
        | Interaktion i kvadranter |
        \*------------------------*/

        //Första && andra (Över)
        if (a4.getY() > a5.getY() && a5.getX() == a4.getX() && a3.getY() > a6.getY() && a3.getX() == a6.getX() && a4.getY() < a8.getY() && a3.getY() < a7.getY()) {
            //System.out.println("Ovanpå objektet");
            return true;
        }

        if (a3.getX() > a5.getX() && a3.getY() > a5.getY() && a5.getX() < a2.getX() && a3.getX() < a7.getX() && a3.getY() < a7.getY()) {

            diffX = (a3.getX() - a5.getX());
            diffY = (a3.getY() - a5.getY());

            vinkel = Math.atan2(diffX, diffY) * (180 / Math.PI);
            //System.out.println(vinkel);

            if (vinkel >= 45) {
                //System.out.println(">-45° i första kvadranten");
                return true;
            }
            if (vinkel < 45) {
                //System.out.println("<-45° i första kvadranten");
                return false;
            }
        }

        if (a4.getX() < a6.getX() && a4.getY() > a6.getY() && a1.getY() < a6.getY() && a4.getX() > a8.getX() && a4.getY() < a8.getY()) {

            diffX = (a4.getX() - a6.getX());
            diffY = (a4.getY() - a6.getY());

            vinkel = Math.atan2(diffX, diffY) * (180 / Math.PI);
            //System.out.println(vinkel);

            if (vinkel >= -45) {
                //System.out.println(">-45° i andra kvadranten");
                return false;
            }
            if (vinkel < -45) {
                //System.out.println("<-45° i andra kvadranten");
                return true;
            }
        }

        return false;
    }
    //endregion

    //region Getters and Setters
    public int getX() {
        return this.position.getX();
    }
    public int getY() {
        return this.position.getY();
    }

    public Color getCol(){
        return Color;
    }

    public Punkt getPosition() {
        return position;
    }

    public void setPosition(Punkt position) {
        this.position = position;
    }
    //endregion
}
