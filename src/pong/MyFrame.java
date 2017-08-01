package pong;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyFrame extends Frame{
    GameDraw GD;

    public MyFrame(String title) {
        super(title);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        addWindowListener(new WindowAdapter ()
                                {   public void windowClosing(WindowEvent e) {
                                    
                                    System.exit(0);
                                    }
                                }
        );
        
        GD = new GameDraw(this);
        this.add(GD);
        
        this.setVisible(true);
    }
    
}
