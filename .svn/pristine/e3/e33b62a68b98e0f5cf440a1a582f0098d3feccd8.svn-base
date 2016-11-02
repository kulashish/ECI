package in.ac.iitb.cse.eci.util;

import in.ac.iitb.cse.eci.data.OccurrenceJoinedPosting;

public class PostingListDocSentSorter extends PostingListSorter {

	public void addPosting(OccurrenceJoinedPosting posting) {
		int doc = posting.getDoc();
		int sent = posting.getSentence();
		OccurrenceJoinedPosting oPosting = null;
		int index = 0;
		for (index = 0; index < postingList.size(); index++) {
			oPosting = (OccurrenceJoinedPosting) postingList.get(index);
			if (oPosting.getDoc() > doc
					|| (oPosting.getDoc() == doc && oPosting.getSentence() >= sent)) {
				postingList.add(index, posting);
				break;
			}
		}
		if (index == postingList.size())
			postingList.add(posting);
	}
}
