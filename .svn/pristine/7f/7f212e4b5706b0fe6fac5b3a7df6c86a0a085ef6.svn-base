package in.ac.iitb.cse.eci.retrieval;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import in.ac.iitb.cse.eci.data.Constraint;
import in.ac.iitb.cse.eci.data.EntityJoinedResult;
import in.ac.iitb.cse.eci.data.EntityJoinedResultSet;
import in.ac.iitb.cse.eci.data.EntityType;
import in.ac.iitb.cse.eci.data.EntityVariable;
import in.ac.iitb.cse.eci.data.EntityVariableSet;
import in.ac.iitb.cse.eci.data.PostingList;
import in.ac.iitb.cse.eci.data.Predicate;
import in.ac.iitb.cse.eci.data.PredicateSet;
import in.ac.iitb.cse.eci.data.Query;
import in.ac.iitb.cse.eci.data.SelectionQueryResult;
import in.ac.iitb.cse.eci.data.QueryResultSet;
import in.ac.iitb.cse.eci.data.RelationPredicate;
import in.ac.iitb.cse.eci.data.SelectionPredicate;
import in.ac.iitb.cse.eci.data.SelectionPredicateSet;

public class EntityCentricRetrieval {
	private Query query;

	public void retrieve() {
		EntityVariableSet variables = query.getVariables();
		PredicateSet predicateSet = query.getPredicates();
		Map<EntityVariable, SelectionPredicateSet> sPredicatesGroupedByVariable = predicateSet
				.splitRelationPredicates().groupByVariable();
		SelectionPredicateSet selectionPredicateSet = null;
		Iterator<EntityType> typeIter = query.getTypes().iterator();
		EntityType type = null;
		Set<Constraint> constraintsSet = null;
		QueryResultSet typeQueryResultSet = null;
		QueryResultSet termQueryResultSet = null;
		EntityJoinedResultSet entityJoinedResultSet = null;
		PostingList occurJoinedPostingList = null;
		SelectionQueryResult occurrenceJoinedResult = null;
		Map<SelectionPredicate, QueryResultSet> termQueryResultsetMap = null;
		Map<Predicate, QueryResultSet> occurrenceJoinedResultsetMap = new HashMap<Predicate, QueryResultSet>();
		Map<Predicate, QueryResultSet> finalResultSetMap = new HashMap<Predicate, QueryResultSet>();
		Map<EntityVariable, EntityJoinedResultSet> resultSetGroupedByVariable = new HashMap<EntityVariable, EntityJoinedResultSet>();

		EntityCentricIndexSearcher searcher = EntityCentricIndexSearcher
				.getInstance();
		EntityCentricResultJoiner joiner = new EntityCentricResultJoiner();

		for (EntityVariable variable : variables.getAll()) {
			type = typeIter.next();
			selectionPredicateSet = sPredicatesGroupedByVariable.get(variable);
			constraintsSet = selectionPredicateSet.getConstraintsCollection();

			typeQueryResultSet = searcher.search(type);
			termQueryResultSet = searcher.search(constraintsSet);
			termQueryResultsetMap = searcher.search(selectionPredicateSet);

			entityJoinedResultSet = joiner.joinOnEntity(termQueryResultSet,
					typeQueryResultSet);

			Iterator<EntityJoinedResult> iter = entityJoinedResultSet
					.iterator();
			while (iter.hasNext()) {
				EntityJoinedResult joinedResult = iter.next();
				for (Predicate sp : selectionPredicateSet.getAll()) {
					occurJoinedPostingList = joinedResult
							.joinOnOccur(termQueryResultsetMap.get(sp)
									.getPostingList(joinedResult.getEntityId()));
					occurrenceJoinedResult = new SelectionQueryResult(
							joinedResult.getEntityId(), occurJoinedPostingList);
					QueryResultSet occurJoinedResultset = occurrenceJoinedResultsetMap
							.get(sp);
					if (null == occurJoinedResultset) {
						occurJoinedResultset = new QueryResultSet();
						occurrenceJoinedResultsetMap.put(sp,
								occurJoinedResultset);
					}
					occurJoinedResultset.addQueryResult(occurrenceJoinedResult);
				}
			}
		}

		for (Predicate pred : predicateSet.getAll()) {
			if (pred.isSelectionPredicate())
				finalResultSetMap.put(pred,
						occurrenceJoinedResultsetMap.get(pred));
			else {
				SelectionPredicateSet predSet = ((RelationPredicate) pred)
						.getSplitPredicates();
				QueryResultSet[] queryResults = new QueryResultSet[predSet
						.size()];
				int resultIndex = 0;
				for (Predicate p : predSet.getAll())
					queryResults[resultIndex++] = occurrenceJoinedResultsetMap
							.get(p);
			}
		}
	}
}
