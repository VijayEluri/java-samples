package jp.canetrash.sample.hbase;

import java.util.NavigableMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;

/**
 * HBaseを操作するシンプルなサンプル
 * 
 * @author tfunato
 * 
 */
public class SimpleAccessMain {

	public static void main(String[] args) throws Exception {

		Configuration config = HBaseConfiguration.create();
		config.set("hbase.zookeeper.quorum", "cloudera-hadoop");
		HBaseAdmin admin = new HBaseAdmin(config);

		// テーブル作成
		if (!admin.isTableEnabled(Bytes.toBytes("test"))) {
			HTableDescriptor htd = new HTableDescriptor("test");
			HColumnDescriptor hcd = new HColumnDescriptor("data");
			htd.addFamily(hcd);
			admin.createTable(htd);
		}

		// データ登録
		HTable table = new HTable(config, Bytes.toBytes("test"));
		Put data = new Put(Bytes.toBytes("row-1"));
		data.add(Bytes.toBytes("data"), Bytes.toBytes("qul"), Bytes.toBytes("aiueo"));
		table.put(data);
		
		//　データ読み込み
		Result result = table.get(new Get(Bytes.toBytes("row-1")));
		NavigableMap<byte[], byte[]> familyMap = result.getFamilyMap(Bytes.toBytes("qul"));
	}
}
