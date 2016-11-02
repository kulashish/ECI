package in.ac.iitb.cse.eci.data;

import java.util.Iterator;
import java.util.List;

public class EntityTypeMultiSet {
	private List<EntityType> typesList;

	public List<EntityType> getAll() {
		return typesList;
	}

	public int size() {
		return typesList.size();
	}

	public Iterator<EntityType> iterator() {
		return typesList.iterator();
	}
}
