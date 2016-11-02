package in.ac.iitb.cse.eci.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityJoinedResultSet {

	private Set<EntityJoinedResult> joinedResultSet;

	public EntityJoinedResultSet() {
		joinedResultSet = new HashSet<EntityJoinedResult>();
	}

	public void addResult(SelectionQueryResult teResult, SelectionQueryResult edResult) {
		EntityJoinedResult joinedResult = new EntityJoinedResult(
				teResult.getEntityId(), teResult.getPostingList(),
				edResult.getPostingList());
		joinedResultSet.add(joinedResult);
	}

	public Iterator<EntityJoinedResult> iterator() {
		return joinedResultSet.iterator();
	}

}
