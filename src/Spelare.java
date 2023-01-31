
public class Spelare extends FlyttbarSO {
    private int liv;
    public Spelare(String illustration, Punkt position, Fyrkant hitbox, int liv) {
        super(illustration, position, hitbox,true);
        this.liv=liv;
    }
    void Hoppa (){
        addDelta(0,-30);
    }
    void flytta(int ddx, int ddy){
        addDelta(ddx ,ddy);
    }
    void defFlytta(int x, int y){
        position.setX(x);
        position.setY(y);
    }

    public void skada(){
        this.liv--;
        kollaOmDead();
    }

    public void kollaOmDead(){
        if(liv<=0) {
            kolavippen();
        }
    }
    public void kolavippen(){
        System.out.println("Du dog!");
    }
}
