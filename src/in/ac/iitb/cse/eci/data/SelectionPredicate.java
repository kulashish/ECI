package in.ac.iitb.cse.eci.data;

public class SelectionPredicate extends Predicate {

	public SelectionPredicate(EntityVariable v, Constraint c) {
		variables = new EntityVariableSet();
		variables.addEntityVariable(v);
		constraint = c;
	}

	public EntityVariable getVariable() {
		return variables.get(0);
	}
}
