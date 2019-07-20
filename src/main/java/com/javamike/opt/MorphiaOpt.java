package com.javamike.opt;

import com.javamike.entity.User;
import com.mongodb.MongoClient;
import dev.morphia.Datastore;
import dev.morphia.Morphia;

import java.util.List;

/**
 * @author huangh
 * @date 2019-07-07 19:57
 * @email huangh@lerongsoft.com
 * @desc
 */
public class MorphiaOpt {

    private Datastore connect(){
        Morphia morphia = new Morphia();

        // 告诉Morphia在哪里找到你的类
        // 可以为不同的包或者类进行多次的调用
//        morphia.mapPackage("com.javamike.entity");

        //创建datastore，并连接到指定数据库
        //datastore有两个参数，第一个用来连接到MongoDB，第二个是数据库的名字。
        final Datastore datastore = morphia.createDatastore(new MongoClient("47.107.170.100"), "javamike");
        datastore.ensureIndexes();

//        User user = new User();
//
//        user.setAddress("深圳");
//        user.setHobby("羽毛球");
//        user.setSex(1);
//        user.setName("java_mike");

        return datastore;

    }

    public void save(Object object){
        Datastore datastore = connect();
        datastore.save(object);
    }

    public void query(){

        Datastore datastore = connect();

        List<User> userList = datastore.createQuery(User.class)
                .field("name").equal("java_mike")
                .asList();

        System.out.println(userList.size());

    }


}
