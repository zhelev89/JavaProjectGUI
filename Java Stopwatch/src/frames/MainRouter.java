package frames;

import panels.StopwatchPanel;

public class MainRouter {

    private MainFrame frame;

    public MainRouter(MainFrame frame) {
        this.frame = frame;
    }

    public void showStopwatchPanel() {
        StopwatchPanel stopwatchPanel = new StopwatchPanel(frame);
        frame.setContentPane(stopwatchPanel);
        frame.validate();
    }
}
