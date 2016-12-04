package APT;

import com.google.gson.Gson;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.VariableElement;
import javax.lang.model.util.ElementFilter;
import javax.lang.model.util.Elements;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by bwelco on 2016/12/2.
 */
public class BeanProcesser extends AbstractProcessor {

    Elements elementUtils;

    @Override
    public synchronized void init(ProcessingEnvironment processingEnv) {
        super.init(processingEnv);

        // 元素操作的辅助类
        elementUtils = processingEnv.getElementUtils();

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {

        // 获得被该注解声明的元素
        Set<? extends Element> elements = roundEnv
                .getElementsAnnotatedWith(Seriable.class);

        // 类元素
        TypeElement classElement = null;
        // 变量元素
        ArrayList<VariableElement> fieldsElement = new ArrayList<VariableElement>();

        // 存放两者
        HashMap<String, ArrayList<VariableElement>> map = new HashMap<String, ArrayList<VariableElement>>();

        // 遍历注解的元素
        for (Element element : elements) {
            // 判断是否是类元素
            if (element.getKind() == ElementKind.CLASS) {
                classElement = (TypeElement) element;
                map.put(classElement.getQualifiedName().toString(), fieldsElement = new ArrayList<VariableElement>());
            } else if (element.getKind() == ElementKind.FIELD) {

                // 判断是否是变量
                VariableElement variableElement = (VariableElement) element;
                // 获取该元素封装类型
                TypeElement enclosingElement = (TypeElement) variableElement
                        .getEnclosingElement();
                String key = enclosingElement.getQualifiedName().toString();

                if (map.containsKey(key)) {
                    // 如果存在这个类，就往类里面添加
                    map.get(key).add(variableElement);
                } else {
                    // 不存在就创建新key
                    map.put(key, fieldsElement = new ArrayList<VariableElement>());
                }
            }
        }


        for (String key : map.keySet()) {
            if (map.get(key).size() == 0) {
                // 把用注解修饰的类里面的所有成员都加进去
                TypeElement typeElement = elementUtils.getTypeElement(key);
                List<? extends Element> allMembers = elementUtils
                        .getAllMembers(typeElement);
                if (allMembers.size() > 0) {
                    map.get(key).addAll(ElementFilter.fieldsIn(allMembers));
                }
            }
        }

        Gson gson = new Gson();
        String json = gson.toJson(map);
        File file = new File("f://apt_test.json");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write(json);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
