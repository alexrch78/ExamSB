package enums;

public enum FilterCategories {
	PRICE("Price");
	
	public String getValue() {
		return value;
	}
	
	private final String value;

	FilterCategories(String value) {
        this.value = value;
    }

}
