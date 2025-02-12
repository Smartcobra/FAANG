//package read_billion_reacords;
//
//import org.apache.avro.generic.GenericData;
//import org.apache.parquet.hadoop.ParquetReader;
//import org.apache.parquet.hadoop.ParquetReader.Builder;
//import org.apache.parquet.hadoop.util.HadoopInputFile;
//import org.apache.parquet.avro.AvroParquetReader;
//import org.apache.hadoop.conf.Configuration;
//
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.HashMap;
//import java.util.Map;
//public class Apache_Parquet {
//    static class Stats {
//        double min;
//        double max;
//        double sum;
//        long count;
//    }
//
//    public static void main(String[] args) throws IOException {
//        String parquetFile = "data/real_estate_prices.parquet";
//        processParquet(parquetFile);
//    }
//
//    private static void processParquet(String parquetFile) throws IOException {
//        long startTime = System.currentTimeMillis();
//
//        Configuration conf = new Configuration();
//        HadoopInputFile inputFile = HadoopInputFile.fromPath(
//                new org.apache.hadoop.fs.Path(Paths.get(parquetFile).toAbsolutePath().toString()),
//                conf
//        );
//        Builder<GenericData.Record> builder = AvroParquetReader.<GenericData.Record>builder(inputFile);
//        try (ParquetReader<GenericData.Record> reader = builder.build()) {
//
//            Map<String, Stats> statsMap = new HashMap<>();
//
//            GenericData.Record record;
//            while ((record = reader.read()) != null) {
//                // Assuming the schema has fields: property_id (string), price (double)
//                String propertyId = record.get("property_id").toString();
//                double price = (double) record.get("price");
//
//                Stats st = statsMap.get(propertyId);
//                if (st == null) {
//                    st = new Stats();
//                    st.min = price;
//                    st.max = price;
//                    st.sum = price;
//                    st.count = 1;
//                    statsMap.put(propertyId, st);
//                } else {
//                    if (price < st.min) st.min = price;
//                    if (price > st.max) st.max = price;
//                    st.sum += price;
//                    st.count++;
//                }
//            }
//
//            // Print results
//            System.out.print("{");
//            for (Map.Entry<String, Stats> entry : statsMap.entrySet()) {
//                double avg = entry.getValue().sum / entry.getValue().count;
//                System.out.printf("%s=%.1f/%.1f/%.1f, ", entry.getKey(), entry.getValue().min, avg, entry.getValue().max);
//            }
//            System.out.println("\b\b}");
//        }
//
//        long endTime = System.currentTimeMillis();
//        System.out.println("Parquet processing duration: " + (endTime - startTime) / 1000.0 + " seconds");
//    }
//}
