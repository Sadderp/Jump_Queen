import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Game extends JFrame implements Runnable {
    GameStage stage;
    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        stage = new GameStage();
        add(stage);
        setResizable(true);
        setTitle("Jump queen");
        setVisible(true);
        pack();
        this.run();
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double ns = 1000000000.0 / 60.0;
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
