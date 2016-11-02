package in.ac.iitb.cse.eci.data;

import java.util.HashSet;
import java.util.Set;

public class PredicateSet {

	protected Set<Predicate> predicateSet;

	public PredicateSet() {
		predicateSet = new HashSet<Predicate>();
	}

	public Set<Predicate> getAll() {
		return predicateSet;
	}

	public void addPredicate(Predicate pred) {
		predicateSet.add(pred);
	}

	public void addPredicates(PredicateSet preds) {
		predicateSet.addAll(preds.getAll());
	}

	public int size() {
		return null != predicateSet ? predicateSet.size() : 0;
	}

	/**
	 * Splits relation predicates in this set of predicates into corresponding
	 * selection predicates
	 * 
	 * @return SelectionPredicateSet
	 */
	public SelectionPredicateSet splitRelationPredicates() {
		SelectionPredicateSet selectionPredicates = new SelectionPredicateSet();
		for (Predicate pred : predicateSet) {
			if (pred.isSelectionPredicate())
				selectionPredicates.addPredicate(pred);
			else
				selectionPredicates.addPredicates(((RelationPredicate) pred)
						.splitRelationPredicate());
		}
		return selectionPredicates;
	}

	public Set<Constraint> getConstraintsCollection() {
		Set<Constraint> constraintsSet = new HashSet<Constraint>();
		for (Predicate pred : predicateSet)
			constraintsSet.add(pred.constraint);
		return constraintsSet;
	}
}
