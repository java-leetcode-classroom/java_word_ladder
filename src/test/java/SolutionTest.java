import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    final private Solution sol = new Solution();
    @Test
    void ladderLengthExample1() {
        assertEquals(5, sol.ladderLength("hit", "cog",
                List.of("hot","dot","dog","lot","log","cog")));
    }
    @Test
    void ladderLengthExample2() {
        assertEquals(0, sol.ladderLength("hit", "cog",
                List.of("hot","dot","dog","lot","log")));
    }
}
