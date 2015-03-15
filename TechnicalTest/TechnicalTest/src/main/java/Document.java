import com.fasterxml.jackson.annotation.JsonGetter;


public class Document {
	private Search search;	
	
	@JsonGetter("Search")
	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}
}
