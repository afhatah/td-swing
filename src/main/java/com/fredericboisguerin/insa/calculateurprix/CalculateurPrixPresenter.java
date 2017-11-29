package com.fredericboisguerin.insa.calculateurprix;

public class CalculateurPrixPresenter {
    private final CalculateurPrixView calculateurPrixView;
    private Pays selectedPays = Pays.FR;

    public CalculateurPrixPresenter(CalculateurPrixView calculateurPrixView) {
        this.calculateurPrixView = calculateurPrixView;
    }

    public void onComboPaysClicked(Object o) {
        try {
            this.selectedPays = (Pays) o;
        } catch (Exception e) {
            calculateurPrixView.afficherErreur("Erreur dans la sélection du pays");
        }
    }

    public void onComputeButtonClicked(String montantArticleAsText) {
        try {
            // calcul HT
            double montantHT = Double.parseDouble(montantArticleAsText) * (Double.parseDouble(this.calculateurPrixView.getQteArticle()));
            calculateurPrixView.setMontantHT(montantHT);

            // calcul TTC
            double montantTTC = montantHT * (1 + selectedPays.getTaxe());
            calculateurPrixView.setMontantTTC(montantTTC);
        }
        catch (Exception e) {
            calculateurPrixView.afficherErreur("Veuillez entrer des nombres.");
        }

    }
}
