package events.com.longines.models;

public class Setting {
	private long id;
	private String title;
	private String accion;
	private String atributte;
	private int id_status;

	public Setting() {
	}

	public Setting(long id, String title, String accion, String atributte, int id_status) {
		this.id = id;
		this.title = title;
		this.accion = accion;
		this.atributte = atributte;
		this.id_status = id_status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAccion() {
		return accion;
	}

	public void setAccion(String accion) {
		this.accion = accion;
	}

	public String getAtributte() {
		return atributte;
	}

	public void setAtributte(String atributte) {
		this.atributte = atributte;
	}

	public int getId_status() {
		return id_status;
	}

	public void setId_status(int id_status) {
		this.id_status = id_status;
	}
}
