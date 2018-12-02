package Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTestPlayer {

	
	@Test
	void testMove() {
		Player p = new Player(1,1);
		Assertions.assertEquals(true, p.move("north"),"Die Richtung ist blockiert");
		Assertions.assertEquals(false, p.move("west"),"Die Richtung ist blockiert");
	}

}
