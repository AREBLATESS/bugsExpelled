import javax.swing.*;
import java.awt.event.*;
import java.util.Random;

public class bugs extends JLabel implements Runnable {
    private int frmW, frmH, x, y, r1 ,r,score;
    private ImageIcon[][] imgIcon = {{new ImageIcon("graphic/f11.png"),
            new ImageIcon("graphic/f21.png"),new ImageIcon("graphic/f31.png")},
            {new ImageIcon("graphic/f1.png"),new ImageIcon("graphic/f2.png"),
                    new ImageIcon("graphic/f3.png")}};
    private boolean isContinue = true;
    private boolean heiFlag = true;
    private boolean dirFrag = true;
    private MainFrame frm;
    private Timer t1;
    private Random rand = new Random();
    public bugs(MainFrame frm,int frmH,int frmW){
        this.frm=frm;
        this.frmH =frmH;
        this.frmW= frmW;
        x=rand.nextInt(frmW-100);
        y=rand.nextInt(frmH-100);
        r=rand.nextInt(2);
        if(r==1){
            this.dirFrag= false;
        }
        this.setIcon(imgIcon[r][r1=rand.nextInt(3)]);  //要改
        this.setBounds(x,y,this.getIcon().getIconWidth(),this.getIcon().getIconHeight());
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent oo) {
                    bugs.this.frm.setSelectedBug(bugs.this);

            }
            @Override
            public void mousePressed(MouseEvent oo) { }
            @Override
            public void mouseReleased(MouseEvent oo) { }
            @Override
            public void mouseEntered(MouseEvent oo) { }
            @Override
            public void mouseExited(MouseEvent oo) { }
        });

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                ImageIcon imgB =new ImageIcon("graphic/blood.png");
                bugs.this.setIcon(imgB);
                bugs.this.setSleep();
                score+=1;
//                isContinue=false;  //測試中
                //程式的小睡
//                try {
//                    Thread.sleep(9999);
//                }
//                catch(InterruptedException out) {
//                    System.out.println("I am interrupted....");
//                }
            }
        });
    }
    public void run(){

            t1 = new Timer(rand.nextInt(500 + 50), new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    while (isContinue == true) {
                        if (bugs.this.heiFlag){
                            if((y-10)>0){
                                y-=10;
                            }else{
                                bugs.this.heiFlag =!bugs.this.heiFlag;
                                y+=10;
                            }
                            bugs.this.setLocation(x,y);
                        } else{
                            if(y + bugs.this.getIcon().getIconHeight()+20<frmH){
                                y+=10;
                            }else{
                                bugs.this.heiFlag = !bugs.this.heiFlag;
                                y -= 10;
                            }
                            bugs.this.setLocation(x,y);
                        }
                        //~~~~~~~~//
                        if (bugs.this.dirFrag) {
                            if ((x - 15) > 0) {
                                x -= 15;
                            } else {
                                bugs.this.dirFrag = !bugs.this.dirFrag;
                                r = 1;
                                bugs.this.setIcon(imgIcon[r][r1]);
                                x += 15;
                            }
                            bugs.this.setLocation(x, y);
                        } else {
                            if ((x + bugs.this.getIcon().getIconWidth() + 30 < frmW)) {
                                x += 15;
                            } else {
                                bugs.this.dirFrag = !bugs.this.dirFrag;
                                r = 0;
                                bugs.this.setIcon(imgIcon[r][r1]);
                                x -= 15;
                            }
                            bugs.this.setLocation(x, y);
                        }
//                        isContinue =true;
//                    }
                    }

            });
            t1.start();
        }

        public void setFreeze(){
            try {
                Thread.sleep(3000);
            }
            catch(InterruptedException out) {
                System.out.println("I am interrupted....");
            }
        }

    public void setSleep(){
        try {
            ImageIcon imgB =new ImageIcon("graphic/blood.png");
            bugs.this.setIcon(imgB);
            Thread.sleep(10);
            t1.stop();
        }
        catch(InterruptedException out) {
            System.out.println("I am interrupted....");
        }
    }


}
