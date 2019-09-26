package Model;

public class Key {
	
	private char[] key;
	private int length = 12;
	private int minIndex = 0;
	private int maxIndex = 11;

	public Key() {
		this.setKey(new char[this.length]);
		
		this.setMinIndex(0);
		this.setMaxIndex(this.length - 1);
		
		for (int i = 0; i < this.getKey().length; i++) {
			this.getKey()[i] = 'a';
		}
	}

	public Key(Key key) {
		this.setLength(key.getKey().length);
		
		this.setKey(new char[this.length]);
		
		this.setMinIndex(0);
		this.setMaxIndex(this.length - 1);
		
		for (int i = 0; i < this.getKey().length; i++) {
			this.getKey()[i] = key.getKey()[i];
		}
	}

	public Key(int length) {
		this.setLength(length);
		
		this.setKey(new char[this.length]);
		
		this.setMinIndex(0);
		this.setMaxIndex(this.length - 1);
		
		for (int i = 0; i < this.getKey().length; i++) {
			this.getKey()[i] = 'a';
		}
	}

	public Key(String keyPart) {
		keyPart = keyPart.toLowerCase();
		
		if (keyPart.length() > this.length) {
			this.setLength(keyPart.length());
		}
		
		this.setKey(new char[this.getLength()]);
		
		this.setMinIndex(keyPart.length());
		this.setMaxIndex(this.getLength() - 1);

		for (int i = 0; i < this.getMinIndex(); i++) {
			this.getKey()[i] = keyPart.charAt(i);
		}
		for (int i = this.getMinIndex(); i <= this.getMaxIndex(); i++) {
			this.getKey()[i] = 'a';
		}
	}

	public Key(String keyPart, int length) {
		keyPart = keyPart.toLowerCase();

		if (keyPart.length() > length) {
			length = keyPart.length();
		}
		
		this.setLength(length);
		
		this.setKey(new char[this.getLength()]);
		
		this.setMinIndex(keyPart.length());
		this.setMaxIndex(this.getLength() - 1);

		for (int i = 0; i < this.getMinIndex(); i++) {
			this.getKey()[i] = keyPart.charAt(i);
		}
		for (int i = this.getMinIndex(); i <= this.getMaxIndex(); i++) {
			this.getKey()[i] = 'a';
		}
	}
	
	public boolean increment() {
		int varLength = this.getMaxIndex() - this.getMinIndex() + 1;
		
		if (varLength == 0) {
			return false;
		}
		
		char[] varKey = new char[varLength];
		
		for (int i = 0; i < varKey.length; i++) {
			varKey[i] = this.getKey()[this.getMinIndex() + i];
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
				this.getKey()[this.getMinIndex() + i] = varKey[i];
			}
			
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean incrementChar(int index) {
		if (index >= this.getMinIndex() && index <= this.getMaxIndex()) {
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
	
	public int getLength() {
		return this.length;
	}

	private void setLength(int length) {
		this.length = length;
	}
	
	public int getMinIndex() {
		return this.minIndex;
	}

	private void setMinIndex(int minIndex) {
		this.minIndex = minIndex;
	}
	
	public int getMaxIndex() {
		return this.maxIndex;
	}

	private void setMaxIndex(int maxIndex) {
		this.maxIndex = maxIndex;
	}

}
