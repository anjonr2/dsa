The traditional way of writing mathematical expression is called infix expression, where the operator is placed between two operands
Infix expression are easy for humans to understand, but computers find them difficult to parse because they require knowledge of operator precedence, associativity rules, and parentheses
To make it easier for computers,we use postfix and prefix notations

In postfix expression, the precendence of operators is determined by the order in which they appear in expression. The operator that appears first is applied to operands

Postfix expression do not require parentheses making them easier for computers to evaluate

Approach to convert Infix Expression to Postfix : 

1.Start by scanning the infix expression from left to right
2.if the scanned character is an operand, print it immediately
3.If the scanned character is an operator
a)If the precedence of the operator is greater than operator in the stack, or the stack is empty, or the stack contains a '(' push the operator into the stack
b)Otherwise, pop all operators from the stack with higher or equal precedence than the scanned operator, then push the scanned operator into the stack
4.If the scanned character is '(' push it into the stack
