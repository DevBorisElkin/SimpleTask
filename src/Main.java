import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /**
            Задача: в функцию передаётся List, и 2 числа n и m. Нужно поменять местами каждое n число через каждые m элементов списка.
         пример: подаются числа 1 и 2. Нужно каждое число поменять местами с последующим кратным двум(после использования одного кратного числа
         можем использовать только более крупные числа).

         Использовал null, так как каждый раз путался из-за того, что индекс первого элемента - 0.

         Не знаю, рабочий ли мой метод, в любом случае, всегда можно переделать.  Метод устроен так, что если в цикле бОльшее число дойдёт
         до края массива, работа приостановится. Таким образом, какая-то часть массива всегда перемешана как-попало. Если подаются значения
         1 и 2, то половина массива справа будет без порядка. Если 1 и 10, то 90 процентов массива будут без порядка. См.посл.вызов.

         Вы можете вызвать метод sout как он используется ниже с вашими значениями.
         */
        List<Integer>list = new ArrayList<>();
        list.add(null);
        for(int i=1;i<1000;i++){
            //для простоты восприятия подаются сисла, следующие дргу за другом
            //list.add(new Random().nextInt(100));
            list.add(i);
        }

        sout("оригинальный список: ",list);
        sout(performSort(list,1,2));
        sout(performSort(list,12,8));
        sout(performSort(list,6,5));
        sout(performSort(list,200,20));
        sout(performSort(list,1,10));

    }

    //n всегда должно быть меньше чем m, производится проверка и если это не так, то они меняются значениями.
    public static List<Integer> performSort(List<Integer> list, int n, int m){
        List<Integer> copiedList = new ArrayList<Integer>(list);
        if(n>m){
            int tmp=n;
            n=m;
            m=tmp;
        }

        if(n<1) {
            System.out.println("Ошибка, число отступа не может быть меньше 1");
        }

        for(int i=n, j=m; j<copiedList.size();i+=n, j+=m){
            int tmp=copiedList.get(i);
            int tmp2=copiedList.get(j);
            copiedList.set(i,tmp2);
            copiedList.set(j,tmp);
        }
        return copiedList;
    }

    public static void sout(List<Integer>list){
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(" ");
    }
    public static void sout(String a, List<Integer>list){
        System.out.print(a);
        for(int i=0; i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println(" ");
    }
}
