
public class Spelare extends FlyttbarSO {
    private float liv;
    public Spelare(String illustration, Punkt position, Fyrkant hitbox) {
        super(illustration, position, hitbox,true);
        this.liv=3;
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
