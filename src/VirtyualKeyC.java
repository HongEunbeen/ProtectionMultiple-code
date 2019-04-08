
public class VirtyualKeyC {
	
	public String key = "";
	public static String alpabet = "abcdefghijklmnopqrstuvwxyz";
	public char table[][];
	public String Stable[][];
	String setNewKey;
	boolean setFlag;
	int setCount;
	
	VirtyualKeyC(String key) {
		this.key = key;
		table = new char[5][5];
		Stable = new String[5][5];
		setNewKey = "";
		setFlag = false; 
		setCount = 0;
	}
	
	public String[][] setTable() {
		key += alpabet;
		// 중복처리
		for( int i = 0 ; i < key.length() ; i++) {
			for( int j = 0 ; j < setNewKey.length() ; j++){
				if(key.charAt(i) == setNewKey.charAt(j)){
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
				Stable[i][j] = String.valueOf(table[i][j]);
			}
		}
		//String 배열로 변환
		return Stable;
	}
	public String getkey(){
		return key;
	}
}
