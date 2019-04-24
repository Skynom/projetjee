package bean;

import java.util.ArrayList;

public class Panier {
	private ArrayList<Produit> list;

	public Panier(){
		list = new ArrayList<Produit>();
	}

	public void add(Produit produit) {
		this.list.add(produit);
	}

	public void remove(Produit produit) {
		this.list.remove(produit);
	}

	public ArrayList<Produit> getList() {
		return list;
	}

	public void setList(ArrayList<Produit> list) {
		this.list = list;
	}
}
