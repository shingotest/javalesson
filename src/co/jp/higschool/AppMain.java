package co.jp.higschool;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

/**
 *
 * csvの内容を表示する
 *
 * @author shing
 *
 *
 */
public class AppMain {
	public static void main(String[] args) {
		Properties properties  = new Properties();
		String file = args[0];
		try{
			InputStream inputStream = new FileInputStream(file);
	        properties.load(inputStream);
	        inputStream.close();

		String csv = properties .getProperty("pas")+properties .getProperty("name");

		FileInputStream f = null;
		InputStreamReader ff = null;

		BufferedReader br;
		List<String> data = new ArrayList<String>();
		List<EmpEntity> entityList = new ArrayList<EmpEntity>();
			f = new FileInputStream(csv);
			ff = new InputStreamReader(f, "SHIFT_JIS");
			br = new BufferedReader(ff);


			CSVParser parse = CSVFormat.EXCEL.parse(br);
			List<CSVRecord> lineList = parse.getRecords();
			for (CSVRecord record :lineList) {
				int i = 0;
				EmpEntity entity = new EmpEntity();
				entity.setEnpNo(record.get(i));
				entity.setName(record.get(++i));
				entity.setEnpName(record.get(++i));
				entity.setEnpcode(record.get(++i));

				entityList.add(entity);
			}
			br.close();
			Companyfactry cop = new Companyfactry();
			for (EmpEntity str : entityList) {
				Section sec = cop.createCompay(str.getEnpcode());
				sec.shwo(str.getEnpName(),str.getEnpNo(),str.getName());
			}
		} catch (FileNotFoundException e) {
			System.out.println("ファイルがありません");
		} catch (IOException e) {
			System.out.println("読み込めませんでした");
		}catch (Exception e){
			System.out.println("予期せぬエラー");
		}
	}

}
