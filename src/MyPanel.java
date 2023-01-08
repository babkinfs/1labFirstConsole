import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MyPanel extends JPanel {

    public MyPanel() {
        setBorder(BorderFactory.createLineBorder(Color.black));
    }

    public Dimension getPreferredSize() {
        return new Dimension(1560,700);
    }
    private int x = 0;
    private int y = 0;
    private int width = 100;
    private int height = 100;
    private String[] numbers = null;
    private int otstup = 1;
    private List<MyPolygon> myPolygons = new ArrayList<>();

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Text
        //g.drawString("This is my custom Panel!",10,20);
        //g.drawLine(x,y,width, height);
        for (MyPolygon myPolygon:myPolygons) {
            int[] polygonX = myPolygon.getPolygonX();
            if (polygonX != null) {
                g.drawPolyline(polygonX, myPolygon.getPolygonY(), polygonX.length);
            }
        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers.replaceAll(" ", "").split(",");
        int index = 0;
        for (String number:this.numbers){
            int tempOtstup = index*(otstup+width);
            List<Integer> polygonX = new ArrayList<>();
            List<Integer> polygonY = new ArrayList<>();
            switch (number){
                case "0":
                    polygonX.add(x+tempOtstup);
                    polygonY.add(y);
                    polygonX.add(x+width);
                    polygonY.add(y);
                    polygonX.add(x+width);
                    polygonY.add(y+height);
                    polygonX.add(x);
                    polygonY.add(y+height);
                    polygonX.add(x);
                    polygonY.add(y);
                    break;
                case "1":
                    polygonX.add(x+tempOtstup);
                    polygonY.add(y+height/2);
                    polygonX.add(x+tempOtstup+width);
                    polygonY.add(y);
                    polygonX.add(x+tempOtstup+width);
                    polygonY.add(y+height);
                    break;
                case "2":
                    polygonX.add(x+tempOtstup);
                    polygonY.add(y);
                    polygonX.add(x+tempOtstup+width);
                    polygonY.add(y);
                    polygonX.add(x+tempOtstup+width);
                    polygonY.add(y+height/2);
                    polygonX.add(x+tempOtstup);
                    polygonY.add(y+height/2);
                    polygonX.add(x+tempOtstup);
                    polygonY.add(y+height);
                    polygonX.add(x+tempOtstup+width);
                    polygonY.add(y+height);
                    break;
            }
            myPolygons.add(new MyPolygon(polygonX, polygonY));
            index++;
        }
    }
    public void setOtstup(int otstup) {
        this.otstup = otstup;
    }
}
