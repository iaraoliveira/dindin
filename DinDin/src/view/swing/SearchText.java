package view.swing;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SearchText extends JFormattedTextField{

    public SearchText() {
        setBorder(new EmptyBorder(0, 0, 0, 0));
        setSelectionColor(new Color(220, 204, 182));
        
    }
    private final String hint = " Filtre por data ...";
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
        super.paintComponent(grphcs);
    }
}
