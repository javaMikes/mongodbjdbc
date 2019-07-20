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

        // ����Morphia�������ҵ������
        // ����Ϊ��ͬ�İ���������ж�εĵ���
//        morphia.mapPackage("com.javamike.entity");

        //����datastore�������ӵ�ָ�����ݿ�
        //datastore��������������һ���������ӵ�MongoDB���ڶ��������ݿ�����֡�
        final Datastore datastore = morphia.createDatastore(new MongoClient("47.107.170.100"), "javamike");
        datastore.ensureIndexes();

//        User user = new User();
//
//        user.setAddress("����");
//        user.setHobby("��ë��");
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
