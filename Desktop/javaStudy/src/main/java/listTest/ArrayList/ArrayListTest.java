package listTest.ArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {
        //List : 중복허용, 저장 순서를 유지
        //1. ArrayList
        ArrayList<String> list = new ArrayList();

        //리스트에 순서대로 저장
        list.add("candy");
        list.add("chocolate");
        list.add("jelly");

        for(String a : list) {
            System.out.println("arraylist저장 : " + a); //순서대로 조회가 된다.
        }

        ArrayList<String> list2 = new ArrayList();
        list2.add("candy2");
        list2.add("chocolate2");
        list2.add("jelly");

        // 해당 리스트들이 동일한지 확인후 동일한 요소 삭제를 하고싶은 경우 삭제하면 빈공간을 채워 자리를 이동하기때문에 감소시키며 찾아야한다
        for(int i = list2.size() -1 ; i >= 0 ; i--) {
            if(list.contains(list2.get(i))){
                list2.remove(i);
            }
        }
        System.out.println("list : " + list);
        System.out.println("list2 : " + list2);

        //2. Iterator로 저장된 인스턴스 순차적으로 접근하는방법
        List<String> list3 = new LinkedList<>();

        list3.add("candy3");
        list3.add("chocolate3");
        list3.add("jelly3");

        Iterator<String> itr = list3.iterator();

        String str = new String();
        while(itr.hasNext()){
            System.out.println(itr.next());
        }
    }
}
