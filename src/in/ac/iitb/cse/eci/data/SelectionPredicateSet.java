package in.ac.iitb.cse.eci.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SelectionPredicateSet extends PredicateSet {
	private Map<EntityVariable, SelectionPredicateSet> variableWiseGroup;

	/**
	 * Groups selection predicates in this set by their variable name
	 * 
	 * @return Map<EntityVariable, SelectionPredicateSet>
	 */
	public Map<EntityVariable, SelectionPredicateSet> groupByVariable() {
		variableWiseGroup = new HashMap<EntityVariable, SelectionPredicateSet>();
		SelectionPredicateSet predicates = null;
		EntityVariable var = null;
		for (Predicate pred : predicateSet) {
			var = ((SelectionPredicate) pred).getVariable();
			predicates = variableWiseGroup.get(var);
			if (null == predicates) {
				predicates = new SelectionPredicateSet();
				variableWiseGroup.put(var, predicates);
			}
			predicates.addPredicate(pred);
		}
		return variableWiseGroup;
	}
}
