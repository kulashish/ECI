package in.ac.iitb.cse.eci.data;

public class Predicate {
	protected EntityVariableSet variables; // Vp
	protected Constraint constraint; // Cp

	public static Predicate createPredicate(EntityVariableSet vars, Constraint c) {
		if (vars.size() == 1)
			return new SelectionPredicate(vars.get(0), c);
		else
			return new RelationPredicate(vars, c);
	}

	public EntityVariableSet getVariables() {
		return variables;
	}

	public Constraint getConstraint() {
		return constraint;
	}

	public boolean isSelectionPredicate() {
		return variables.size() == 1;
	}

	public boolean isRelationPredicate() {
		return !isSelectionPredicate();
	}
}
