package utils;

import model.Modal;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ExportCSV {
    public <T extends Modal>boolean exportCSV(List<T> objectList) {
        try {
            if (objectList.isEmpty()) return false;
            String fileName = String.valueOf(objectList.get(0).getClass()).split("\\.")[1];
            BufferedWriter bw = new BufferedWriter(new FileWriter("export/" + fileName + "_" + new Timestamp(new Date().getTime()).toString() + ".csv"));
            bw.write(objectList.get(0).toColumn());
            bw.newLine();
            for (T o : objectList) {
                bw.write(o.toColumnValue());
                bw.newLine();
            }
            bw.close();
            return true;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
