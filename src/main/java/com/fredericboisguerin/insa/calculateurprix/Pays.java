package com.fredericboisguerin.insa.calculateurprix;

public enum Pays {

    FR("France", 0.2d),
    BEL("Belgique", 0.21d),
    DAN("Danemark", 0.25d),
    ALL("Allemagne", 0.19d),
    GRE("Grèce", 0.23d),
    ESP("Espagne", 0.21d),
    IRL("Irlande", 0.23d),
    ITA("Italie", 0.22d),
    CHY("Chypre", 0.19d),
    LUX("Luxembourg", 0.15d),
    PB("Pays Bas", 0.21d),
    AUT("Autriche", 0.20d),
    POR("Portugal", 0.23d),
    SUE("Suède", 0.25d);

    private final String nom;
    private final double taxe;

    private Pays(String nom, double  taxe) {
        this.nom = nom;
        this.taxe = taxe;
    }

    public String getNom() {
        return this.nom;
    }

    public double getTaxe() {
        return this.taxe;
    }

}
