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
        gubbe = new Spelare("mario.png",new Punkt(100,100),new Fyrkant(new Punkt(0,0),100,100));
        //MusGubbe = new MusSpelare("lakitu2.png",new Punkt(200,100),new Fyrkant(new Punkt(0,0),100,100));
        //ParaKoopa = new FastObjekt("parakoopa.png",new Punkt(500,200),new Fyrkant(new Punkt(0,0),100,100));
        //FastObjekt = new FastObjekt("tegel.png",new Punkt(700,800),new Fyrkant(new Punkt(0,0),100,100));
        Goomba = new FastObjekt("goomba.png", new Punkt(400,700), new Fyrkant(new Punkt(0,0),100,100));
        lista.add(gubbe);
        //lista.add(MusGubbe);
        //lista.add(ParaKoopa);
        //lista.add(FastObjekt);
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
        // Dubbelbufffrar skärmen så den inte flickrar.
        // Ritar till en bild sen ritar ut den nya  bilden.
        //System.out.println("Width: "+this.getWidth()+" height: "+this.getHeight());
        Graphics offgc;  // Temp rityta
        Image offscreen = null;  // temp bild
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        offscreen = createImage(d.width, d.height);  // Skapar bilden
        offgc = offscreen.getGraphics();  // Hämtar det som är på bilden ..
        lista.forEach((obj)->{if(obj instanceof FlyttbarSO) ((FlyttbarSO) obj).relFlytta();});
        lista.forEach((obj)->{if(!(obj instanceof Spelare)) {
            int answ = Math.round(obj.collides(gubbe));
            if (answ != 0){
                /*System.out.println("mario: "+gubbe.position);
                System.out.println("mario: "+gubbe.fyrkantGetX());*/
            }
            if(answ == 1){
                //gubbe.defFlytta(0,0);
                //System.out.println("mario: "+gubbe.position);
            }
            else if(answ == 2){
                //System.out.println("mario: "+gubbe.position);
                //System.out.println("mario: "+gubbe.fyrkantGetX());
                //gubbe.defFlytta(0,0);
            }
            else if(answ == 3){
                //gubbe.defFlytta(0,0);
                //System.out.println("mario: "+gubbe.position);
            }
            else if(answ == 4){
                //gubbe.defFlytta(0,0);
                //System.out.println("mario: "+gubbe.position);
            }
        }
        });
        lista.forEach((obj)->obj.ritaut(offgc,this));
//        System.out.println(gubbe.getX()+" "+gubbe.getY()+" "+gubbe.fyrkantGetX()+" "+gubbe.fyrkantGetY()+" "+gubbe.getWidth()+" "+gubbe.getHeight()+" "+gubbe.getFyrkant().getHeight()+" "+gubbe.getFyrkant().getWidth());
//        System.out.println("GOOMBA: "+Goomba.getX()+" "+Goomba.getY()+" "+Goomba.fyrkantGetX()+" "+Goomba.fyrkantGetY()+" "+Goomba.getWidth()+" "+Goomba.getHeight()+" "+Goomba.getFyrkant().getHeight()+" "+Goomba.getFyrkant().getWidth());
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
            gubbe.Hoppa();
        }
    }
    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}
