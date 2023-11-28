
package view.component;

import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLayer;
import javax.swing.SwingUtilities;
import javax.swing.plaf.LayerUI;
import view.form.HomepageForm;


public class FloatingButton extends LayerUI<HomepageForm> {

    private Shape shape;
    private boolean mousePressed;
    private boolean mouseHovered;
    private Image image;
    private BufferedImage imageShadow;

    
    public FloatingButton() {
        String path = new File("src/view/icon/plus.png").getAbsolutePath();
        ImageIcon imageIcon = new ImageIcon(path); // load the image to a imageIcon
        image = imageIcon.getImage(); // transform it 
        
    }

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
        if(c instanceof JLayer){
            ((JLayer) c).setLayerEventMask(AWTEvent.MOUSE_EVENT_MASK|AWTEvent.MOUSE_MOTION_EVENT_MASK);
        }
    }

    @Override
    public void uninstallUI(JComponent c) {
        super.uninstallUI(c);
        super.installUI(c);
        if(c instanceof JLayer){
            ((JLayer) c).setLayerEventMask(0);
        }
    }
      
    @Override
    public void paint(Graphics g, JComponent c) {
        super.paint(g, c);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int size = 50;
        int x = c.getWidth() - size - 15;
        int y = c.getHeight() - size - 15;
        shape = new Ellipse2D.Double(x,y,size, size);
        if(mousePressed){
            g2.setColor(new Color(59,99,23));
        }else if(mouseHovered){
            g2.setColor(new Color(76,130,38));
        }else{
            g2.setColor(new Color(99,161,66));
        }
        g2.fill(shape);
        
        int iconSize = 24;
        int iconX=(size-iconSize)/2;
        int iconY=(size-iconSize)/2;
        
        g2.drawImage(image, x+iconX, y+iconY, null);
        g2.dispose();
    }

    @Override
    protected void processMouseEvent(MouseEvent e, JLayer<? extends HomepageForm> l) {
        if(mouseHovered){
            e.consume();
        }
        if(SwingUtilities.isLeftMouseButton(e)){
            if(e.getID()==MouseEvent.MOUSE_PRESSED){
                if(mouseHovered){
                    mousePressed = true;
                    l.repaint(shape.getBounds());

                }
            }else if (e.getID()==MouseEvent.MOUSE_RELEASED){
                mousePressed = false;
                l.repaint(shape.getBounds());
                if(mouseHovered){
                    HomepageForm home = l.getView();
                    home.actionButton();
                }

            }
        }
        Point point = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(),l.getView());
    }

    @Override
    protected void processMouseMotionEvent(MouseEvent e, JLayer<? extends HomepageForm> l) {
        Point point = SwingUtilities.convertPoint(e.getComponent(), e.getPoint(),l.getView());
        boolean hover = shape.contains(point);
        
        if (mouseHovered != hover) {
            mouseHovered=hover;
            l.repaint(shape.getBounds());
        }
        if(mousePressed){
            e.consume();
        }
        
    }
    
    private void createImageShadow(int size){
        int shadowSize = 6;
        int width = size + shadowSize * 2;
        int height = size + shadowSize * 2;
        imageShadow = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = imageShadow.createGraphics();
//        g2.drawImage(new ShadowRenderer(), xform, obs)
        g2.dispose();
    }
    
//    private BufferedImage createShape(int size){
//        BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
//        Graphics2D g2 = img.createGraphics();
//        g2.fill(new Ellipse2D.Double(0,0, size, size));
//        
//        g2.dispose();
//        return img;
//    }
    
    
    
    
    
    
}
