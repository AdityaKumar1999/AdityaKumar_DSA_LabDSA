package Problem_1;

import java.util.*;

public class Balance_Bracket {

	Stack<Character> stack = new Stack<>();

	public void validateBrackets(String strArr) {
		int balance = strToArr(strArr);
		if (balance == 0)
			System.out.println("The entered String has Balanced Brackets");
		else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
	}

	public int strToArr(String strArr) {
		int balance = 0;
		for (int i = 0; i < strArr.length(); i++) {

			char c = strArr.charAt(i);

			if (c == '(' || c == '[' || c == '{') {

				stack.push(c);
				balance = balance + 1;
				continue;
			} else {

				if (c == ')') {
					c = '(';
				}
				if (c == ']') {
					c = '[';
				}
				if (c == '}') {
					c = '{';
				}

				char popBracket = stack.pop();
				if (popBracket == c) {
					balance = balance - 1;
					continue;
				} else {
					break;
				}

			}

		}

		return balance;
	}

	public static void main(String[] args) {
		Balance_Bracket obj = new Balance_Bracket();
		String bracketsSequence = "({[]})";
		obj.validateBrackets(bracketsSequence);
	}
}
