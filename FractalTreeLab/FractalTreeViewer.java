import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.Scanner;
public class FractalTreeViewer 
{

    private final int WIDTH = 1200;
    private final int HEIGHT = 900;
    private JFrame frame;
    
    

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
        frame.setTitle("FRACTAL TREE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FractalTree fTree= new FractalTree( startX, startY, endX, endY, percent, smallest, angle);
        this.frame.add(fTree);
        this.frame.setVisible(true);
    }
    public static void main(String[] args)
    {
        // initialise instance variables
       Scanner scan= new Scanner(System.in);
       System.out.println("What do you want your bottom xCordinate to be(int only): ");
       int x1= scan.nextInt();
       System.out.println("What do you want your bottom yCordinate to be (int only): ");
       int y1= scan.nextInt();
       System.out.println("What do you want your top xCordinate to be(if you want your line to be vertical make sure it is the same as the previous x coordinate): ");
       int x2= scan.nextInt();
       System.out.println("What do you want your top yCordinate to be(int only): ");
       int y2= scan.nextInt();
       System.out.println("What do you want the percent length change: ");
       double percent= scan.nextDouble();
       System.out.println("How small do you want to make the smallest length");
       double smallest= scan.nextInt();
       double angle= Math.PI/2;
       FractalTreeViewer viewer= new FractalTreeViewer(x1, y1, x2, y2, percent, smallest, angle);
       //calls fractal tree
    }   

}
