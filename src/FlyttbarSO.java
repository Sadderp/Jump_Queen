public abstract class FlyttbarSO extends SpelObjekt{
    private float deltaX;
    private float deltaY;

    private boolean gravity;
    public FlyttbarSO(String illustration, Punkt position, Fyrkant hitbox) {
        super(illustration, position, hitbox);
        this.deltaX=0;
        this.deltaY=0;
        this.gravity = false;
    }
    public FlyttbarSO(String illustration, Punkt position, Fyrkant hitbox, boolean gravity) {
        super(illustration, position, hitbox);
        this.deltaX=0;
        this.deltaY=0;
        this.gravity = gravity;
    }

    public void relFlytta(){
        if(this.gravity){
            addDelta(0,3);
        }
        this.position.relflyttaX(this.deltaX);
        this.position.relflyttaY(this.deltaY);
        if(this.position.getX()>(1000-115))
            this.position.setX((1000-115));
        if(this.position.getX()<0)
            this.position.setX(0);
        if(this.position.getY()>(800-135)) {
            this.position.setY((800 - 135));
            resetDelta();
        }
        if(this.position.getY()<0)
            this.position.setY(0);

    }
    public void showDelta(){
        System.out.println("delta"+deltaY);
    }


    public void addDelta(float ddx,float ddy){
        this.deltaX+=ddx;
        this.deltaY+=ddy;
        if(Math.abs(this.deltaY)>30) {
            this.deltaY = this.deltaY / Math.abs(this.deltaY) * 30;
        }
    }

    public void resetDelta() {
        this.deltaX = 0;
        this.deltaY = 0;
    }
}
