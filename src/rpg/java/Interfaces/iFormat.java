package rpg.java.Interfaces;

import rpg.java.Difficulty;

public interface iFormat {
    public default String ordinal(int i) {
        String[] suffixes = new String[] { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th" };
        switch (i % 100) {
        case 11:
        case 12:
        case 13:
            return i + "th";
        default:
            return i + suffixes[i % 10];
    
        }
    }
    public default String difficultyStars(Difficulty diff){
        switch(diff){
            case EASY:
                return "★";
            case NORMAL:
                return "★★";
            case HARD:
                return "★★★";
            default:
                return "";
        }
    }
}
