package tasks.first;

import java.util.*;

public class FirstTaskSolution implements FirstTask {
    @Override
    public String breadthFirst(boolean[][] adjacencyMatrix, int startIndex) {
        StringBuilder result = new StringBuilder();

        Graph graph = new Graph(adjacencyMatrix);

        ArrayDeque<Elem> deque = new ArrayDeque();

        Elem cursor = graph.getElems().get(0);

        HashSet<Elem> usedElems = new HashSet<>();

        deque.addLast(cursor);

        while (!deque.isEmpty()) {
            cursor = deque.removeFirst();
            usedElems.add(cursor);
            result.append(cursor.getId());
            Iterator<Elem> childIterator = cursor.getElems().iterator();

            while (childIterator.hasNext()) {
                Elem child = childIterator.next();
                if (!usedElems.contains(child)) {
                    usedElems.add(child);
                    deque.addLast(child);
                }
            }
        }
        return result.toString();
    }


    public long applyOperation(long a, long b, String strOperator) throws IllegalArgumentException{
        switch (strOperator){
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Long polishCalculation(String s) {
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "*", "-", "/"));

        String[] splittedString = s.split(" ");

        ArrayDeque<Long> stack =  new ArrayDeque<>();


        for (int i = 0; i < splittedString.length; i++) {
            if (operators.contains(splittedString[i])){
                stack.push(applyOperation(stack.pop(), stack.pop(), splittedString[i]));
                continue;
            }
            stack.push(Long.parseLong(splittedString[i]));
        }

        return stack.pop();
    }



    public char getPairBracket(char c) throws IllegalArgumentException{
        switch (c){
            case ')':
                return '(';
            case ']':
                return '[';
            case '}':
                return '{';
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Boolean validateBrackets(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            if ((s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') && stack.isEmpty()){
                return false;
            }
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']'){
                if (getPairBracket(s.charAt(i)) != stack.pop())
                    return false;
            }
        }
        return stack.isEmpty();
    }
}
