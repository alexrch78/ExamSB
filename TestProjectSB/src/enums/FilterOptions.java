package enums;

public enum FilterOptions {
	FREE("Free");
	
	public String getValue() {
		return value;
	}
	
	private final String value;

	FilterOptions(String value) {
        this.value = value;
    }

}
