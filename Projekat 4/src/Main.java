import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	     // Player: pravougaoni kolajder 32x32
		RectangleCollider playerCollider = new RectangleCollider(10, 5, 32, 32);
		Player player = new Player(10, 5, playerCollider, "Petar Petrović", 85);

		Game game = new Game(player);

		// Neprijatelj 1: ručno (pravougaonik)
		RectangleCollider enemy1Collider = new RectangleCollider(12, 5, 16, 16); 
		Enemy enemy1 = new MeleeEnemy("Goblin", 12, 5, enemy1Collider, 20, 60);
		game.addEnemy(enemy1);

        // Neprijatelj 2: kružni boss iz stringa
        Enemy enemy2 = Game.parseEnemy("Goblin King;50,20;32x32;25;boss");
        game.addEnemy(enemy2);

        
        System.out.println("\nPretraga po tipu 'gob':");
        ArrayList<Enemy> gobEnemies = game.findByType("gob");
        for (Enemy e : gobEnemies) {
            System.out.println("  " + e.getDisplayName());
        }

        System.out.println("\nStanje igraca prije resolveCollisions():");
        System.out.println(player);

        System.out.println("\nNeprijatelji koji se trenutno sudaraju s igracem:");
        for (Enemy e : game.collidingWithPlayer()) {
            System.out.println("  " + e.getDisplayName());
        }

        game.resolveCollisions();

        System.out.println("\nStanje igraca poslije resolveCollisions():");
        System.out.println(player);

        System.out.println("\nDnevnik dogadjaja:");
        for (String log : game.getEventLog()) {
            System.out.println("  " + log);
        }
	}

}
