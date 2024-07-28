from pyspark.sql import SparkSession
from pyspark.sql.functions import avg
from pyspark import SparkContext

spark = SparkSession.builder.appName("Rdd Level 1").getOrCreate()
sc = spark.sparkContext

dataDF = spark.createDataFrame([("Brooke", 20), ("Denny", 31), ("Jules", 30),("TD", 35), ("Brooke", 25)], ["name", "age"])
dataDFLow = sc.parallelize([("Brooke", 20), ("Denny", 31), ("Jules", 30),("TD", 35), ("Brooke", 25)])

# Low Level RDD

print("Low Level RDD")
agesRDD = (dataDFLow.map(lambda x: (x[0], (x[1], 1))) \
    .reduceByKey(lambda x, y: (x[0] + y[0], x[1] + y[1])) \
        .map(lambda x: (x[0], x[1][0]/x[1][1])))
print("Low level RDD OPERATIONS:- ")
print(agesRDD.collect())

# High Level RDD
print("High Level RDD:- ")
avg_df = dataDF.groupBy("name").agg(avg("age"))

avg_df.show()

print("Total Records:- ", avg_df.count())