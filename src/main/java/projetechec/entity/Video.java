package projetechec.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("V")
public class Video extends ContenuPedagogique {
	@Column(name = "site_internet", length = 150)
	private String siteInternet;

	public Video() {
		super();
	}

	public Video(String titre, Double prix, String siteInternet) {
		super(titre, prix);
	}

	public String getSiteInternet() {
		return siteInternet;
	}

	public void setSiteInternet(String siteInternet) {
		this.siteInternet = siteInternet;
	}

}
