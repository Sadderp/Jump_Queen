
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
    public void  kollaOmDead(){
        if(liv<=0) {
     //       kolavippen();
        }
    }
    public void kolavippen(){
        System.out.println("sadad");
    }
}
