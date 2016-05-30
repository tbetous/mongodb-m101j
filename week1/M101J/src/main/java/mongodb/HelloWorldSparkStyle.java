package mongodb;

import spark.Spark;

/**
 * Created by Thomas Betous on 30/05/2016.
 */
public class HelloWorldSparkStyle {
    public static void main(String[] args) {
        Spark.get("/hello", (req,res) -> "Hello World !");
    }
}
