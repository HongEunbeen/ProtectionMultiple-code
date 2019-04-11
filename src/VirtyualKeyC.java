
public class VirtyualKeyC {
	
	public String key = "";
	public static String alpabet = "ABCDEFGHIJKLMNOPQRSTUVWXY";
	public char table[][];
	public String Stable[][];
	String setNewKey;
	boolean setFlag;
	int setCount;
	int arrQ[][];
	
	VirtyualKeyC(String key) {
		this.key = key;
		table = new char[5][5];
		Stable = new String[5][5];
		setNewKey = "";
		setFlag = false; 
		setCount = 0;
		arrQ = new int[1][2];
	}
	public void checkspace(){
		key = key.replaceAll(" ", "");	
	}
	public String[][] setTable() {
		key += alpabet;
		checkspace();
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
				if(table[i][j] == 'Q') {
					Stable[i][j] = String.valueOf(table[i][j]) + "/Z";
					arrQ[0][0] = i;
					arrQ[0][1] = j;
				}else {
					Stable[i][j] = String.valueOf(table[i][j]);
				}
				
			}
		}
		//String 배열로 변환
		return Stable;
	}
	public String getkey(){
		return key;
	}
	public int[][] getarrQ() {
		return arrQ;
	}
}
