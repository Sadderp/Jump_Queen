import java.awt.*;

public class FlyttSO extends FastObjekt{
    public String Name;
    private final FlyttSO ConnectedTo;

    public FlyttSO(String name, FlyttSO connectedTo, Color illustration, Punkt position, Fyrkant hitbox){
        super(illustration, position, hitbox, false, false, true);
        Name = name;
        ConnectedTo = connectedTo;
    }

    public FlyttSO getConnection(){
        return ConnectedTo;
    }
}
