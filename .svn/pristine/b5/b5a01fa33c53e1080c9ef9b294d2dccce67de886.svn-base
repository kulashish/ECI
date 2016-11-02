package in.ac.iitb.cse.eci.data;

import in.ac.iitb.cse.eci.util.PostingListDocSentSorter;

public class EntityJoinedResult {

	public EntityJoinedResult() {

	}

	public EntityJoinedResult(int id, PostingList te, PostingList ed) {
		entityId = id;
		termEntityPostingList = te;
		entityDocPostingList = ed;
	}

	public PostingList joinOnOccur() {
		return joinOnOccur(termEntityPostingList);
	}

	/**
	 * Joins the entity-doc posting list in this resultset with the term-entity
	 * posting list of the resultset passed to this method.
	 * 
	 * @param tePostingList
	 * @return
	 */
	public PostingList joinOnOccur(PostingList tePostingList) {
		PostingList occurJoinedPostingList = new PostingList(
				new PostingListDocSentSorter());
		TermEntityPosting tePosting = null;
		EntityDocPosting edPosting = null;
		for (Posting p1 : tePostingList.getPostingList()) {
			tePosting = (TermEntityPosting) p1;
			for (Posting p2 : entityDocPostingList.getPostingList()) {
				edPosting = (EntityDocPosting) p2;
				if (edPosting.getOccur() > tePosting.getOccur())
					break;
				else if (edPosting.getOccur() == tePosting.getOccur())
					occurJoinedPostingList
							.addPosting(new OccurrenceJoinedPosting(tePosting,
									edPosting));
			}
		}
		return occurJoinedPostingList;
	}

	public int getEntityId() {
		return entityId;
	}

	private int entityId;
	private PostingList termEntityPostingList;
	private PostingList entityDocPostingList;

}
