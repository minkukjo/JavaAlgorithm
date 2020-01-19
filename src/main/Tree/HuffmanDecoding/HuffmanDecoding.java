package main.Tree.HuffmanDecoding;
class Node{
        public  int frequency;
        public  char data;
        public  Node left, right;
}
public class HuffmanDecoding {
    void decode(String s, Node root) {
        StringBuilder str = new StringBuilder();
        Node temp = root;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '0'){
                temp = temp.left;
                if(temp.data != '\0'){
                    str.append(temp.data);
                    temp = root;
                }
            }else if(s.charAt(i) == '1'){
                temp = temp.right;
                if(temp.data != '\0'){
                    str.append(temp.data);
                    temp = root;
                }
            }
        }
        System.out.println(str);
    }
}
