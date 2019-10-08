package events.com.longines.models;

public class Event {
	private int id;
	private String title;
	private String url_image;
	private String date;
	private int id_status;

	public Event() {
	}

	public Event(int id, String title, String url_image, String date, int id_status) {
		this.id = id;
		this.title = title;
		this.url_image = url_image;
		this.date = date;
		this.id_status = id_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
}
