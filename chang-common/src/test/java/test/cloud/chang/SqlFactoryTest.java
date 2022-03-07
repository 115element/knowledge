package test.cloud.chang;

import com.cloud.chang.util.sql.SQLFactory;

public class SqlFactoryTest {

	public static void main(String[] args) {

		String sql = SQLFactory.getSql("insert_cmm_day_stat");

		System.out.println(sql);

	}

}
