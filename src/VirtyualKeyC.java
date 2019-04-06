
public class VirtyualKeyC {
	public static char alphabetBoard[][] = new char[5][5];
	public String key;
	public String alpabet = "abcdefghijklmnopqrstuvwxyz";
	public char table[][] = new char[5][5];
	
	String setNewKey = "";
	boolean setFlag = false;
	int setCount = 0;	
	
	VirtyualKeyC(String key) {
		this.key = key;
	}
	
	public char[][] setTable() {
		// 중복처리
		for( int i = 0 ; i < key.length() ; i++) {
			for( int j = 0 ; j < setNewKey.length() ; j++){
				if(key.charAt(i)==setNewKey.charAt(j)){
					setFlag = true;
					break;
				}
			}
			if(!(setFlag)) setNewKey += key.charAt(i);
			setFlag = false;
		}
		
		//배열에 대입
		for( int i = 0 ; i < table.length ; i++ ){
			for( int j = 0; j <table[i].length ; j++ ){
				table[i][j] = setNewKey.charAt(setCount++);
			}
		}	
		//return
		return table;
	}
}
