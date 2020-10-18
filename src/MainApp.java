import jdk.nashorn.internal.ir.Block;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class MainApp {
    public static void main(String[] args) throws IOException {
        BlockMap map = BlockMap.readBlockMap("block.csv");

        Tag tag = Tag.readFrom(new FileInputStream("test.schematic"));
        Tag blocks = tag.findTagByName("Blocks");
        tag.print();
        tag.writeTo(new FileOutputStream("test2.schematic"));
    }
}
