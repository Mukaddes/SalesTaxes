# SalesTaxes
Basic sales tax is applicable at a rate of 10% on all goods, except books, food, and medical products that are exempt. Import duty is an additional sales tax applicable on all imported goods at a rate of 5%, with no exemptions.

When I purchase items I receive a receipt which lists the name of all the items and their price (including tax), finishing with the total cost of the items, and the total amounts of sales taxes paid. The rounding rules for sales tax are that for a tax rate of n%, a shelf price of p contains (np/100 rounded up to the nearest 0.05) amount of sales tax.

## Class Diagram
-![alt text](http://i.imgur.com/NIOcDDd.png README.md URL")

##Implementation

This application basically makes three operations, these are respectively read, calculate and write. According to the program format we gets the inputs from shopping baskets. So our read operation is carried out by ShoppingBasketReader. This function reads the sales information from "input.txt" file. 
I used a specialized input file. The input file format is as shown as shown below.

    Count     | Is imported  |     kind     |     price    |          name          |
------------- | -------------|------------- | -------------|----------------------- |
      1       |   imported   |     food     |     10.00    |   box of chocolate     |
      2       |   domestic   |     goods    |     14.99    |        music CD        |



## Test

