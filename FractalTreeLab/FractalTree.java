import java.awt.*;
import javax.swing.JPanel;
import java.lang.Math;
import java.awt.Graphics2D;
import java.util.*;
/**
 * Write a description of class FractalTree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FractalTree extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */

    private int startX;
    private int startY;
    //Start x and Y coordinates
    
    private int endX;
    private int endY; 
    //End of original trunk
    
    private double percent;
    private double smallest;
    private double angle;
    private ArrayList<Color> colors;
    
    /**
     * Default constructor for objects of class FractalTree
     */
    public FractalTree(int startX,int startY,int endX  ,int endY, double percent, double smallest,double angle)
    {
        this.startX= startX;
        this.startY= startY;
        this.endX= endX;
        this.endY= endY;
        this.percent= percent;
        this.smallest= smallest;
        this.angle= angle;
        this.setPreferredSize(new Dimension(1000,1000));
        setBackground(Color.white);

        this.colors= new ArrayList<Color>();
        colors.add(0,Color.blue);
        colors.add(0,Color.red);
        colors.add(0,Color.gray);
        colors.add(0,Color.green);
        colors.add(0,Color.orange);
        colors.add(0,Color.pink);
        colors.add(0,Color.yellow);
        colors.add(0,Color.black);
    }


    public void drawFractal(Graphics g2, double prevAngle, double startX, double startY, double endX, double endY, double prevLength ){
        //caculates length;
        double length= prevLength*percent;
        //calculates new angles
        double newAngle1= prevAngle-Math.PI/6;
        double newAngle2= prevAngle+ Math.PI/6;
        double leftX, leftY, rightX, rightY;  
        
        if(length< this.smallest){
            //terminating sequence;
        }
        else{
            //draws the orignal line
            Random rand= new Random();
            g2.setColor(colors.get(rand.nextInt(colors.size()-1)));
            g2.drawLine((int)startX, (int)startY, (int)endX, (int)endY);
            //creates left coordinates
            leftX= endX-Math.cos(newAngle2)*length;
            leftY= endY-Math.sin(newAngle2)*length;
            //calculats right coordinates
            rightX= endX-Math.cos(newAngle1)*length;
            rightY= endY-Math.sin(newAngle1)*length;
            
            //drawfractals
            this.drawFractal(g2, newAngle1, endX, endY, leftX ,leftY,(int)length);
            this.drawFractal(g2, newAngle2, endX, endY, rightX, rightY, (int)length);
            
        }
    
    }
    
    public void paintComponent(Graphics g){
        Graphics g2= (Graphics2D) g;
        super.paintComponent(g2);

        
        double distance= Math.sqrt((startX-endX)*(startX-endX)+ (startY-endY)*(startY-endY));
        //initializes the problem
        this.drawFractal(g2, angle, startX, startY, endX, endY,distance); 
    }
}


