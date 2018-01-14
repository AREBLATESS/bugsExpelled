import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.*;
import java.io.File;
import java.util.Random;


public class bugs extends JLabel implements Runnable {
    private int frmW, frmH, x, y, r1 ,r ;
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
    private MainFrame mf;
    private boolean mouseListenerIsActive = true;
    Random rd = new Random();
    private int flow = rd.nextInt(3)+1;


    public bugs(MainFrame frm,int frmH,int frmW,MainFrame mf){

        this.mf=mf;
        this.frm=frm;
        this.frmH =frmH;
        this.frmW= frmW;
        x=rand.nextInt(frmW-100);
        y=rand.nextInt(frmH-300);
        r=rand.nextInt(2);

        if(r==1){
            this.dirFrag= false;
        }
        if(mf.getScore()<=10) {
            this.setIcon(imgIcon[r][r1 = rand.nextInt(1)]);  //要改
        }else if(mf.getScore()<=20){
            if(mf.getScore()==11){
                JOptionPane.showMessageDialog(null,"here comes red mosqitos");
                mf.setScore(mf.getScore()+1);
                bugs.this.setFreeze();
            }
            this.setIcon(imgIcon[r][r1 = rand.nextInt(2)]);
        }else if (mf.getScore()>20){
            if(mf.getScore()==21){
                JOptionPane.showMessageDialog(null,"here comes the giant mosqitos");
                mf.setScore(mf.getScore()+1);
                bugs.this.setFreeze();
            }
            this.setIcon(imgIcon[r][r1 = rand.nextInt(3)]);
        }
//        else if (mf.getScore()>30){
//            if(mf.getScore()==31){
//                JOptionPane.showMessageDialog(null,"You win , you are the pro of killing mosqitos");
//                mf.setScore(mf.getScore()+1);
//                bugs.this.setFreeze();
//                try {
//                    AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("BGM2.wav"));
//                    Clip clip = AudioSystem.getClip();
//                    clip.open(inputStream);
//                    clip.loop(Clip.LOOP_CONTINUOUSLY);
//                    Thread.sleep(10000);
//                }
//                catch (Exception music){
//                    System.out.print(music);
//                }
//            }
//        }
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
//                ImageIcon imgB =new ImageIcon("graphic/blood.png");
//                bugs.this.setIcon(imgB);

                if(mouseListenerIsActive) {
                    bugs.this.setSleep();
                    addScore();
                    minFly();
                    addCombo();
                }
                mouseListenerIsActive=false;
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

            t1 = new Timer(rand.nextInt(100)+ 150, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
//                    while (isContinue == true) {
                    if(flow==1){
                        if (bugs.this.heiFlag){
                            if((y-10)>0){
                                y-=10;
                            }else{
                                bugs.this.heiFlag =!bugs.this.heiFlag;
                                y+=10;
                            }
                            bugs.this.setLocation(x,y);
                        }else{
                            if(y + bugs.this.getIcon().getIconHeight()+200<frmH){
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
                        //flow1/////////////
                    }else if(flow==2){
                        if (bugs.this.heiFlag){
                            if((y-10)>0){
                                y-=10;
                            }else{
                                bugs.this.heiFlag =!bugs.this.heiFlag;
                                y+=10;
                            }
                            bugs.this.setLocation(x,y);
                        }else{
                            if(y + bugs.this.getIcon().getIconHeight()+200<frmH){
                                y+=10;
                            }else{
                                bugs.this.heiFlag = !bugs.this.heiFlag;
                                y -= 10;
                            }
                            bugs.this.setLocation(x,y);
                        }
                        //~~~~~~~~//
                        if (bugs.this.dirFrag) {
                            if ((x - 30) > 0) {
                                x -= 30;
                            } else {
                                bugs.this.dirFrag = !bugs.this.dirFrag;
                                r = 1;
                                bugs.this.setIcon(imgIcon[r][r1]);
                                x += 30;
                            }
                            bugs.this.setLocation(x, y);
                        } else {
                            if ((x + bugs.this.getIcon().getIconWidth() + 30 < frmW)) {
                                x += 30;
                            } else {
                                bugs.this.dirFrag = !bugs.this.dirFrag;
                                r = 0;
                                bugs.this.setIcon(imgIcon[r][r1]);
                                x -= 30;
                            }
                            bugs.this.setLocation(x, y);
                        }
                        //flow2////////
                    }else if(flow==3){
                        if (bugs.this.heiFlag){
                            if((y-30)>0){
                                y-=30;
                            }else{
                                bugs.this.heiFlag =!bugs.this.heiFlag;
                                y+=30;
                            }
                            bugs.this.setLocation(x,y);
                        }else{
                            if(y + bugs.this.getIcon().getIconHeight()+200<frmH){
                                y+=30;
                            }else{
                                bugs.this.heiFlag = !bugs.this.heiFlag;
                                y -= 30;
                            }
                            bugs.this.setLocation(x,y);
                        }
                        //~~~~~~~~//
                        if (bugs.this.dirFrag) {
                            if ((x - 10) > 0) {
                                x -= 10;
                            } else {
                                bugs.this.dirFrag = !bugs.this.dirFrag;
                                r = 1;
                                bugs.this.setIcon(imgIcon[r][r1]);
                                x += 10;
                            }
                            bugs.this.setLocation(x, y);
                        } else {
                            if ((x + bugs.this.getIcon().getIconWidth() + 30 < frmW)) {
                                x += 10;
                            } else {
                                bugs.this.dirFrag = !bugs.this.dirFrag;
                                r = 0;
                                bugs.this.setIcon(imgIcon[r][r1]);
                                x -= 10;
                            }
                            bugs.this.setLocation(x, y);
                        }
                    }
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
            try {
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("bugsdown.wav"));
                Clip clip = AudioSystem.getClip();
                clip.open(inputStream);
                clip.loop(0);
                clip.start();
//                Thread.sleep(10000);
            }
            catch (Exception music){
                System.out.print(music);
            }

            Thread.sleep(10);

            t1.stop();
        }
        catch(InterruptedException out) {
            System.out.println("I am interrupted....");
        }
    }
    public void addScore(){
        mf.setScore(mf.getScore()+1);
        mf.getJlbPoint().setText(Integer.toString(mf.getScore()));
    }

    public void minFly(){
        mf.setfly(mf.getfly()-1);
    }

    public void addCombo(){
        mf.setCombo(mf.getCombo()+1);
    }
}

