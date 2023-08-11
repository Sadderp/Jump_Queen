import java.awt.*;

public class FastObjekt extends SpelObjekt{
    public FastObjekt(Color illustration, Punkt position, Fyrkant hitbox) {
        super(illustration, position, hitbox);
    }
    public FastObjekt(Color illustration, Punkt position, Fyrkant hitbox, boolean interactable) {
        super(illustration, position, hitbox, interactable);
    }
    public FastObjekt(Color illustration, Punkt position, Fyrkant hitbox, boolean interactable, boolean dealDamage) {
        super(illustration, position, hitbox, interactable, dealDamage);
    }
    public FastObjekt(Color illustration, Punkt position, Fyrkant hitbox, boolean interactable, boolean dealDamage, boolean warpable) {
        super(illustration, position, hitbox, interactable, dealDamage, warpable);
    }
}
