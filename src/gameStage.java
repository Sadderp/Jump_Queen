import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameStage extends Canvas implements MouseListener, KeyListener {
    //region Variables
    Spelare Player;
    MusSpelare MusGubbe;
    Enemy ParaKoopa;
    FastObjekt FastObjekt;
    FastObjekt Platform;
    Enemy Goomba;
    Enemy Goomba2;
    FlyttSO Pipe1;
    FlyttSO Pipe2 = new FlyttSO("Pipe2", null, new Color(200,200,200), new Punkt(1400,200), new Fyrkant(new Punkt(0,0), 100,100));
    ArrayList <SpelObjekt> list = null;
    //endregion

    //region Constructor
    public GameStage() {
        list = new ArrayList<>();

        Player = new Spelare(new Color(100,255,100),new Punkt(100,800),new Fyrkant(new Punkt(0,0),100,100), 5);
        MusGubbe = new MusSpelare(new Color(255,0,0),new Punkt(200,100),new Fyrkant(new Punkt(0,0),100,100));
        ParaKoopa = new Enemy(new Color(255, 105, 180), new Punkt(900,200), new Fyrkant(new Punkt(0,0),100,100), false, true, 1);
        FastObjekt = new FastObjekt(new Color(0,255,255),new Punkt(700,800),new Fyrkant(new Punkt(0,0),100,100), true);
        Platform = new FastObjekt(new Color(255, 145, 0),new Punkt(1100,300),new Fyrkant(new Punkt(0,0),400,100), false);
        Goomba = new Enemy(new Color(255,255,0), new Punkt(400,800), new Fyrkant(new Punkt(0,0),100,100), true, 1);
        Goomba2 = new Enemy(new Color(255,255,0), new Punkt(1000,800), new Fyrkant(new Punkt(0,0),100,100), true, 1);
        Pipe1 = new FlyttSO("Pipe1", Pipe2, new Color(35, 245, 3, 255), new Punkt(1500,800), new Fyrkant(new Punkt(0,0), 100,100));
        Pipe2 = new FlyttSO("Pipe2", Pipe1, new Color(35,245,3), new Punkt(1400,200), new Fyrkant(new Punkt(0,0), 100,100));

        list.add(Player);
        list.add(MusGubbe);
        list.add(ParaKoopa);
        list.add(FastObjekt);
        list.add(Platform);
        list.add(Goomba);
        list.add(Goomba2);
        list.add(Pipe1);
        list.add(Pipe2);

        addMouseListener(this);
        addKeyListener(this);
        setBackground(Color.LIGHT_GRAY);
        setPreferredSize(new Dimension(1700,900));
    }
    //endregion

    //region Functions
    @Override
    public void paint(Graphics g) {}
    @Override
    public void update(Graphics g) {
        // Dubbelbuffrar skärmen så den inte flickrar.
        // Ritar till en bild sen ritar ut den nya  bilden.
        Graphics offgc;  // Temp rityta
        Image offscreen = null;  // temp bild
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        offscreen = createImage(d.width, d.height);  // Skapar bilden
        offgc = offscreen.getGraphics();  // Hämtar det som är på bilden
        list.forEach((obj)->{if(obj instanceof FlyttbarSO) ((FlyttbarSO) obj).relFlytta();});
        list.forEach((obj)->{if(!(obj instanceof Spelare)) {

            /*-----------------------*\
            | Kollision i kvadranter  |
            \*-----------------------*/

            //Höger om objektet
            if (obj.collides(Player) == 1){
                Player.position.setX(obj.getX()+obj.getWidth());
                Player.resetDelta();
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //Ovanpå objektet
            if (obj.collides(Player) == 2){
                Player.position.setY(obj.getY()- Player.getHeight());
                if(obj instanceof Enemy){
                    //Checks if the object the player lands on is damageable
                    //If they are then it damages them
                    if(((Enemy) obj).Damageable){
                        if(((Enemy) obj).Damage()){
                            list.remove(obj);
                            Player.addDelta(-2,-40);
                        }
                    }

                }else{
                    Player.resetDelta();
                }
                Player.setJumping(false);
            }

            //Vänster om objektet
            if (obj.collides(Player) == 3){
                Player.position.setX(obj.getX()- Player.getWidth());
                Player.resetDelta();
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //Under objektet
            if (obj.collides(Player) == 4){
                Player.position.setY(obj.getY()+obj.getHeight());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //>45° i första kvadranten
            if (obj.collides(Player) == 5){
                Player.position.setY(obj.getY()- Player.getHeight());
                if(obj instanceof Enemy){
                    //Checks if the object the player lands on is damageable
                    //If they are then it damages them
                    if(((Enemy) obj).Damageable){
                        if(((Enemy) obj).Damage()){
                            list.remove(obj);
                            Player.addDelta(-2,-40);
                        }
                    }

                }else{
                    Player.resetDelta();
                }
                Player.setJumping(false);
            }

            //<45° i första kvadranten
            if (obj.collides(Player) == 6){
                Player.position.setX(obj.getX()- Player.getWidth());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //>-45° i andra kvadranten
            if (obj.collides(Player) == 7){
                Player.position.setY(obj.getY()- Player.getHeight());
                if(obj instanceof Enemy){
                    //Checks if the object the player lands on is damageable
                    //If they are then it damages them
                    if(((Enemy) obj).Damageable){
                        if(((Enemy) obj).Damage()){
                            list.remove(obj);
                            Player.addDelta(-2,-40);
                        }
                    }

                }else{
                    Player.resetDelta();
                }
                Player.setJumping(false);
            }

            //<-45° i andra kvadranten
            if (obj.collides(Player) == 8){
                Player.position.setX(obj.getX()+obj.getWidth());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //>45° i tredje kvadranten
            if (obj.collides(Player) == 9){
                Player.position.setX(obj.getX()+obj.getWidth());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //<45° i tredje kvadranten
            if (obj.collides(Player) == 10){
                Player.position.setY(obj.getY()+obj.getHeight());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //>45° i fjärde kvadranten
            if (obj.collides(Player) == 11){
                Player.position.setX(obj.getX()- Player.getWidth());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }

            //<45° i fjärde kvadranten
            if (obj.collides(Player) == 12){
                Player.position.setY(obj.getY()+obj.getHeight());
                if (obj.DealDamage){
                    Player.Hurt();
                }
            }
        }
        });
        list.forEach((obj)->obj.ritaut(offgc,this));
        paint(offgc);  // Ritar över gamla bilden.
        g.drawImage(offscreen, 0, 0, this);
    }
    //endregion

    //region Imports
    public void mouseEntered (MouseEvent mouseEvent) {}
    public void mousePressed (MouseEvent mouseEvent) {}
    public void mouseReleased (MouseEvent mouseEvent) {}
    public void mouseExited (MouseEvent mouseEvent) {}
    public void mouseClicked (MouseEvent mouseEvent) {}

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            Player.Move(10, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            Player.Move(-10, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {}
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            //makes it so that you can't jump while jumping
            if (!Player.isJumping()) {
                Player.setJumping(true);
                Player.Jump();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE){
            list.forEach((obj)->{if(!(obj instanceof Spelare)) {
                if(obj.Interactable && obj.CanInteract(Player)){
                    //Interaction with an npc
                    for(int i = 0; i<3000; i++){
                        getGraphics().drawString("Hello there!", obj.getX(), obj.getY() - 10);
                    }
                    for(int i = 0; i<3000; i++){
                        getGraphics().drawString("General kenobi", Player.getX(), Player.getY() - 10);
                    }
                };
                if(obj instanceof FlyttSO){
                    if(obj.Warpable && obj.CanWarp(Player)){
                        //Check what object is connected to the one they're standing on
                        //System.out.println(((FlyttSO) obj).ConnectedTo);
                        //Moves the player to the object that's connected to the one they're standing on
                        Player.defMove(((FlyttSO) obj).getConnection().getX(), ((FlyttSO) obj).getConnection().getY() - ((FlyttSO) obj).getConnection().getHeight() - 100);
                    }
                }
            }});
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
    //endregion
}