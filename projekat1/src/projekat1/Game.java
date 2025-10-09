package projekat1;

//Hajdana Radanovic 24/158
//Elena Bozaric 24/070
//Damir Hadzic 24/062
public class Game {
	
	class Player {
		private int x;   //pozicije igraca
		private int y;
		private int width;   //dimenzije
		private int height;
		private int health;
		
		
		public Player(int x, int y, int width, int height, int health) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.health = health;
		}


		public int getX() {
			return x;
		}


		public void setX(int x) {
			this.x = x;
		}


		public int getY() {
			return y;
		}


		public void setY(int y) {
			this.y = y;
		}


		public int getWidth() {
			return width;
		}


		public void setWidth(int width) {
			this.width = width;
		}


		public int getHeight() {
			return height;
		}


		public void setHeight(int height) {
			this.height = height; 
		}


		public int getHealth() {
			return health;
		}


		public void setHealth(int health) {
			if(health < 0) {
				this.health = 0;
			} else if(health > 100) {
				this.health = 100;
			} else
				this.health = health;
	     }
	}
	
	class Enemy {
		private int x;   //pozicije igraca
		private int y;
		private int width;   //dimenzije
		private int height;
		private int damage;
		
		public Enemy(int x, int y, int width, int height, int damage) {
			this.x = x;
			this.y = y;
			this.width = width;
			this.height = height;
			this.damage = damage;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getWidth() {
			return width;
		}

		public void setWidth(int width) {
			this.width = width;
		}

		public int getHeight() {
			return height;
		}

		public void setHeight(int height) {
			this.height = height;
		}

		public int getDamage() {
			return damage;
		}

		public void setDamage(int damage) {
			if(damage<0) {
				this.damage = 0;
			} else if(damage > 100) {
				this.damage = 100;
			} else {
				this.damage = damage;
			}
		}
	}
		
		public boolean checkCollision(Player player, Enemy enemy) {
		    if (player.x < enemy.x + enemy.width && player.x + player.width > enemy.x &&
		        player.y < enemy.y + enemy.height && player.y + player.height > enemy.y) {
		        
		        int newHealth = player.getHealth() - enemy.damage;
		        
		        if (newHealth < 0) {
		        	newHealth = 0;
		        
		        }
		        player.setHealth(newHealth);
		        return true; //desio se sudar
		    }
		    return false;  //nema sudara
		}
		
		
		public void decreaseHealth(Player player, int damage) {
			int novoZdravlje = player.getHealth() - damage;
			
		    if (novoZdravlje < 0) novoZdravlje = 0;
		    player.setHealth(novoZdravlje);
			System.out.println("Zdravlje igrača je smanjeno za " + damage + ". Trenutno zdravlje: " + player.getHealth());
		}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Game igra = new Game();
	    Player igrac = igra.new Player(30, 40, 25, 25, 90);           
    	Enemy neprijateljA = igra.new Enemy(35, 45, 30, 30, 20);     
		Enemy neprijateljB = igra.new Enemy(100, 100, 25, 25, 50); 
		  
		System.out.println("Početno zdravlje igrača: " + igrac.getHealth());

		igra.checkCollision(igrac, neprijateljA);
	    System.out.println("Nakon sudara sa neprijateljem A, zdravlje: " + igrac.getHealth());
		igra.decreaseHealth(igrac, 35);
	    System.out.println("Nakon dodatnog oštećenja od 35, zdravlje: " + igrac.getHealth());
		igra.checkCollision(igrac, neprijateljB);
		System.out.println("Nakon pokušaja sudara sa neprijateljem B, zdravlje: " + igrac.getHealth());

	}
}
	
	

