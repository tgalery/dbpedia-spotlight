MAVEN_OPTS='-Xmx15G' mvn -pl index exec:java  -Dexec.mainClass=org.dbpedia.spotlight.db.CreateSpotlightModel -Dexec.args="en_US ../data/model-data-copy ../data/model-data-copy None stopwords.list EnglishStemmer" -e -MAVEN_OPTS='-Xmx15G' mvn -pl index exec:java  -Dexec.mainClass=org.dbpedia.spotlight.db.CreateSpotlightModel -Dexec.args="en_US ../data/model-data-copy ../data/model-data-copy None stopwords.list EnglishStemmer" -e -X
