#Problem 2: Supermarket Pricing
The task is to model Supermarket Pricing. This is one of the original Pragmatic Programmers Code Kata's, and is intended to be more a thought exercise than a coding exercise.

Some things in supermarkets have simple prices, i.e. a can of beans costs $0.65. 

Other things have more complex prices, for example:

* Three for a dollar (so what's the price if I buy 4, or 5?)
* $1.99/pound (so what does 4 ounces cost?)
* Buy two; get one free (so does the third item have a price?)

The exercise is to experiment with various models for representing money and prices that are flexible enough to deal with these (and other) pricing schemes, and at the same time are generally usable (at the checkout, for stock management, order entry, and so on). 

Time should be spent considering issues such as:

* Does fractional money exist?
* When (if ever) does rounding take place?
* How do you keep an audit trail of pricing decisions (and do you need to)?
* Are costs and prices the same class of thing?
* If a shelf of 100 cans is priced using "buy two, get one free", how do you value the stock?

#Output
As is usually the case, this problem can be handled in several different ways, and the best way would depend on some business decisions, including, but certainly not limited to:
* Your costs and reasons for discounting the items (You might have paid $1 for a can of beans, but if you have a million cans in your warehouse and lose out on being able to buy canned corn at half a dollar, they might be costing you a lot more).
* How much would it cost to implement the different systems to deal with different strategies

Some possible ways to handle the pricing:
* The naive way - If it is 3 for $3, just make the price $1 each. Fruit and Veg city follows this approach. Of course in their case, if they don't sell the items at this point, it becomes worthless.
* Calculate a discount after every 3 items you see. The advantage of this is that cashier's tend to scan like items at the same time, so the discount usually reflects right where the products were scanned. Checkers uses this method. The disadvantage is that you have to potentially reverse the discount when an item gets removed.
* Calculate total discounts at the end of the transaction. It means you only calculate discounts once everything has been rung up, but you tend to have more queries by people asking why they didn't get their discounts. I believe Woolworths does it this way.

All of these methods should work with buy 2 get one free or other types of promotions as well.

You also have to handle refunds though, and that's potentially harder:
* With the naive implementation, it's easy as you are just doing a normal refund.
* With the other two methods, you could calculate the price of the undiscounted items that remain on the transaction, get the difference to what was paid and then refund just the difference. Of course, there are social factors that make this problematic. People get upset when they return a can of beans that shows on their receipt with a price of $1 and they only get half a dollar back. Being right is not necessarily enough here.

##Some other considerations:
Some of the considerations when implementing the system would be fractional money and rounding. My feeling would be that regardless of which strategy you employ, you should keep fractional amounts throughout the process, and only round down to the nearest whole amount once everything has been totalled. 

An audit trail would be important as you always want to know what people paid and why - If you lose that, the whole system would become easier to abuse. It would probably make sense to store each transaction with the exact amounts paid and any discounts (You'd do this in any case) and separate to that, you would need to store the list of all promotions and when they happened.

Valuing the stock would depend on the business. In the example of Fruit and Veg city, they might very well value their stock at the discounted price, but it might make sense to value it at the full price (since you don't know how much you will be selling).  

Of course, another argument could be made that it makes sense to value them based on the current price as that is true at the moment...