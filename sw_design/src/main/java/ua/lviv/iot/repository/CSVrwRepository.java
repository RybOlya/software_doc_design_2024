package ua.lviv.iot.Taxi.repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvException;
import org.springframework.stereotype.Repository;
import ua.lviv.iot.repository.StorgeRepository;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

@Repository
public class CSVrwRepository implements StorgeRepository {
    @Override
    public List<String[]> readAll(String filepath) {
        try (CSVReader reader = new CSVReader(new FileReader(filepath))) {
            List<String[]> result = reader.readAll();
            return result;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void writeAll(String filepath, List<String[]> data) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filepath))) {
            writer.writeAll(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}