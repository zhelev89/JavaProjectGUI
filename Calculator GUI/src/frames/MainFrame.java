package frames;

import javax.swing.*;

public class MainFrame extends JFrame {

    public MainRouter router;
    public MainDataProvider dataProvider;

    public MainFrame() {
        super("Calculator");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(420, 550);
        setResizable(false);
        setLayout(null);
        dataProvider = new MainDataProvider(this);
        dataProvider.fetchFunctionButtons();
        dataProvider.fetchNumberButtons();

        //show actionPanel
        router = new MainRouter(this);
        router.showActionPanel();
    }
}
