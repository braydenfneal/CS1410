package a11;

/**
 * A special Zombie actor that causes the plant to shift its
 * position down one row and out of the way so it can get through once
 * both collide.
 */
public class SpecialZombie extends Zombie {
	private static final int HEALTH = 5;
	private static final int COOL_DOWN = 10;
	private static final int SPEED = -1;
	private static final int ATTACK_DAMAGE = 30;
	private static int specialCoolDown = 0;

	/**
     * Creates a zombie. For parameter descriptions, see Actor.
     */
	public SpecialZombie(int xPosition, int yPosition, int size, String imgPath, int health, int coolDown, int speed,
			int attackDamage) {
		super(xPosition, yPosition, size, "src/a11/averageBusiness.png", HEALTH, COOL_DOWN, SPEED,
				ATTACK_DAMAGE);
	}

	/**
	 * An attack only happens when two hitboxes are overlapping and the
	 * Zombie is ready to attack again (based on its cooldown).
	 * 
	 * Zombies only attack Plants.
	 */
	@Override
	public void actOn(Plant other) {
		if (isColliding(other)) {
			if (isReadyForAction()) {
				other.changeHealth(-attackDamage);
				if (specialCoolDown == 4) {
					other.shiftPosition(0, 75);
					specialCoolDown = 0;
				}
				specialCoolDown++;
				resetCoolDown();
			}
		}
	}

}