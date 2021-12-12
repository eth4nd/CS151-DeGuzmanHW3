package hw3.controller;

public class AddColorMessage implements Message{
    private int red;
    private int green;
    private int blue;

    public AddColorMessage(int r, int g, int b)
    {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getRed()
    {
        return red;
    }

    public int getGreen()
    {
        return green;
    }

    public int getBlue()
    {
        return blue;
    }

}
