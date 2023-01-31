import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class gameStage extends Canvas implements MouseListener, KeyListener {
    int test = 1;
    Spelare gubbe;
    MusSpelare MusGubbe;
    FastObjekt ParaKoopa;
    FastObjekt FastObjekt;
    FastObjekt Goomba;
    ArrayList <SpelObjekt> lista = null;
    public gameStage() {
        lista = new ArrayList<SpelObjekt>();
        gubbe = new Spelare("mario.png",new Punkt(100,100),new Fyrkant(new Punkt(0,0),100,100), 5);
        MusGubbe = new MusSpelare("lakitu2.png",new Punkt(200,100),new Fyrkant(new Punkt(0,0),100,100));
        ParaKoopa = new FastObjekt("parakoopa.png",new Punkt(500,200),new Fyrkant(new Punkt(0,0),100,100));
        FastObjekt = new FastObjekt("tegel.png",new Punkt(700,700),new Fyrkant(new Punkt(0,0),100,100));
        Goomba = new FastObjekt("goomba.png", new Punkt(400,700), new Fyrkant(new Punkt(0,0),100,100));
        lista.add(gubbe);
        lista.add(MusGubbe);
        lista.add(ParaKoopa);
        lista.add(FastObjekt);
        lista.add(Goomba);
        addMouseListener(this);
        addKeyListener(this);
        setBackground(Color.GREEN);
        setPreferredSize(new Dimension(1000,800));
    }
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
        lista.forEach((obj)->{if(obj instanceof FlyttbarSO) ((FlyttbarSO) obj).relFlytta();});
        lista.forEach((obj)->{if(!(obj instanceof Spelare)) {

            /*-----------------------*\
            | Kollision i kvadranter  |
            \*-----------------------*/

            //Höger om objektet
            if (obj.collides(gubbe) == 1){
                gubbe.position.setX(obj.getX()+obj.getWidth());
                gubbe.skada();
            }

            //Ovanpå objektet
            if (obj.collides(gubbe) == 2){
                gubbe.position.setY(obj.getY()-gubbe.getHeight());
                gubbe.resetDelta();
                gubbe.setJumping(false);
            }

            //Vänster om objektet
            if (obj.collides(gubbe) == 3){
                gubbe.position.setX(obj.getX()-gubbe.getWidth());
                gubbe.skada();
            }

            //Under objektet
            if (obj.collides(gubbe) == 4){
                gubbe.position.setY(obj.getY()+obj.getHeight());
                gubbe.skada();
            }

            //>45° i första kvadranten
            if (obj.collides(gubbe) == 5){
                gubbe.position.setY(obj.getY()-gubbe.getHeight());
                gubbe.resetDelta();
                gubbe.setJumping(false);
            }

            //<45° i första kvadranten
            if (obj.collides(gubbe) == 6){
                gubbe.position.setX(obj.getX()-gubbe.getWidth());
                gubbe.skada();
            }

            //>-45° i andra kvadranten
            if (obj.collides(gubbe) == 7){
                gubbe.position.setY(obj.getY()-gubbe.getHeight());
                gubbe.resetDelta();
                gubbe.setJumping(false);
            }

            //<-45° i andra kvadranten
            if (obj.collides(gubbe) == 8){
                gubbe.position.setX(obj.getX()+obj.getWidth());
                gubbe.skada();
            }

            //>45° i tredje kvadranten
            if (obj.collides(gubbe) == 9){
                gubbe.position.setX(obj.getX()+obj.getWidth());
                gubbe.skada();
            }

            //<45° i tredje kvadranten
            if (obj.collides(gubbe) == 10){
                gubbe.position.setY(obj.getY()+obj.getHeight());
                gubbe.skada();
            }

            //>45° i fjärde kvadranten
            if (obj.collides(gubbe) == 11){
                gubbe.position.setX(obj.getX()-gubbe.getWidth());
                gubbe.skada();
            }

            //<45° i fjärde kvadranten
            if (obj.collides(gubbe) == 12){
                gubbe.position.setY(obj.getY()+obj.getHeight());
                gubbe.skada();
            }

        }
        });
        lista.forEach((obj)->obj.ritaut(offgc,this));
        paint(offgc);  // Ritar över gamla bilden.
        g.drawImage(offscreen, 0, 0, this);
    }
    public void mouseEntered (MouseEvent mouseEvent) {
    }
    public void mousePressed (MouseEvent mouseEvent) {}
    public void mouseReleased (MouseEvent mouseEvent) {}
    public void mouseExited (MouseEvent mouseEvent) {}
    public void mouseClicked (MouseEvent mouseEvent) {}

    private gameStage draw;
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gubbe.flytta(10, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            gubbe.flytta(-10, 0);
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {}
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            if (!gubbe.isJumping()) {

                //disallow jumping while already jumping
                gubbe.setJumping(true);

                //going up
                gubbe.Hoppa();
            }
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
