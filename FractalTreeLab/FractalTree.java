import java.awt.*;
import javax.swing.JPanel;
import java.lang.Math;
import java.awt.Graphics2D;
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
        setBackground(Color.black);
        
    }


    public void drawFractal(Graphics g, double prevAngle, double startX, double startY, double endX, double endY, int prevLength ){
        double length= prevLength*percent;
        double newAngle1= prevAngle-Math.PI/6;
        double newAngle2= prevAngle+ Math.PI/6;
        double leftX, leftY, rightX, rightY;  
        
        if(length< smallest){
            g.drawLine((int)startX, (int)startY, (int)endX, (int)endY);
        }
        else{
            if(newAngle1<=0){
                newAngle1= Math.PI/2;
            }
            leftX= endX+(Math.cos(newAngle)*length);
            rightX= endX-(Math.cos(newAngle)*length);
            
            leftY= endY+(Math.sin(newAngle/2)*length);
            rightY= endY-(Math.sin(newAngle/2)*length);
            
            drawFractal(g, newAngle, endX, endY, leftX,leftY,(int)length);
            drawFractal(g, newAngle, endX, endY, rightX, rightY, (int)length);
            
        }
    
    }
    
    public void paint(Graphics g){
        int length= 100;
        drawFractal(g, angle, startX, startY, endX, endY,500); 
    }
}


