package codecheck;

import java.util.ArrayList;

public class App {
	public static void main(String[] args) {
		String column = args[0];
		String[] str = column.split(" ");
		int crd = Integer.parseInt(str[0]);
		ArrayList<Integer> listPower = new ArrayList<Integer>();
		ArrayList<Integer> listCost = new ArrayList<Integer>();
		int num = 0;

		for (int i = 0 ; num < crd; i = i+2) {
			listPower.add(num, Integer.parseInt(str[i+2]));
			listCost.add(num, Integer.parseInt(str[i+3]));
			num++;
		}

		int mp = Integer.parseInt(str[1]);
		int ans = 0;
		int deleteFlg = 1;

		while (deleteFlg == 1) {
			int max = 0;
			int power = 0;
			int cost = 0;
			int deleteNum = 0;

			for (int i = 0, l = listPower.size(); i < l; i++) {
				power = listPower.get(i);
				cost = listCost.get(i);
				if (power > max && mp >= cost) {
					max = power;
					deleteNum = i;
				}
			}

			if (max == 0) {
				deleteFlg = 0;
			} else {
				mp = mp - listCost.get(deleteNum);
				ans = ans + max;
				listPower.remove(deleteNum);
				listCost.remove(deleteNum);
			}
		}
		System.out.println(ans);
	}
}
