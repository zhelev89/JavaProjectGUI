package frames;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainRouter router;
    public MainDataProvider dataProvider;

    public MainFrame() {
        super("Stopwatch");
        setSize(420, 305);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        router = new MainRouter(this);
        dataProvider = new MainDataProvider(this);

        //from here we show stopwatch
        router.showStopwatchPanel();

    }
}
