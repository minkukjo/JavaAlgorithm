package main.ProgrammersLevel2;

import java.util.HashMap;
import java.util.Map;

public class SkillTree {

    public static int solution(String skill, String[] skill_trees){
        int answer = 0;

        Map<Character,Integer> hashMap = new HashMap<>();

        for(int i=0; i<skill.length(); i++){
            hashMap.put(skill.charAt(i),i);
        }

        for(int i=0; i<skill_trees.length; i++){
            int order = 0;
            boolean isPosibble = true;
            for(int j=0; j<skill_trees[i].length(); j++){
                if(hashMap.containsKey(skill_trees[i].charAt(j))){
                    if(hashMap.get(skill_trees[i].charAt(j)) == order){
                        order++;
                    }else{
                        isPosibble = false;
                        break;
                    }
                }
            }

            if(isPosibble){
                answer++;
            }

        }

        return answer;

    }

    public static void main(String[] args) {
        String skill = "CBD";
        String[] skill_trees = {
                "BACDE",
                "CBADF",
                "AECB",
                "BDA"
        };
        System.out.println(solution(skill,skill_trees));

    }
}
