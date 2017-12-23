import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

public class bugs extends JLabel implements Runnable {
    private int frmW, frmH, x, y, r1 ,r;
    private ImageIcon[][] imgIcon = {{new ImageIcon("graphic/f11.png"),
            new ImageIcon("graphic/f21.png"),new ImageIcon("graphic/f31.png")},
            {new ImageIcon("graphic/f1.png"),new ImageIcon("graphic/f2.png"),
                    new ImageIcon("graphic/f3.png")}};
    private boolean dirFrag = true;
    private Timer t1;
    private Random rand = new Random();
    public bugs(int frmH,int frmW){
        this.frmH =frmH;
        this.frmW= frmW;
        x=rand.nextInt(frmW-100);
        y=rand.nextInt(frmH-100);
        r=rand.nextInt(2);
        if(r==1){
            this.dirFrag= false;
        }
        this.setIcon(imgIcon[r][r=rand.nextInt(3)]);  //要改
        this.setBounds(x,y,this.getIcon().getIconWidth(),this.getIcon().getIconHeight());

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ImageIcon imgB =new ImageIcon("graphic/blood.png");
                bugs.this.setIcon(imgB);
            }
        });
    }
    public void run(){
        t1 =new Timer(rand.nextInt(1000 + 50), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bugs.this.dirFrag){
                    if((x-10)>0){
                        x-=10;
                    }else{
                        bugs.this.dirFrag = !bugs.this.dirFrag;
                        r=1;
                        bugs.this.setIcon(imgIcon[r][r1]);
                        x+=10;
                    }
                    bugs.this.setLocation(x,y);
                }else{
                    if((x+bugs.this.getIcon().getIconWidth()+20<frmW)){
                        x+=10;
                    }else{
                        bugs.this.dirFrag= !bugs.this.dirFrag;
                        r=0;
                        bugs.this.setIcon(imgIcon[r][r1]);
                        x-=10;
                    }
                    bugs.this.setLocation(x,y);
                }
            }
        });
        t1.start();
    }
}
