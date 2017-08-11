package co.jp.higschool;

class Pd extends Section {

	@Override
	void shwo(String str,String str2,String str3) {
		String[] lien = str.split(",", 0);
		System.out.println("私は" + str + "の従業員番号" + str2 + str3 + "です。");
		System.out.println("仕事内容：ナンパ");
	}
}
