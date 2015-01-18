# SalesTaxes
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

## Class Diagram
-![alt text](http://i.imgur.com/NIOcDDd.png README.md URL")

##Implementation

This application basically makes three operations, these are respectively read, calculate and write. 

* According to the program format we gets the inputs from shopping baskets. So our read operation is carried out by ShoppingBasketReader. This function reads the sales information from "input.txt" file. 
I used a specialized input file. The input file format is as shown as shown below.

    Count     | Is imported  |     kind     |     price    |          name          |
------------- | -------------|------------- | -------------|----------------------- |
      1       |   imported   |     food     |     10.00    |   box of chocolate     |
      2       |   domestic   |     goods    |     14.99    |        music CD        |

***Count***: number of product
***Is imported***: imported or domistic 
***kind***: There are 5 different kinds, foods, goods, book, medical
***price***: the amount of money expected
***name***: the product description

* After reading file the calculation will be started. ***TaxesCalculation*** class calculates the taxes and total price by using ***calculate()*** method. This class writes the results of calculations in a Receipt object by using ***getResults()*** method.
* Finally ***ReceiptWriter*** interface provides to write the results in an output file or console screen. Factory pattern was used here. There is a ***ReceiptWriterFactory*** class which help the user to decide that results will write on console or on an output file.

Factory Class
```java
public ReceiptWriter getWriter(String writerType) {
	if (writerType == null) {
		return null;
	}
	if (writerType.equalsIgnoreCase("FILE")) {
		return new ReceiptFileWriter();

	} else if (writerType.equalsIgnoreCase("CONSOLE")) {
		return new ReceiptConsoleWrite();

	}

	return null;
}
```
Test with factory pattern
```java
ReceiptWriterFactory rFactory = new ReceiptWriterFactory();
		
	ReceiptWriter rcw = rFactory.getWriter("CONSOLE");
	rcw.write(receipt);
	ReceiptWriter rfw = rFactory.getWriter("FILE");
	rfw.write(receipt);
	
```
Results of the task printed on console using ***log4j*** console appander

## Missing Features
* spring framework but Spring Tool Suite is used
* Unit, Integrity and Functional test
* No input validation

