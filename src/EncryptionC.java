import java.util.ArrayList;

public class EncryptionC{
	private String key;
	private String EncyrText;
	private String PlainText;
	private ArrayList<char[]> NOverArr;
	private ArrayList<char[]> EncryArr;
	public String Stable[][];
	
	EncryptionC(String[][] table ,String key, String PlainText){
		this.key = key;
		this.PlainText = PlainText;
		EncryArr = new ArrayList<char[]>();
		NOverArr = new ArrayList<char[]>();
		Stable = table;
	}
	public void CheckSpace() {
		PlainText = PlainText.replaceAll(" ", "");
		System.out.println(PlainText);
	}
	public void CheckOverLap(){
		for( int i = 0 ; i < PlainText.length() ; i+=2 ){
			char[] temp = new char[2];
			temp[0] = PlainText.charAt(i);
			try{
				if( PlainText.charAt(i) == PlainText.charAt(i+1)){
					temp[1] = 'x';
					i--;
				}else{
					temp[1] = PlainText.charAt(i+1);
				}
			}catch(StringIndexOutOfBoundsException e){
				temp[1] = 'x'; 
			}
			NOverArr.add(temp);
			System.out.println(temp);
		}
	}
/*	public void CreEncry() {
		int x1 = 0 , x2 = 0 , y1 = 0, y2 = 0;
		for(int i = 0 ; i < NOverArr.size() ; i++){
			char[] temp = new char[2];
			for( int j = 0 ; j < Stable.length; j++ ){
				for( int z = 0 ; z < Stable[j].length; z++ ){
					if(Stable[j][z].equals(NOverArr.get(i)[0])){
						x1 = j;
						y1 = z;
					}
					if(Stable[j][z].equals(NOverArr.get(i)[1])){
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
			EncryArr.add(temp);	
		}
		for(int i = 0 ; i < EncryArr.size() ; i++){
			EncyrText += EncryArr.get(i)[0]+""+EncryArr.get(i)[1]+" ";
		}
		System.out.println(EncyrText);
	}*/
}
