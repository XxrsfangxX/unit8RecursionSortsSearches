import javax.swing.JFrame;

public class LogSpiralFrame extends JFrame
{
private LogSpiralPanel canvas;
public LogSpiralFrame()
{
canvas = new LogSpiralPanel();
add(canvas);
setSize(500,500);
}
public static void main(String[] args)
{
JFrame frame = new LogSpiralFrame();
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.setVisible(true);
}
}