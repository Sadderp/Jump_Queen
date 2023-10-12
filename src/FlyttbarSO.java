import java.awt.*;

public class FlyttbarSO extends SpelObjekt {
    //region Variables
    private float deltaX;
    private float deltaY;
    private boolean gravity;
    private boolean jumping = false;
    //endregion

    //region Constructors
    public FlyttbarSO(Color illustration, Punkt position, Fyrkant hitbox) {
        super(illustration, position, hitbox);
        this.deltaX = 0;
        this.deltaY = 0;
        this.gravity = false;
    }
    public FlyttbarSO(Color illustration, Punkt position, Fyrkant hitbox, boolean gravity) {
        super(illustration, position, hitbox);
        this.deltaX = 0;
        this.deltaY = 0;
        this.gravity = gravity;
    }
    public FlyttbarSO(Color illustration, Punkt position, Fyrkant hitbox, boolean gravity, boolean dealDamage) {
        super(illustration, position, hitbox, false, dealDamage);
        this.deltaX = 0;
        this.deltaY = 0;
        this.gravity = gravity;
    }
    //endregion

    //region Functions
    public void relFlytta(){
        if(this.gravity){
            addDelta(0,2);
        }
        this.position.relflyttaX(this.deltaX);
        this.position.relflyttaY(this.deltaY);
        if(this.position.getX()>(1700-100))
            this.position.setX((1700-100));
        if(this.position.getX()<0)
            this.position.setX(0);
        if(this.position.getY()>(900-100)) {
            this.position.setY((900-100));
            resetDelta();
            this.jumping = false;
        }
        if(this.position.getY()<0)
            this.position.setY(0);
    }
    public void showDelta(){
        System.out.println("deltaY: " + deltaY + ", DeltaX: " + deltaX);
    }

    public void addDelta(float ddx,float ddy){
        this.deltaX+=ddx;
        this.deltaY+=ddy;
        if(Math.abs(this.deltaY)>30) {
            this.deltaY = this.deltaY / Math.abs(this.deltaY) * 30;
        }
        if(Math.abs(this.deltaX)>30) {
            this.deltaX = this.deltaX / Math.abs(this.deltaX) * 30;
        }
        //System.out.println("deltaX "+deltaX);
        //System.out.println("deltaY "+deltaY);
    }

    public void resetDelta() {
        this.deltaX = 0;
        this.deltaY = 0;
    }

    public boolean isJumping() {
        return jumping;
    }

    public void setJumping(boolean jumping) {
        this.jumping = jumping;
    }
    //endregion

    //region Getters and Setters
    public float getDeltaX(){
        return this.deltaX;
    }
    //endregion
}