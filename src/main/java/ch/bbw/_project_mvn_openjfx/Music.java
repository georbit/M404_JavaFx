package ch.bbw._project_mvn_openjfx;

public class Music {

	private String genre;

	private String kuenstler;

	private String medium;

	public Music() {
	}

	public Music(String genre, String kuenstler, String medium) {
		this.genre = genre;
		this.kuenstler = kuenstler;
		this.medium = medium;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getKuenstler() {
		return kuenstler;
	}

	public void setKuenstler(String kuenstler) {
		this.kuenstler = kuenstler;
	}

	public String getMedium() {
		return medium;
	}

	public void setMedium(String medium) {
		this.medium = medium;
	}

	@Override
	public String toString() {
		return "Music{" +
				"genre='" + genre + '\'' +
				", kuenstler='" + kuenstler + '\'' +
				", medium='" + medium + '\'' +
				'}';
	}
}

