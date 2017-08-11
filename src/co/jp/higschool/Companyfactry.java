package co.jp.higschool;

public class Companyfactry {
	public Section createCompay(String sectioId) {
		if(sectioId.equals("2")){
			Section gad = new Gad();
			return gad;
		}else if(sectioId.equals("1")){
			Section pd = new Pd();
			return pd;
		}else if(sectioId.equals("3")){
			Section isd = new Isd();
			return isd;
		}else{
			Section etc = new Etc();
			return etc;
		}
	}
}
