package in.ac.iitb.cse.eci.util;

import in.ac.iitb.cse.eci.data.OccurrenceJoinedPosting;
import in.ac.iitb.cse.eci.data.Posting;

import java.util.ArrayList;
import java.util.List;

public class PostingListSorter {
	protected List<Posting> postingList;

	public PostingListSorter() {
		postingList = new ArrayList<Posting>();
	}

	public List<Posting> getPostingList() {
		return postingList;
	}

	public void addPosting(OccurrenceJoinedPosting posting) {
		
	}

}
