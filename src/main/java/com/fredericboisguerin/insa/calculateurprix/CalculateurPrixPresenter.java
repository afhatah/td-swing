package com.fredericboisguerin.insa.calculateurprix;

public class CalculateurPrixPresenter {
    private final CalculateurPrixView calculateurPrixView;

    public CalculateurPrixPresenter(CalculateurPrixView calculateurPrixView) {
        this.calculateurPrixView = calculateurPrixView;
    }

    public void onComputeButtonClicked(String montantArticleAsText) {
        try {
            // calcul HT
            double montantHT = Double.parseDouble(montantArticleAsText) * (Double.parseDouble(this.calculateurPrixView.getQteArticle()));
            calculateurPrixView.setMontantHT(montantHT);

            // calcul TTC
            double montantTTC = montantHT * 1.2d;
            calculateurPrixView.setMontantTTC(montantTTC);
        }
        catch (Exception e) {
            calculateurPrixView.afficherErreur("Veuillez entrer des nombres.");
        }

    }
}
