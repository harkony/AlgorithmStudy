package Kakao_2018;
//2018-09-15

//idea
//계속 record를 뒤에서부터 한번 읽고 앞에서 부터 다시 읽으면서 msg를 만들다가 시간 초과가 나서 멘붕이었다.
//앞에서 부터 읽으면서 uid에 따른 name을 생신함과 동시에 uid 와 action을 저장했다가, 나중에 uid를 name으로 치환시켰다.
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
		// key: uid  value: nickname
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
				act.add(" 님이 들어왔습니다.");
			} else if (action.contentEquals("Leave")) {
				who.add(uid);
				act.add(" 님이 나갔습니다.");
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
