package com.javamike.opt;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

/**
 * @author huangh
 * @date 2019-07-07 19:39
 * @email huangh@lerongsoft.com
 * @desc
 */
public class ClientOpt {

    private static MongoDatabase mongoDatabase;

    /**
     * 连接mongoDB
     *
     * @return
     */
    private MongoDatabase connect(){
        // To connect to mongodb server
        MongoClient mongoClient = new MongoClient("47.107.170.100", 27017);

        // Now connect to your databases
        mongoDatabase = mongoClient.getDatabase("javamike");

        System.out.println("Connect to database successfully!");
        System.out.println("MongoDatabase inof is : "+mongoDatabase.getName());

        return mongoDatabase;
    }

    /**
     * 查询数据
     */
    public void query(){
        connect();

        //获取集合
        MongoCollection<Document> c = mongoDatabase.getCollection("user");

        FindIterable<Document> documents = c.find();
        MongoCursor<Document> iterator = documents.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    /**
     * 增加数据
     */
    public void add(){
        connect();

        //获取集合
        MongoCollection<Document> c = mongoDatabase.getCollection("user");

        //插入数据
        Document d1 = new Document();
        d1.append("name", "javamike").append("sex", "male");
        c.insertOne(d1);
    }

    /**
     * 修改数据
     */
    public void update(){
        connect();

        //获取集合
        MongoCollection<Document> c = mongoDatabase.getCollection("user");

        //修改数据
        c.updateOne(Filters.eq("name", "javamike"), new Document("$set", new Document("name", "javamikes")));
    }

    /**
     * 删除数据
     */
    public void delete(){
        connect();

        //获取集合
        MongoCollection<Document> c = mongoDatabase.getCollection("user");

        //删除数据
        c.deleteOne(Filters.eq("name", "javamikes"));
    }

}
