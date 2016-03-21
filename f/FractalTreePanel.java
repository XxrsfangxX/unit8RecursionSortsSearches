+import java.awt.*;
+import javax.swing.JPanel;
+/**
+ * This class draws the fractal tree by using a recursion with trigonometry.
+ * 
+ * @author Eric Kim
+ * @version 3/18/2016
+ */
+public class FractalTreePanel extends JPanel
+{
+    //Panel width and height dimensions
+    private final int PANEL_WIDTH = 800;
+    private final int PANEL_HEIGHT = 800;
+
+    //Permanent instance variable for the length reduction number and angle number that the angle will be subtracted by
+    //Member variables
+    private final double ANGLE = Math.PI / 6;
+    private final double LENGTH_SCALE = .75;
+
+    //Keeps track of the order
+    private int current_order;
+
+    /**
+     * Default constructor for objects of class FractalTreePanel
+     */
+    public FractalTreePanel(int currentOrder)
+    {
+        //Initialize current_order instance variable to the order passed in from the viewer class
+        this.current_order = currentOrder;
+        this.setPreferredSize(new Dimension(this.WIDTH, this.HEIGHT));
+        this.setBackground(Color.BLACK);
+    }
+
+    /**
+     * drawFractal uses recursion and trigonemetry to repeatedly draw the next branchline with the correct angle
+     *
+     * @param x1, y1, x2, y2 are points for the initial line
+     */
+    public void drawFractal(int order, int x1, int y1, int x2, int y2, double newAngle, Graphics g2)
+    {
+        double dX, dY, PositiveX, PositiveY, NegativeX, NegativeY;
+        //Draws the initial line if order equals 1
+        if (order == 1)
+        {
+            g2.drawLine(x1, y1, x2, y2);
+        }
+        //Draws two branches if order is greater than 1
+        else
+        {
+            //Creating a new x and y for the new and shorter length of the branch
+            dX = x2 - x1;
+            dY = y2 - y1;
+            //Changing the branches color if the order is on a even number
+            if (order % 2 == 0)
+            {
+                g2.setColor(Color.green);
+            }
+            //Changing the branches color if the order's remainder equals 0 when divided by 3
+            else if(order % 3 == 0)
+            {
+                g2.setColor(Color.yellow);
+            }
+            //Changes the branches color if the order is on a odd number
+            else
+            {
+                g2.setColor(Color.red);
+            }
+
+            g2.drawLine(x1, y1, x2, y2);
+            //Creates the shorter branch by multiplying the old branch length by langth scale
+            double length = (Math.sqrt(dX * dX + dY * dY)) * LENGTH_SCALE;
+
+            //Creates two new angles, one that adds angle, and one that subtract angle
+            double newPositiveAngle = newAngle + ANGLE;
+            double newNegativeAngle = newAngle - ANGLE;
+
+            //Uses trigonometry to determine the next angle of the branch
+            PositiveX = x2 - Math.sin(newPositiveAngle) * length;
+            PositiveY = y2 - Math.cos(newPositiveAngle) * length;
+
+            NegativeX = x2 - Math.sin(newNegativeAngle) * length;
+            NegativeY = y2 - Math.cos(newNegativeAngle) * length;
+
+            //Recursion step, calls drawFractal again to loop the method
+            this.drawFractal(order - 1, x2, y2, (int) PositiveX, (int) PositiveY, newPositiveAngle, g2);
+            this.drawFractal(order - 1, x2, y2, (int) NegativeX, (int) NegativeY, newNegativeAngle, g2);
+        }
+    }
+
+    /**
+     * Calls the drawFractal method
+     * @param Graphics g
+     */
+    public void paintComponent(Graphics g)
+    {
+        Graphics g2 = (Graphics2D) g;
+        super.paintComponent (g2);
+        //Calls the drawFractal method with the required parameter variables
+        this.drawFractal(current_order, 600, 800, 600, 600, 0, g2);
+
+    }
+
+    /**
+     * Sets the instance variable current_order to order
+     * @param order is the number that current_order is going to be set to
+     */
+   public void setOrder(int order)
+    
+        //Initializes the current_order instance variable to the parameter variable order
+        this.current_order = order;+    }
} 