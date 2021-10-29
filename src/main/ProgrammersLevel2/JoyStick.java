package main.ProgrammersLevel2;

public class JoyStick {
    public static void main(String[] args) {
        System.out.println(solution("ABABAAAAABA"));
    }

    public static int solution(String name) {

        int answer = 0;

        char[] names = name.toCharArray();

        // 위,아래로 알파벳을 움직여주는 경우.명확하다.
        for (int i = 0; i < names.length; i++) {
            if (names[i] < 78) {// A~M까지
                answer += names[i] % 65;
            } else { // N~Z
                answer += 91 - names[i];
            }
        }

        // 좌->우 끝까지 조이스틱을 이동한 경우.
        int min = name.length() - 1;

        // 좌,우 움직이는 경우
        if (name.contains("A")) {

            int moveCnt = 1;

            // 뒤부터 세는경우 , 1번째부터 'A'가 아닌게 나올때까지는 무조건 움직여 주어야 한다.
            for (int i = 1; i < names.length; i++) {
                if (names[i] != 'A') {
                    moveCnt = names.length - i;
                    break;
                }
            }

            if (min > moveCnt) min = moveCnt;
            int i = 0;

            while (i < names.length) {

                int endIndex = 0;

                if (names[i] == 'A') {

                    endIndex = i + 1;

                    while (endIndex < names.length && names[endIndex] == 'A') {
                        endIndex++;
                    }

                    // 연속된 A의 끝이 마지막 까지 이어진 경우라면
                    if (endIndex == names.length) {
                        moveCnt = i - 1;
                    } else moveCnt = 1 + (i - 1) * 2 + names.length - 1 - endIndex;

                    if (moveCnt < min) min = moveCnt;

                    i = endIndex + 1;

                } else i++;
            }

            if (min > moveCnt) min = moveCnt;
        }

        return answer + min;
    }
}
