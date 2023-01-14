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
        gubbe = new Spelare("par.jpg",new Punkt(100,100),new Fyrkant(new Punkt(100,100),300,300));
        MusGubbe = new MusSpelare("par.jpg",new Punkt(100,100),new Fyrkant(new Punkt(100,100),300,300));
        FastObjekt = new FastObjekt("par.jpg",new Punkt(100,100),new Fyrkant(new Punkt(100,100),300,300));
        lista.add(gubbe);
        lista.add(MusGubbe);
        lista.add(FastObjekt);
        // Lägg till ytterligare objekt!
        addMouseListener(this);
        addKeyListener(this);
        setBackground(Color.RED);
        setSize(400,400);
    }

    @Override
    public void paint(Graphics g) {
      //  super.paint(g);   // Tömmer skärmen så det flimmrar.
    }


    @Override
    public void update(Graphics g) {
        // Dubbelbufffrar skärmen så den inte flickrar.
        // Ritar till en bild sen ritar ut den nya  bilden.
        Graphics offgc;  // Temp rityta
        Image offscreen = null;  // temp bild
        Dimension d = size();
        offscreen = createImage(d.width, d.height);  // Skapar bilden
        offgc = offscreen.getGraphics();  // Hämtar det som är på bilden ..
        lista.forEach((obj)->{if(obj instanceof FlyttbarSO) ((FlyttbarSO) obj).flytta(0,d.height-100);});
        lista.forEach((obj)->obj.ritaut(offgc,this));
//        test.ritaut(offgc,this);  // ritar ut min gubbe
        paint(offgc);  // Ritar över gamla bilden.
        // transfer offscreen to window
        g.drawImage(offscreen, 0, 0, this);
    }


    public void mouseEntered (MouseEvent mouseEvent) {
        MusGubbe.flyttaObjekt(10);
    }
    public void mousePressed (MouseEvent mouseEvent) {}
    public void mouseReleased (MouseEvent mouseEvent) {}
    public void mouseExited (MouseEvent mouseEvent) {}
    public void mouseClicked (MouseEvent mouseEvent) {}

    private gameStage draw;

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            gubbe.flyttaObjekt(5);
            System.out.println("right");
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT){
            gubbe.flyttaObjekt(-5);
            System.out.println("left");
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("down");
        }
        else if (e.getKeyCode() == KeyEvent.VK_UP){
            gubbe.flyttaObjektHoppa(-5);
            System.out.println("up");
        }
    }

    public void keyReleased(KeyEvent e) {}

    public void keyTyped(KeyEvent e) {}
}
