package frames;

import panels.ActionPanel;

public class MainRouter {

    private MainFrame frame;

    public MainRouter(MainFrame frame) {
        this.frame = frame;
    }

    public void showActionPanel() {
        ActionPanel actionPanel = new ActionPanel(frame);
        frame.setContentPane(actionPanel);
        frame.validate();
    }
}
