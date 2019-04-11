import java.util.ArrayList;

public class DecryptionC{
	private String key;
	private String DecryText;
	private String SecurityText;
	private ArrayList<char[]> NOverList;
	private ArrayList<char[]> PlainList;
	public String Stable[][];
	public int[][] arrQ;
	public String space;
	public String checkZ;
	public boolean checkOdd;
	public String checkX;
	DecryptionC(String[][] table ,String key, int [][] arrQ ,String space, boolean checkOdd ,String z,
																		String checkX, String SecurityText){
		this.key = key;
		this.SecurityText = SecurityText;
		this.arrQ = arrQ;
		this.space = space;
		this.checkOdd = checkOdd;
		this.checkZ = z;
		this.checkX = checkX;
		DecryText = "";
		NOverList = new ArrayList<char[]>();
		PlainList = new ArrayList<char[]>();
		Stable = table;
		System.out.println(space);
		System.out.println(checkZ);
	}
	
	public void CheckSpace() {
		SecurityText = SecurityText.replaceAll(" ", "");
	}
	public void CheckOverLap(){
		CheckSpace();
		for( int i = 0 ; i < SecurityText.length() ; i+=2 ){
			char[] temp = new char[2];
			temp[0] = SecurityText.charAt(i);
			temp[1] = SecurityText.charAt(i+1);
			NOverList.add(temp);
			System.out.println(temp);
		}
	}
	public String CreDecry() {
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0, i = 0;
		while(i < NOverList.size()){
			char[] temp = new char[2];
			for( int j = 0 ; j < Stable.length; j++ ){
				for( int z = 0 ; z < Stable[j].length; z++ ){			
					if(Stable[j][z].charAt(0) == NOverList.get(i)[0]){
						x1 = j;
						y1 = z;
					}
					if(Stable[j][z].charAt(0) == NOverList.get(i)[1]){
						x2 = j;
						y2 = z;
					}
				}
			}
			
			if(x1==x2){
				temp[0] = Stable[x1][(y1+4)%5].charAt(0);
				temp[1] = Stable[x2][(y2+4)%5].charAt(0);
			}
			else if(y1==y2){
				temp[0] = Stable[(x1+4)%5][y1].charAt(0);
				temp[1] = Stable[(x2+4)%5][y2].charAt(0);
			}
			else{
				temp[0] = Stable[x2][y1].charAt(0);
				temp[1] = Stable[x1][y2].charAt(0);
			}
			
			PlainList.add(temp);
			System.out.println(temp);
			i++;
		}
		
		System.out.println(DecryText);
		
		reXText();
		reZText();
		reSpaceText();

		return DecryText;
	}
	public void reXText() {
		for(int i = 0 ; i < PlainList.size(); i++){
			if(i != PlainList.size()-1 && PlainList.get(i)[1]=='X'&& PlainList.get(i)[0]==PlainList.get(i+1)[0]){
				DecryText += PlainList.get(i)[0];
			}else{
				DecryText += PlainList.get(i)[0]+""+PlainList.get(i)[1];
			}
		}
		if(checkOdd) {
			DecryText = DecryText.substring(0,DecryText.length()-1);
		}
	}
	public void reZText() {
		for(int i = 0 ; i < DecryText.length() ; i++ ){
			if(checkZ.charAt(i) == '1') {
				DecryText = DecryText.substring(0,i)+'Z'+DecryText.substring(i+1,DecryText.length());
			}
		}
		
	}
	public void reSpaceText() {
		for( int i = 0 ; i < DecryText.length() ; i++){
			if(space.charAt(i)=='1'){
				DecryText = DecryText.substring(0,i)+" "+DecryText.substring(i,DecryText.length());
			}
		}
	}
}