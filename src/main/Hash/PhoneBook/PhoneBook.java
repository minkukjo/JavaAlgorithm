package main.Hash.PhoneBook;

import java.util.Arrays;

public class PhoneBook {
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Trie trie = new Trie();
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length; i++) {
            if (trie.insert(phone_book[i])) {
                answer = false;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] phone_book = {"12", "123", "1235"};
        System.out.println(solution(phone_book));
    }
}
