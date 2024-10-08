// Create sparkSession and apply cache() on DataFrame
val spark:SparkSession = SparkSession.builder()
    .master("local[1]")
    .appName("ccspark")
    .getOrCreate()

import spark.implicits._
val columns = Seq("Seqno","Quote")
val data = Seq(("1", "Be the change that you wish to see in the world"),
    ("2", "Everyone thinks of changing the world, but no one thinks of changing himself."),
    ("3", "The purpose of our lives is to be happy."))
val df = data.toDF(columns:_*)

val dfCache = df.cache()
dfCache.show(false)
