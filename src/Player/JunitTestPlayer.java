package Player;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class JunitTestPlayer {

	
	@Test
	void testMove() {
		Player p = new Player(1,1);
		Assertions.assertArrayEquals(new boolean[]{true,false,true,true}, p.move("north"),"Die Wände sind falsch angeordnet");
		Assertions.assertArrayEquals(new boolean[]{true,false,true,false}, p.move("north"),"Die Wände sind falsch angeordnet");
	}

}
