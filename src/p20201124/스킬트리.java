package p20201124;

public class 스킬트리 {

	public int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			StringBuilder sb = new StringBuilder();
			String temp = skill_trees[i];
			for (int j = 0; j < temp.length(); j++) {
				if (skill.contains(String.valueOf(temp.charAt(j))))
					sb.append(temp.charAt(temp.charAt(j)));
			}

			if (skill.startsWith(sb.toString()))
				answer++;
		}

		return answer;
	}

	public static void main(String[] args) {

		스킬트리 skillTree = new 스킬트리();
		int result = skillTree.solution("CBD", new String[] { "BACDE", "CBADF", "AECB", "BDA" });
		System.out.println(result);
	}

}
