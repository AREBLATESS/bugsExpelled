import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Illustrated extends JFrame{

    private Container cp;

    private JLabel lb1 = new JLabel("");
    public Illustrated(){
        initComp();
    }
    private void initComp(){

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                MainFrame mram = new MainFrame();
                mram.setVisible(true);
                Illustrated.this.setVisible(false);
            }
        });



        cp=this.getContentPane();
        this.setBounds(500,0,1000,1000);
        cp.add(lb1);
        ImageIcon illustrated = new ImageIcon("graphic/illustrated.png");
        lb1.setIcon(illustrated);
    }
}
