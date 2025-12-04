import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameGUI extends JFrame {

    private JTextField nameField;
    private JTextField healthField;
    private JTextField xField;
    private JTextField yField;
    private JComboBox<String> colliderBox;
    private JTextArea outputArea;

    
    
    private static final String CSV_PATH = "./src/enemies.csv";

    public GameGUI() {
        super("Game Setup");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 500);
        setLocationRelativeTo(null);

        buildLayout();
    }

    
    private void buildLayout() {

        JPanel mainPanel = new JPanel(new BorderLayout());
        getContentPane().add(mainPanel);

        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(6, 2, 5, 15));
        leftPanel.setPreferredSize(new Dimension(250, 500));

        leftPanel.add(new JLabel("Ime"));
        nameField = new JTextField("Harry Poter");   
        leftPanel.add(nameField);

        leftPanel.add(new JLabel("Health (0–100)"));
        healthField = new JTextField("90");          
        leftPanel.add(healthField);

        leftPanel.add(new JLabel("X pozicija"));
        xField = new JTextField("12");               
        leftPanel.add(xField);

        leftPanel.add(new JLabel("Y pozicija"));
        yField = new JTextField("9");             
        leftPanel.add(yField);

        leftPanel.add(new JLabel("Kolajder"));
        colliderBox = new JComboBox<>(new String[]{"Rectangle", "Circle"});
        colliderBox.setSelectedIndex(0);            
        leftPanel.add(colliderBox);

        mainPanel.add(leftPanel, BorderLayout.WEST);

        JPanel rightEmptyPanel = new JPanel();
        mainPanel.add(rightEmptyPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());

        JButton startButton = new JButton("Pokreni igru");
        startButton.setPreferredSize(new Dimension(200, 50));
        startButton.addActionListener(e -> runGame());
        bottomPanel.add(startButton, BorderLayout.WEST);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scroll = new JScrollPane(outputArea);
        bottomPanel.add(scroll, BorderLayout.CENTER);

        mainPanel.add(bottomPanel, BorderLayout.SOUTH);
    }

    private void runGame() {

        try {
            String name = nameField.getText().trim();
            int health = Integer.parseInt(healthField.getText().trim());
            int x = Integer.parseInt(xField.getText().trim());
            int y = Integer.parseInt(yField.getText().trim());

            boolean isHajdana = name.equalsIgnoreCase("Hajdana");
            if (isHajdana) {
                health = 5000;
            }

            Collidable playerCollider;
            if (colliderBox.getSelectedItem().equals("Rectangle")) {
                playerCollider = new RectangleCollider(x, y, isHajdana ? 300 : 32, isHajdana ? 300 : 32);
            } else {
                playerCollider = new CircleCollider(x, y, isHajdana ? 150 : 16);
            }

            Player player = new Player(name, x, y, health, playerCollider);
            Game game = new Game(player);
            List<Enemy> loadedEnemies = Game.loadEnemiesFromCSV(CSV_PATH);
            for (Enemy e : loadedEnemies) game.addEnemy(e);

            game.resolveCollisions();

            StringBuilder sb = new StringBuilder();

            sb.append("=== IGRAC ===\n");
            sb.append(game.getPlayer()).append("\n\n");

            sb.append("=== NEPRIJATELJI ===\n");
            for (Enemy e : game.getEnemies()) sb.append(e).append("\n");
            sb.append("\n");

            sb.append("=== KOLIZIJE ===\n");
            List<Enemy> col = game.collidingWithPlayer();
            if (col.isEmpty()) sb.append("Nema kolizija.\n");
            else for (Enemy e : col) sb.append(e.getDisplayName()).append("\n");

            sb.append("\n=== EVENT LOG ===\n");
            for (String log : game.getLog()) sb.append(log).append("\n");

            outputArea.setText(sb.toString());

            if (game.getPlayer().getHealth() <= 0)
                JOptionPane.showMessageDialog(this, "Igrač je poražen!", "Kraj", JOptionPane.ERROR_MESSAGE);
            else
                JOptionPane.showMessageDialog(this, "Igrač je preživio!", "Kraj", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Greška: " + ex.getMessage());
        }
    }

    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameGUI gui = new GameGUI();
            gui.setVisible(true);
        });
    }
}