package bean;

import java.util.ArrayList;
import java.util.Arrays;

public class Produit {
	private int id, idUser;
	private String label, img;
	private boolean enchere;
	private ArrayList<String> tag;

	public Produit(int id, int idUser, String label, String img, boolean enchere, String tagString) {
		this.id = id;
		this.idUser = idUser;
		this.label = label;
		this.img = img;
		this.enchere = enchere;
		String[] t = tagString.split(" ");
		ArrayList<String> array = new ArrayList<String>();
		array.addAll(Arrays.asList(t));
		this.tag = array;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public boolean isEnchere() {
		return enchere;
	}

	public void setEnchere(boolean enchere) {
		this.enchere = enchere;
	}

	public ArrayList<String> getTag() {
		return tag;
	}

	public void setTag(ArrayList<String> tag) {
		this.tag = tag;
	}

	@Override
	public String toString() {
		return "Produit{" +
				"id=" + id +
				", idUser=" + idUser +
				", label='" + label + '\'' +
				", img='" + img + '\'' +
				", enchere=" + enchere +
				", tag=" + tag +
				'}';
	}
}
