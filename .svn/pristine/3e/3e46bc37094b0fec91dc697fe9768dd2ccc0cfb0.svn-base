package in.ac.iitb.cse.eci.retrieval;

import java.util.Iterator;

import in.ac.iitb.cse.eci.data.AbstractQueryResult;
import in.ac.iitb.cse.eci.data.EntityJoinedResult;
import in.ac.iitb.cse.eci.data.EntityJoinedResultSet;
import in.ac.iitb.cse.eci.data.Posting;
import in.ac.iitb.cse.eci.data.SelectionQueryResult;
import in.ac.iitb.cse.eci.data.QueryResultSet;

public class EntityCentricResultJoiner {

	/**
	 * Joins a term-entity result set and an entity-document result set on their
	 * entity-id. The joined result set contains only those entities common to
	 * the two result sets along with their term-entity posting list and
	 * entity-document posting list. The two original result sets are assumed to
	 * be sorted on entity-id.
	 * 
	 * @param teResultSet
	 * @param edResultSet
	 * @return EntityJoinedResultSet
	 */
	public EntityJoinedResultSet joinOnEntity(QueryResultSet teResultSet,
			QueryResultSet edResultSet) {
		EntityJoinedResultSet joinedResultSet = new EntityJoinedResultSet();
		Iterator<AbstractQueryResult> teIter = teResultSet.iterator();
		Iterator<AbstractQueryResult> edIter = edResultSet.iterator();
		SelectionQueryResult teResult = null;
		SelectionQueryResult edResult = null;

		while (teIter.hasNext()) {
			teResult = (SelectionQueryResult) teIter.next();
			while (edIter.hasNext()) {
				edResult = (SelectionQueryResult) edIter.next();
				if (edResult.getEntityId() > teResult.getEntityId())
					break;
				else if (edResult.getEntityId() == teResult.getEntityId())
					joinedResultSet.addResult(teResult, edResult);
			}
		}
		return joinedResultSet;
	}

	public void joinOnOccurrence(EntityJoinedResultSet entityJoinedResultSet) {
		Iterator<EntityJoinedResult> iter = entityJoinedResultSet.iterator();
		EntityJoinedResult result = null;
		while (iter.hasNext()) {
			result = iter.next();
			result.joinOnOccur();
		}

	}

	public void joinOnDocSent(QueryResultSet[] resultsets) {
		QueryResultSet pivotResultSet = resultsets[0];
		QueryResultSet joinedResultSet = new QueryResultSet();
		for (AbstractQueryResult pivotResult : pivotResultSet.getAll())
			for (int i = 1; i < resultsets.length; i++) {
				joinOnDocSent(pivotResult, resultsets[i]);
			}
	}

	private void joinOnDocSent(AbstractQueryResult pivotResult,
			QueryResultSet queryResultSet) {
		SelectionQueryResult sQueryResult = null;
		SelectionQueryResult sPivotResult = null;
		if (pivotResult instanceof SelectionQueryResult)
			sPivotResult = (SelectionQueryResult) pivotResult;
		for (Posting posting : sPivotResult.getAllPostings()) {
			for (AbstractQueryResult queryResult : queryResultSet.getAll()) {
				sQueryResult = (SelectionQueryResult) queryResult;
			}
		}
	}
}
