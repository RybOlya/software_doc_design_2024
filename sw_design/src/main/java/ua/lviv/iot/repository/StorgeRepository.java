package ua.lviv.iot.repository;

import java.util.List;

public interface StorgeRepository {
    public List<String[]> readAll(String filepath);

    public void writeAll(String filepath, List<String[]> data);
}