package co.jp.fujixerox.test1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Enploy {

	public List<String> shwoInf(String csv) {

		FileInputStream f = null;
		InputStreamReader ff = null;

		BufferedReader br;
		List<String> data = new ArrayList<String>();
		try {
			f = new FileInputStream(csv);
			ff = new InputStreamReader(f, "SHIFT_JIS");
			br = new BufferedReader(ff);

			String line;

			while ((line = br.readLine()) != null) {
				data.add(line);
			}
			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("ファイルがありません");
		} catch (IOException e) {
			System.out.println("読み込めませんでした");
		}
		return data;
	}
}
