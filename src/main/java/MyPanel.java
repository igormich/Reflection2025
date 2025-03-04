import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyPanel extends JPanel {

    private int x =500;
    private int y =100;
    private int vx =1;
    private int vy =1;
    private Image sprite;

    public MyPanel() throws IOException {
        super();
        sprite = ImageIO.read(new File("1.png"))
                .getScaledInstance(100,100,Image.SCALE_SMOOTH);
    }
    @Override
    public void paint(Graphics g) {
        var g2d = (Graphics2D)g;
        g2d.setColor(Color.BLACK);
        g2d.fillRect(0,0,getWidth(),getHeight());
        g2d.setColor(Color.RED);
       // g2d.fillOval(x,y, 100,100);
        g2d.drawImage(sprite,x,y,null);
    }

    public static void main(String[] args) throws IOException {
        var frame = new JFrame();
        var panel = new MyPanel();

        panel.setSize(800,800);
        panel.setPreferredSize(new Dimension(800,800));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        var timer = new ScheduledThreadPoolExecutor(1);
        timer.scheduleWithFixedDelay(panel::step,0,10, TimeUnit.MILLISECONDS);

    }

    private void step() {
        x+=vx;
        y+=vy;
        if(x>getWidth()-100||(x<0))
            vx=-vx;
        if(y>getWidth()-100||(y<0))
            vy=-vy;
        invalidate();
        repaint();
    }
}
