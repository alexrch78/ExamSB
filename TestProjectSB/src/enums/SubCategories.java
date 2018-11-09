package enums;

public enum SubCategories {
	WEB_DEVELOPMENT("web-development");
	
	public String getValue() {
		return value;
	}
	
	private final String value;

	SubCategories(String value) {
        this.value = value;
    }
	
}
