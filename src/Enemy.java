import java.awt.*;

public class Enemy extends FlyttbarSO {
    //region Variables
    public boolean Damageable = true;
    public int Health;
    //endregion

    //region Constructors
    public Enemy(Color illustration, Punkt position, Fyrkant hitbox, boolean dealDamage, int health){
        super(illustration, position, hitbox, true, dealDamage);
        Health = health;
    }
    public Enemy(Color illustration, Punkt position, Fyrkant hitbox, boolean gravity, boolean dealDamage, int health){
        super(illustration, position, hitbox, gravity, dealDamage);
        Health = health;
    }
    //endregion

    //region Functions
    public boolean Damage(){
        this.Health--;
        return CheckIfDead();
    }

    public boolean CheckIfDead(){
        return Health <= 0;
    }
    //endregion
}
