import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

import com.csvreader.CsvReader;

public class BlockMap {
    private HashMap<String, Byte> mapId = new HashMap<>();

    /**
     * 读取方块数据值
     * @param fileName 文件路径
     * @return BlockMap 数据值列表
     * @throws IOException
     */
    public static BlockMap readBlockMap(String fileName) throws IOException {
        BlockMap map = new BlockMap();
        CsvReader reader = new CsvReader(fileName, ',');
        reader.readHeaders();
        while (reader.readRecord()) {
            map.mapId.put(reader.get("RegistryName"), Integer.valueOf(reader.get("ID")).byteValue());
        }
        reader.close();
        return map;
    }

    /**
     * 获取方块数据值，可不附加minecraft命名空间
     * @param name 方块注册名
     * @return id
     */
    public byte get(String name) {
        if (!name.startsWith("minecraft:"))
            name = "minecraft:" + name;
        return mapId.get(name);
    }

    /**
     * 获取数据值表
     * @return mapId
     */
    public HashMap<String, Byte> getMapId() {
        return mapId;
    }
}
