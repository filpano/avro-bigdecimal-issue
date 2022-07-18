package org.example;

import org.apache.avro.Conversions;
import org.apache.avro.Schema;
import org.apache.avro.reflect.ReflectData;
import org.example.model.Transaction;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws IOException {
        Schema schema = generateSchema(Transaction.class);
        String dirPath = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "generated" + File.separator;
        String schemaFilename = "Transaction.avsc";
        File pathToSchema = new File(dirPath);
        assert pathToSchema.exists() || pathToSchema.mkdirs();

        Files.write(Paths.get(dirPath + schemaFilename), schema.toString(true).getBytes(StandardCharsets.UTF_8));
    }

    private static Schema generateSchema(Class<?> clazz) {
        ReflectData rd = ReflectData.AllowNull.get();
        rd.addLogicalTypeConversion(new Conversions.UUIDConversion());
        // This doesn't work because the conversion doesn't register a default recommended schema
        // see org.apache.avro.Conversions.DecimalConversion.getRecommendedSchema
        // what is the point of having it then...?
        //rd.addLogicalTypeConversion(new Conversions.DecimalConversion());
        return rd.getSchema(clazz);
    }
}
