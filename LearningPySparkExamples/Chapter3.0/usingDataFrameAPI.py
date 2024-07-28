from pyspark.sql import SparkSession
from pyspark.sql.types import *

if __name__ == "__main__":

    spark = SparkSession.builder.appName("Schema Using API").getOrCreate()

    dataD = [
        {"Id":1, "First": "Jules", "Last":"Damji", "Url":"https://tinyurl.1", "Published":"1/4/2016", "Hits": 4535, "Campaigns": ["twitter", "LinkedIn"]},
        {"Id":2, "First": "Brooke","Last": "Wenig","Url": "https://tinyurl.2", "Published": "5/5/2018", "Hits":8908, "Campaigns": ["twitter", "LinkedIn"]},
        {"Id": 3, "First": "Denny", "Last": "Lee", "Url": "https://tinyurl.3","Published": "6/7/2019","Hits": 7659, "Campaigns": ["web", "twitter", "FB", "LinkedIn"]},
        {"Id": 4, "First":"Tathagata", "Last": "Das","Url": "https://tinyurl.4", "Published": "5/12/2018", "Hits": 10568, "Campaigns": ["twitter", "FB"]},
        {"Id": 5, "First": "Matei","Last": "Zaharia","Url": "https://tinyurl.5", "Published": "5/14/2014", "Hits": 40578, "Campaigns": ["web", "twitter", "FB", "LinkedIn"]},
        {"Id":6,  "First": "Reynold", "Last": "Xin", "Url": "https://tinyurl.6", "Published": "3/2/2015", "Hits": 25568, "Campaigns": ["twitter", "LinkedIn"] }
        ]
    ## Custom Schema using Structype
    schemaD = StructType([
        StructField("Id", IntegerType(), True),
        StructField("First", StringType(), True),
        StructField("Last", StringType(), True),
        StructField("Url", StringType(),True),
        StructField("Published",StringType(),True),
        StructField("Hits", IntegerType(), True),
        StructField("Campaigns", ArrayType(StringType()), True)
    ])
    
    print("DataFrame")
    ddf = spark.createDataFrame(data=dataD, schema=schemaD)

    print("Data Frame Schema")
    ddf.printSchema()

    ddf.show()

    ## custom Schema Using DDL

    schemaDDL= """ Id int, First String, Last String, Url String, Published String, Hits int, Campaigns array<string>"""

    ddlDF = spark.createDataFrame(dataD, schemaDDL)

    print("DDL SCHEMA")

    ddlDF.printSchema()

    ddlDF.show()

    print(ddlDF.schema)

    spark.stop()