package dao;


public class Devotant {

	private int id;
	private String identification;
	private String bulltinvote;

	public Devotant(String identification, String bulltinvote) {
		super();
		this.identification = identification;
		this.bulltinvote = bulltinvote;
	}

	@Override
	public String toString() {
		return "Devotant [id=" + id + ", identification=" + identification + ", bulltinvote=" + bulltinvote + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIdentification() {
		return identification;
	}

	public void setIdentification(String identification) {
		this.identification = identification;
	}

	public String getBulltinvote() {
		return bulltinvote;
	}

	public void setBulltinvote(String bulltinvote) {
		this.bulltinvote = bulltinvote;
	}

}

