As stock span is the number of consecutive days for which the stock price was less than or equal to the price on the current day. Hence, to get the stock span for current day, the aim is to find the position of its previous greater element

We have to maintain a decreasing order of elements in stack 

Once the indices of previous greater elements are known , the stock span for each day will be difference between the current index and the index of its previous greater element