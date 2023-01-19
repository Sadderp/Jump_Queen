import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Game extends JFrame implements Runnable{
    gameStage stage;
    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.RED);
        stage = new gameStage();
        add(stage);
        setPreferredSize(new Dimension(1000,800));
        show();
        pack();
        this.run();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 30.0;
        double delta = 0;
        while(true){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1){
                stage.repaint();
                delta--;
            }
        }

    }
}
