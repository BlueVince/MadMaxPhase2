package Model;

public class Key {
	
	private char[] key;
	private int length = 12;
	private int minIndex = 0;
	private int maxIndex = 11;

	public Key() {
		this.setKey(new char[this.length]);
		
		this.minIndex = 0;
		this.maxIndex = this.length - 1;
		
		for (int i = 0; i < this.getKey().length; i++) {
			this.getKey()[i] = 'a';
		}
	}

	public Key(Key key) {
		this.length = key.getKey().length;
		
		this.setKey(new char[this.length]);
		
		this.minIndex = 0;
		this.maxIndex = this.length - 1;
		
		for (int i = 0; i < this.getKey().length; i++) {
			this.getKey()[i] = key.getKey()[i];
		}
	}

	public Key(int length) {
		this.length = length;
		
		this.setKey(new char[this.length]);
		
		this.minIndex = 0;
		this.maxIndex = this.length - 1;
		
		for (int i = 0; i < this.getKey().length; i++) {
			this.getKey()[i] = 'a';
		}
	}

	public Key(String keyPart) {
		keyPart = keyPart.toLowerCase();
		
		if (keyPart.length() > this.length) {
			this.length = keyPart.length();
		}
		
		this.setKey(new char[this.length]);
		
		this.minIndex = keyPart.length();
		this.maxIndex = this.length - 1;

		for (int i = 0; i < this.minIndex; i++) {
			this.getKey()[i] = keyPart.charAt(i);
		}
		for (int i = this.minIndex; i <= this.maxIndex; i++) {
			this.getKey()[i] = 'a';
		}
	}

	public Key(String keyPart, int length) {
		keyPart = keyPart.toLowerCase();

		if (keyPart.length() > length) {
			length = keyPart.length();
		}
		
		this.length = length;
		
		this.setKey(new char[this.length]);
		
		this.minIndex = keyPart.length();
		this.maxIndex = this.length - 1;

		for (int i = 0; i < this.minIndex; i++) {
			this.getKey()[i] = keyPart.charAt(i);
		}
		for (int i = this.minIndex; i <= this.maxIndex; i++) {
			this.getKey()[i] = 'a';
		}
	}
	
	public boolean increment() {
		int varLength = this.maxIndex - this.minIndex + 1;
		
		if (varLength == 0) {
			return false;
		}
		
		char[] varKey = new char[varLength];
		
		for (int i = 0; i < varKey.length; i++) {
			varKey[i] = this.getKey()[this.minIndex + i];
		}
		
		boolean incremented = false;
		
		for (int i = 0; i < varKey.length && !incremented; i++) {
			char c = varKey[i];
			
			if (c >= 'a' && c < 'z') {
				c++;
				incremented = true;
			}
			else {
				c = 'a';
				incremented = false;
			}
			
			varKey[i] = c;
		}
		
		if (incremented) {
			for (int i = 0; i < varKey.length; i++) {
				this.getKey()[this.minIndex + i] = varKey[i];
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean incrementChar(int index) {
		if (index >= this.minIndex && index <= this.maxIndex) {
			return false;
		}
		
		if (this.getKey()[index] >= 'a' && this.getKey()[index] < 'z') {
			this.getKey()[index]++;
		}
		else {
			this.getKey()[index] = 'a';
		}
		
		return true;
	}
	
	public char[] getKey() {
		return key;
	}
	
	public String getKeyString() {
		return String.valueOf(key);
	}

	private void setKey(char[] key) {
		this.key = key;
	}

}
