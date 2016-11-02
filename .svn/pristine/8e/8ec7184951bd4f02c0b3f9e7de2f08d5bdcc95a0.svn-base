package in.ac.iitb.cse.eci.data;

public class OccurrenceJoinedPosting extends Posting {

	private TermEntityPosting termEntityPosting;
	private EntityDocPosting entityDocPosting;

	public OccurrenceJoinedPosting() {

	}

	public OccurrenceJoinedPosting(TermEntityPosting tePosting,
			EntityDocPosting edPosting) {
		occur = tePosting.getOccur();
		termEntityPosting = tePosting;
		entityDocPosting = edPosting;
	}

	public int getDoc() {
		return entityDocPosting.getDoc();
	}

	public int getSentence() {
		return entityDocPosting.getSent();
	}
}
