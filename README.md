# PacSearch

PacSearch is an index search engine

## Installation

...

## Usage

...

## Infos

We will develop a distributed index engine a little bit like Elasticsearch. An index engine accelerates the recovery of
data from a database. The data is stored in memory.

### Objectives:

1. Ingest data: Load data as quickly as possible.
2. Find the lines: Make queries allowing you to quickly find fine data. Similar SQL functions are the SELECT… WHERE
3. Distribute the dataset: Turning over 3 nodes, develop the best way to distribute the data

### Technologies

Back-end : JAX-RS or vert.x, full Java Infrastructure : Git, Maven, GitHub

### Characteristics

Using JAX-RS or vert.x, we will create a REST API in JSON format to:
1 - Create tables: Like SQL tables, they have named columns having a type

2 - Add indexes: An index is defined on 1… n columns of the table

3 - Load data: In CSV format, 1 file at a time which will be parsed and each row will be inserted in the indexes of the
table

4 - Retrieve index lines: Using the appropriate index, the engine will be able to return lines searched

### Big steps:

1. Develop the REST API Define a standard REST API to perform the 4 operations above.

2. Add support for tables / indexes The internal structure will remain simple (HashMap, ...) but will make it possible
   to obtain the first convincing results on a low volume.

3. Load data Perform CSV parsing and ingestion of rows in the indexes of a table

4. Distribute the server To be able to make the nodes communicate. When an action is performed on a node, it is passed
   on to others. Each node knows the tables, indexes ... THEs notions of fault tolerance and replication are not the
   objective of the project.


5. Make the program effective

- Be able to have the most lines in available memory
- Load / Recover data as quickly as possible
- Discover indexing techniques (B-Tree, hash, ...)

### Additional features:

- Support of aggregates (SUM, AVG, MIN, MAX, COUNT) as in SQL
- Update / delete rows in indexes
- Support of HAVING ORDER BY LIMIT
- Administration of tables / indexes (deletion, addition of columns ...)
- Addition of functions like CONTAINS, YEAR ... in the selection requests
- any other feature that is useful

where to find real data ?

The defense will be done on the NYC CAB dataset. This is public data on journeys ds New York taxis. It is accessible
here:
https://www1.nyc.gov/site/tlc/about/tlc-trip-record-data.page
and we will focus on files named ‘Yellow’ so neither Green nor FHV). Use the data from 2009 to 2015.

We re talking about data of billion of lines, more than 725 mo files !!!!! ALL IN MEMORY !!!!

## Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License

GNU GENERAL PUBLIC LICENSE Version 3.0
