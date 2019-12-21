package de.sprachfaul.comic.monger.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Comic
 */
@Entity
public class Comic {

    @Id
    @GeneratedValue
    @JsonProperty("id")
    private Long id;


    @JsonProperty("nummer")
    private String nummer;


    @JsonProperty("titel")
    private String titel;


    @JsonProperty("untertitel")
    private String untertitel;

    @JsonProperty("preis")
    private Double preis;


    @JsonProperty("isbn")
    private String isbn;

    @JsonProperty("wertung")
    private Integer wertung;


    @JsonProperty("releaseDatum")
    private String releaseDatum;


    @JsonProperty("inhaltsangabe")
    private String inhaltsangabe;


    @JsonProperty("coverUrl")
    private String coverUrl;

    public Comic id(Long id) {
        this.id = id;
        return this;
    }

    
    public Long getId() {
        return id;
    }

    
    public void setId(Long id) {
        this.id = id;
    }

    
    public String getNummer() {
        return nummer;
    }

    
    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    
    public String getTitel() {
        return titel;
    }

    
    public void setTitel(String titel) {
        this.titel = titel;
    }

    
    public String getUntertitel() {
        return untertitel;
    }

    
    public void setUntertitel(String untertitel) {
        this.untertitel = untertitel;
    }

    
    public Double getPreis() {
        return preis;
    }

    
    public void setPreis(Double preis) {
        this.preis = preis;
    }

    
    public String getIsbn() {
        return isbn;
    }

    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    
    public Integer getWertung() {
        return wertung;
    }

    
    public void setWertung(Integer wertung) {
        this.wertung = wertung;
    }

    
    public String getReleaseDatum() {
        return releaseDatum;
    }

    
    public void setReleaseDatum(String releaseDatum) {
        this.releaseDatum = releaseDatum;
    }

    
    public String getInhaltsangabe() {
        return inhaltsangabe;
    }

    
    public void setInhaltsangabe(String inhaltsangabe) {
        this.inhaltsangabe = inhaltsangabe;
    }

    
    public String getCoverUrl() {
        return coverUrl;
    }

    
    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }


    @Override
    public String toString() {
        return "Comic [id=" + id + ", nummer=" + nummer + ", titel=" + titel + ", untertitel=" + untertitel + ", preis=" + preis + ", isbn="
                + isbn + ", wertung=" + wertung + ", releaseDatum=" + releaseDatum + ", inhaltsangabe=" + inhaltsangabe + ", coverUrl="
                + coverUrl + "]";
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Comic other = (Comic) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        }
        else if (!id.equals(other.id))
            return false;
        if (isbn == null) {
            if (other.isbn != null)
                return false;
        }
        else if (!isbn.equals(other.isbn))
            return false;
        return true;
    }
}
