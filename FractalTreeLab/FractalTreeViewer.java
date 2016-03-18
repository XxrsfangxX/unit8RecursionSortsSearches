import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
public class FractalTreeViewer 
{

    private final int WIDTH = 600;
    private final int HEIGHT = 600;
    private JFrame frame;
    
    public static void main(String[] args)
    {
        // initialise instance variables
       int x1= 100;
       int y1= 500;
       int x2= 100;
       int y2= 10;
       double percent= .67;
       double smallest=1;
       double angle= Math.PI/2;
        FractalTreeViewer viewer= new FractalTreeViewer(x1, y1, x2, y2, percent, smallest, angle);
       
    }   

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public FractalTreeViewer(int startX, int startY, int endX, int endY, double percent, double smallest, double angle)
    {
        frame= new JFrame();
        frame.setSize(WIDTH, HEIGHT);
        FractalTree fTree= new FractalTree( startX, startY, endX, endY, percent, smallest, angle);
        this.frame.add(fTree);
        this.frame.setVisible(true);
    }

}
