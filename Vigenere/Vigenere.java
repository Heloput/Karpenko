 import java.util.Scanner;

class Vigener{
	private  int bias, letters;
	
	public Vigener( int bias, int letters) {
		this.letters = letters;
		this.bias = bias;
	}
	
	public String encrypt(String text, String key) {
		String encrypt = "";
		int keyLen = key.length();
		for(int i = 0, len = text.length();i < len; i++) {
			char c = text.charAt(i);
			if(c == ' ' ) encrypt += ' ';
			else
			encrypt += (char)(((c + key.charAt(i % keyLen) - 2 * this.bias)%this.letters)+this.bias);
		}

		return encrypt;
	}

	public String decrypt ( String cipher, String key) {
		String decrypt = "";
		int keyLen = key.length();
		for(int i = 0, len = cipher.length(); i < len; i++) {
			char c = cipher.charAt(i);
			if(c == ' ' ) decrypt += ' ';
			else
			decrypt += (char) (((c - key.charAt(i % keyLen) + this.letters)%this.letters)+this.bias);
		}
		return decrypt;
	}
 }

class Cesar{
	private int bias, letters;
	
	public Cesar(int bias, int letters) {
		this.bias = bias;
		this.letters = letters;
	}
	
	String encrypt(String text, int key) {
		String encrypt = "";
		for(int i = 0, len = text.length(); i < len; i++) {
			char c = text.charAt(i);
			if(c == ' ') encrypt += ' ';
			else
			encrypt += (char)(((c + key - this.bias)% letters)+this.bias);
		}
		
		return encrypt;
	}
	
	String decrypt(String cipher, int key) {
		String decrypt = "";
		for(int i = 0, len = cipher.length();i < len; i++) {
			char c = cipher.charAt(i);
			if(c == ' ') decrypt += ' ';
			else
			decrypt += (char)(((c - key + this.bias)% letters)+this.bias);
		}
		return decrypt;
	}
}

class Vigenere {
	@SuppressWarnings("resource")
	public static void main (String [ ] argc) {
		
		Scanner sc = new Scanner(System.in);
	
		System.out.print("Введите текст: ");
		String text = sc.nextLine();
		
		System.out.print("Введите ключ(Для Виженера): ");
		String key = sc.nextLine();
		
		System.out.print("Введите ключ(Для Цезаря): ");
		int keyCesar= sc.nextInt();	
	
		key = key.substring(0).toUpperCase();	
		text = text.substring(0).toUpperCase();
		

		//1040, 32 для русского.
		//65 - 90 .... 26 для английского языка.
		
		String enc;
		Vigener v = new Vigener(65, 26);
		Cesar c = new Cesar(65, 26);
		
		System.out.print("Ваш шифр(Для Виженера: ");
	
		enc =  v.encrypt(text, key);
		System.out.println(enc);
		
		System.out.print("Расшифровка: ");
		enc = v.decrypt(enc, key);
		System.out.println(enc);
		
		System.out.print("Ваш шифр(Для цезаря): ");
		enc = c.encrypt(text, keyCesar);
		System.out.println(enc);
		
		System.out.print("Расшифровка: ");
		enc = c.decrypt(enc, keyCesar);
		System.out.println(enc);
		
	
	}
}




