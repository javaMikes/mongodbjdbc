import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;


/**
 * @author huangh
 * @date 2019-07-06 16:45
 * @email huangh@lerongsoft.com
 * @desc
 */
public class Main {

    public static void main(String[] args) {

        try {

            // To connect to mongodb server
            MongoClient mongoClient = new MongoClient("47.107.170.100", 27017);

            // Now connect to your databases
            MongoDatabase mgdb = mongoClient.getDatabase("javamike");

            System.out.println("Connect to database successfully!");
            System.out.println("MongoDatabase inof is : "+mgdb.getName());

            //获取集合
            MongoCollection<Document> c = mgdb.getCollection("user");

            //插入数据
            Document d1 = new Document();
            d1.append("name", "javamike").append("sex", "male");
            c.insertOne(d1);

            //修改数据
            c.updateOne(Filters.eq("name", "javamike"), new Document("$set", new Document("name", "javamikes")));

            //删除数据
            c.deleteOne(Filters.eq("name", "javamikes"));

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }
}
