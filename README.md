Cart
====

The goal of this project is to implement a simple user case and aply the unit testing methods to check the correctnes of the code.
The user case is about a Cart with products and diferents currencies.

## Cart Class

This class represents the buying cart. The main operations and responsabilities are the followings:
git 
*	**Cart(Currency currency):** creates an instance of Cart that will return the amount expressend with the Currency given.
*	**void init():** empty the cart.
*	**selectCurrency(Currency currency):** selects the currency which will be used to show the amount of each product of the cart.
*	**Money getTotal():** Returns the total amount of all the products contained in the Cart expressed in the actual Currency.
*	**addItem(UPC upc, int quantity):** add quantitiy unities of upc product to the chart.

## Money Class

A really simple class, has one **value** (BigDecimal) and a **currency** (Currency)

## Currency Class

This class represents a Currency. Has an internal static list with the valid currencies.

## MultiCurrencyMoney Class

This class handles the monetary values expressed in multiple currencies .
*	**addMoney(Money money):** add the money to the MultiCurrencyMoney object.
*	**Money getTotal(CurrencyExchanger exchanger, Currency currency):** returns the total money.

## CurrencyExchanger Class

This class handles the currency exchange.
*	**setRate(Curency from, Currency to, double rate):** register the exchange rate between two Currencies.
*	**Money convert(Money from, Currency to):** returns the from quantitiy expressed in to Currency.

## ProductDB Class

This class will allow to transform a product to a price.
*	**addProduct(UOP upc, Money Price)** 
*	**Money getPrice(UPC upc):** given a upc code returns his price in Money.


## DataBase Interface

Really simple interface to implement the tests, simulate a real DataBase but is a double.

## Exchanger Interface

Just the same purpose of DataBase interface. But in addition I pass the Cart also in the constructor.




