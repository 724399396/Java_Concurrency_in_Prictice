package excutor.pool;

import java.util.*;

public interface Puzzle<P, M> {
	P initialPosition();
	boolean isGoal(P postion) ;
	Set<M> legalMoves(P position);
	P move (P postion, M move);
}
