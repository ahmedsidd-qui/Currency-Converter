import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.swing.*;

public class CurrencyConverter extends JFrame implements ActionListener {

    private static final String API_KEY = "168f333a336d8108c8429176";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/";

    private JTextField fromCurrencyField;
    private JTextField toCurrencyField;
    private JTextField amountField;
    private JLabel conversionResultLabel;

    public CurrencyConverter() {
        super("Currency Converter");

        JLabel fromCurrencyLabel = new JLabel("From Currency:");
        fromCurrencyField = new JTextField(10);
        JLabel toCurrencyLabel = new JLabel("To Currency:");
        toCurrencyField = new JTextField(10);
        JLabel amountLabel = new JLabel("Amount:");
        amountField = new JTextField(10);
        JButton convertButton = new JButton("Convert");
        conversionResultLabel = new JLabel();

        convertButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(fromCurrencyLabel);
        panel.add(fromCurrencyField);
        panel.add(toCurrencyLabel);
        panel.add(toCurrencyField);
        panel.add(amountLabel);
        panel.add(amountField);
        panel.add(convertButton);
        panel.add(conversionResultLabel);

        this.add(panel);

        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String fromCurrency = fromCurrencyField.getText().toUpperCase();
        String toCurrency = toCurrencyField.getText().toUpperCase();
        String amountString = amountField.getText();

        if (fromCurrency.isEmpty() || toCurrency.isEmpty() || amountString.isEmpty()) {
            conversionResultLabel.setText("Please enter all fields.");
            return;
        }

        double amount;
        try {
            amount = Double.parseDouble(amountString);
        } catch (NumberFormatException ex) {
            conversionResultLabel.setText("Invalid amount format.");
            return;
        }

        new Thread(() -> {
            try {
                double conversionRate = fetchConversionRate(fromCurrency, toCurrency);
                double convertedAmount = amount * conversionRate;
                conversionResultLabel.setText(String.format("%.2f %s is equal to %.2f %s", amount, fromCurrency, convertedAmount, toCurrency));
            } catch (Exception ex) {
                conversionResultLabel.setText("Conversion failed: " + ex.getMessage());
            }
        }).start();
    }

    private double fetchConversionRate(String fromCurrency, String toCurrency) throws Exception {
        throw new UnsupportedOperationException("JSON parsing not implemented yet");
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}