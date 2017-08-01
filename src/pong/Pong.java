package pong;

public class Pong {

    public static void main(String[] args) throws Exception{
        
        int choice = 0;
        boolean game = false;
        
        
        
        MainMenu mainMenu = new MainMenu("Main Menu",choice);
        
        while (mainMenu.isActive()) {
            
        }

        
        if (game) {
            boolean isRunning = true;
            long currentTime = 0;
            long updateLength = 0;
            long lastTime = 0;
            double deltaTime;

            MyFrame GameWindow = new MyFrame("Pong");
                while (isRunning) {

                    currentTime = System.nanoTime();
                    if (lastTime == 0)
                        lastTime = currentTime;

                    updateLength = currentTime - lastTime;
                    lastTime = currentTime;
                    deltaTime = updateLength / ((double)1000000000 / 60);


                    GameWindow.GD.ball.update(deltaTime,GameWindow.GD.arena,
                    GameWindow.GD.player1pad, GameWindow.GD.player2pad);

                    GameWindow.GD.player1pad.update(deltaTime,GameWindow.GD.arena);
                    GameWindow.GD.player2pad.update(deltaTime,GameWindow.GD.arena);

                    //System.out.println(deltaTime);

                    GameWindow.GD.repaint();
                }
        }
        
        System.out.println("Eh?");
    }
}
