import java.util.ArrayList;

public class EncryptionC{
	private String key;
	private String EncyrText;
	private String PlainText;
	private ArrayList<char[]> NOverList;
	private ArrayList<char[]> EncryList;
	public String Stable[][];
	public int[][] arrQ;
	public String checkZ;
	public String checkX;
	public boolean checkOdd;
	public String checkSpace;
	EncryptionC(String[][] table ,String key, int [][] arrQ , String PlainText){
		this.key = key;
		this.PlainText = PlainText;
		EncyrText = "";
		checkSpace = "";
		EncryList = new ArrayList<char[]>();
		NOverList = new ArrayList<char[]>();
		Stable = table;
		this.arrQ = arrQ;
		checkOdd = false;
		checkZ = "";
		checkX ="";
	}
	public String CheckX() {
		return checkX;
	}
	public String CheckZ(){
		for( int i = 0 ; i < PlainText.length() ; i++ ) {
			if(PlainText.charAt(i)=='Z'){
				checkZ+=1;
			}else{
				checkZ+=0;
			}
			System.out.println(PlainText.charAt(i));
		}
		
		System.out.println(checkZ);
		PlainText = PlainText.replaceAll("Z", "Q");
		return checkZ;
	}
	public String CheckSpace() {
		for( int i = 0 ; i < PlainText.length() ; i++ ) {
			if(PlainText.charAt(i)==' '){
				checkSpace+=1;
			}else{
				checkSpace+=0;
			}
		}
		PlainText = PlainText.replaceAll(" ", "");
		return checkSpace;
	}
	public void CheckOverLap(){
		for( int i = 0 ; i < PlainText.length(); i+=2 ){
			char[] temp = new char[2];
			temp[0] = PlainText.charAt(i);
			try{
				if( PlainText.charAt(i) == PlainText.charAt(i+1)){
					temp[1] = 'X';
					checkX += 1;
					i--;
				}else{
					temp[1] = PlainText.charAt(i+1);
					checkX += 0;
				}
			}catch(StringIndexOutOfBoundsException e){
				temp[1] = 'X';
				checkOdd = true;
			}
			NOverList.add(temp);
			System.out.println(temp);
		}
	}
	
	public String CreEncry() {
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		int i = 0;
		while(i < NOverList.size()) {
			char[] temp = new char[2];
			for(int j = 0 ; j < Stable.length; j++){
				for(int z = 0 ; z < Stable[j].length; z++){
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
				temp[0] = Stable[x1][(y1+1)%5].charAt(0);
				temp[1] = Stable[x2][(y2+1)%5].charAt(0);
			}
			else if(y1==y2){
				temp[0] = Stable[(x1+1)%5][y1].charAt(0);
				temp[1] = Stable[(x2+1)%5][y2].charAt(0);
			} 
			else{
				temp[0] = Stable[x2][y1].charAt(0);
				temp[1] = Stable[x1][y2].charAt(0);
			}
			EncryList.add(temp);
			i++;
		}
		for(int j = 0 ; j < EncryList.size() ; j++){
			EncyrText += EncryList.get(j)[0]+""+EncryList.get(j)[1]+" ";
		}
		System.out.println(EncyrText);
		return EncyrText;
	}
}
