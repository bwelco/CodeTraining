package OJTrain;

/**
 * Created by bwelco on 2016/11/27.
 */

/*请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。*/
public class Day1_01_SpaceReplace {


    public String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ", "%20");
    }


    public static void main(String[] args) {
        Day1_01_SpaceReplace replace = new Day1_01_SpaceReplace();
        System.out.print(replace.replaceSpace(new StringBuffer("we are young")));
    }
}
