package ch.bbw._project_mvn_openjfx;

public enum EyeColor {
	
	GREEN("Green"), BLUE("Blue"), BROWN("Brown"), AZURE("Azure");

	public static final EyeColor[] ALL = { GREEN, BLUE, BROWN, AZURE };

	private final String name;

	private EyeColor(final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public String toString() {
		return getName();
	}

}
