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

    void flytta(int miny,int maxy){
        if(this.gravity){
            this.position.relY(deltaY+1);
        }
        if(this.position.getY()<miny)
            this.position.setY(miny);
        if(this.position.getY()>maxy)
            this.position.setY(maxy);
    }

    void flyttaObjekt(float x){
        this.position.relX(x);
    }
    void flyttaObjektHoppa (float y){
        System.out.println(deltaY);
        if (y <= 800-200) {
            this.position.relY(deltaY++);
        }
        else{
            this.position.relY(0);
            y = 800-200;
        }
    }
}
