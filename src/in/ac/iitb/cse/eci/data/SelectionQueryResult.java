package in.ac.iitb.cse.eci.data;

import java.util.List;

public class SelectionQueryResult extends AbstractQueryResult {

	protected int entityId;
	protected PostingList postingList;

	public SelectionQueryResult() {

	}

	public SelectionQueryResult(int eid, PostingList pl) {
		entityId = eid;
		postingList = pl;
	}

	public int getEntityId() {
		return entityId;
	}

	public PostingList getPostingList() {
		return postingList;
	}

	public List<Posting> getAllPostings() {
		return getPostingList().getPostingList();
	}
}
