Example project showcasing an issue with Avro schema generation using the ReflectData API when dealing with POJOs containing BigDecimal properties.

Generating the schema can be done by running the single main class.

Adding the commented-out portion in `org.example.Main#generateSchema:31` causes the generation to stop with an exception.

See the related StackOverflow question [here](https://stackoverflow.com/questions/72981329/generating-an-avro-schema-from-a-pojo-containing-a-java-lang-bigdecimal-does-not).
