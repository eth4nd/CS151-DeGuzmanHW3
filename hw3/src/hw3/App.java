package hw3;

import hw3.controller.Controller;
import hw3.controller.Message;
import hw3.model.Model;
import hw3.view.View;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class App {
    public static void main(String[] args)
    {
        BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

        Model model = new Model();
        View view = new View(queue, model.getRed(), model.getGreen(), model.getBlue());
        Controller controller = new Controller(queue, model, view);
        controller.mainLoop();
    }

}
