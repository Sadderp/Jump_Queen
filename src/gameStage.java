import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
public class gameStage extends Canvas implements MouseListener, KeyListener {

    Spelare gubbe;
    MusSpelare MusGubbe;
    FastObjekt FastObjekt;
    ArrayList <SpelObjekt> lista = null;
    public gameStage() {
        lista = new ArrayList<SpelObjekt>();
        gubbe = new Spelare("mario.png",new Punkt(100,300),new Fyrkant(new Punkt(0,0),100,100));
        MusGubbe = new MusSpelare("par.jpg",new Punkt(100,100),new Fyrkant(new Punkt(0,0),100,100));
        FastObjekt = new FastObjekt("tegel.png",new Punkt(700,800),new Fyrkant(new Punkt(0,0),100,100));
        lista.add(gubbe);
        lista.add(MusGubbe);
        lista.add(FastObjekt);
        addMouseListener(this);
        addKeyListener(this);
        setBackground(Color.GREEN);
    }
    @Override
    public void paint(Graphics g) {}
    @Override
    public void update(Graphics g) {
        // Dubbelbufffrar skärmen så den inte flickrar.
        // Ritar till en bild sen ritar ut den nya  bilden.
        Graphics offgc;  // Temp rityta
        Image offscreen = null;  // temp bild
        Dimension d = size();
        offscreen = createImage(d.width, d.height);  // Skapar bilden
        offgc = offscreen.getGraphics();  // Hämtar det som är på bilden ..
        lista.forEach((obj)->{if(obj instanceof FlyttbarSO) ((FlyttbarSO) obj).relFlytta();});
        lista.forEach((obj)->{if(!(obj instanceof Spelare) && obj.collides(gubbe))
            gubbe.resetDelta();
        });
        lista.forEach((obj)->obj.ritaut(offgc,this));
        paint(offgc);  // Ritar över gamla bilden.
        g.drawImage(offscreen, 0, 0, this);
    }
    public void mouseEntered (MouseEvent mouseEvent) {
        MusGubbe.relFlytta();
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
