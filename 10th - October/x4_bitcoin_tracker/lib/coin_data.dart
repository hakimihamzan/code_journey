//2. Import the required packages.
import 'dart:convert';
import 'package:http/http.dart' as http;

const List<String> currenciesList = [
  'AUD',
  'BRL',
  'CAD',
  'CNY',
  'EUR',
  'GBP',
  'HKD',
  'IDR',
  'ILS',
  'INR',
  'JPY',
  'MXN',
  'NOK',
  'NZD',
  'PLN',
  'RON',
  'RUB',
  'SEK',
  'SGD',
  'USD',
  'ZAR'
];

const List<String> cryptoList = [
  'BTC',
  'ETH',
  'LTC',
];

const coinAPIURL = 'https://rest.coinapi.io/v1/exchangerate';
const apiKey = 'CD560EF9-2CB7-4894-AB40-147ED8D4FF77';

class CoinData {
  Future getCoinData(var selectedCurrency) async {
    var mapData = new Map();

    for (String cryptoType in cryptoList) {
      String cryptoName = cryptoType;
      String requestURL =
          '$coinAPIURL/$cryptoName/$selectedCurrency?apikey=$apiKey';
      http.Response response = await http.get(requestURL);

      if (response.statusCode == 200) {
        var decodedData = jsonDecode(response.body);
        var lastPrice = decodedData['rate'].toInt();
        mapData[cryptoName] = lastPrice;
      } else {
        print(response.statusCode);
        throw 'Problem with the get request';
      }
    }
    return mapData;
  }
}
