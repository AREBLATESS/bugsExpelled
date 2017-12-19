import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bugs extends JLabel implements Runnable {
    private int frmW, frmH, x, y, r1 ,r;
    private ImageIcon[][] imgIcon = {{new ImageIcon("")}{}};
    private boolean dirFrag = true;
    private Timer t1;
    private Random rand = new Random();
    public Fish(int frmH,int frmW){
        this.frmH =frmH;
        this.frmW= frmW;
        x=rand.nextInt(frmW-100);
        y=rand.nextInt(frmH-100);
        r=rand.nextInt(2);
        if(r==1){
            this.dirFrag= false;
        }
        this.setIcon(image[r][r=rand.nextInt(5)]);  //要改
        this.setBounds(x,y,this.getIcon().getIconWidth(),this.getIcon().getIconHeight());

    }
    public void run(){
        t1 =new Timer(rand.nextInt(1000 + 50), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(Fish.this.dirFlag){
                    if((x-10)>0){
                        x-=10;
                    }else{
                        Fish.this.dirFlag = !Fish.this.dirFlag;
                        r=1;
                        Fish.this.setIcon(imgIcon[r][r1]);
                        x+=10;
                    }
                    Fish.this.setLocation(x,y);
                }else{
                    if((x+Fish.this.getIcon().getIconWidth()+20<frmW)){
                        x+=10;
                    }else{
                        Fish.this.dirFlag= !Fish.this.dirFlag;
                        r=0;
                        Fish.this.setIcon(ImageIcon[r][r1]);
                        x-=10;
                    }
                    Fish.this.setLocation(x,y);
                }
            }
        });
        t1.start();
    }
}
