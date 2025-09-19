package th.co.ais.to;

import java.io.Serializable;

public abstract class SearchTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6742906116657748834L;
	/**
	 * 
	 */
	private boolean overMaxResultLimit = false;
	private int totalResult = 0;

	public boolean isOverMaxResultLimit() {
		return overMaxResultLimit;
	}

	public void setOverMaxResultLimit(boolean overMaxResultLimit) {
		this.overMaxResultLimit = overMaxResultLimit;
	}

	public int getTotalResult() {
		return totalResult;
	}

	public void setTotalResult(int totalResult) {
		this.totalResult = totalResult;
	}


	
}
