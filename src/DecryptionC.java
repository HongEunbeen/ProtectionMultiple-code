import java.util.ArrayList;

public class DecryptionC{
	private String key;
	private String DecryText;
	private String SecurityText;
	private ArrayList<char[]> NOverList;
	private ArrayList<char[]> DecryList;
	public String Stable[][];
	public int[][] arrQ;
	DecryptionC(String[][] table ,String key, int [][] arrQ , String SecurityText){
		this.key = key;
		this.SecurityText = SecurityText;
		DecryText = "";
		DecryList = new ArrayList<char[]>();
		NOverList = new ArrayList<char[]>();
		Stable = table;
		this.arrQ = arrQ;
	}
}