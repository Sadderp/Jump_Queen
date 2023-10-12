import java.awt.*;

public class Spelare extends FlyttbarSO {
    //region Variables
    private final int StartingHealth;
    private int liv;
    private final Punkt StartPos;
    //endregion

    //region Constructors
    public Spelare(Color illustration, Punkt position, Fyrkant hitbox, int liv) {
        super(illustration, position, hitbox,true);
        this.liv=liv;
        this.StartingHealth = liv;
        StartPos = position;
    }
    //endregion

    //region Functions
    void Jump(){
        addDelta(0,-30);
    }
    void Move(int ddx, int ddy){
        addDelta(ddx ,ddy);
    }
    void defMove(int x, int y){
        position.setX(x);
        position.setY(y);
    }

    public void Hurt(){
        this.liv--;
        CheckIfDead();
    }

    public void CheckIfDead(){
        if(liv<=0) {
            System.out.println("You died");
            this.defMove(StartPos.getX(), StartPos.getY());
            liv = StartingHealth;
        }
    }
    //endregion
}
