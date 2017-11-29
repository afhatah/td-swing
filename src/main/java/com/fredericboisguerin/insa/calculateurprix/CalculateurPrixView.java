package com.fredericboisguerin.insa.calculateurprix;

import static java.awt.BorderLayout.EAST;
import static java.awt.BorderLayout.SOUTH;
import static java.awt.BorderLayout.WEST;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.*;
import java.text.NumberFormat;

import javax.swing.*;

public class CalculateurPrixView extends JFrame {

    private final CalculateurPrixPresenter presenter;
    private JFormattedTextField montantHTTextField;
    private final JTextField prixArticleTextField;
    private final JTextField qteArticleTextField;
    private final JFormattedTextField montantTTCTextField;


    public CalculateurPrixView() throws HeadlessException {
        super("Calculateur de prix");
        this.presenter = new CalculateurPrixPresenter(this);

        JLabel prixArticleLabel = new JLabel("Montant d'un article");
        prixArticleTextField = new JTextField(10);
        prixArticleLabel.setLabelFor(prixArticleTextField);
        prixArticleTextField.setToolTipText("Entrez ici le montant d'un article");

        JLabel qteArticleLabel = new JLabel("Quantité");
        qteArticleTextField = new JTextField();
        qteArticleLabel.setLabelFor(qteArticleTextField);
        qteArticleTextField.setToolTipText("Entrez ici la quantité d'un article");

        JLabel paysLabel = new JLabel("Pays");
        JComboBox<Pays> comboPays = new JComboBox<Pays>(Pays.values());
        paysLabel.setLabelFor(comboPays);
        comboPays.addActionListener(e -> this.presenter.onComboPaysClicked(comboPays.getSelectedItem()));

        JLabel montantHTLabel = new JLabel("Montant HT");
        montantHTTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        montantHTTextField.setEditable(false);
        montantHTLabel.setLabelFor(montantHTTextField);

        JLabel montantTTCLabel = new JLabel("Montant TTC(France)");
        montantTTCTextField = new JFormattedTextField(NumberFormat.getCurrencyInstance());
        montantTTCTextField.setEditable(false);
        montantHTLabel.setLabelFor(montantTTCTextField);

        JButton computeButton = new JButton("Calculer");
        computeButton.addActionListener(e -> this.presenter.onComputeButtonClicked(prixArticleTextField.getText()));

        JPanel contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.add(prixArticleTextField);

        JPanel labelPane = new JPanel(new GridLayout(0, 1));
        labelPane.add(prixArticleLabel);
        labelPane.add(qteArticleLabel);
        labelPane.add(paysLabel);
        labelPane.add(montantHTLabel);
        labelPane.add(montantTTCLabel);

        JPanel fieldPane = new JPanel(new GridLayout(0, 1));
        fieldPane.add(prixArticleTextField);
        fieldPane.add(qteArticleTextField);
        fieldPane.add(comboPays);
        fieldPane.add(montantHTTextField);
        fieldPane.add(montantTTCTextField);

        contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        add(labelPane, WEST);
        add(fieldPane, EAST);
        add(computeButton, SOUTH);

        prixArticleTextField.requestFocus();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void afficherErreur(String message) {
        showMessageDialog(this, message, "Erreur", ERROR_MESSAGE);
    }

    public void setMontantHT(double n) {
        this.montantHTTextField.setValue(n);
    }

    public void setMontantTTC(double n) {
        this.montantTTCTextField.setValue(n);
    }

    public String getPrixArticle() {
        return this.prixArticleTextField.getText();
    }

    public String getQteArticle() {
        return this.qteArticleTextField.getText();
    }

    public void display() {
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
