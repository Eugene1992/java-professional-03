package serial;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.StringTokenizer;

public class Serial<T>
{
    public String toJSON (T t)
    {
        Field[] fields = t.getClass().getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean zp = false;
        for (Field field : fields)
        {
            //Annotation[] an = t.getClass().getAnnotations();
            field.setAccessible(true);
            String name = field.getName();
            String value = "";
            try { value = field.get(t).toString(); }
            catch (IllegalAccessException e) { }
            if (zp) sb.append(",");
            sb.append("\n    \"" + name + "\": \"" + value + "\"");
            zp = true;
        }
        sb.append("\n}");
        return sb.toString();
    }

    public void fromJSON (String json, T t)
    {
        StringTokenizer st = new StringTokenizer(json, "\"");
        st.nextToken();
        while (st.hasMoreTokens())
        {
            String name = st.nextToken();
            st.nextToken();
            String value = st.nextToken();
            st.nextToken();
            try {
                Field field = t.getClass().getDeclaredField(name);
                field.setAccessible(true);
                if (field.getType() == String.class)
                    field.set(t, (Object)value);
                if (field.getType() == int.class)
                    field.setInt(t, Integer.parseInt(value));
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
