package JavaAnnotation;

/**
 * Created by bwelco on 2016/12/2.
 */
public class Book {


    @BookName(getName = "admin")
    String bookName;

    @BookPrice(getValue = 1)
    String bookPrice;

}
