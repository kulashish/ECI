package in.ac.iitb.cse.eci.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class QueryResultSet {

	private String queryTerm;
	private Set<AbstractQueryResult> resultSet;

	public QueryResultSet() {
		resultSet = new HashSet<AbstractQueryResult>();
	}

	public Set<AbstractQueryResult> getResultSet() {
		return resultSet;
	}

	public Iterator<AbstractQueryResult> iterator() {
		return resultSet.iterator();
	}

	public void addQueryResult(AbstractQueryResult result) {
		resultSet.add(result);
	}

	public Set<AbstractQueryResult> getAll() {
		return resultSet;
	}

	public PostingList getPostingList(int eid) {
		PostingList pl = null;
		for (AbstractQueryResult result : resultSet)
			if (eid == ((SelectionQueryResult) result).entityId)
				pl = ((SelectionQueryResult) result).postingList;
		return pl;
	}
}
