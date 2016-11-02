package in.ac.iitb.cse.eci.retrieval;

import in.ac.iitb.cse.eci.data.Constraint;
import in.ac.iitb.cse.eci.data.EntityType;
import in.ac.iitb.cse.eci.data.Predicate;
import in.ac.iitb.cse.eci.data.QueryResultSet;
import in.ac.iitb.cse.eci.data.SelectionPredicate;
import in.ac.iitb.cse.eci.data.SelectionPredicateSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class EntityCentricIndexSearcher {

	public static EntityCentricIndexSearcher getInstance() {
		return null;
	}

	public QueryResultSet search(EntityType type) {
		return null;
	}

	public QueryResultSet search(Set<Constraint> constraints) {
		return null;
	}

	public QueryResultSet search(EntityType type, Set<Constraint> constraints) {
		return null;
	}

	public Map<SelectionPredicate, QueryResultSet> search(
			SelectionPredicateSet selectionPredicateSet) {
		Map<SelectionPredicate, QueryResultSet> predicateResultMap = new HashMap<SelectionPredicate, QueryResultSet>();
		SelectionPredicate selecPred = null;
		for (Predicate pred : selectionPredicateSet.getAll()) {
			selecPred = (SelectionPredicate) pred;
			if (!predicateResultMap.containsKey(selecPred))
				predicateResultMap.put(selecPred,
						search(selecPred.getConstraint()));
		}
		return predicateResultMap;
	}

	private QueryResultSet search(Constraint constraint) {
		return null;
	}
}
