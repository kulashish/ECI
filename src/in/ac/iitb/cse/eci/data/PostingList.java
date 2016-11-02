package in.ac.iitb.cse.eci.data;

import in.ac.iitb.cse.eci.util.PostingListSorter;

import java.util.ArrayList;
import java.util.List;

public class PostingList {

	private List<Posting> postingList;
	private PostingListSorter sorter;

	public PostingList() {
		postingList = new ArrayList<Posting>();
	}

	public PostingList(PostingListSorter sorter) {
		this.sorter = sorter;
		postingList = sorter.getPostingList();
	}

	public List<Posting> getPostingList() {
		return postingList;
	}

	public void addPosting(OccurrenceJoinedPosting posting) {
		if (null != sorter)
			sorter.addPosting(posting);
		else
			postingList.add(posting);
	}

}
