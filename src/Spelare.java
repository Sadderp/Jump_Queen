
public class Spelare extends FlyttbarSO {
    private float liv;
    public Spelare(String illustration, Punkt position, Fyrkant hitbox) {
        super(illustration, position, hitbox,true);
        this.liv=3;
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
    public void  kollaOmDead(){
        if(liv<=0) {
     //       kolavippen();
        }
    }
    public void kolavippen(){
        System.out.println("sadad");
    }
}
