package com.example.aaron.test.gui;

public enum ColorTheme {
    white, black, gray, darkGray, red, yellow, green, purple, cyan, blue ;
    /**
     * Gives the direction that results from a 90 degree clockwise rotation
     * applied to the current direction.
     * @return direction after 90 degree clockwise rotation
     */
    public int getColorCode() {
        switch (this) {
            case white:
                return MazePanel.getColorEncoding(0, 0, 0);
            case black:
                return MazePanel.getColorEncoding(255, 255, 255);
            case gray:
                return MazePanel.getColorEncoding(150, 150, 150);
            case darkGray:
                return MazePanel.getColorEncoding(200, 200, 200);
            case red:
                return MazePanel.getColorEncoding(255, 0, 0);
            case yellow:
                return MazePanel.getColorEncoding(255, 255, 0);
            case green:
                return MazePanel.getColorEncoding(0, 255, 0);
            case purple:
                return MazePanel.getColorEncoding(255, 0, 255);
            case cyan:
                return MazePanel.getColorEncoding(0, 255, 255);
            case blue:
                return MazePanel.getColorEncoding(0, 0, 255);
            default:
                throw new RuntimeException("Inconsistent enum type");
        }
    }
}
