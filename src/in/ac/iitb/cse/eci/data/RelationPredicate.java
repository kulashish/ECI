package in.ac.iitb.cse.eci.data;

public class RelationPredicate extends Predicate {

	private SelectionPredicateSet splitPredicates;

	public RelationPredicate(EntityVariableSet vars, Constraint c) {
		variables = vars;
		constraint = c;
	}

	/**
	 * If this is a relation predicate, splits it into corresponding selection
	 * predicates
	 * 
	 * @return SelectionPredicateSet
	 */
	public SelectionPredicateSet splitRelationPredicate() {
		if (isRelationPredicate()) {
			splitPredicates = new SelectionPredicateSet();
			for (EntityVariable v : variables.getAll())
				splitPredicates.addPredicate(new SelectionPredicate(v,
						constraint));
		}
		return splitPredicates;
	}

	public SelectionPredicateSet getSplitPredicates() {
		return splitPredicates;
	}

}
