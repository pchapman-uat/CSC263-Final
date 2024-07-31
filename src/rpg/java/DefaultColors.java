package rpg.java;

import java.awt.Color;

public class DefaultColors {
    public static final Color PURPLE = new Color(200,0,255);
    public static Color TwoColorRange(Color lowColor, Color highColor, float percent){
        if(percent == 0){
            return lowColor;
        } else if(percent == 1){
            return highColor;
        }

        int diffRed = (int) ((highColor.getRed() - lowColor.getRed()) * percent);
        int diffGreen = (int) ((highColor.getGreen() - lowColor.getGreen()) * percent);
        int diffBlue = (int) ((highColor.getBlue() - lowColor.getBlue()) * percent);

        int newRed = lowColor.getRed() + diffRed;
        int newGreen = lowColor.getGreen() + diffGreen;
        int newBlue = lowColor.getBlue() + diffBlue;

        return new Color(newRed, newGreen, newBlue);

    }
    public static Color ThreeColorRange(Color lowColor, Color midColor, Color highColor, float percent){
        if(percent == 1){
            return highColor;
        } 
        else if(percent == 0){
            return lowColor;
        } else {
            if(percent >= 0.5){
                return TwoColorRange(midColor, highColor, (float) (percent - 0.5));
            } else {
                return TwoColorRange(lowColor, midColor, (float) (percent + 0.5));
            }
        }
    }
}
