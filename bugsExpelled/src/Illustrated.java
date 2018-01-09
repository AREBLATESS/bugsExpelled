import javax.swing.*;
import java.awt.*;

public class Illustrated extends JFrame{

    private Container cp;
    private JLabel lb1 = new JLabel("1");
    public Illustrated(){
        initComp();
    }
    private void initComp(){

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        cp=this.getContentPane();
        this.setBounds(500,500,500,500);

    }
}
