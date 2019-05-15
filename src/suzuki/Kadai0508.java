package suzuki;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Kadai0508 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int x = 0;
		do { //正しい値が入力されるまで繰り返す
			try {
				System.out.println("整数（1～65535）を入力してください。");
				x = scn.nextInt();
				if(1 <= x && x <= 65535) {
					break;
				}else {
					System.out.println("不正な値です。");
				}
			}catch(InputMismatchException e) {
				System.out.println("不正な値です。");
				scn.next();
			}
		}while(true);

		change(x, 2); //2進数に変換
		change(x,16); //16進数に変換

		scn.close();
	}

	//入力された10進数numをnum2で指定した進数に変換
	public static void change(int num, int num2) {
		StringBuilder sb = new StringBuilder();
		int ans = num;
		while(ans != 0) { //商が0になるまでnum2で割る
			String amari = String.valueOf(ans % num2);
			switch (amari) { //10～15はA～Fに置き換え
			case "10":
				amari = "A";
				break;
			case "11":
				amari = "B";
				break;
			case "12":
				amari = "C";
				break;
			case "13":
				amari = "D";
				break;
			case "14":
				amari = "E";
				break;
			case "15":
				amari = "F";
				break;
			default:
			}
			sb.append(amari); //余りを文字列に加える
			ans /= num2;
		}
		System.out.println("10進数 " + num + " は"
					+ num2 + "進数の " + sb.reverse() + " です。");
	}

}
