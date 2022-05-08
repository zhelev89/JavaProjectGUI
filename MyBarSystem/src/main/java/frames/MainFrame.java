package frames;

import javax.swing.*;
import java.io.IOException;
import java.net.http.HttpClient;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    public MainDataProvider dataProvider;
    public MainRouter router;

    public MainFrame() throws IOException, InterruptedException {
        super("Advance Bar");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(895, 584);
        setResizable(false);
        dataProvider = new MainDataProvider(this);
        dataProvider.fetchUsers();
        dataProvider.fetchTables();
        dataProvider.fetchCategories();
        dataProvider.orders = new ArrayList<>();

        //First panel to be loaded on start
        router = new MainRouter(this);
        router.showLoginPanel();
    }
}