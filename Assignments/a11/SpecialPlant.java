package a11;

/**
 * 
 * A special Plant actor that when it collides with a 
 * Zombie actor it sends it back to the start of the row 
 *
 */
public class SpecialPlant extends Plant {
	private static final int HEALTH = 30;
	private static final int COOL_DOWN = 5;
	private static final int ATTACK_DAMAGE = 25;
	private static int specialCoolDown = 0;

	/**
     * Creates a plant. For parameter descriptions, see Actor.
     */
	public SpecialPlant(int xPosition, int yPosition, int size, String imgPath, int health, int coolDown,
			int attackDamage) {
		super(xPosition, yPosition, size, "src/a11/noAlchohol.png", HEALTH, COOL_DOWN, ATTACK_DAMAGE);
	}
	
	/**
	 * The special attack only happens when both are 
	 * colliding and the special is ready to attack again
	 * (based on its cooldown)
	 */
	@Override
	public void actOn(Zombie other) {
		if (isColliding(other)) {
			if (isReadyForAction()) {
				other.changeHealth(-attackDamage);
				if (specialCoolDown == 2) {
					other.shiftPosition(400, 0);
					specialCoolDown = 0;
				}
				specialCoolDown++;
				resetCoolDown();
			}
		}
	}
}
