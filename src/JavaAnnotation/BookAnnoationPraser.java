package JavaAnnotation;

import java.lang.reflect.Field;

/**
 * Created by bwelco on 2016/12/2.
 */
public class BookAnnoationPraser {

    public static void getBookInfo(Class<?> clazz){
        Field[] fields = clazz.getDeclaredFields();

        for (Field f : fields) {
            BookName bookName = f.getAnnotation(BookName.class);
            if (bookName != null) {
                System.out.print("bookname = " + bookName.getName());
            }
        }
    }

    public enum EnumTest{
        MON("mon"){
            @Override
            public boolean isreset() {
                return false;
            }
        }, TUE("tue"){
            @Override
            public boolean isreset() {
                return false;
            }
        }, WES("wes"){
            @Override
            public boolean isreset() {
                return false;
            }
        },THUS("thus"){
            @Override
            public boolean isreset() {
                return false;
            }
        };

        String s;
        EnumTest(String s){
            this.s = s;
        }

        public String getS() {
            return s;
        }

        public abstract boolean isreset();
    }

    public static <T> T getMiddle(T[] b) {
        return b[b.length/2];
    }


    public static void main(String[] args) {
        BookAnnoationPraser.getBookInfo(Book.class);

        int i = 0;
        EnumTest.MON.getS();
    }
}
