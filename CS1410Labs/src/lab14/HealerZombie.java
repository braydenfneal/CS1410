package lab14;

public class HealerZombie extends Zombie {
	private static final int HEALTH = 20;
	private static final int COOLDOWN = 30;
	private static final int SPEED = -1;
	private static final int ATTACK_DAMAGE = 0;
	private static final int HEAL = 10;

	
	public HealerZombie(int xPosition, int yPosition, int size) {
		super(xPosition, yPosition, size, 
				"src/lab14/Animal-Icons/black-cat-icon.png", HEALTH, COOLDOWN, SPEED, ATTACK_DAMAGE);
	}
	
	@Override
	public void actOn(Zombie other) {
		if (isOverlapping(this, other) && !(other instanceof HealerZombie) && other.health <= other.fullHealth) {
			if (isReadyForAction()) {
				other.changeHealth(HEAL);
				resetCoolDown();
			}
		}
	}
}
