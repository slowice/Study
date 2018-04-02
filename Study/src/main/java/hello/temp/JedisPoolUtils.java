package hello.temp;/*
package abg.util;


import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.io.*;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;

public class JedisPoolUtils {
    private final static Logger logger = LoggerFactory.getLogger(JedisPoolUtils.class);

    private JedisCluster jc;

    public JedisPoolUtils(String hostAndPort, int timeout, GenericObjectPoolConfig poolConfig){
        Set< HostAndPort > nodes = new HashSet< HostAndPort >();
        String[] hostAndPortArr = hostAndPort.split(",");
        for(int i = 0;i< hostAndPortArr.length;i++){
            String host = hostAndPortArr[i].split(":")[0];
            String port = hostAndPortArr[i].split(":")[1];
            nodes.add(new HostAndPort(host,Integer.parseInt(port)));
        }
        logger.info("nodes："+nodes+"timeout:"+timeout+"poolConfig:"+poolConfig);
        this. jc = new JedisCluster(nodes,timeout,poolConfig);
    }

    public String set(String key,Serializable value) throws Exception{
        return jc.set(key.getBytes(Charset.forName("UTF-8")),toByteArray(value));
    }

    public Serializable get(String key) throws Exception{
        return toObject(jc.get(key.getBytes(Charset.forName("UTF-8"))));
    }

    */
/**
     * 将bytes[]输在还原为Object对象
     * @param bytes
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     *//*


    public Serializable toObject (byte[] bytes) throws IOException, ClassNotFoundException {
        if(bytes == null){
            return null;
        }
        Serializable obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream (bytes);
            ObjectInputStream ois = new ObjectInputStream (bis);
            obj = (Serializable) ois.readObject();
            ois.close();
            bis.close();
        } catch (IOException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw e;
        }
        return obj;
    }



    */
/**
     * 将Object转化成byte[]
     * @param obj
     * @return
     * @throws IOException
     *//*

    public byte[] toByteArray (Object obj) throws IOException {
        if(obj == null){
            return null;
        }
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray ();
            oos.close();
            bos.close();
        } catch (IOException e) {
            throw e;
        }
        return bytes;
    }
}
*/
