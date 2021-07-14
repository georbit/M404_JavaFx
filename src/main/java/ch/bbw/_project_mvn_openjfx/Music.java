package ch.bbw._project_mvn_openjfx;

public class Music {
	public enum Genres{
		POP,ROCK,METAL
	}

	public enum Kuenstler{
		POP,ROCK,METAL
	}

	public enum Medien{
		POP,ROCK,METAL
	}

	private Genres genre;

	private Kuenstler kuenstler;

	private Medien medium;

	public Genres getGenre() {
		return genre;
	}

	public Music(Genres genre, Kuenstler kuenstler, Medien medium) {
		this.genre = genre;
		this.kuenstler = kuenstler;
		this.medium = medium;
	}

	public void setGenre(Genres genre) {
		this.genre = genre;
	}

	public Kuenstler getKuenstler() {
		return kuenstler;
	}

	public void setKuenstler(Kuenstler kuenstler) {
		this.kuenstler = kuenstler;
	}

	public Medien getMedium() {
		return medium;
	}

	public void setMedium(Medien medium) {
		this.medium = medium;
	}
}