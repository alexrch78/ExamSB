package enums;

public enum Categories {
	DEVELOPMENT("development");

	public String getValue() {
		return value;
	}
	
	private final String value;

	Categories(String value) {
        this.value = value;
    }

}
