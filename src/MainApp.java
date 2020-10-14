import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainApp {
    public static void main(String[] args) throws IOException {
        FileInputStream ifs = new FileInputStream("test.schematic");
        FileOutputStream ofs = new FileOutputStream("out.schematic");
        Tag tag = Tag.readFrom(ifs);
        Tag blocks = tag.findTagByName("Blocks");

        Tag intList = new Tag(Tag.Type.TAG_Int_Array,"Array",new int[]{1,2,3,4,5,6,7,8,9});
        tag.insertTag(intList, 4);
        tag.insertTag(new Tag(Tag.Type.TAG_Int, "Int", 255), 4);
        tag.print();

        tag.writeTo(ofs);
        ifs.close();
        ofs.close();
    }
}
