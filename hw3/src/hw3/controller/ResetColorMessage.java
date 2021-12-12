package hw3.controller;

public class ResetColorMessage implements Message{
    private int red;
    private int green;
    private int blue;

    public ResetColorMessage(int r, int g, int b)
    {
        this.red = r;
        this.green = g;
        this.blue = b;
    }

    public int getRed()
    {
        return 0;
    }

    public int getGreen()
    {
        return 0;
    }

    public int getBlue()
    {
        return 0;
    }


}
