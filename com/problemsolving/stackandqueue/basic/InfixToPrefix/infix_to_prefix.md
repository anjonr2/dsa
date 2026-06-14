In a prefix expression operator are placed before the operands

Approach to convert Infix Expression to Prefix : 
. Reverse the given infix expression
. Scan the expression from left to right
. When an operand is encountered, add to the resultant string
. If an operator is encountered and stack is empty push it into the stack
. If the incoming operator has higher precedence than the top of the stack, push it into the stack
. If the incoming operator has the same precedence as the top of the stack, push it into the stack
. If the incoming operator has lower precedence than the top of the stack, pop and print the top of the stack. Then test the incoming operator against the top of the stack again and continue popping operators from stack until it finds and operator with lower or same precedence
. If the incoming operator has the same precedence as the top of the stack and the incoming operator is '^' , pop the top of the stack until the condition is met. If not push the '^' operator