package Kakao_2018;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution_1 {
	public static void main(String[] args) {
		String[] str = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };
		String[] str2 = solution(str);
		for (int i = 0; i < str2.length; i++)
			System.out.print(str2[i] + " ");
	}

	public static String[] solution(String[] record) {
		Map<String, String> map = new HashMap<String, String>();
		ArrayList<String> who = new ArrayList<String>();
		ArrayList<String> act=new ArrayList<String>();
		int cnt = 0;
		for (int i = 0; i < record.length; i++) {
			String str = record[i];
			String splits[] = str.split(" ");
			String action = splits[0];
			String uid = splits[1];

			if (action.contentEquals("Enter") || action.contentEquals("Change")) {
				String name = splits[2];
				if (map.get(uid) == null) {
					map.put(uid, name);
				} else {
					map.replace(uid, name);
				}
			}
			if (action.contentEquals("Enter")) {
				who.add(uid);
				act.add(" ´ÔÀÌ µé¾î¿Ô½À´Ï´Ù.");
			} else if (action.contentEquals("Leave")) {
				who.add(uid);
				act.add(" ´ÔÀÌ ³ª°¬½À´Ï´Ù.");
			}
		}
		int size=who.size();
		String answer[]=new String[size];
		for(int i=0;i<size;i++)
			answer[i]=map.get(who.get(i))+act.get(i);
		//System.out.println(answer);
		return answer;
	}

}
