package hw3.controller;

import hw3.model.Model;
import hw3.view.View;

import java.util.concurrent.BlockingQueue;

public class Controller {
    BlockingQueue<Message> queue;
    Model model;
    View view;

    public Controller(BlockingQueue<Message> queue, Model model, View view)
    {
        this.queue = queue;
        this.model = model;
        this.view = view;
    }

    public void mainLoop()
    {
        while (view.isDisplayable())
        {
            Message message = null;
            try {
                message = queue.take();
            } catch (InterruptedException exception)
            {

            }

            if(message.getClass() == AddColorMessage.class)
            {
                AddColorMessage newMessage = (AddColorMessage) message;
                model.setBlue(newMessage.getBlue());
                model.setGreen(newMessage.getGreen());
                model.setRed(newMessage.getRed());
                view.updateColorsInView(model.getBlue(), model.getGreen(), model.getRed());
            }
            else if(message.getClass() == ResetColorMessage.class)
            {
                ResetColorMessage newMessage = (ResetColorMessage) message;
                model.setBlue(newMessage.getBlue());
                model.setGreen(newMessage.getGreen());
                model.setRed(newMessage.getRed());
                view.resetColorsInView(0, 0, 0);
            }
        }
    }

}
