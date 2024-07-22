package rpg.java.Interfaces;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public interface iGradient {
    public default void makeGradient(Graphics g, Color top, Color bottom){
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
        GradientPaint gp = new GradientPaint(0, 0, top, 0, h, bottom);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
    }
    public abstract int getWidth();
    public abstract int getHeight();
}
