//creates the main window for the game
import javax.swing.JFrame;
public class runthis
{
runthis()

{
  
main_game game=new main_game();
  
  JFrame frame = new JFrame();
  frame.setSize(1000,900);
  frame.setLocationRelativeTo(null);
  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  frame.setResizable(false);
  main_game panel = new main_game();
  frame.add(panel);
  frame.setVisible(true);
  // add start menu and credits screen
  game.mainLoop();//starts the mainloop in main_game
}
public static void main(String[] args)
 {
  new runthis(); 
 }
}