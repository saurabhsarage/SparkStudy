# 60 Days of Apache Spark Series A Comprehensive Guide to Apache Spark 

### Dataset Links:
  - [Retail Analysis on Large Dataset](https://www.kaggle.com/datasets/sahilprajapati143/retail-analysis-large-dataset)

## [Spark 60 days](./Spark60Days/)
 - [Create a Spark RDD using Parallelize](./Spark60Days/RDD_using_parallelize.ipynb)
 - [Read Text files into single RDD](./Spark60Days/ReadTextfile.ipynb)
 - [Read/Load CSV File into RDD and Data frame.](./Spark60Days/RddDataFrame.ipynb)


## Narrow and Wide Transformation
- ### Narrow Transformation
  -  Any transformation where a single output partition can be computed from a single input partition is a narrow transformation. 
  -  For example, in the previous code snippet, filter() and contains() represent narrow transformations because they can operate on a single partition and produce the resulting output partition without any exchange of data.
- ### Wide transformations
    - groupBy() or orderBy() instruct Spark to perform wide transformations, where data from other partitions is read in, combined, and written to disk.
    - Since each partition will have its own count of the word that contains the “Spark” word in its row of data, a count (groupBy()) will force a shuffle of data from each of the executor’s partitions across the cluster. In this transformation, orderBy() requires output from other partitions to compute the final aggregation.