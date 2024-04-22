## Currency Converter with API and UI

This project provides a Java application for currency conversion. It fetches live exchange rates from an API and allows users to convert between different currencies through a graphical user interface (UI).

### Features

* Fetches latest exchange rates using an external API.
* Converts between various currencies based on user input.
* Displays the conversion result in a user-friendly format.

### Requirements

* Java Runtime Environment (JRE)
* A JSON parsing library (e.g., Jackson, Gson) - not included in this project

### Usage

1. Clone or download the repository.
2. Install a JSON parsing library of your choice. Refer to the library's documentation for installation instructions.
3. Implement the `fetchConversionRate` method in `CurrencyConverterUI.java` to handle the API call and JSON parsing logic. You'll need to include the API key and URL from the provided code.
4. Compile and run the `CurrencyConverterUI.java` class.
5. Enter the currency you want to convert from, the currency you want to convert to, and the amount.
6. Click the "Convert" button to see the converted amount.

### Contributing

We welcome contributions to this project! Please see the CONTRIBUTING.md file (if available) for guidelines on how to contribute.
