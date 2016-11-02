package in.ac.iitb.cse.eci.data;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class EntityVariableSet {

	private Set<EntityVariable> varSet;

	public EntityVariableSet() {
		varSet = new HashSet<EntityVariable>();
	}

	public int size() {
		return varSet.size();
	}

	public Set<EntityVariable> getAll() {
		return varSet;
	}

	public void addEntityVariable(EntityVariable var) {
		varSet.add(var);
	}

	public EntityVariable get(int index) {
		EntityVariable var = null;
		Iterator<EntityVariable> iter = varSet.iterator();
		if (index < size())
			for (int i = 0; i <= index; i++)
				var = iter.next();
		return var;
	}
}
