package events.com.longines.models;

public class Directory {
	private int id;
	private String url_image;
	private String name;
	private String lastname;
	private int sex;
	private String position;
	private int id_status;

	public Directory() {
	}

	public Directory(int id, String url_image, String name, String lastname, int sex, String position, int id_status) {
		this.id = id;
		this.url_image = url_image;
		this.name = name;
		this.lastname = lastname;
		this.sex = sex;
		this.position = position;
		this.id_status = id_status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrl_image() {
		return url_image;
	}

	public void setUrl_image(String url_image) {
		this.url_image = url_image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
}
