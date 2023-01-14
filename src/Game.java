import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;


public class Game extends JFrame implements Runnable{
    gameStage stage;
    public Game(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(Color.RED);
        stage = new gameStage();
        setSize(400,400);
        add(stage);
        setPreferredSize(new Dimension(1000,800));
        show();
        pack();
        this.run();
    }

    @Override
    public void run() {
        while(true) {
            stage.repaint();
        }

    }
}
